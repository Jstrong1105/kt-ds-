package com.ktdsuniversity.edu.tmdb.common.utils;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class Main {

	public static void main(String[] args) {
		DBConnector dbConn = DBConnector.builder()
										.setDriverClassName("oracle.jdbc.driver.OracleDriver")
										.setUrl("jdbc:oracle:thin:@localhost:1521:XE")
										.setSchemaName("TMDB")
										.setPassword("TMDB")
										.connect();
		
		String query = """
					SELECT BDGT 
					     , BX_OFFC_RVN 
					     , MV_ID
					     , TTL
					     , SMMR
					     , MV_RTNG
					     , RLS_DT
					     , MAIN_PSTL_URL
					     , X_URL 
					  FROM MV 
					 WHERE MV_ID = ? 
				""" ;
		
		MvVO mv = dbConn.selectBuilder(MvVO.class, query)
						.setParams(pstmt -> {
							pstmt.setString(1, "1-spider-man-brand-new-day");
						})
						.selectOne();
		dbConn.close();
		System.out.println(mv);
	}
}