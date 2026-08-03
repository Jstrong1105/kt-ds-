package com.ktdsuniversity.edu.board.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 한개
 */
public class Article {
	
	/** 게시글 제목 */
	private String title;
	
	/** 게시글 작성자 */
	private final String WRITER;
	
	/** 게시글 작성 날짜 */
	private final String WRITE_DATE;
	
	/** 게시글 조회 수 */
	private int hitCount;
	
	/** 게시글 내용 */
	private String content;
	
	/** 댓글 목록 */
	private final List<Comment> COMMENT_LIST;
	
	// 일반적으로 게시글 작성 시 호출하는 생성자
	public Article(String title, String writer, String writeDate, String content) {
		this(title,writer,writeDate,0,content);
	}
	
	// 파일에 저장된 정보를 가져와 게시글 작성 시 호출하는 생성자
	public Article(String title, String writer, String writeDate, int hitCount, String content) {
		this.title = title;
		this.WRITER = writer;
		this.WRITE_DATE = writeDate;
		this.hitCount = hitCount;
		this.content = content;
		this.COMMENT_LIST = new ArrayList<>();
	}
	
	
	// 정보 출력하기
	public void printStatus() {
		System.out.println();
		System.out.println("게시글 제목: " + this.title);
		System.out.println("게시글 작성자: " + this.WRITER);
		System.out.println("게시글 작성 날짜: " + this.WRITE_DATE);
		System.out.println("게시글 조회 수: " + this.hitCount);
		System.out.println("게시글 내용: " + this.content);
		
		if (this.COMMENT_LIST.isEmpty()) {
			System.out.println("등록된 댓글이 없습니다.");
		} else {
			for (Comment comment : this.COMMENT_LIST) {
				System.out.println();
				comment.printStatus();
			}
		}
		System.out.println();
	}
	
	// 조회수 증가하기
	public void incrementHitCount() {
		this.hitCount++;
	}
	
	// 제목 수정하기
	public void setTitle(String title) {
		this.title = title;
	}
	
	// 내용 수정하기
	public void setContent(String content) {
		this.content = content;
	}
	
	// 댓글 여부 반환하기
	public boolean existComment(int index) {
		return index >= 0 && this.COMMENT_LIST.size() > index;
	}
	
	// 댓글 추가하기
	public void addComment(Comment comment) {
		this.COMMENT_LIST.add(comment);
	}
	
	// 댓글 좋아요 추가하기
	public void goodComment(int index) {
		this.COMMENT_LIST.get(index).incrementGood();
	}
	
	// 댓글 하나 지우기
	public void commentDeleteAt(int index) {
		this.COMMENT_LIST.remove(index);
	}
	
	// 댓글 전부 지우기
	public void commentDeleteAll() {
		this.COMMENT_LIST.clear();
	}
	
	// getter
	public String getTitle() {
		return this.title;
	}
	
	public int getCommentCount() {
		return this.COMMENT_LIST.size();
	}
	
	public String getWriter() {
		return this.WRITER;
	}
	
	public String getWriteDate() {
		return this.WRITE_DATE;
	}
	
	public int getHitCount() {
		return this.hitCount;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String toSaveString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(this.title).append(",");
		buffer.append(this.WRITER).append(",");
		buffer.append(this.WRITE_DATE).append(",");
		buffer.append(this.hitCount).append(",");
		buffer.append(this.content);
		
		if (!this.COMMENT_LIST.isEmpty()) {
			for (Comment c : this.COMMENT_LIST) {
				buffer.append("@");
				buffer.append(c.toSaveString());
			}
		}
		
		return buffer.toString();
	}
}
