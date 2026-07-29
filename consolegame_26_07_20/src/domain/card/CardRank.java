package domain.card;

/**
 * 트럼프 카드가 가지는 숫자 모음
 * 표시 형태와 등급을 가지고 있음
 * 콘솔 창 출력 폭을 맞추기 위해서 10을 T 로 표시 
 * 등급은 포커 족보 기준으로 가지고 있음
 * 비교 기준이 다른 경우 별도로 구현할 것
 */
public enum CardRank {
	
	ACE("A",14)
	,KING("K",13)
	,QUEEN("Q",12)
	,JACK("J",11)
	,TEN("T",10)
	,NINE("9",9)
	,EIGHT("8",8)
	,SEVEN("7",7)
	,SIX("6",6)
	,FIVE("5",5)
	,FOUR("4",4)
	,THREE("3",3)
	,TWO("2",2)
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
