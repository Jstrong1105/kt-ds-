package domain.card;

import java.util.List;

import common.ConsoleAnsi;
import common.OutputWriter;

/**
 * CardPrinter 인터페이스 구현 클래스
 * 
 * Outputwriter 를 주입 받아 출력한다.
 */
public class ConsoleCardPrinter implements CardPrinter {
	
	private static final String TOP = "┌────┐ ";
	private static final String BOTTOM = "└────┘ ";
	
	private final OutputWriter writer;
	
	public ConsoleCardPrinter(OutputWriter writer) {
		this.writer = writer;
	}
	
	@Override
	public void printCard(List<CardView> cards) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(TOP.repeat(cards.size())).append("\n");
		
		for(CardView card : cards) {
			sb.append("│  ").append(colored(card, card.card().suit().getSymbol())).append("  │");
		}
		sb.append("\n");
		
		for(CardView card : cards) {
			sb.append("│ ").append("%2s".formatted(colored(card, card.card().rank().getSymbol()))).append("  │");
		}
		sb.append("\n");
		
		sb.append(BOTTOM.repeat(cards.size())).append("\n");
		
		writer.print(sb.toString());
	}
	
	private String colored(CardView card, String symbol) {
		
		String ansi = 
		switch(card.card().suit().getColor()) {
			// 콘솔창에서 검은색은 가독성이 안좋아서 BLUE 로 출력
			case BLACK -> ConsoleAnsi.TXT_BLUE;
			case RED -> ConsoleAnsi.TXT_RED;
		};
		
		return ansi + symbol + ConsoleAnsi.RESET;
	}
}
