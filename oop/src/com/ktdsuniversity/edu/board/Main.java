package com.ktdsuniversity.edu.board;

import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 시작점
 */
public class Main {
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int answer = 0;
		
		Board board = new DefaultBoard(reader);
		
		List<Runnable> action = List.of(
			board::writeArticle,
			board::printArticle,
			board::printArticleById,
			board::modifyArticleById,
			board::deleteArticleById,
			board::countArticle,
			board::writeComment,
			board::deleteCommentById,
			board::goodCommentById,
			board::articleByTitle,
			board::deleteAllArticle,
			board::deleteAllCommentByArticle
		);
		
		while (true) {
			
			System.out.println();
			System.out.println();
			System.out.println(" ======= 게시판 =======");
			System.out.println(" 1. 게시글 작성");
			System.out.println(" 2. 모든 게시글 출력");
			System.out.println(" 3. 게시글 번호로 게시글 정보 출력");
			System.out.println(" 4. 게시글 수정");
			System.out.println(" 5. 게시글 번호로 게시글 삭제");
			System.out.println(" 6. 게시판에 등록된 게시글의 개수 출력");
			System.out.println(" 7. 게시판에 댓글 작성하기");
			System.out.println(" 8. 게시글에 등록된 댓글 삭제");
			System.out.println(" 9. 게시글에 등록된 댓글 하나 추천하기");
			System.out.println("10. 게시글 제목으로 검색하기");
			System.out.println("11. 게시글 목록 전체 삭제하기");
			System.out.println("12. 원하는 게시글의 모든 댓글 삭제하기");
			System.out.println("13. 프로그램 종료");
			
			answer = readInt("번호를 선택하세요: ");
			
			if (answer == action.size()+1) {
				break;
			} else if (answer >= 1 && answer <= action.size()) {
				action.get(answer-1).run();
				reader.nextLine();
			} else {
				System.out.println("다시 입력하세요.");
				reader.nextLine();
			}
		}
	}
	
	public static int readInt(String prompt) {
		
		while (true) {
			try {
				System.out.print(prompt);
				String answer = reader.nextLine();
				return Integer.parseInt(answer);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
}
