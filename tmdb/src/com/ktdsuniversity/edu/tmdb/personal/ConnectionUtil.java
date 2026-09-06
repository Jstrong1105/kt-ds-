package com.ktdsuniversity.edu.tmdb.personal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionUtil {
	
	private String query;
	private SetPstmt param;
	
	public ConnectionUtil setQuery(String query) {
		this.query = query;
		return this;
	}
	
	public ConnectionUtil setParam(SetPstmt param) {
		this.param = param;
		return this;
	}
	
	@FunctionalInterface
	public static interface SetPstmt {
		void set(PreparedStatement pstmt) throws SQLException;
	}
	
	public <T> List<T> getList(Class<T> clazz){
		
		if (clazz == null || this.query == null) {
			throw new RuntimeException("유효하지 않음");
		}
		
		Connection db = getConnection();
		List<T> result = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		try {
			pstmt = db.prepareStatement(query);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if (this.param != null) {
			try {
				param.set(pstmt);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		result = toList(rs, clazz);
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	private <T> List<T> toList(ResultSet rs, Class<T> clazz) {
		
		if (rs == null) {
			throw new RuntimeException();
		}
		
		List<T> result = new ArrayList<>();
		
		ResultSetMetaData meta = null;
		Field[] fields = null;
		
		try {
			meta = rs.getMetaData();
			fields = clazz.getDeclaredFields();
			
			while(rs.next()) {
				T obj = clazz.getDeclaredConstructor().newInstance();
				
				for(int i = 1; i <= meta.getColumnCount(); i++) {
					
					String label = meta.getColumnLabel(i);
					Field field = null;
					
					for(int j = 0; j < fields.length; j++) {
						if(label.equals(fields[j].getName())) {
							field = fields[j];
							break;
						}
					}
					if (field == null) {
						throw new RuntimeException("별칭 오타");
					}
					String setterName = "set" + Character.toUpperCase(label.charAt(0)) + label.substring(1);
					
					Method setter = clazz.getDeclaredMethod(setterName, field.getType());
					
					Class<?> type = field.getType();
					
					if (type == String.class) {
						setter.invoke(obj, rs.getString(i));
					} else if (type == int.class) {
						setter.invoke(obj, rs.getInt(i));
					} else if (type == long.class) {
						setter.invoke(obj, rs.getLong(i));
					}
				}
				
				result.add(obj);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		this.query = null;
		this.param = null;
		
		return result;
	}
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TMDB","TMDB");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
