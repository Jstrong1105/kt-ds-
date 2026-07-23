package domain.game.minesweeper;

import common.InputReader;
import common.OutputWriter;
import domain.GameApp;

/**
 * 지뢰찾기 구체 클래스
 * 
 * 패키지 프라이빗 
 */
class Minesweeper implements GameApp {
	
	private static final String GAME_PROMPT = "지뢰찾기 게임입니다.";
	private static final String SIZE_INPUT = "사이즈를 입력하세요.";
	private static final String MINE_INPUT = "지뢰 비율을 입력하세요.";
	private static final String ROW_INPUT = "행을 입력하세요.";
	private static final String COL_INPUT = "열을 입력하세요.";
	private static final String NOT_VALID_POSITION = "이미 오픈된 셀입니다.";
	private static final String ACTION_PROMPT = "1.오픈\n2.깃발\n3.취소";
	private static final String FLAG_OPEN = "깃발은 열 수 없습니다.";
	private static final String SUCCESS_PROMPT = "승리";
	private static final String FAIL_PROMPT = "실패";
	private static final String RESTART_PROMPT = "다시 시작하시겠습니까?";
	private static final String RESTART_TRUE = "Y";
	private static final String RESTART_FALSE = "N";
	
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 20;
	private static final int MIN_MINE_PERCENT = 10;
	private static final int MAX_MINE_PERCENT = 20;
	
	private final InputReader reader;
	private final OutputWriter writer;
	private final CellBoard board;
	private final CellPrinter printer;
	
	private boolean run; 
	private int size;
	private int minePercent;
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
		this.writer.println(GAME_PROMPT);
		this.size = this.reader.readIntRange(SIZE_INPUT, MIN_SIZE, MAX_SIZE);
		this.minePercent = this.reader.readIntRange(MINE_INPUT, MIN_MINE_PERCENT, MAX_MINE_PERCENT);
		this.board.reset(this.size, (this.size * this.size * this.minePercent / 100) );
	}
	
	private void startGame() {
		this.run = true;
	}
	
	private void endGame() {
		this.run = false;
	}
	
	private void render() {
		this.printer.printCell(this.board.getBoard(), this.size, this.choice);
	}
	
	private void selectCell() {
		
		int row;
		int col;
		
		do {
			row = this.reader.readIntRange(ROW_INPUT, 1, size) -1;
			col = this.reader.readIntRange(COL_INPUT, 1, size) -1;
			this.choice = new CellPosition(row, col);
			
			if(this.board.isOpen(this.choice)) {
				this.reader.pause(NOT_VALID_POSITION);
			}
		} while (this.board.isOpen(this.choice));
	}
	
	private void action() {
		int action = this.reader.readIntRange(ACTION_PROMPT, 1, 3);
		if(action == 1) {
			this.openCell();
		} else if(action == 2) {
			this.toggleFlag();
		} else if(action == 3) {
			this.cancelCell();
		}
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
		this.board.openMine();
		this.printer.printCell(this.board.getBoard(), this.size, null);
		if(this.board.isClear()) {
			this.writer.println(SUCCESS_PROMPT);
		} else {
			this.writer.println(FAIL_PROMPT);
		}
		this.endGame();
	}
	
	private boolean restart() {
		return this.reader.readBoolean(RESTART_PROMPT, RESTART_TRUE, RESTART_FALSE);
	}
}
