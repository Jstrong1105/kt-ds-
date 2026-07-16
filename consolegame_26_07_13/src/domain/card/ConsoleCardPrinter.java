package domain.card;

import java.util.List;

import common.IOUtil;

/**
 * CardPrinter 인터페이스를 구현한 클래스
 * 
 * 카드 목록을 받아서 콘솔 화면에 출력하는 기능을 구현
 */
public class ConsoleCardPrinter implements CardPrinter{
	
	// 상수 선언
	private static final String NULL_CARD_ERROR = "출력 목록이 비어있습니다.";
	private static final String HIDDEN = "?";
	private static final String RESET = "\033[0m";
	
	private static final String TOP =  "┌─────┐ ";
	
	private static final String BOTTOM = "└─────┘ ";
	
	// 화면 출력 메소드
	@Override
	public void printCard(List<CardView> cards) {
		if(cards == null || cards.isEmpty()) {
			throw new IllegalArgumentException(NULL_CARD_ERROR);
		}
		
		// 출력할 카드의 길이 계산
		int count = cards.size();
		
		// 출력할 문자를 담아둘 객체 선언
		StringBuffer prompt = new StringBuffer();
		
		// 카드 상단 문자열
		prompt.append(TOP.repeat(count));
		prompt.append("\n");
		
		// 카드 모양 출력
		// 카드의 오픈 여부에 따른 처리
		for(CardView card : cards) {
			prompt.append(getText(card, card.getSuitSymbol()));
		}
		prompt.append("\n");
		
		// 카드 숫자 출력
		// 카드의 오픈 여부에 따른 처리
		for(CardView card : cards) {
			prompt.append(getText(card, card.getRankSymbol()));
		}
		prompt.append("\n");
		
		// 카드 하단 문자열
		prompt.append(BOTTOM.repeat(count));
		
		// 출력
		IOUtil.print(prompt.toString());
	}
	
	// 카드의 상태와 모양에 따라 화면에 출력할 문자열을 반환하는 메소드
	private String getText(CardView card, String symbol) {
		
		// 반환할 문자열을 담아둘 객체 선언
		StringBuffer prompt = new StringBuffer();
		
		// 열리지 않은 카드라면 HIDDEN 문자열 반환
		if(!card.open()) {
			prompt.append(String.format("│  %s  │ ", HIDDEN));
		}
		// 열린 카드라면 
		// 카드의 모양에 따라 색상을 추가해서 반환
		else {
			prompt.append("│  ");
			prompt.append(card.getSuitColor());
			prompt.append(symbol);
			prompt.append(RESET);
			
			prompt.append("  │ ");
		}
		
		return prompt.toString();
	}
}
