package domain.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.FakeOutputWriter;

class SimpleCardPrinterTest {

	private SimpleCardPrinter printer;
	private List<CardView> cards;
	private FakeOutputWriter writer;
	
	void of(CardSuit suit, CardRank rank, boolean open) {
		cards.add(new CardView(new Card(suit, rank), open));
	}
	
	@BeforeEach
	void 초기화() {
		cards = new ArrayList<>();
		writer = new FakeOutputWriter();
		printer = new SimpleCardPrinter(writer);
	}
	
	@Test
	void printCard_빈파라미터() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			printer.printCard(null);
		});
		assertEquals(SimpleCardPrinter.EMPTY_CARD, e.getMessage());
		e = assertThrows(IllegalArgumentException.class, () -> {
			printer.printCard(cards);
		});
		assertEquals(SimpleCardPrinter.EMPTY_CARD, e.getMessage());
	}
	
	@Test
	void printCard_출력확인() {
		of(CardSuit.SPADE,CardRank.ACE,true);
		of(CardSuit.DIAMOND,CardRank.EIGHT,false);
		of(CardSuit.HEART,CardRank.FOUR,false);
		of(CardSuit.CLUB,CardRank.KING,false);
		
		printer.printCard(cards);
		
		assertTrue(writer.output().contains(SimpleCardPrinter.TOP.repeat(4)));
		assertTrue(writer.output().contains(SimpleCardPrinter.BOTTOM.repeat(4)));
		assertTrue(writer.output().contains(CardSuit.SPADE.getSymbol()));
		assertTrue(writer.output().contains(CardRank.ACE.getSymbol()));
		assertFalse(writer.output().contains(CardSuit.DIAMOND.getSymbol()));
		assertFalse(writer.output().contains(CardRank.EIGHT.getSymbol()));
		assertTrue(writer.output().contains(SimpleCardPrinter.HIDDEN_SYMBOL));
	}
}
