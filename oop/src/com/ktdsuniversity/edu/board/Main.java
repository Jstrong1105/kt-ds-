package com.ktdsuniversity.edu.board;

import java.util.Scanner;

import com.ktdsuniversity.edu.board.io.DefaultFileIo;

/**
 * 프로그램 시작점
 */
public class Main {
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int answer = 0;
		Board board = new DefaultBoard(reader, new DefaultFileIo());
		BoardAction[] actions = BoardAction.values();
		
		while (true) {
			// 메뉴 출력
			System.out.println("======= 게시판 =======");
			for(BoardAction action : actions) {
				System.out.printf("%2d. %s\n", (action.ordinal()+1), action.getPrompt() );
			}
			System.out.printf("%2d. 종료\n", (actions.length+1));
			
			// 사용자 입력
			answer = readInt("번호를 선택하세요: ");
			
			// 종료 기능 실행
			if (answer == actions.length+1) {
				board.saveData();
				System.out.println("저장이 완료되었습니다.");
				reader.close();
				break;
			}
			// 특정 기능 실행
			else if (answer >= 1 && answer <= actions.length) {
				actions[answer-1].action(board);
				reader.nextLine();
			}
			// 잘못된 번호 입력
			else {
				System.out.println("다시 입력하세요.");
				reader.nextLine();
			}
		}
	}
	
	public static int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(reader.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
}
