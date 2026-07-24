package domain.card;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultCardDeckTest {

	private static final long SEED = 1105L;
	/*   1105 시드 순서
		 Card[suit=HEART, rank=FOUR]
		 Card[suit=CLUB, rank=QUEEN]
		 Card[suit=DIAMOND, rank=THREE]
		 Card[suit=SPADE, rank=QUEEN]
		 Card[suit=DIAMOND, rank=EIGHT]
		 Card[suit=CLUB, rank=KING]
		 Card[suit=CLUB, rank=JACK]
		 Card[suit=CLUB, rank=TWO]
		 Card[suit=HEART, rank=NINE]
		 Card[suit=HEART, rank=QUEEN]
		 Card[suit=HEART, rank=SIX]
		 Card[suit=CLUB, rank=SIX]
		 Card[suit=SPADE, rank=KING]
		 Card[suit=CLUB, rank=FIVE]
		 Card[suit=HEART, rank=THREE]
		 Card[suit=SPADE, rank=ACE]
		 Card[suit=HEART, rank=JACK]
		 Card[suit=DIAMOND, rank=JACK]
		 Card[suit=DIAMOND, rank=QUEEN]
		 Card[suit=DIAMOND, rank=SEVEN]
		 Card[suit=HEART, rank=SEVEN]
		 Card[suit=DIAMOND, rank=KING]
		 Card[suit=CLUB, rank=TEN]
		 Card[suit=HEART, rank=EIGHT]
		 Card[suit=DIAMOND, rank=FIVE]
		 Card[suit=HEART, rank=KING]
		 Card[suit=CLUB, rank=NINE]
		 Card[suit=SPADE, rank=TEN]
		 Card[suit=DIAMOND, rank=SIX]
		 Card[suit=CLUB, rank=THREE]
		 Card[suit=SPADE, rank=NINE]
		 Card[suit=CLUB, rank=SEVEN]
		 Card[suit=DIAMOND, rank=TWO]
		 Card[suit=DIAMOND, rank=FOUR]
		 Card[suit=SPADE, rank=JACK]
		 Card[suit=CLUB, rank=FOUR]
		 Card[suit=HEART, rank=FIVE]
		 Card[suit=SPADE, rank=THREE]
		 Card[suit=SPADE, rank=EIGHT]
		 Card[suit=HEART, rank=TWO]
		 Card[suit=SPADE, rank=TWO]
		 Card[suit=CLUB, rank=ACE]
		 Card[suit=CLUB, rank=EIGHT]
		 Card[suit=SPADE, rank=FOUR]
		 Card[suit=SPADE, rank=SIX]
		 Card[suit=DIAMOND, rank=NINE]
		 Card[suit=SPADE, rank=SEVEN]
		 Card[suit=DIAMOND, rank=ACE]
		 Card[suit=DIAMOND, rank=TEN]
		 Card[suit=SPADE, rank=FIVE]
		 Card[suit=HEART, rank=TEN]
		 Card[suit=HEART, rank=ACE]
	 */
	private DefaultCardDeck cardDeck;
	
	@BeforeEach
	void 초기화() {
		cardDeck = new DefaultCardDeck(new Random(SEED));
	}
	
	@Test
	void drawCard_53장뽑기() {
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
			for(int i = 0; i < 53; i++) {
				cardDeck.draw();
			}
		});
		
		assertEquals(DefaultCardDeck.EMPTY_CARD_DECK, e.getMessage());
	}
	
	@Test
	void drawCard_50장뽑고_reset이후_50장() {
		assertDoesNotThrow(() -> {
			for(int i = 0; i < 50; i++) {
				cardDeck.draw();
			}
			cardDeck.reset();
			for(int i = 0; i < 50; i++) {
				cardDeck.draw();
			}
		});
	}
	
	@Test
	void drawCard_52장뽑고_중복검사() {
		List<PlayCard> deck = new ArrayList<>();
		for(int i = 0; i < 52; i++) {
			deck.add(cardDeck.draw());
		}
		
		assertEquals(52L,deck.stream().map(PlayCard::getCard).distinct().count());
	}
}
