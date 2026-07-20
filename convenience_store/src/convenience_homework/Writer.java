package convenience_homework;

/**
 * 작가 클래스
 */
public class Writer {
	
	/**
	 * 작가의 활동명
	 */
	String nickname;
	
	/**
	 * 작가 소개
	 */
	String comment;
	
	/**
	 * 책 만들기
	 */
	public Book makeBook() {
		return new Book();
	}
}
