package convenience_homework;

/**
 * 리뷰 클래스
 */
public class Review {
	
	/**
	 * 리뷰 대상 책
	 */
	Book book;
	
	/**
	 * 리뷰 작성자 닉네임
	 */
	String nickname;
	
	/**
	 * 리뷰 점수
	 */
	int rating;
	
	/**
	 * 리뷰 작성일
	 */
	String createDate;
	
	/**
	 * 리뷰 내용
	 */
	String comment;
	
	/**
	 * 리뷰 좋아요 수
	 */
	int great; 
	
	/**
	 * 리뷰에 달린 댓글 수
	 */
	int count;
	
	/**
	 * 리뷰 신고
	 */
	public void reportReview() {
		System.out.println("신고하기");
	}
	
	/**
	 * 리뷰 차단
	 */
	public void blockReview() {
		System.out.println("리뷰차단");
	}
}
