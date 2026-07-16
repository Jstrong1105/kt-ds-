package main;

import common.ConsoleUtil;
import common.IOUtil;

/**
 * GameMenu 목록을 화면에 출력하고 주문을 받는 유틸리티
 */
public final class GameStore {
	
	private static final String TITLE = "============ 게임 메뉴 ============\n===================================\n";
	
	// 생성자 프라이빗
	// 인스턴스 생성 방지
	private GameStore() {
		
	}
	
	public static void order() {
		
		GameMenu[] menus = GameMenu.values();
		
		while(true) {
			
			ConsoleUtil.clearConsole();
			
			IOUtil.print(TITLE);
			
			int index = 1;
			
			for(GameMenu menu : menus) {
				IOUtil.print(String.format("%d. %s : %s%n", index, menu.getGameName(),menu.getGameDescription()));
				index++;
			}
			
			IOUtil.print(index + ". 프로그램 종료\n");
			
			int answer = IOUtil.readIntRange("메뉴 번호를 입력하세요.", 1, index);
			
			if(answer == index) {
				IOUtil.print("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
				break;
			} else {
				menus[answer-1].getGame().run();
			}
		}
	}
}
