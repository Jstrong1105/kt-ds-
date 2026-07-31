package com.ktdsuniversity.edu.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Board 인터페이스를 구현한 클래스
 */
public class DefaultBoard implements Board {
	
	private static final String NOT_EXIST_ARTICLE = "등록된 게시글이 없습니다.";
	private static final String NOT_EXIST_ARTICLE_NUMBER = "잘못된 게시글 번호입니다.";
	private static final String NOT_EXIST_COMMENT = "잘못된 댓글 번호입니다.";
	
	private List<Article> board;
	
	private Scanner reader;
	
	public DefaultBoard(Scanner reader) {
		this.reader = reader;
		this.board = new ArrayList<>();
	}

	private String readString(String prompt) {
		System.out.print(prompt);
		return this.reader.nextLine().trim();
	}
	
	private int readInt(String prompt) {
		while (true) {
			try {
				return Integer.parseInt(readString(prompt));
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
	@Override
	public void writeArticle() {
		
		System.out.println();
		System.out.println("======= 게시글 작성 =======");
		
		String title = this.readString("게시글 제목을 입력하세요: ");
		if (title.isBlank() || title.length() > 30) {
			throw new ArticleException("제목 예외");
		}
		
		String writer = this.readString("게시글 작성자를 입력하세요: ");
		if (writer.isBlank()) {
			throw new ArticleWriterException("작성자 예외");
		}
		
		String writeDate = this.readString("게시글 작성일을 입력하세요: ");
		String content = this.readString("게시글 내용을 입력하세요: ");
		
		this.board.add(new Article(title, writer, writeDate, content));
		
		System.out.println("게시글 작성이 완료되었습니다.");
		System.out.println();
	}

	@Override
	public void printArticle() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			
			System.out.println("======= 게시글 목록 =======");
			
			for (int i = 0; i < this.board.size(); i++) {
				Article art = this.board.get(i);
				System.out.printf("%d. %s (%d)%n",i, art.getTitle(), art.getCommentCount() );
			}
			System.out.println("모든 게시글 출력이 완료되었습니다.");
		}
		System.out.println();
	}

	@Override
	public void printArticleById() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
			return;
		}
		
		System.out.println("======= 게시글 조회 =======");
		
		int index = this.readInt("조회할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else {
			this.board.get(index).incrementHitCount();
			this.board.get(index).printStatus();;
			System.out.println("게시글 출력이 완료되었습니다.");
		}
		System.out.println();
	}

	@Override
	public void modifyArticleById() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		}
		
		System.out.println("======= 게시글 수정 =======");
		
		int index = this.readInt("수정할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else {
			String title = this.readString("수정할 제목을 입력하세요: ");
			String content = this.readString("수정할 내용을 입력하세요: ");
			this.board.get(index).setTitle(title);
			this.board.get(index).setContent(content);
			System.out.println("게시글 수정이 완료되었습니다.");
		}
		System.out.println();
	}

	@Override
	public void deleteArticleById() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		}
		
		System.out.println("======= 게시글 삭제 =======");
		
		int index = this.readInt("삭제할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else {
			this.board.remove(index);
			System.out.println("게시글 삭제가 완료되었습니다.");
		}
		System.out.println();
	}

	@Override
	public void countArticle() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			System.out.println("======= 등록된 게시글 조회 =======");
			System.out.println(this.board.size() + "개의 게시글이 등록되었습니다.");
		}
		System.out.println();
	}

	@Override
	public void writeComment() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		}
		
		System.out.println("======= 댓글 작성 =======");
		
		int index = this.readInt("댓글을 작성할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else if (this.board.get(index).getCommentCount() >= 10) {
			System.out.println("댓글을 더 이상 등록할 수 없습니다.");
		} else {
			
			String content = this.readString("댓글 내용을 입력하세요: ");
			String name = this.readString("댓글 작성자 이름을 입력하세요: ");
			String writeDate = this.readString("댓글 작성일을 입력하세요: ");
			
			this.board.get(index).addComment(new Comment(content, name, writeDate));
			
			System.out.println("댓글 작성이 완료되었습니다.");
		}
		
		System.out.println();
	}

	@Override
	public void deleteCommentById() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		}
		
		System.out.println("======= 댓글 삭제 =======");
		
		int index = this.readInt("댓글을 삭제할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else {
			int commentIndex = this.readInt("삭제할 댓글 번호를 입력하세요: ");
			
			if (this.board.get(index).existComment(commentIndex)) {
				this.board.get(index).commentDeleteAt(commentIndex);
				System.out.println("댓글 삭제가 완료되었습니다.");
			} else {
				System.out.println(NOT_EXIST_COMMENT);
			}
		}
		System.out.println();
	}

	@Override
	public void goodCommentById() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		}
		
		System.out.println("======= 댓글 추천 =======");
		
		int index = this.readInt("추천할 댓글이 존재하는 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else {
			int commentIndex = this.readInt("추천할 댓글 번호를 입력하세요: ");
			
			if (this.board.get(index).existComment(commentIndex)) {
				this.board.get(index).goodComment(commentIndex);
				System.out.println("댓글 추천이 완료되었습니다.");
			} else {
				System.out.println(NOT_EXIST_COMMENT);
			}
		}
		
		System.out.println();
	}

	@Override
	public void articleByTitle() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
			return;
		}
		
		System.out.println("======= 게시글 검색 =======");
		
		String title = readString("검색할 제목을 입력하세요: ");
		
		for (int i = 0; i < this.board.size(); i++) {
			Article art = this.board.get(i);
			if (art.getTitle().contains(title)) {
				System.out.printf("%d. %s (%d)%n",i, art.getTitle(), art.getCommentCount() );
			}
		}
		
		System.out.println("게시글 검색이 완료되었습니다.");
		System.out.println();
	}

	@Override
	public void deleteAllArticle() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			System.out.println("======= 게시글 삭제 =======");
			int size = this.board.size();
			this.board.clear();
			System.out.println(size + "개 게시글을 삭제했습니다.");
		}
		
		System.out.println();
	}

	@Override
	public void deleteAllCommentByArticle() {
		
		System.out.println();
		
		if (this.board.isEmpty()) {
			System.out.println(NOT_EXIST_ARTICLE);
			return;
		}
		
		System.out.println("======= 댓글 삭제 =======");
		
		int index = this.readInt("댓글을 삭제할 게시글 번호를 입력하세요: ");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE_NUMBER);
		} else if (this.board.get(index).getCommentCount() == 0){
			System.out.println("등록된 댓글이 없습니다.");
		} else {
			this.board.get(index).commentDeleteAll();
			System.out.println("댓글 삭제가 완료되었습니다.");
		}
		
		System.out.println();
	}

}
