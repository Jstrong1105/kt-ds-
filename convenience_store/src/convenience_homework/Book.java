package convenience_homework;

/**
 * 도서 클래스
 */
public class Book {

	/**
	 * 책의 제목
	 */
	String title;
	
	/**
	 * 책의 작가
	 */
	Writer writer;
	
	/**
	 * 번역가
	 */
	Writer translator;
	
	/**
	 * 책의 고유 번호
	 */
	long serial;
	
	/**
	 * 책의 출간일
	 */
	String publicationDate;
	
	/**
	 * 책의 가로, 세로, 높이
	 */
	int[] size = new int[3];
	
	/**
	 * 책의 페이지 수
	 */
	int page;
	
	/**
	 * 책 소개
	 */
	String description;
	
	/**
	 * 책의 분야
	 */
	String theme; 
	
	/**
	 * 책의 평점
	 */
	double rating;
	
	/**
	 * 책의 리뷰 수
	 */
	int reviewCount;
	
	/**
	 * 책의 가격
	 */
	int price;
	
	/**
	 * 책 구매하기
	 */
	public void buyBook() {
		System.out.println("책 구매하기");
	}
}
