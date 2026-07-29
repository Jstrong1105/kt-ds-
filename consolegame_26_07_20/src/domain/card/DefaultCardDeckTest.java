package domain.card;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultCardDeckTest {
	
	private static final long SEED = 1105L;
	/* 1105 시드 시 카드 순서 (뒤에서부터 나누어줌)
	CardView[card=Card[suit=HEART, rank=FOUR], open=false]
	CardView[card=Card[suit=HEART, rank=TWO], open=false]
	CardView[card=Card[suit=SPADE, rank=FIVE], open=false]
	CardView[card=Card[suit=SPADE, rank=TWO], open=false]
	CardView[card=Card[suit=CLUB, rank=FIVE], open=false]
	CardView[card=Card[suit=CLUB, rank=THREE], open=false]
	CardView[card=Card[suit=SPADE, rank=THREE], open=false]
	CardView[card=Card[suit=DIAMOND, rank=KING], open=false]
	CardView[card=Card[suit=HEART, rank=ACE], open=false]
	CardView[card=Card[suit=HEART, rank=JACK], open=false]
	CardView[card=Card[suit=CLUB, rank=QUEEN], open=false]
	CardView[card=Card[suit=CLUB, rank=KING], open=false]
	CardView[card=Card[suit=HEART, rank=FIVE], open=false]
	CardView[card=Card[suit=CLUB, rank=SIX], open=false]
	CardView[card=Card[suit=SPADE, rank=SIX], open=false]
	CardView[card=Card[suit=SPADE, rank=EIGHT], open=false]
	CardView[card=Card[suit=DIAMOND, rank=TWO], open=false]
	CardView[card=Card[suit=CLUB, rank=NINE], open=false]
	CardView[card=Card[suit=CLUB, rank=JACK], open=false]
	CardView[card=Card[suit=HEART, rank=THREE], open=false]
	CardView[card=Card[suit=DIAMOND, rank=TEN], open=false]
	CardView[card=Card[suit=CLUB, rank=TEN], open=false]
	CardView[card=Card[suit=SPADE, rank=FOUR], open=false]
	CardView[card=Card[suit=CLUB, rank=FOUR], open=false]
	CardView[card=Card[suit=HEART, rank=KING], open=false]
	CardView[card=Card[suit=DIAMOND, rank=JACK], open=false]
	CardView[card=Card[suit=CLUB, rank=TWO], open=false]
	CardView[card=Card[suit=HEART, rank=SEVEN], open=false]
	CardView[card=Card[suit=HEART, rank=SIX], open=false]
	CardView[card=Card[suit=HEART, rank=EIGHT], open=false]
	CardView[card=Card[suit=CLUB, rank=EIGHT], open=false]
	CardView[card=Card[suit=DIAMOND, rank=ACE], open=false]
	CardView[card=Card[suit=HEART, rank=NINE], open=false]
	CardView[card=Card[suit=HEART, rank=TEN], open=false]
	CardView[card=Card[suit=DIAMOND, rank=SEVEN], open=false]
	CardView[card=Card[suit=CLUB, rank=SEVEN], open=false]
	CardView[card=Card[suit=SPADE, rank=TEN], open=false]
	CardView[card=Card[suit=SPADE, rank=SEVEN], open=false]
	CardView[card=Card[suit=HEART, rank=QUEEN], open=false]
	CardView[card=Card[suit=CLUB, rank=ACE], open=false]
	CardView[card=Card[suit=SPADE, rank=QUEEN], open=false]
	CardView[card=Card[suit=SPADE, rank=KING], open=false]
	CardView[card=Card[suit=DIAMOND, rank=THREE], open=false]
	CardView[card=Card[suit=DIAMOND, rank=QUEEN], open=false]
	CardView[card=Card[suit=DIAMOND, rank=SIX], open=false]
	CardView[card=Card[suit=DIAMOND, rank=FOUR], open=false]
	CardView[card=Card[suit=SPADE, rank=ACE], open=false]
	CardView[card=Card[suit=DIAMOND, rank=EIGHT], open=false]
	CardView[card=Card[suit=DIAMOND, rank=FIVE], open=false]
	CardView[card=Card[suit=DIAMOND, rank=NINE], open=false]
	CardView[card=Card[suit=SPADE, rank=NINE], open=false]
	CardView[card=Card[suit=SPADE, rank=JACK], open=false]
	*/
	private DefaultCardDeck cardDeck;
	
	@BeforeEach
	void init() {
		cardDeck = new DefaultCardDeck(new Random(SEED));
	}
	
	@Test
	void cardDeck_첫번째카드_두번째카드() {
		PlayCard card = cardDeck.draw();
		assertEquals(CardSuit.SPADE, card.getCard().suit());
		assertEquals(CardRank.JACK, card.getCard().rank());
		card = cardDeck.draw();
		assertEquals(CardSuit.SPADE, card.getCard().suit());
		assertTrue(card.getCard().rank() == CardRank.NINE);
		assertEquals(CardRank.NINE, card.getCard().rank());
	}
	
	@Test
	void cardDeck_중복여부() {
		List<PlayCard> cards = new ArrayList<>();
		
		for(int i = 0; i < 52; i++) {
			cards.add(cardDeck.draw());
		}
		
		assertEquals(52L, cards.stream().distinct().count());
	}
	
	@Test
	void cardDeck_53장_뽑기() {
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
			for(int i = 0; i < 53; i++) {
				cardDeck.draw();
			}
		});
		assertEquals(DefaultCardDeck.EMPTY_DECK, e.getMessage());
	}
	
	@Test
	void cardDeck_50장_뽑고_reset_50장_뽑기() {
		assertDoesNotThrow(() -> {
			for(int i = 0; i < 50; i++) {
				cardDeck.draw();
			}
		});
		cardDeck.reset();
		assertDoesNotThrow(() -> {
			for(int i = 0; i < 50; i++) {
				cardDeck.draw();
			}
		});
	}
}
