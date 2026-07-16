package domain.game.minesweeper;

import java.time.Duration;
import java.time.Instant;

import common.ConsoleUtil;
import common.IOUtil;
import domain.DoubleActionTemplate;

/**
 * 지뢰찾기 구현체
 * 
 * DoubleActionTemplate 을 상속받아 구현
 * 
 * firstAction 에서 셀을 선택
 * secondAction 에서 액션 선택
 * 
 * 패키지 프라이빗
 */
class MinesweeperApp extends DoubleActionTemplate{
	
	// 생성자
	MinesweeperApp(CellPrinter printer, CellBoard board){
		this.printer = printer;
		this.board = board;
	}
	
	// 콘솔 창에 화면을 출력하는 객체
	private final CellPrinter printer;
	
	// 지뢰찾기 보드판 객체
	private final CellBoard board;
	
	// 보드판 사이즈 (가로, 세로)
	private int size; 
	// 보드판 최대, 최소 사이즈
	private static final int MIN_SIZE = 10;
	private static final int MAX_SIZE = 30;
	
	// 보드판의 지뢰 개수
	private int mineCount;
	// 보드판의 지뢰 매설 최대, 최소 비율
	// size * size * (비율) / 100 으로 구성됨
	private static final int MIN_MINE_PERCENT = 10;
	private static final int MAX_MINE_PERCENT = 30;
	
	// 게임 시작 시간 
	private Instant startTime;
	
	// 사용자 입력 값
	private int playerRow;
	private int playerCol;
	
	// 남은 찬스 횟수
	private int chanceCount;
	
	// 첫 입력 여부
	// 첫 입력 여부에 따른 지뢰 위치 변경 로직
	private boolean first;
	
	// 사용자가 선택한 셀의 위치를 표시하기 위한 객체
	private CellPosition choice;
	
	// 보드판 초기화
	@Override
	public void init() {
		
		// 콘솔 화면 정리
		ConsoleUtil.clearConsole();
		
		// 안내 메시지 출력 및 사이즈 입력
		IOUtil.print("지뢰찾기 게임입니다.\n");
		size = IOUtil.readIntRange("지뢰찾기 사이즈를 입력해주세요.", MIN_SIZE, MAX_SIZE);
		
		// 지뢰 매설 가능 숫자 계산
		int minMine = size * size * MIN_MINE_PERCENT / 100;
		int maxMine = size * size * MAX_MINE_PERCENT / 100;
		
		// 지뢰 개수 입력
		mineCount = IOUtil.readIntRange("지뢰 개수를 입력해주세요", minMine, maxMine);
		
		// 입력한 사이즈와 지뢰 개수에 따라 보드판 생성
		board.init(size, mineCount);
		
		// 데이터 초기화
		choice = null;
		chanceCount = 5;
		first = true;
		startTime = Instant.now();
	}
	
	// 화면 출력
	@Override
	public void render() {
		
		// 콘솔 화면 정리
		ConsoleUtil.clearConsole();
		// printer 객체에 CellView[][] 을 넘겨주고 화면에 출력
		printer.renderBoard(board.getSnapshot(), choice);
		// 남은 찬스 횟수 출력
		IOUtil.print("남은 찬스 : " + chanceCount + "\n");
	}
	
	// 셀 선택
	@Override
	public void firstAction() {
		
		// 이미 오픈된 셀을 선택한 경우 
		// 안내 메시지 출력 이후 다시 입력 받음
		do {
			playerRow = IOUtil.readIntRange("행을 선택하세요.", 1, size)-1;
			playerCol = IOUtil.readIntRange("열을 선택하세요.", 1, size)-1;
			
			if(board.isOpen(playerRow, playerCol)) {
				IOUtil.pause("이미 오픈된 칸입니다.");
			}
			
		} while (board.isOpen(playerRow, playerCol));
		
		// 사용자가 선택한 셀을 저장
		choice = new CellPosition(playerRow, playerCol);
	}
	
	// 선택한 셀에 대한 사용자의 액션
	// 액션 종류
	// 오픈
	// 깃발 설치/회수
	// 찬스 사용
	// 선택 취소
	@Override
	public void secondAction() {
		
		// 안내 메시지 출력
		IOUtil.print("1. 오픈\n");
		IOUtil.print("2. 깃발(설치/회수)\n");
		IOUtil.print("3. 찬스 사용\n");
		IOUtil.print("4. 취소\n");
		
		// 사용자 입력 
		int answer = IOUtil.readIntRange("액션을 선택하세요.", 1, 4);
		
		// 사용자 입력에 따른 분기 처리
		if(answer == 1) {
			openCell();
		}else if(answer == 2) {
			toggleFlag();
		}else if(answer == 3) {
			useChance();
		}
		
		cancelCell();
	}
	
	// 한칸 오픈 액션
	private void openCell() {
		
		// 첫 입력인 경우 
		// 해당 칸이 지뢰인지 여부를 파악해
		// 지뢰라면 다른 곳으로 지뢰를 옮기는 로직 구성
		if(first) {
			board.firstOpen(playerRow, playerCol);
			first = false;
		}
		
		// 해당 칸이 지뢰라면
		// 게임 종료
		if(board.isMine(playerRow, playerCol)) {
			// 지뢰 오픈 게임 종료
			finish(false);
		}
		// 해당 칸이 지뢰가 아니라면 
		// 해당 칸을 오픈하고 
		// 오픈 한 후 
		// 게임 클리어 유무 파악
		else {
			board.openCell(playerRow, playerCol);
			
			if(board.isClear()) {
				// 게임 클리어 
				finish(true);
			}
		}
	}
	
	// 깃발 설치/회수 액션
	private void toggleFlag() {
		
		// 첫 입력 시 깃발 기능 사용 불가
		if(first) {
			IOUtil.pause("첫 오픈 전에는 사용할 수 없습니다.");
		}else {
			board.toggleFlag(playerRow, playerCol);
		}
	}
	
	// 사용자 찬스 사용 액션
	private void useChance() {
		
		// 첫 입력 시 찬스 사용 불가
		if(first) {
			IOUtil.pause("첫 오픈 전에는 사용할 수 없습니다.");
		}
		// 찬스를 모두 사용한 경우 찬스 사용 불가
		else if(chanceCount <= 0){
			IOUtil.pause("찬스를 모두 사용했습니다.");
		}
		// 찬스 사용
		else {
			// 찬스 횟수 차감
			chanceCount--;
			// 해당 칸이 지뢰인 경우
			// 해당 칸에 깃발이 설치되있지 않다면
			// 해당 칸에 깃발을 설치함
			if(board.isMine(playerRow, playerCol)) {
				IOUtil.pause("해당 칸은 지뢰입니다.");
				if(!board.isFlag(playerRow, playerCol)) {
					board.toggleFlag(playerRow, playerCol);
				}
			}
			// 해당 칸이 지뢰가 아닌 경우
			// 해당 칸에 깃발이 설치되어있다면
			// 깃발을 해제하고
			// 해당 칸을 오픈함
			else {
				IOUtil.pause("해당 칸은 지뢰가 아닙니다.");
				if(board.isFlag(playerRow, playerCol)) {
					board.toggleFlag(playerRow, playerCol);
				}
				openCell();
			}
		}
	}
	
	// 셀 선택 취소
	private void cancelCell() {
		choice = null;
	}
	
	// 게임 종료 메소드
	private void finish(boolean win) {
		
		// 게임 종료 시 모든 지뢰를 개방함
		board.allOpen();
		// 선택한 셀을 취소함
		cancelCell();
		// 화면 출력
		render();
		
		// 승패 여부에 따른 안내 메시지 분기
		if(win) {
			long clearTime = Duration.between(startTime, Instant.now()).getSeconds();
			
			IOUtil.pause(String.format("클리어 타임 : %d초", clearTime));
		}else {
			IOUtil.pause("지뢰를 밟았습니다.");
		}
		// 게임 종료
		endGame();
	}
}
