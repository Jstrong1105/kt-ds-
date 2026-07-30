package com.ktdsuniversity.edu.board;

/**
 * 게시판이 수행하는 기능을 정의한 인터페이스
 */
public interface Board {
	
	// 게시글 작성하기
	void writeArticle();
	
	// 모든 게시글 출력하기
	void printArticle();
	
	// 게시글 번호로 게시글 정보 출력하기
	void printArticleById();
	
	// 게시글 수정하기
	void modifyArticleById();
	
	// 게시글 삭제하기
	void deleteArticleById();
	
	// 게시판에 등록된 게시글의 개수 출력하기
	void countArticle();
	
	// 게시글에 번호를 이용해 게시글의 댓글 작성하기
	void writeComment();
	
	// 게시글에 등록된 댓글 삭제하기
	void deleteCommentById();
	
	// 게시글에 등록된 댓글 추천하기
	void goodCommentById();
	
	// 게시글 제목으로 검색하기
	void articleByTitle();
	
	// 게시글 목록 전체 삭제하기
	void deleteAllArticle();
	
	// 원하는 게시글의 모든 댓글 삭제하기
	void deleteAllCommentByArticle();
}
