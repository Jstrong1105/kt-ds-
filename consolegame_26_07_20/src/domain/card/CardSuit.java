package domain.card;

/**
 * 트럼프 카드 모양 목록
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
