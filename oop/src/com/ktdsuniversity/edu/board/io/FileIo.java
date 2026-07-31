package com.ktdsuniversity.edu.board.io;

import java.util.List;

import com.ktdsuniversity.edu.board.Article;

/**
 * 게시판 내용을 파일 형태로 저장하고 불러오는 기능을 수행하는 인터페이스
 */
public interface FileIo {
	
	List<Article> loadData();
	
	void saveData(List<Article> board);
}
