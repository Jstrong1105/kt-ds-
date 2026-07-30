package com.ktdsuniversity.edu.board;

/**
 * 게시글 제목이 유효하지 않아 던져지는 예외
 */
public class ArticleException extends RuntimeException {

	private static final long serialVersionUID = -8099020032886521650L;
	
	public ArticleException(String message) {
		super(message);
	}
}
