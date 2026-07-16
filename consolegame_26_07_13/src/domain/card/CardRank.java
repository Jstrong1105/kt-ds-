package domain.card;

/**
 * 카드 한장이 가지는 숫자
 */
public enum CardRank {
	TWO("2",2)
	, THREE("3",3)
	, FOUR("4",4)
	, FIVE("5",5)
	, SIX("6",6)
	, SEVEN("7",7)
	, EIGHT("8",8)
	, NINE("9",9)
	, TEN("T",10)
	, JACK("J",11)
	, QUEEN("Q",12)
	, KING("K",13)
	, ACE("A",14)
	;
	
	// 화면에 표시할 모양
	private final String symbol;
	
	// 카드의 순서
	// 실제 비교 기준은 게임 별도 상이함
	private final int order;
	
	// 생성자
	private CardRank(String symbol, int order) {
		this.symbol = symbol;
		this.order = order;
	}
	
	// getter
	public String getSymbol() {
		return symbol;
	}
	
	public int getOrder() {
		return order;
	}
}
