package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.ConsoleAnsi;
import common.ConsoleInputReader;
import common.ConsoleOutputWriter;
import common.GameIO;
import common.InputReader;
import common.OutputWriter;

/**
 * 게임 목록을 보여주고 주문을 받아 게임을 실행해주는 클래스
 */
public class GameStore {
	
	private static final String TITLE_PROMPT = "====== 콘솔 게임 런처 ======\n============================";
	private static final String MENU_ORDER_PROMPT = "번호를 선택하세요.";
	private static final String END_PROMPT = "이용해주셔서 감사합니다.";
	
	private final OutputWriter writer;
	private final InputReader reader;
	
	public GameStore() {
		this.writer = new ConsoleOutputWriter();
		this.reader = new ConsoleInputReader(this.writer, new BufferedReader(new InputStreamReader(System.in)));
	}
	
	public GameStore(OutputWriter writer, InputReader reader) {
		this.writer = writer;
		this.reader = reader;
	}
	
	public void order() {
		
		GameMenu[] menus = GameMenu.values();
		
		int endOrder = menus.length + 1;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(ConsoleAnsi.SCREEN_CLEAR);
		
		sb.append(TITLE_PROMPT);
		
		int index = 1;
		
		for(GameMenu menu : menus) {
			sb.append("\n");
			sb.append(index++).append(".").append(" ")
			.append(menu.getGameName()).append(": ")
			.append(menu.getGameDescription());
		}
		
		sb.append("\n");
		sb.append(endOrder).append(".").append(" 종료");
		
		GameIO io = new GameIO(reader, writer);
		
		while(true) {
			writer.print(sb.toString());
			
			int answer = reader.readIntRange(MENU_ORDER_PROMPT,1,endOrder);
			
			if(answer == endOrder) {
				writer.println(END_PROMPT);
				break;
			} else {
				menus[answer-1].getGame(io).doGame();
			}
		}
	}

}
