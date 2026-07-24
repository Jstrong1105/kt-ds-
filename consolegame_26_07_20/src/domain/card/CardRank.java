package domain.card;

/**
 * 트럼프 카드 등급 목록
 */
public enum CardRank {
	ACE("A",14)
	, KING("K",13)
	, QUEEN("Q",12)
	, JACK("J",11)
	, TEN("T",10)
	, NINE("9",9)
	, EIGHT("8",8)
	, SEVEN("7",7)
	, SIX("6",6)
	, FIVE("5",5)
	, FOUR("4",4)
	, THREE("3",3)
	, TWO("2",2)
	;
	
	private final String symbol;
	private final int order;
	
	private CardRank(String symbol, int order) {
		this.symbol = symbol;
		this.order = order;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getOrder() {
		return order;
	}
}
