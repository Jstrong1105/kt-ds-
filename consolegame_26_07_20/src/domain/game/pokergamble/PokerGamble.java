package domain.game.pokergamble;

import java.util.function.Supplier;

import common.ConsoleAnsi;
import common.InputReader;
import common.OutputWriter;
import domain.GameApp;
import domain.card.CardDeck;
import domain.card.CardPrinter;
import domain.card.PlayCard;

/**
 * GameApp 인터페이스를 구현한 클래스
 * 
 * 포커 겜블 사용자 인터페이스 담당
 */
class PokerGamble implements GameApp {
	
	private static final String GAME_PROMPT = "포커 겜블 입니다.";
	private static final String CARD_COUNT_INPUT = "카드 개수를 입력하세요.";
	private static final int MIN_CARD_COUNT = 5;
	private static final int MAX_CARD_COUNT = 7;
	
	private static final String CPU_CARD = "컴퓨터의 카드";
	private static final String PLAYER_CARD = "당신의 카드";
	private static final String TARGET_COIN_PROMPT = "목표 코인: %d";
	private static final String BET_COIN_PROMPT = "베팅 코인: %d";
	private static final String NOW_COIN_PROMPT = "현재 코인: %d";
	private static final String BET_PROMPT = "베팅 금액을 입력하세요.";
	
	private static final String FOLD_PROMPT = "기권했습니다.";
	private static final String WIN_PROMPT = "승리했습니다.";
	private static final String DRAW_PROMPT = "무승부입니다.";
	private static final String LOSE_PROMPT = "패배했습니다.";
	
	private static final String CLEAR_PROMPT = "목표를 달성했습니다.";
	private static final String FAIL_PROMPT = "코인을 모두 소모했습니다.";
	
	private static final String RESTART_PROMPT = "다시 시작하시겠습니까?";
	private static final String RESTART_YES = "Y";
	private static final String RESTART_NO = "N";
	
	private static final int TARGET_COIN = 10000;
	private static final int START_COIN = 1000;
	private static final int BASIC_BET = 100;
	
	private final InputReader reader;
	private final OutputWriter writer;
	private final CardDeck cardDeck;
	private final CardPrinter printer;
	private final HandEvaluator evaluator;
	
	private final HandCard playerCard;
	private final HandCard cpuCard;
	
	private PlayerState state;
	
	private int playerCoin;
	private int currentBetCoin;
	private int totalBetCoin;
	
	private boolean running;
	private boolean loop;
	
	private int cardCount;
	
	public PokerGamble(InputReader reader, OutputWriter writer, CardDeck cardDeck,
			CardPrinter printer, HandEvaluator evaluator, Supplier<HandCard> handCard) {
		this.reader = reader;
		this.writer = writer;
		this.printer = printer;
		this.cardDeck = cardDeck;
		this.evaluator = evaluator;
		this.playerCard = handCard.get();
		this.cpuCard = handCard.get();
	}
	
	@Override
	public void doGame() {
		
		do {
			
			init();
			
			while(running) {
				
				roundInit();
				
				while(loop) {
					
					render();
					betting();
					process();
				}
			}
			
		} while (restart());
	}
	
	private void init() {
		
		writer.println(ConsoleAnsi.SCREEN_CLEAR);
		writer.println(GAME_PROMPT);
		cardCount = reader.readIntRange(CARD_COUNT_INPUT, MIN_CARD_COUNT, MAX_CARD_COUNT);
		playerCoin = START_COIN;
		running = true;
	}
	
	private void roundInit() {
		
		if (playerCoin <= 0) {
			running = false;
			return;
		}
		
		loop = true;
		cardDeck.reset();
		playerCard.clear();
		cpuCard.clear();
		totalBetCoin = 0;
		
		if (playerCoin >= BASIC_BET) {
			totalBetCoin += BASIC_BET;
			playerCoin -= BASIC_BET;
		} else {
			totalBetCoin += playerCoin;
			playerCoin = 0;
		}
		
		drawCard();
		drawCard();
	}
	
	private void render() {
		writer.println(ConsoleAnsi.SCREEN_CLEAR);
		printer.printCard(cpuCard.getCardView());
		writer.println(CPU_CARD);
		printer.printCard(playerCard.getCardView());
		writer.println(PLAYER_CARD);
		writer.println(TARGET_COIN_PROMPT.formatted(TARGET_COIN));
		writer.println(BET_COIN_PROMPT.formatted(totalBetCoin));
		writer.println(NOW_COIN_PROMPT.formatted(playerCoin));
	}
	
	private void betting(){
		state = PlayerState.WAIT;
		currentBetCoin = reader.readIntRange(BET_PROMPT,0,playerCoin);
		if (currentBetCoin == 0 && playerCoin > 0) {
			state = PlayerState.FOLD;
		} else {
			state = PlayerState.RAISE;
			totalBetCoin += currentBetCoin;
			playerCoin -= currentBetCoin;
		}
	}

	private void process() {
		if (state == PlayerState.FOLD) {
			reader.pause(FOLD_PROMPT);
			loop = false;
		} else {
			if (playerCard.getSize() >= cardCount) {
				evaluate();
				loop = false;
			} else {
				drawCard();
			}
		}
	}
	
	private void evaluate() {
		HandResult cpuResult = evaluator.evaluate(cpuCard.getCard());
		HandResult playerResult = evaluator.evaluate(playerCard.getCard());
		showResult(cpuResult, playerResult);
		
		int result = playerResult.compareTo(cpuResult);
		
		if (result > 0) {
			playerCoin += 2 * totalBetCoin;
			reader.pause(WIN_PROMPT);
			
			if (playerCoin >= TARGET_COIN) {
				reader.pause(CLEAR_PROMPT);
				running = false;
			} 
			
		} else if (result < 0) {
			reader.pause(LOSE_PROMPT);
			
			if (playerCoin <= 0) {
				reader.pause(FAIL_PROMPT);
				running = false;
			}
			
		} else {
			playerCoin += totalBetCoin;
			reader.pause(DRAW_PROMPT);
		}
	}
	
	private void showResult(HandResult cpuResult, HandResult playerResult) {
		cpuCard.openAll();
		writer.println(ConsoleAnsi.SCREEN_CLEAR);
		printer.printCard(cpuCard.getCardView());
		writer.println(cpuResult.getShowName());
		printer.printCard(playerCard.getCardView());
		writer.println(playerResult.getShowName());
	}
	
	private boolean restart() {
		return reader.readBoolean(RESTART_PROMPT, RESTART_YES, RESTART_NO);
	}
	
	private void drawCard() {
		cpuCard.addCard(cardDeck.draw());
		PlayCard card = cardDeck.draw();
		card.openCard();
		playerCard.addCard(card);
	}
}
