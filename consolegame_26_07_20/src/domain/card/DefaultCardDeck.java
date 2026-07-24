package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * CardDeck 인터페이스를 구현한 클래스
 */
public class DefaultCardDeck implements CardDeck {

	// 테스트 용 패키지 프라이빗
	static final String EMPTY_CARD_DECK = "카드 덱이 비어있습니다.";
	
	private final List<PlayCard> cards;
	private final Random random;
	
	public DefaultCardDeck() {
		this(new Random()); 
	}
	
	public DefaultCardDeck(Random random) {
		this.cards = new ArrayList<>();
		this.random = random;
		reset();
	}
	
	@Override
	public void reset() {
		cards.clear();
		
		for(CardSuit suit : CardSuit.values()) {
			for(CardRank rank : CardRank.values()) {
				cards.add(new PlayCard(new Card(suit,rank)));
			}
		}
		
		Collections.shuffle(cards, random);
	}
	
	@Override
	public PlayCard draw() {
		if(cards.isEmpty()) {
			throw new IllegalStateException(EMPTY_CARD_DECK);
		}
		return cards.remove(cards.size()-1);
	}
}
