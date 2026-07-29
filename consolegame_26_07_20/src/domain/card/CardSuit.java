package domain.card;

/**
 * 트럼프 카드가 가지는 형태 모음
 * 표시 모양과 색상 종류를 가지고 있음
 */
public enum CardSuit {
	
	SPADE("♠",CardColor.BLACK)
	, DIAMOND("◆",CardColor.RED)
	, HEART("♥",CardColor.RED)
	, CLUB("♣",CardColor.BLACK)
	;
	
	private final String symbol;
	private final CardColor color;
	
	private CardSuit(String symbol, CardColor color) {
		this.symbol = symbol; 	
		this.color = color;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public CardColor getColor() {
		return color;
	}
}
