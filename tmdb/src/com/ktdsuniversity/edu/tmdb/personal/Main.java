package com.ktdsuniversity.edu.tmdb.personal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class Main {
	
	public static void main(String[] args) {
		
		String query = """
				SELECT MV_ID AS "mvId"
				     , TTL   AS "ttl"
				     , MV_RTNG AS "mvRtng"
				     , RNNG_TM AS "rnngTm"
				     , TO_CHAR(RLS_DT,'YYYY-MM- DD') AS "rlsDt"
				     , MAIN_PSTL_URL AS "mainPstlUrl"
				     , FB_URL AS "fbUrl"
				     , X_URL AS "xUrl"
				     , INSTA_URL AS "instaUrl"
				     , TGLN AS "tgln"
				     , ORGNL_TTL AS "orgnlTtl"
				     , PLYNG AS "plyng"
				     , ORGNL_LNGG AS "orgnlLngg"
				     , BDGT AS "bdgt"
				     , BX_OFFC_RVN AS "bxOffcRvn"
				     , SMMR AS "smmmr"
				  FROM MV
				 WHERE DEL_YN = 'N'
				   AND MV_ID = ?
				""";
		
		ConnectionUtil.getData(query, Main::setter, MvVO.class).forEach(System.out::println);
		
		query = """
				SELECT BCKGRND_ID AS "bckdgndId"
				     , MV_ID AS "mvId"
				     , BCKGRND_URL "bckdgnd"
				  FROM BCKGRND 
				""";
		
		ConnectionUtil.getData(query, pstml -> {}, BckgrndVO.class).forEach(System.out::println);
	}
	
	private static void setter(PreparedStatement pstmt) {
		try {
			pstmt.setString(1, "1-spider-man-brand-new-day");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
