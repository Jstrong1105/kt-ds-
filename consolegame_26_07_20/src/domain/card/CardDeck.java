package domain.card;

/**
 * 여러 장의 카드를 만들고 나누어 주는 기능을 가진 인터페이스
 */
public interface CardDeck {
	
	/**
	 * 카드 덱을 초기화하는 메소드
	 * reset 실행 시 이전에 나누어진 카드도 초기화할 것
	 */
	void reset();
	
	/**
	 * 카드를 나누어 주는 메소드
	 * @return 카드
	 * @throws IllegalStateException 나누어줄 카드가 없는 경우 발생
	 */
	PlayCard draw();
}
