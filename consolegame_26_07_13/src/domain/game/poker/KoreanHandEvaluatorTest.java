package domain.game.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.CardRank;
import domain.card.CardSuit;

/**
 * KoreanHandEvaluator 테스트 
 */
class KoreanHandEvaluatorTest {

	private final HandEvaluator evaluator = new KoreanHandEvaluator();
	
	@Test
	void 판정() {
		
		List<Card> cards = List.of(
					new Card(CardSuit.SPADE,CardRank.ACE)
					, new Card(CardSuit.CLUB,CardRank.KING)
					, new Card(CardSuit.SPADE,CardRank.QUEEN)
					, new Card(CardSuit.SPADE,CardRank.JACK)
					, new Card(CardSuit.SPADE,CardRank.TEN)
				);
		
		HandResult result = evaluator.evaluate(cards);
		
		assertEquals(HandRank.MOUNTAIN, result.rank());
		assertEquals(List.of(CardRank.ACE), result.kickers());
	}
}
