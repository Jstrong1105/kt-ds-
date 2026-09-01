package com.ktdsuniversity.edu.tmdb.personal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtil {
	
	public static <T> List<T> getData(String query, SetPreparedStatement setter, Class<T> clazz){

		List<T> result = new ArrayList<>();
		
		try {
			
			Connection dbConn = DBConn.getConnection();
			
			PreparedStatement pstmt = dbConn.prepareStatement(query);
			setter.set(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			T data = null;
			
			while(rs.next()) {
				data = clazz.getConstructor().newInstance();
				get(rs, data);
				result.add(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static <T> T get(ResultSet rs, T data) {
		
		try {
			Class<T> clazz = (Class<T>) data.getClass();
			
			Field[] fields = clazz.getDeclaredFields();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			for (Field f : fields) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					if (f.getName().equals(metaData.getColumnLabel(i))) {
						
						String methodName = "set" + Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
						Class type = f.getType();
						Method method = clazz.getMethod(methodName, type);
						
						// System.out.println(methodName);
						// System.out.println(type.toString());
						
						Object d = convert(rs.getObject(i), type);
						
						method.invoke(data, d);
						break;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	private static Object convert(Object v, Class<?> target) {
	    if (v == null) return null;
	    if (target.isInstance(v)) return v;

	    if (v instanceof Number n) {
	        if (target == int.class    || target == Integer.class) return n.intValue();
	        if (target == long.class   || target == Long.class)    return n.longValue();
	        if (target == double.class || target == Double.class)  return n.doubleValue();
	    }
	    if (target == String.class) return v.toString();
	    return v;
	}
}
