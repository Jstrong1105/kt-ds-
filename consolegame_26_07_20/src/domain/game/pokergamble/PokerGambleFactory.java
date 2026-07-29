package domain.game.pokergamble;

import java.util.function.Supplier;

import common.GameIO;
import common.InputReader;
import common.OutputWriter;
import domain.GameApp;
import domain.card.CardDeck;
import domain.card.CardPrinter;
import domain.card.DefaultCardDeck;
import domain.card.SimpleCardPrinter;

/**
 * 포커 겜블 공장
 */
public class PokerGambleFactory {
	
	private final InputReader reader;
	private final OutputWriter writer;
	private final CardDeck cardDeck;
	private final CardPrinter printer;
	private final HandEvaluator evaluator;
	private final Supplier<HandCard> handCard;
	
	public PokerGambleFactory(GameIO io) {
		this.reader = io.reader();
		this.writer = io.writer();
		this.cardDeck = new DefaultCardDeck();
		this.printer = new SimpleCardPrinter(this.writer);
		this.evaluator = new DefaultHandEvaluator();
		this.handCard = () -> new DefaultHandCard();
	}
	
	public GameApp getGame() {
		
		return new PokerGamble(reader, writer, cardDeck, printer, evaluator, handCard); 
	}
}
