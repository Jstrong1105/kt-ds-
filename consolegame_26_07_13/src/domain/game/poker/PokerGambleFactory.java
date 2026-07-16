package domain.game.poker;

import domain.GameApp;
import domain.card.CardDeck;
import domain.card.CardPrinter;
import domain.card.ConsoleCardPrinter;
import domain.card.StandardCardDeck;

/**
 * 포커 겜블 구현체를 생성하는 클래스
 * 
 * 패키지 내에서 유일한 public 클래스
 * 
 * 생성 과정에서 필요한 인스턴스를 주입한다.
 */
public class PokerGambleFactory {
	
	public GameApp getGame() {
		
		Hand playerHand = new DefaultHand();
		Hand cpuHand = new DefaultHand();
		CardDeck deck = new StandardCardDeck();
		CardPrinter printer = new ConsoleCardPrinter();
		HandEvaluator evaluator = new KoreanHandEvaluator();
		
		GameApp game = new PokerGambleApp(playerHand, cpuHand, deck, printer, evaluator);
		
		return game;
	}
}
