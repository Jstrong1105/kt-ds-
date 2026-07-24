package domain.game.minesweeper;

import java.time.Duration;
import java.time.Instant;

import common.ConsoleAnsi;
import common.InputReader;
import common.OutputWriter;
import domain.GameApp;

/**
 * 지뢰찾기 구체 클래스
 * 
 * 패키지 프라이빗 
 */
class Minesweeper implements GameApp {
	
	// 테스트를 위한 패키지 프라이빗
	static final String GAME_PROMPT = "지뢰찾기 게임입니다.";
	static final String SIZE_INPUT = "사이즈를 입력하세요.";
	static final String MINE_INPUT = "지뢰 비율을 입력하세요.";
	static final String ROW_INPUT = "행을 입력하세요.";
	static final String COL_INPUT = "열을 입력하세요.";
	static final String NOT_VALID_POSITION = "이미 오픈된 셀입니다.";
	static final String MINE_COUNT = "지뢰 수 %d";
	static final String FLAG_COUNT = "현재 깃발 수 %d";
	static final String ACTION_PROMPT = "1.오픈\n2.깃발\n3.취소";
	static final String FLAG_OPEN = "깃발은 열 수 없습니다.";
	static final String SUCCESS_PROMPT = "클리어 타임: %d초";
	static final String FAIL_PROMPT = "실패";
	static final String RESTART_PROMPT = "다시 시작하시겠습니까?";
	static final String RESTART_TRUE = "Y";
	static final String RESTART_FALSE = "N";
	
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 20;
	private static final int MIN_MINE_PERCENT = 10;
	private static final int MAX_MINE_PERCENT = 20;
	
	private final InputReader reader;
	private final OutputWriter writer;
	private final CellBoard board;
	private final CellPrinter printer;
	
	private Instant startTime;
	
	private boolean run; 
	private int size;
	private int minePercent;
	private int mineCount;
	private CellPosition choice;
	
	Minesweeper(InputReader reader, OutputWriter writer, CellBoard board, CellPrinter printer){
		this.reader = reader;
		this.writer = writer;
		this.board = board;
		this.printer = printer;
	}
	
	@Override
	public void doGame() {
		do {
			this.init();
			this.startGame();
			
			while(this.run) {
				this.render();
				this.selectCell();
				this.render();
				this.action();
			}
		} while (this.restart());
	}
	
	/**
	 * 게임 초기화 로직
	 */
	private void init() {
		this.writer.println(ConsoleAnsi.SCREEN_CLEAR);
		this.writer.println(GAME_PROMPT);
		this.size = this.reader.readIntRange(SIZE_INPUT, MIN_SIZE, MAX_SIZE);
		this.minePercent = this.reader.readIntRange(MINE_INPUT, MIN_MINE_PERCENT, MAX_MINE_PERCENT);
		this.mineCount = this.size * this.size * this.minePercent / 100;
		this.board.reset(this.size, this.mineCount);
		this.startTime = Instant.now(); 
	}
	
	private void startGame() {
		this.run = true;
	}
	
	private void endGame() {
		this.run = false;
	}
	
	private void render() {
		this.writer.println(ConsoleAnsi.SCREEN_CLEAR);
		this.printer.printCell(this.board.getBoard(), this.size, this.choice);
		this.writer.println(FLAG_COUNT.formatted(this.board.flagCount()));
		this.writer.println(MINE_COUNT.formatted(this.mineCount));
	}
	
	private void selectCell() {
		
		do {
			int row = this.reader.readIntRange(ROW_INPUT, 1, size) -1;
			int col = this.reader.readIntRange(COL_INPUT, 1, size) -1;
			this.choice = new CellPosition(row, col);
			
			if(this.board.isOpen(this.choice)) {
				this.reader.pause(NOT_VALID_POSITION);
			}
		} while (this.board.isOpen(this.choice));
	}
	
	private void action() {
		int action = this.reader.readIntRange(ACTION_PROMPT, 1, 3);
		switch(action) {
			case 1 -> this.openCell();
			case 2 -> this.toggleFlag();
			case 3 -> this.cancelCell();
		};
	}
	
	private void openCell() {
		
		OpenResult result = this.board.openCell(choice); 
		this.cancelCell();
		
		if (result == OpenResult.SAFE && this.board.isClear()) {
			finish();
		}
		else if (result == OpenResult.BLOCKED) {
			this.reader.pause(FLAG_OPEN);
		} else if (result == OpenResult.EXPLODED) {
			this.finish();
		}
	}
	
	private void toggleFlag() {
		this.board.toggleFlag(this.choice);
		this.cancelCell();
	}
	
	private void cancelCell() {
		this.choice = null;
	}
	
	private void finish() {
		this.writer.println(ConsoleAnsi.SCREEN_CLEAR);
		this.board.openMine();
		this.printer.printCell(this.board.getBoard(), this.size, null);
		this.writer.println("");
		if(this.board.isClear()) {
			this.writer.println(SUCCESS_PROMPT.formatted(Duration.between(startTime, Instant.now()).getSeconds()));
		} else {
			this.writer.println(FAIL_PROMPT);
		}
		this.endGame();
	}
	
	private boolean restart() {
		return this.reader.readBoolean(RESTART_PROMPT, RESTART_TRUE, RESTART_FALSE);
	}
}
