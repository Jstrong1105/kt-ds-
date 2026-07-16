package domain.card;

/**
 * 카드 객체 한장이 가지는 모양
 * 
 * \033[94m : 블루
 * \033[91m : 레드
 */
public enum CardSuit {
	SPADE("♠","스페이드","\033[94m")
	, DIAMOND("◆","다이아","\033[91m")
	, HEART("♥","하트","\033[91m")
	, CLUB("♣","클로버","\033[94m")
	;
	
	// 속성
	// 콘솔에 출력할 모양
	private final String symbol;
	// 콘솔에 표시할 이름
	private final String koreanName;
	// 콘솔에 출력할 색상
	private final String color;
	
	// 생성자
	private CardSuit(String symbol, String koreanName, String color) {
		this.symbol = symbol;
		this.koreanName = koreanName;
		this.color = color;
	}
	
	// getter
	public String getSymbol() {
		return symbol;
	}
	
	public String getKoreanName() {
		return koreanName;
	}
	
	public String getColor() {
		return color;
	}
}
