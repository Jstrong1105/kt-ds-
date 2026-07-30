package com.ktdsuniversity.edu.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Board 인터페이스를 구현한 클래스
 */
public class DefaultBoard implements Board {
	
	private static final String NOT_EXIST_ARTICLE = "잘못된 게시글 번호입니다.";
	private static final String NOT_EXIST_COMMENT = "잘못된 댓글 번호입니다.";
	
	private List<Article> board;
	
	private Scanner reader;
	
	public DefaultBoard(Scanner reader) {
		this.reader = reader;
		this.board = new ArrayList<>();
	}

	private String readString(String prompt) {
		System.out.print(prompt);
		return reader.nextLine();
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
	}

	@Override
	public void printArticle() {
		
		if (this.board.isEmpty()) {
			System.out.println("아직 등록된 게시글이 없습니다.");
		} else {
			for (int i = 0; i < this.board.size(); i++) {
				Article art = this.board.get(i);
				System.out.println( "%d. %s (%d)".formatted( i, art.getTitle(), art.getCommentCount() ) );
			}
		}
	}

	@Override
	public void printArticleById() {
		
		int index = this.readInt("조회할 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			this.board.get(index).printStatus();;
		}
	}

	@Override
	public void modifyArticleById() {
		
		int index = this.readInt("수정할 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			String title = this.readString("수정할 제목을 입력하세요: ");
			String content = this.readString("수정할 내용을 입력하세요: ");
			this.board.get(index).setTitle(title);
			this.board.get(index).setContent(content);
			System.out.println("게시글 수정이 완료되었습니다.");
		}
	}

	@Override
	public void deleteArticleById() {
		int index = this.readInt("삭제할 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			this.board.remove(index);
			System.out.println("게시글 삭제가 완료되었습니다.");
		}
	}

	@Override
	public void countArticle() {
		
		if (this.board.isEmpty()) {
			System.out.println("등록된 게시글이 없습니다.");
		} else {
			System.out.println(this.board.size() + "개의 게시글이 등록되었습니다.");
		}
	}

	@Override
	public void writeComment() {
		
		int index = this.readInt("댓글을 작성할 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else if (this.board.get(index).getCommentCount() >= 10) {
			System.out.println("댓글을 더 이상 등록할 수 없습니다.");
		} else {
			
			String content = this.readString("댓글 내용을 입력하세요: ");
			String name = this.readString("댓글 작성자 이름을 입력하세요: ");
			String writeDate = this.readString("댓글 작성일을 입력하세요: ");
			
			this.board.get(index).addComment(new Comment(content, writeDate, writeDate));
			
			System.out.println("댓글 작성이 완료되었습니다.");
		}
	}

	@Override
	public void deleteCommentById() {
		
		int index = this.readInt("댓글을 삭제할 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			int commentIndex = this.readInt("삭제할 댓글 번호를 입력하세요: ");
			
			if (this.board.get(index).existComment(commentIndex)) {
				this.board.get(index).commentDeleteAt(commentIndex);
				System.out.println("댓글 삭제가 완료되었습니다.");
			} else {
				System.out.println(NOT_EXIST_COMMENT);
			}
		}
	}

	@Override
	public void goodCommentById() {
		
		int index = this.readInt("추천할 댓글이 존재하는 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else {
			int commentIndex = this.readInt("추천할 댓글 번호를 입력하세요: ");
			
			if (this.board.get(index).existComment(commentIndex)) {
				this.board.get(index).goodComment(commentIndex);
				System.out.println("댓글 추천이 완료되었습니다.");
			} else {
				System.out.println(NOT_EXIST_COMMENT);
			}
		}
	}

	@Override
	public void articleByTitle() {
		String title = readString("검색할 제목을 입력하세요");
		
		for (Article art : this.board) {
			if (art.getTitle().contains(title)) {
				art.printStatus();
			}
		}
	}

	@Override
	public void deleteAllArticle() {
		if (this.board.isEmpty()) {
			System.out.println("제거할 게시글이 없습니다.");
		} else {
			int size = this.board.size();
			this.board.clear();
			System.out.println(size + "개 게시글을 삭제했습니다.");
		}
	}

	@Override
	public void deleteAllCommentByArticle() {
		
		int index = this.readInt("추천할 댓글이 존재하는 게시글 번호를 입력하세요.");
		
		if (index < 0 || index >= this.board.size()) {
			System.out.println(NOT_EXIST_ARTICLE);
		} else if (this.board.get(index).getCommentCount() == 0){
			System.out.println("등록된 댓글이 없습니다.");
		} else {
			this.board.get(index).commentDeleteAll();
			System.out.println("댓글 삭제가 완료되었습니다.");
		}
	}

}
