package domain.game.pokergamble;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.CardRank;
import domain.card.CardSuit;

class DefaultHandEvaluatorTest {
	
	private DefaultHandEvaluator evaluator;
	
	private List<Card> cards; 
	
	void add(CardSuit suit, CardRank rank) {
		cards.add(new Card(suit,rank));
	}
	
	@BeforeEach
	void 초기화() {
		evaluator = new DefaultHandEvaluator();
		cards = new ArrayList<>();
	}
	
	@Test
	void 유효하지않은카드판독() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> evaluator.evaluate(cards));
		assertEquals(DefaultHandEvaluator.NOT_VALID_CARDS, e.getMessage());
		add(CardSuit.SPADE, CardRank.ACE);
		add(CardSuit.SPADE, CardRank.EIGHT);
		add(CardSuit.SPADE, CardRank.FIVE);
		add(CardSuit.SPADE, CardRank.JACK);
		e = assertThrows(IllegalArgumentException.class, () -> evaluator.evaluate(cards));
		assertEquals(DefaultHandEvaluator.NOT_VALID_CARDS, e.getMessage());
	}
	
	@Test
	void 로얄스트레이트플러시() {
		add(CardSuit.SPADE, CardRank.ACE);
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.SPADE, CardRank.QUEEN);
		add(CardSuit.SPADE, CardRank.JACK);
		add(CardSuit.SPADE, CardRank.TEN);

		assertEquals(new HandResult(HandRank.ROYAL_FLUSH, List.of(CardRank.ACE))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 스트레이트플러시() {
		add(CardSuit.CLUB, CardRank.KING);
		add(CardSuit.CLUB, CardRank.QUEEN);
		add(CardSuit.CLUB, CardRank.JACK);
		add(CardSuit.CLUB, CardRank.TEN);
		add(CardSuit.CLUB, CardRank.NINE);
		
		assertEquals(new HandResult(HandRank.STRAIGHT_FLUSH, List.of(CardRank.KING))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 포카드() {
		add(CardSuit.DIAMOND, CardRank.FIVE);
		add(CardSuit.SPADE, CardRank.FIVE);
		add(CardSuit.CLUB, CardRank.FIVE);
		add(CardSuit.HEART, CardRank.FIVE);
		add(CardSuit.DIAMOND, CardRank.ACE);
		
		assertEquals(new HandResult(HandRank.FOUR_OF_A_KIND, List.of(CardRank.FIVE, CardRank.ACE))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 풀하우스() {
		add(CardSuit.DIAMOND, CardRank.EIGHT);
		add(CardSuit.SPADE, CardRank.EIGHT);
		add(CardSuit.CLUB, CardRank.EIGHT);
		add(CardSuit.DIAMOND, CardRank.NINE);
		add(CardSuit.HEART, CardRank.NINE);
		
		assertEquals(new HandResult(HandRank.FULL_HOUSE, List.of(CardRank.EIGHT, CardRank.NINE))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 플러시() {
		add(CardSuit.DIAMOND, CardRank.ACE);
		add(CardSuit.DIAMOND, CardRank.KING);
		add(CardSuit.DIAMOND, CardRank.JACK);
		add(CardSuit.DIAMOND, CardRank.EIGHT);
		add(CardSuit.DIAMOND, CardRank.SIX);
		
		assertEquals(new HandResult(HandRank.FLUSH
					, List.of(CardRank.ACE, CardRank.KING, CardRank.JACK, CardRank.EIGHT, CardRank.SIX))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 마운틴() {
		add(CardSuit.SPADE, CardRank.ACE);
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.SPADE, CardRank.QUEEN);
		add(CardSuit.SPADE, CardRank.JACK);
		add(CardSuit.HEART, CardRank.TEN);
		
		assertEquals(new HandResult(HandRank.MOUNTAIN, List.of(CardRank.ACE))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 스트레이트() {
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.HEART, CardRank.QUEEN);
		add(CardSuit.SPADE, CardRank.JACK);
		add(CardSuit.SPADE, CardRank.TEN);
		add(CardSuit.SPADE, CardRank.NINE);
		
		assertEquals(new HandResult(HandRank.STRAIGHT, List.of(CardRank.KING))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 백스트레이트() {
		add(CardSuit.SPADE, CardRank.ACE);
		add(CardSuit.SPADE, CardRank.FIVE);
		add(CardSuit.SPADE, CardRank.TWO);
		add(CardSuit.CLUB, CardRank.THREE);
		add(CardSuit.SPADE, CardRank.FOUR);
		
		assertEquals(new HandResult(HandRank.BACK_STRAIGHT, List.of(CardRank.FIVE))
					, evaluator.evaluate(cards));
	}
	
	@Test 
	void 트리플() {
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.DIAMOND, CardRank.KING);
		add(CardSuit.CLUB, CardRank.KING);
		add(CardSuit.SPADE, CardRank.TWO);
		add(CardSuit.SPADE, CardRank.ACE);
		
		assertEquals(new HandResult(HandRank.THREE_OF_A_KIND, List.of(CardRank.KING, CardRank.ACE, CardRank.TWO))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 투페어() {
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.DIAMOND, CardRank.KING);
		add(CardSuit.CLUB, CardRank.TWO);
		add(CardSuit.SPADE, CardRank.TWO);
		add(CardSuit.HEART, CardRank.ACE);
		
		assertEquals(new HandResult(HandRank.TWO_PAIR, List.of(CardRank.KING, CardRank.TWO, CardRank.ACE))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 원페어() {
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.DIAMOND, CardRank.KING);
		add(CardSuit.CLUB, CardRank.JACK);
		add(CardSuit.SPADE, CardRank.TWO);
		add(CardSuit.HEART, CardRank.ACE);
		
		assertEquals(new HandResult(HandRank.ONE_PAIR, List.of(CardRank.KING, CardRank.ACE, CardRank.JACK, CardRank.TWO))
					, evaluator.evaluate(cards));
	}
	
	@Test
	void 하이카드() {
		add(CardSuit.SPADE, CardRank.KING);
		add(CardSuit.SPADE, CardRank.QUEEN);
		add(CardSuit.SPADE, CardRank.JACK);
		add(CardSuit.SPADE, CardRank.TWO);
		add(CardSuit.HEART, CardRank.ACE);
		
		assertEquals(new HandResult(HandRank.HIGH_CARD, List.of(CardRank.ACE, CardRank.KING, CardRank.QUEEN, CardRank.JACK, CardRank.TWO))
					, evaluator.evaluate(cards));
	}
}
