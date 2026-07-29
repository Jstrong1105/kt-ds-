package domain.card;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 특정 카드를 반환하는 가짜 카드덱
 * 
 * reset 이 아무것도 하지 않는다.
 */
public class FakeCardDeck implements CardDeck {
	
	private Deque<PlayCard> cards = new ArrayDeque<>();
	
	@Override
	public void reset() {
	}
	
	@Override
	public PlayCard draw() {
		PlayCard card = cards.remove();
		if (card == null) {
			throw new IllegalStateException("카드 소진 (시나리오 오류)");
		}
		return card;
	}
	
	public void set(PlayCard... cards) {
		for(PlayCard c : cards) {
			this.cards.add(c);
		}
	}
}
