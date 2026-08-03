package com.ktdsuniversity.edu.board.exception;

/**
 * 게시글 작성자의 이름이 입력되지 않아 던져지는 예외
 */
public class ArticleWriterException extends RuntimeException {

	private static final long serialVersionUID = 5283280644306143570L;
	
	public ArticleWriterException(String message) {
		super(message);
	}
}
