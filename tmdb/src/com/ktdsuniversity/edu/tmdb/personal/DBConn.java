package com.ktdsuniversity.edu.tmdb.personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static Connection dbConn;
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "TMDB";
	private static String password = "TMDB";
	
	public static Connection getConnection() {
		
		if (dbConn == null) {
			try {
				Class.forName(driver);
				dbConn = DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException cnfe) {
				throw new RuntimeException("OJDBC 못찾음", cnfe);
			} catch (SQLException sqle) {
				throw new RuntimeException("DB 연결 실패", sqle);
			}
		}
		
		return dbConn;
	}
	
	public static void close() {
		
		if (dbConn != null) {
			try {
				if (!dbConn.isClosed()) {
					dbConn.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			dbConn = null;
		}
	}
}
