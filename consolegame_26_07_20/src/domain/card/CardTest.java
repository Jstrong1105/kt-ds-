package domain.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void Card_생성에_널_인자() {
		assertThrows(NullPointerException.class, () -> new Card(null, CardRank.ACE));
		assertThrows(NullPointerException.class, () -> new Card(CardSuit.HEART, null));
		assertThrows(NullPointerException.class, () -> new Card(null, null));
	}
	
	@Test
	void Card_데이터_확인() {
		Card card = new Card(CardSuit.SPADE, CardRank.ACE);
		assertEquals(CardSuit.SPADE, card.suit());
		assertEquals(CardRank.ACE, card.rank());
		assertEquals(CardColor.BLACK, card.suit().getColor());
		assertEquals("♠", card.suit().getSymbol());
		assertEquals("A", card.rank().getSymbol());
	}
}
