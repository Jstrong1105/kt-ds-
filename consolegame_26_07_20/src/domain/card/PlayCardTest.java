package domain.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayCardTest {
	
	@Test
	void PlayCard_NULL_카드() {
		assertThrows(NullPointerException.class, () -> new PlayCard(null));
	}
	
	@Test
	void PlayCard_open_hide() {
		PlayCard card = new PlayCard(new Card(CardSuit.SPADE, CardRank.ACE));
		assertFalse(card.isOpen());
		card.openCard();
		assertTrue(card.isOpen());
		card.hideCard();
		assertFalse(card.isOpen());
	}
	
	@Test 
	void PlayCard_toView() {
		Card card = new Card(CardSuit.SPADE, CardRank.ACE);
		PlayCard pCard = new PlayCard(card);
		assertEquals(new CardView(card, false), pCard.toView());
	}
}
