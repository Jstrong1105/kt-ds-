package com.ktdsuniversity.edu.tmdb;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.bckgrnd.vo.BckgrndVO;
import com.ktdsuniversity.edu.tmdb.common.utils.DBConnector;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;
import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.kwrd.vo.KwrdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;
import com.ktdsuniversity.edu.tmdb.pstr.vo.PstrVO;
import com.ktdsuniversity.edu.tmdb.vd.vo.VdVO;

public class MovieInfo {
	
	private DBConnector connector;
	
	public MovieInfo() {
		this.connector = DBConnector.builder()           
				                    .setDriverClassName("oracle.jdbc.driver.OracleDriver")
				                    .setUrl("jdbc:oracle:thin:@localhost:1521:xe")
				                    .setSchemaName("TMDB")
				                    .setPassword("TMDB")
				                    .connect()
				                    ;
	}
	
	public void close() {
		this.connector.close();
	}
	
	public MvVO selectMovie(String mvId) {
		
	    String query = """
	    			SELECT MV_ID
					     , TTL
					     , MV_RTNG
					     , RNNG_TM
					     , TO_CHAR(RLS_DT,'YYYY-MM- DD') AS RLS_DT
					     , MAIN_PSTL_URL
					     , FB_URL
					     , X_URL
					     , INSTA_URL
					     , TGLN
					     , ORGNL_TTL
					     , PLYNG
					     , ORGNL_LNGG
					     , BDGT
					     , BX_OFFC_RVN
					     , SMMR
					  FROM MV
					 WHERE DEL_YN = 'N'
					   AND MV_ID = ?
	    		""";
		
		return connector.selectBuilder(MvVO.class, query)
				        .setParams(pstmt -> pstmt.setString(1, mvId))
				        .selectOne()
				        ;
	}
	
	public void setGenres(MvVO movie) {
		
		String query = """
				SELECT G.GNR_ID
				     , G.NM     
				  FROM GNR G
				 INNER JOIN MV_GNR MG
				    ON G.GNR_ID = MG.GNR_ID 
				 WHERE MG.MV_ID = ?
				""";
		
		List<GnrVO> genres = 
		this.connector.selectBuilder(GnrVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		
		movie.setGnrList(genres);
	}
	
	public void setKeywords(MvVO movie) {
		
		String query = """
				SELECT K.KWRD_ID 
				     , K.NM 
				  FROM MV_KWRD MK
				 INNER JOIN KWRD K
				    ON MK.KWRD_ID = K.KWRD_ID 
				 WHERE MV_ID = ?
				""";
		
		List<KwrdVO> kwrdList = 
		this.connector.selectBuilder(KwrdVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		
		movie.setKwrdList(kwrdList);
	}
	
	public void setVideos(MvVO movie) {
		
		String query = """
				SELECT VD_ID 
				     , MV_ID
				     , VD_URL
				  FROM VD
				 WHERE MV_ID = ?
				""";
		
		List<VdVO> vdList = 
		this.connector.selectBuilder(VdVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		vdList.forEach(vo -> vo.setMvVO(movie));
		
		movie.setVdList(vdList);
	}
	
	public void setBackground(MvVO movie) {
		
		String query = """
				SELECT BCKGRND_ID 
				     , MV_ID 
				     , BCKGRND_URL 
				  FROM BCKGRND 
				 WHERE MV_ID = ?
				""";
		
		List<BckgrndVO> bgList = 
		this.connector.selectBuilder(BckgrndVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		bgList.forEach(vo -> vo.setMvVO(movie));
		
		movie.setBckgrndList(bgList);
	}
	
	public void setPosters(MvVO movie) {
		
		String query = """
				SELECT PSTR_ID  
				     , MV_ID
				     , PSTR_URL
				  FROM PSTR 
				 WHERE MV_ID = ?
				""";
	
		List<PstrVO> psList =
		this.connector.selectBuilder(PstrVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		psList.forEach(vo -> vo.setMvVO(movie));
		
		movie.setPstrList(psList);
	}
	
	public void setCasts(MvVO movie) {
		
		String query = """
				SELECT APPR_ID 
				     , MV_ID
				     , INVLVD_ID 
				     , RL 
				  FROM APPR
				 WHERE MV_ID = ?
				""";
		
		List<ApprVO> apList = 
		this.connector.selectBuilder(ApprVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		
		apList.forEach(vo -> {
			vo.setMvVO(movie);
			vo.setInvlvdVO(getInvlvd(vo.getInvlvdId()));
		});
		
		movie.setApprList(apList);
	}
	
	public void setFilmmakrs(MvVO movie) {
		
		String query = """
				SELECT FLMMKR_ID
				     , MV_ID
				     , INVLVD_ID
				     , RL 
				     , PRT
				  FROM FLMMKR
				 WHERE MV_ID = ?
				""";
		
		List<FlmmkrVO> flList = 
		this.connector.selectBuilder(FlmmkrVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, movie.getMvId()))
		              .selectList()
		              ;
		
		flList.forEach(vo -> {
			vo.setMvVO(movie);
			vo.setInvlvdVO(getInvlvd(vo.getInvlvdId()));
		});
		
		movie.setFlmmkrList(flList);
	}
	

	private InvlvdVO getInvlvd(String invlvdId) {
		
		String query = """
				SELECT INVLVD_ID 
				     , INVLVD_PRFL_URL
				     , NM
				  FROM INVLVD
				 WHERE INVLVD_ID = ?
				""";
		
		return 
		this.connector.selectBuilder(InvlvdVO.class, query)
		              .setParams(pstmt -> pstmt.setString(1, invlvdId))
		              .selectOne()
		              ;
	}
	
	public static void main(String[] args) {
		MovieInfo mv = new MovieInfo();
		MvVO movie = mv.selectMovie("1-spider-man-brand-new-day");
		
		mv.setGenres(movie);
		mv.setKeywords(movie);
		mv.setVideos(movie);
		mv.setBackground(movie);
		mv.setPosters(movie);
		mv.setCasts(movie);
		mv.setFilmmakrs(movie);
		
		movie.getGnrList().forEach(System.out::println);
		movie.getKwrdList().forEach(System.out::println);
		movie.getVdList().forEach(System.out::println);
		movie.getBckgrndList().forEach(System.out::println);
		movie.getPstrList().forEach(System.out::println);
		movie.getApprList().forEach(System.out::println);
		movie.getFlmmkrList().forEach(System.out::println);
		
		mv.close();
	}
}
