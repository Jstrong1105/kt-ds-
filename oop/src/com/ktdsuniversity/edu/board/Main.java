package com.ktdsuniversity.edu.board;

import com.ktdsuniversity.edu.board.io.DefaultFileIo;
import com.ktdsuniversity.edu.board.service.Board;
import com.ktdsuniversity.edu.board.service.BoardAction;
import com.ktdsuniversity.edu.board.service.DefaultBoard;
import com.ktdsuniversity.edu.board.util.Reader;

/**
 * 프로그램 시작점
 */
public class Main {
	
	public static void main(String[] args) {
		
		int answer = 0;
		Board board = new DefaultBoard(new DefaultFileIo());
		BoardAction[] actions = BoardAction.values();
		
		while (true) {
			// 메뉴 출력
			System.out.println("======= 게시판 =======");
			for(BoardAction action : actions) {
				System.out.printf("%2d. %s\n", (action.ordinal()+1), action.getPrompt() );
			}
			System.out.printf("%2d. 종료\n", (actions.length+1));
			
			// 사용자 입력
			answer = Reader.readInt("번호를 입력하세요: ");
			
			// 종료 기능 실행
			if (answer == actions.length+1) {
				board.saveData();
				System.out.println("저장이 완료되었습니다.");
				Reader.close();
				break;
			}
			// 특정 기능 실행
			else if (answer >= 1 && answer <= actions.length) {
				actions[answer-1].action(board);
				Reader.readString("");
			}
			// 잘못된 번호 입력
			else {
				System.out.println("다시 입력하세요.");
				Reader.readString("");
			}
		}
	}
}
