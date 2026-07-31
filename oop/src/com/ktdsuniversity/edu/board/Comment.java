package com.ktdsuniversity.edu.board;

/**
 * 댓글 1개
 */
public class Comment {
	
	/** 댓글 내용 */
	private final String CONTENT;
	/** 댓글 작성자 */
	private final String WRITER;
	/** 댓글 작성일 */
	private final String WRITE_DATE;
	/** 추천 수 */
	private int good;
	
	public Comment(String content, String writer, String writeDate) {
		this.CONTENT = content;
		this.WRITER = writer;
		this.WRITE_DATE = writeDate;
		this.good = 0; // 멤버 변수라서 0 초기화 이지만 명시적으로 초기화 진행
	}
	
	// 정보 출력
	public void printStatus() {
		System.out.println("댓글 작성자: " + this.WRITER);
		System.out.println("댓글 작성일: " + this.WRITE_DATE);
		System.out.println("댓글 추천수: " + this.good);
		System.out.println("댓글 내용: " + this.CONTENT);
	}
	
	// 추천 수 증가
	public void incrementGood() {
		this.good++;
	}
	
	// getter 
	public String getContent() {
		return this.CONTENT;
	}
	
	public String getWriter() {
		return this.WRITER;
	}
	
	public String getWriteDate() {
		return this.WRITE_DATE;
	}
	
	public int getGood() {
		return this.good;
	}
	
	public String toSaveString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.CONTENT).append(",");
		buffer.append(this.WRITER).append(",");
		buffer.append(this.WRITE_DATE).append(",");
		buffer.append(this.good);
		return buffer.toString();
	}
}
