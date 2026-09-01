

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.tmdb.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ConnectionTest {
	
	public static MvVO selectMovie(String mvId) {
		
		// Java -> Oracle 연결하기 위한 URL
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		// Oracle 에 접속하기 위한 인증 정보
		String schemaName = "TMDB";
		String password = "TMDB";
		
		Connection dbConnection = null;
		
		try {
			// Oracle로 접속
			dbConnection = DriverManager.getConnection(url, schemaName, password);
			// 연결한 스키마 이름을 출력한다. 
			// System.out.println(dbConnection.getSchema());
			
		} catch (SQLException sqle) {
			throw new RuntimeException("데이터 베이스에 연결할 수 없습니다.", sqle);
		}
		
		// Oracle로 쿼리를 전송하고 실행 한 뒤 결과를 받아온다.
		// 영화의 정보만 조회를 해본다.
		
		StringBuffer query = new StringBuffer();
		
	    query.append("""
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
					 WHERE DEL_YN = ?
					   AND MV_ID = ?
	    		""");
	    
	    // List<MvVO> movieList = new ArrayList<>();
	    
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    // 위의 준비된 쿼리를 Oracle에 전송하고 실행한다.
	    try {
	    	pstmt = dbConnection.prepareStatement(query.toString());
	    	
	    	// ? 에 들어갈 값을 할당한다.
	    	pstmt.setString(1, "N");
	    	pstmt.setString(2, mvId);
	    	
	    	rs = pstmt.executeQuery();
	    	MvVO mvVO = null;
	    	   
	    	// ResultSet 의 Row를 처음부터 끝까지 반복시킨다.
	    	while(rs.next()) {
	    		mvVO = new MvVO();
	    		// 현재 반복 중인 ROW 에서 각 컬럼들의 값을 추출한다.
	    		// 추출된 값을 MvVO에게 할당해준다.
	    		mvVO.setMvId(rs.getString("MV_ID"));
	    		mvVO.setTtl(rs.getString("TTL"));
	    		mvVO.setMvRtng(rs.getString("MV_RTNG"));
	    		mvVO.setRnngTm(rs.getInt("RNNG_TM"));
	    		mvVO.setRlsDt(rs.getString("RLS_DT"));
	    		mvVO.setSmmr(rs.getString("SMMR"));
	    		mvVO.setMainPstlUrl(rs.getString("MAIN_PSTL_URL"));
	    		mvVO.setFbUrl(rs.getString("FB_URL"));
	    		mvVO.setXUrl(rs.getString("X_URL"));
	    		mvVO.setInstaUrl(rs.getString("INSTA_URL"));
	    		mvVO.setTgln(rs.getString("TGLN"));
	    		mvVO.setOrgnlTtl(rs.getString("ORGNL_TTL"));
	    		mvVO.setPlyng(rs.getString("PLYNG"));
	    		mvVO.setOrgnlLngg(rs.getString("ORGNL_LNGG"));
	    		mvVO.setBdgt(rs.getLong("BDGT"));
	    		mvVO.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
	    	}
	    	
	    	return mvVO;
	    	
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리에 문제가 있습니다.", sqle);
		} finally {
			// rs close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {}
			}
			// pstmt close
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {}
			}
			// dbConnection close
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException sqle) {}
			}
		}
	}
	
	public static List<GnrVO> selectGenre(String mvId){
		
		List<GnrVO> gnrList = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException("OJDBC 못찾음", cnfe);
		}
		
		Connection dbConn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "TMDB";
		String password = "TMDB";
		
		try {
			dbConn = DriverManager.getConnection(url, username, password);
		} catch (SQLException sqle) {
			throw new RuntimeException("DB 연결 실패", sqle);
		}
		
		String query = """
				SELECT G.GNR_ID
				     , G.NM     
				  FROM GNR G
				 INNER JOIN MV_GNR MG
				    ON G.GNR_ID = MG.GNR_ID 
				 WHERE MG.MV_ID = ?
				""";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, mvId);
			rs = pstmt.executeQuery();
			GnrVO gnrVO = null;
			
			while(rs.next()) {
				gnrVO = new GnrVO();
				gnrVO.setGnrId(rs.getString("GNR_ID"));
				gnrVO.setNm(rs.getString("NM"));
				
				gnrList.add(gnrVO);
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리 이상", sqle);
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (dbConn != null) {
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return gnrList;
	}
	
	/**
	 * 장르에 해당하는 영화를 모두 조회한다.
	 * @param gnrId 조회하려는 장르의 아이디
	 * @return 해당 장르의 영화 목록
	 */
	public static List<MvVO> selectMovieOf(String gnrId){
		List<MvVO> movieList = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException("OJDBC 못찾음", cnfe);
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "TMDB";
		String password = "TMDB";
		Connection dbConn = null;

		try {
			dbConn = DriverManager.getConnection(url, username, password);
		} catch (SQLException sqle) {
			throw new RuntimeException("DB 연결 실패", sqle);
		}
		
		String sql = """
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
				   AND MV_ID IN (SELECT MV_ID
					 			   FROM MV_GNR
								  WHERE GNR_ID = ?)
				""";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, gnrId);
			
			rs = pstmt.executeQuery();
			
			MvVO mvVO = null;
			
			while(rs.next()) {
				mvVO = new MvVO();
				mvVO.setMvId(rs.getString("MV_ID"));
	    		mvVO.setTtl(rs.getString("TTL"));
	    		mvVO.setMvRtng(rs.getString("MV_RTNG"));
	    		mvVO.setRnngTm(rs.getInt("RNNG_TM"));
	    		mvVO.setRlsDt(rs.getString("RLS_DT"));
	    		mvVO.setSmmr(rs.getString("SMMR"));
	    		mvVO.setMainPstlUrl(rs.getString("MAIN_PSTL_URL"));
	    		mvVO.setFbUrl(rs.getString("FB_URL"));
	    		mvVO.setXUrl(rs.getString("X_URL"));
	    		mvVO.setInstaUrl(rs.getString("INSTA_URL"));
	    		mvVO.setTgln(rs.getString("TGLN"));
	    		mvVO.setOrgnlTtl(rs.getString("ORGNL_TTL"));
	    		mvVO.setPlyng(rs.getString("PLYNG"));
	    		mvVO.setOrgnlLngg(rs.getString("ORGNL_LNGG"));
	    		mvVO.setBdgt(rs.getLong("BDGT"));
	    		mvVO.setBxOffcRvn(rs.getLong("BX_OFFC_RVN"));
	    		
	    		movieList.add(mvVO);
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("쿼리 오류", sqle);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConn != null) {
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return movieList;
	}
	
	public static void main(String[] args) {
		
		MvVO movie = selectMovie("1-spider-man-brand-new-day");
		System.out.println(movie);
		
		selectGenre(movie.getMvId()).forEach(System.out::println);
		
		selectMovieOf("2-action").forEach(System.out::println);
	}
}


