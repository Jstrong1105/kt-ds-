package domain.card;

import java.util.List;

import common.ConsoleAnsi;
import common.OutputWriter;

/**
 * CardPrinter 를 구현한 클래스
 * 
 * 카드 뭉치를 받아서 간단한 형태로 출력하는 클래스
 */
public class SimpleCardPrinter implements CardPrinter {
	
	// 테스트를 위한 패키지 프라이빗
	static final String EMPTY_CARD = "비어있는 카드 뭉치입니다.";
	static final String TOP = "┌─────┐ ";
	static final String BOTTOM = "└─────┘ ";
	static final String HIDDEN_SYMBOL = "?";
	
	private final OutputWriter writer;
	
	public SimpleCardPrinter(OutputWriter writer) {
		this.writer = writer;
	}
	
	@Override
	public void printCard(List<CardView> cards) {
		if(cards == null || cards.size() == 0) {
			throw new IllegalArgumentException(EMPTY_CARD);
		}
		
		int size = cards.size();
		
		StringBuilder sb = new StringBuilder();
		sb.append(TOP.repeat(size));
		sb.append("\n");
		
		for(CardView view : cards) {
			sb.append("│  ");
			sb.append(getSymbol(view, view.card().suit().getSymbol()));
			sb.append("  │ ");
		}
		sb.append("\n");
		for(CardView view : cards) {
			sb.append("│  ");
			sb.append(getSymbol(view, view.card().rank().getSymbol()));
			sb.append("  │ ");
		}
		sb.append("\n");
		sb.append(BOTTOM.repeat(size));
		
		writer.print(sb.toString());
	}
	
	private String getSymbol(CardView view, String symbol) {
		
		if (view.open()) {
			CardColor c = view.card().suit().getColor();
			// 콘솔창 가독성 이슈로 검은색인 SPADE 와 CLUB 을 파란색으로 표현
			String color = switch(c) {
				case BLACK -> ConsoleAnsi.TXT_BLUE;
				case RED -> ConsoleAnsi.TXT_RED;
			};
			return color + symbol + ConsoleAnsi.RESET;
		} else {
			return HIDDEN_SYMBOL;
		}
	}
}
