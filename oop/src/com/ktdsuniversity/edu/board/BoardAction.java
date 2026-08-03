package com.ktdsuniversity.edu.board;

import java.util.function.Consumer;

/**
 * 액션 프롬프트 및 동작
 */
public enum BoardAction {
	
	WRITE_ARTICLE("게시글 작성", Board::writeArticle)
	, PRINT_ARTICLE("게시글 목록 조회", Board::printArticle)
	, PRINT_ARTICLE_BY_ID("게시글 조회", Board::printArticleById)
	, MODIFY_ARTICLE_BY_ID("게시글 수정", Board::modifyArticleById)
	, DELETE_ARTICLE_BY_ID("게시글 삭제", Board::deleteArticleById) 
	, COUNT_ARTICLE("게시글 개수 조회", Board::countArticle)
	, WRITE_COMMENT("게시글 댓글 작성", Board::writeComment)
	, DELETE_COMMENT_BY_ID("게시글 댓글 삭제", Board::deleteCommentById)
	, GOOD_COMMENT_BY_ID("게시글 댓글 추천", Board::goodCommentById)
	, ARTILCLE_BY_TITLE("게시글 검색", Board::articleByTitle)
	, DELETE_ALL_ARTICLE("게시글 전체 삭제", Board::deleteAllArticle)
	, DELETE_ALL_COMMENT_BY_ARTICLE("게시글 댓글 전체 삭제", Board::deleteAllCommentByArticle)
	;
	
	private BoardAction(String prompt, Consumer<Board> board) {
		this.prompt = prompt;
		this.board = board;
	}
	
	private final String prompt;
	private final Consumer<Board> board;
	
	public String getPrompt() {
		return this.prompt;
	}
	
	public void action(Board board) {
		this.board.accept(board);
	}
}