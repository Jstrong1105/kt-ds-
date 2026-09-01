package com.ktdsuniversity.edu.tmdb.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.ktdsuniversity.edu.tmdb.common.utils.DBConnector.ConnectionPool.Conn;
// connection 한개와 사용 중 유무

public class DBConnector {

	private static ConnectionBuilder builder;
	// 커넥션 연결 객체, 설정 세팅, 드라이버 검사, 연결
	
	private static DBConnector dbUtil;
	
	private ConnectionPool pool;
	// 10 개의 커넥션을 생성하고 사용중이지 않은 커넥션 반환, 모든 커넥션 종료
	
	private DBConnector() {}

	private <T> T selectData(String query, SetParam preparedParams, Class<T> resultClass,
			Map<String, String> renameColumn, Consumer<T> appender, boolean fetchOnlyOne) {
		if (DBConnector.dbUtil == null) {
			throw new RuntimeException("Database에 연결되어 있지 않습니다.");
		}

		Conn connection = this.getConnection();

		PreparedStatement pstmt = null;
		try {
			pstmt = this.getPreparedStatement(connection.getConnection(), query);
			if (preparedParams != null) {
				preparedParams.accept(pstmt);
			}
		} catch (RuntimeException | SQLException re) {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			connection.release();
		}

		ResultSet rs = null;
		try {
			rs = this.getResultSet(pstmt);
			return ResultSetUtil.setResult(resultClass, rs, renameColumn, (cls) -> createObject(cls, connection), appender, fetchOnlyOne);
		} catch (RuntimeException re) {
			throw new RuntimeException(re.getMessage(), re);
		} finally {
			connection.release();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T createObject(Class<T> resultClass, Conn connection) {
		try {
			return (T) resultClass.getDeclaredConstructors()[0].newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			connection.release();
			throw new RuntimeException("생성자가 존재하지 않습니다.", e);
		}
	}
	
	public void close() {
		this.pool.releaseAll();
	}

	private Conn getConnection() {

		Conn connection = null;
		while (true) {
			connection = this.pool.get();
			if (connection.useableConnection()) {
				connection.use();
				return connection;
			}
		}
	}

	private PreparedStatement getPreparedStatement(Connection connection, String query) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			return pstmt;
		} catch (SQLException e) {
			throw new RuntimeException("쿼리가 잘못되었습니다.", e);
		}
	}

	private ResultSet getResultSet(PreparedStatement pstmt) {
		try {
			return pstmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException("잘못된 컬럼입니다.", e);
		}
	}

	public static ConnectionBuilder builder() {
		DBConnector.builder = new ConnectionBuilder();
		return DBConnector.builder;
	}
	
	public <T> SelectBuilder<T> selectBuilder(Class<T> resultClass, String query) {
		return new SelectBuilder<T>(resultClass, query);
	}
	
	public <T> SelectBuilder<T> selectBuilder(Class<T> resultClass, StringBuffer query) {
		return new SelectBuilder<T>(resultClass, query.toString());
	}

	@FunctionalInterface
	public static interface SetParam {
		public void accept(PreparedStatement pstmt) throws SQLException;
	}

	public class SelectBuilder<T> {
		private String query;
		private SetParam params;
		private Class<T> resultClass;
		private Map<String, String> renameColumn;
		
		public SelectBuilder(Class<T> resultClass, String query) {
			this.resultClass = resultClass;
			this.query = query;
		}
		
		public SelectBuilder<T> setParams(SetParam params) {
			this.params = params;
			return this;
		}
		
		public Map<String, String> getRenameColumn() {
			return this.renameColumn;
		}

		public SelectBuilder<T> addRenameColumn(String columnName, String newName) {
			if (this.renameColumn == null) {
				this.renameColumn = new HashMap<>();
			}
			this.renameColumn.put(columnName, newName);
			return this;
		}
		
		public T selectOne() {
			if (DBConnector.dbUtil == null) {
				return null;
			}
			return DBConnector.dbUtil.selectData(this.query, this.params, this.resultClass, this.renameColumn, null, true);
		}
		
		public List<T> selectList() {
			if (DBConnector.dbUtil == null) {
				return null;
			}
			List<T> result = new ArrayList<>();
			DBConnector.dbUtil.selectData(this.query, this.params, this.resultClass, this.renameColumn, (row) -> {
				result.add(row);
			}, false);
			return result;
		}

	}

	public static class ConnectionBuilder {

		private String driverClassName;
		private String url;
		private String schemaName;
		private String password;

		public ConnectionBuilder setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
			return this;
		}

		public ConnectionBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public ConnectionBuilder setSchemaName(String schemaName) {
			this.schemaName = schemaName;
			return this;
		}

		public ConnectionBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public DBConnector connect() {
			try {
				Class.forName(this.driverClassName);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(this.driverClassName + "을(를) 찾을 수 없습니다. 라이브러리가 있는지 확인하세요.");
			}

			if (DBConnector.dbUtil == null) {
				DBConnector.dbUtil = new DBConnector();
				DBConnector.dbUtil.pool = new ConnectionPool(DBConnector.builder.url, DBConnector.builder.schemaName, DBConnector.builder.password);
			}

			return DBConnector.dbUtil;
		}

	}
	
	private abstract class ResultSetUtil {

		private static final Pattern pattern = Pattern.compile("_([a-zA-Z])");
		
		public static <T> T setResult(Class<T> objectClass, 
								ResultSet rs, 
								Map<String, String> resultMap, 
								CreateObject<T> createObject, 
								Consumer<T> appender,
								boolean fetchOnlyOne) {
			
			if (rs != null || objectClass != null) {
				Map<String, String> newResultMap = new HashMap<>();
				if (resultMap != null) {
					resultMap.forEach((key, value) -> {
						newResultMap.put(key.toUpperCase(), value.toUpperCase());
					});
				}
				
				ResultSetMetaData metadata = null;
				int columnCount = 0;
				
				Method setter = null;
				String columnName = null;
				String setterName = null;
				Class<?> parameterType = null;
				
				try {
					T obj = null;
					int index = 0;
					
					while (rs.next()) {
						
						if (fetchOnlyOne && index > 0) {
							throw new RuntimeException("두 개 이상의 Row가 반환되었습니다.");
						}
						
						obj = createObject.creatObject(objectClass);
						
						metadata = getMetadata(rs);
						columnCount = getColumnCount(metadata);
						
						for (int i = 1; i <= columnCount; i++) {
							columnName = getColumnName(metadata, i);
							columnName = newResultMap.getOrDefault(columnName, columnName);
							setterName = getSetterName(columnName);
							parameterType = getJavaType(objectClass, columnName);
							
							if (parameterType != null) {
								setter = getSetter(objectClass, setterName, parameterType);
								invoke(setter, obj, rs, i, parameterType);
							}
						}
						
						if (appender != null) {
							appender.accept(obj);
						}
						
						index++;
					}
					
					return obj;
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			
			return null;
		}
		
		private static ResultSetMetaData getMetadata(ResultSet rs) {
			try {
				return rs.getMetaData();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		private static int getColumnCount(ResultSetMetaData metadata) {
			if (metadata == null) {
				return 0;
			}
			try {
				return metadata.getColumnCount();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		private static Method getSetter(Class<?> objectClass, String methodName, Class<?> parameterType) {
			if (methodName == null) {
				return null;
			}
			if (parameterType == null) {
				return null;
			}
			
			try {
				return objectClass.getDeclaredMethod(methodName, parameterType);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		private static String getSetterName(String columnName) {
			if (columnName == null) {
				return null;
			}
			String str = toCamelCase("set_" + columnName);
			/**
			 * System.out.println(str);
			 * setBdgt
			 * setBxOffcRvn
			 * setMvId
			 * setTtl
			 * setSmmr
			 * setMvRtng
			 * setRlsDt
			 * setMainPstlUrl
			 * setXUrl
			 */
			return str;
		}
		
		private static String toCamelCase(String string) {
			Matcher matcher = pattern.matcher(string.toLowerCase()); // 우선 전체를 소문자(mv_id)로 변환
			String result = matcher.replaceAll(m -> m.group(1).toUpperCase());
			return result;
		}
		
		private static String getColumnName(ResultSetMetaData metadata, int index) {
			if (metadata == null) {
				return null;
			}
			
			try {
				return metadata.getColumnName(index);
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		private static Class<?> getJavaType(Class<?> objClass, String columnName) {
			try {
				Field field = objClass.getDeclaredField(toCamelCase(columnName));
				return field.getType();
			} catch (NoSuchFieldException | SecurityException e) {
				return null;
			}
		}
		
		private static void invoke(Method setter, Object obj, ResultSet rs, int index, Class<?> parameterType) {
			if (setter != null) {
				try {
					
					if (parameterType == String.class) {
						setter.invoke(obj, rs.getString(index));
					} else if (parameterType == long.class || parameterType == Long.class) {
						setter.invoke(obj, rs.getLong(index));
					} else if (parameterType == int.class || parameterType == Integer.class) {
						setter.invoke(obj, rs.getInt(index));
					} else if (parameterType == double.class || parameterType == Double.class) {
						setter.invoke(obj, rs.getDouble(index));
					} else if (parameterType == float.class || parameterType == Float.class) {
						setter.invoke(obj, rs.getFloat(index));
					}
					
				} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
		}
		
		public static interface CreateObject<T> {
			T creatObject(Class<T> objectClass);
		}
		
	}
	
	public static class ConnectionPool {
		
		private int index;
		private List<Conn> dbcp;
		
		public ConnectionPool(String url, String username, String password) {
			this.dbcp = new ArrayList<>();
			this.setup(url, username, password);
		}
		
		private void setup(String url, String username, String password) {
			List<Conn> connections = 
					IntStream.range(0, 10)
							 .parallel()
							 .mapToObj(n -> {
								try {
									return new Conn(DriverManager.getConnection(url, username, password));
								} catch (SQLException e) {
									throw new RuntimeException("Database에 연결할 수 없습니다.", e);
								}
							 })
							 .toList();
			
			this.dbcp.addAll(connections);
		}
		
		public void addAll(List<Conn> conn) {
			this.dbcp.addAll(conn);
		}
		
		public void add(Conn conn) {
			this.dbcp.add(conn);
		}
		
		public Conn get() {
			Conn conn = null;
			while(true) {
				if (this.index == this.dbcp.size()) {
					this.index = 0;
				}
				
				conn = this.dbcp.get(this.index++);
				if (conn.useableConnection()) {
					return conn;
				}
			}
		}
		
		public void releaseAll() {
			this.dbcp.forEach(connection -> {
				try {
					connection.getConnection().close();
				} catch (SQLException e) {}
			});
			
			this.dbcp = null;
			this.index = 0;
		}
		
		public static class Conn {

			private boolean use;
			private Connection connection;
			
			public Conn(Connection connection) {
				this.connection = connection;
			}
			
			public void use() {
				this.use = true;
			}
			
			public void release() {
				this.use = false;
			}
			
			public boolean useableConnection() {
				return this.use == false;
			}
			
			public Connection getConnection() {
				return this.connection;
			}
		}
	}

}