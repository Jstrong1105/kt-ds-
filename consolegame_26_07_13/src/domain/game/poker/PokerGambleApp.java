package domain.game.poker;

import common.ConsoleUtil;
import common.IOUtil;
import domain.RoundActionTemplate;
import domain.card.CardDeck;
import domain.card.CardPrinter;
import domain.card.GameCard;

/**
 * 포커 게임 구현체
 * 
 * RoundActionTemplate 을 상속받아 구현
 * 
 * 패키지 프라이빗
 */
class PokerGambleApp extends RoundActionTemplate{
	
	// 상수 선언
	// 목표 코인
	private static final int TARGET_COIN = 5000;
	// 시작 코인
	private static final int START_COIN = 1000;
	// 기본 베팅금
	private static final int BASIC_BET_COIN = 100;
	// 승리 시 획득하는 배율
	private static final int WIN_PERCENT = 2;
	// 안내 메시지
	private static final String BET_PROMPT = "베팅 금액을 입력하세요";
	
	// 현재 플레이어의 코인
	private int currentPlayerCoin;
	// 현재 턴에 베팅한 금액
	private int currentBetCoin;
	// 현재 라운드 전체 베팅 금액
	private int totalBetCoin;
	
	// 플레이어가 가진 카드
	private final Hand playerHand;
	// 컴퓨터가 가진 카드
	private final Hand cpuHand;
	// 딜러의 카드
	private final CardDeck deck;
	// 카드 출력 객체
	private final CardPrinter printer;
	// 족보 평가 객체
	private final HandEvaluator evaluator;
	// 플레이어의 족보
	private HandResult playerResult;
	// 컴퓨터의 족보
	private HandResult cpuResult;
	// 5 , 7 포커 사이즈
	private int size;
	
	// 생성자
	PokerGambleApp(Hand playerHand, Hand cpuHand
			, CardDeck deck, CardPrinter printer, HandEvaluator evaluator){
		this.playerHand = playerHand;
		this.cpuHand = cpuHand;
		this.deck = deck;
		this.printer = printer;
		this.evaluator = evaluator;
	}
	
	@Override
	protected void init() {
		
		ConsoleUtil.clearConsole();
		IOUtil.print("포커 겜블입니다.\n");
		boolean five = IOUtil.readBoolean("옵션 선택 : 5포커 / 7포커","5","7");
		if(five) {
			size = 5;
		}else {
			size = 7;
		}
		currentPlayerCoin = START_COIN;
	}
	
	@Override
	protected void roundInit() {
		
		// 손패 초기화
		playerHand.clear();
		cpuHand.clear();
		
		// 딜러 카드 초기화
		deck.init();
		
		// 베팅 금액 초기화
		totalBetCoin = 0;
		
		// 초기 기본 베팅
		if(currentPlayerCoin >= BASIC_BET_COIN) {
			totalBetCoin += BASIC_BET_COIN;
			currentPlayerCoin -= BASIC_BET_COIN;
		}else {
			currentBetCoin += currentPlayerCoin;
			currentPlayerCoin = 0;
		}
		
		drawCard();
		drawCard();
	}
	
	@Override
	protected void render() {
		ConsoleUtil.clearConsole();
		printer.printCard(cpuHand.getViews());
		IOUtil.print("CPU 카드\n");
		printer.printCard(playerHand.getViews());
		IOUtil.print("당신의 카드\n");
		IOUtil.print("목표 코인 : " + TARGET_COIN + "\n");
		IOUtil.print("현재 베팅 금액 : " + totalBetCoin + "\n");
		IOUtil.print("남은 코인 : " + currentPlayerCoin + "\n");
	}
	
	@Override
	protected void play() {
		currentBetCoin = IOUtil.readIntRange(BET_PROMPT, 0, currentPlayerCoin);
		currentPlayerCoin -= currentBetCoin;
		totalBetCoin += currentBetCoin;
	}
	
	@Override
	protected void update() {
		// 베팅하지 않음 (FOLD)
		if(currentBetCoin == 0 && currentPlayerCoin > 0) {
			IOUtil.pause("기권");
			endRound();
		}
		// 베팅함
		else {
			// 아직 카드를 전부 받지 않음
			if(playerHand.size() < size) {
				drawCard();
			}
			// 카드를 전부 받음
			else {
				finish();
			}
		}
	}
	
	// 카드 나누어주기
	private void drawCard() {
		cpuHand.addCard(new GameCard(deck.drawCard()));
		GameCard card = new GameCard(deck.drawCard());
		card.openCard();
		playerHand.addCard(card);
	}
	
	private void finish() {
		ConsoleUtil.clearConsole();
		cpuHand.openAllCard();
		playerResult = evaluator.evaluate(playerHand.getCards());
		cpuResult = evaluator.evaluate(cpuHand.getCards());
		
		printer.printCard(cpuHand.getViews());
		IOUtil.print(cpuResult.toString() + "\n");
		
		printer.printCard(playerHand.getViews());
		IOUtil.print(playerResult.toString() + "\n");
		
		int result = playerResult.compareTo(cpuResult);
		
		String prompt = "";
		
		if(result > 0) {
			currentPlayerCoin += totalBetCoin * WIN_PERCENT;
			prompt = "승리";
		} else if (result == 0) {
			currentPlayerCoin += totalBetCoin;
			prompt = "무승부";
		} else {
			prompt = "패배";
		}
		IOUtil.pause(prompt);
		
		endRound();
	}
	
	@Override
	protected void check() {
		
		if(currentPlayerCoin >= TARGET_COIN) {
			IOUtil.print("목표 달성\n");
			endGame();
		} else if(currentPlayerCoin <= 0) {
			IOUtil.print("코인 소진\n");
			endGame();
		}
	}
}
