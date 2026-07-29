package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * CardDeck 인터페이스를 구현한 카드덱 클래스
 * 조커 미포함 52장 카드를 생성하고 나누어 준다.
 */
public class DefaultCardDeck implements CardDeck {
	
	// 테스트를 위한 패키지 프라이빗
	static final String EMPTY_DECK = "카드 덱이 비어있습니다.";
	
	private final List<PlayCard> cardDeck;
	private final Random random;
	
	// 인자 없는 생성자 - 실 사용 용도
	public DefaultCardDeck() {
		this(new Random());
	}
	
	// 랜덤 인자 생성자 - 테스트 용 시드 고정
	public DefaultCardDeck(Random random) {
		this.random = random;
		this.cardDeck = new ArrayList<>();
		reset();
	}
	
	@Override
	public void reset() {
		
		cardDeck.clear();
		
		for(CardSuit suit : CardSuit.values()) {
			for(CardRank rank : CardRank.values()) {
				cardDeck.add(new PlayCard(new Card(suit, rank)));
			}
		}
		
		Collections.shuffle(cardDeck, random);
	}
	
	@Override
	public PlayCard draw() {
		if(cardDeck.isEmpty()) {
			throw new IllegalStateException(EMPTY_DECK);
		}
		// 리스트 인덱스 처리 최적화를 위해서 뒤에서 부터 뽑아줌
		return cardDeck.remove(cardDeck.size() - 1);
	}
}
