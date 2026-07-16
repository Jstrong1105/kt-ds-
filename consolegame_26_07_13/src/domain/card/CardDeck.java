package domain.card;

/**
 * 52장의 카드를 생성하고 셔플하고 나누어 주는 기능을 수행하는 인터페이스
 */
public interface CardDeck {
	
	// 초기화 
	// 52장 생성 및 셔플
	void init();
	
	// 한장의 카드 나누어주기
	// 덱에 있는 카드 감소
	Card drawCard();
}
