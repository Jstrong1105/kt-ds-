package domain.card;

/**
 * 카드 덱 인터페이스
 * 카드 뭉치를 가지고 나누어 주는 기능을 수행
 * 
 * 조커가 없는 52장의 카드 조합을 나누어 주는 덱
 * 
 * 카드덱을 초기화하는 기능을 제공 
 * 카드덱 초기화 시 초기화 전에 나누어준 카드와 섞이지 않도록 주의
 */
public interface CardDeck {
	
	/**
	 * 카드덱 초기화
	 */
	void reset();
	
	/**
	 * 카드 나누어 주기
	 * @return 카드 한장
	 * @throws IllegalStateException 카드가 덱에 한장도 없는 경우
	 */
	PlayCard draw();
}
