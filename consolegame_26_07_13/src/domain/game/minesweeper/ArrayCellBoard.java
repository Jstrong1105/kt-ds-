package domain.game.minesweeper;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * CellBoard 인터페이스를 구현한
 * 구현체 클래스
 * 
 * 패키지 프라이빗
 */
class ArrayCellBoard implements CellBoard {

	// 주요 속성 구성
	// 지뢰찾기 보드판
	private Cell[][] board;
	
	// 난수 발생 인스턴스
	private Random random = new Random();
	
	// 보드판의 사이즈 (가로, 세로 동일)
	private int size;
	
	// 8방향 좌표 값
	private static final int[] DIRECT_ROW = {-1,-1,-1,0,0,1,1,1};
	private static final int[] DIRECT_COL = {-1,0,1,-1,1,-1,0,1};
	
	private static final String OUT_OF_ARRAY = "보드판의 유효한 범위를 벗어났습니다.";
	
	// 보드판 초기화 로직
	// 처음 시작 혹은 다시 시작 시 반드시 실행해야 함
	@Override
	public void init(int size, int count) {
		// 사이즈 저장
		this.size = size;
		
		// 보드 생성
		board = new Cell[size][size];
		
		// 보드 초기화
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				board[row][col] = new Cell();
			}
		}
		
		// 지뢰 매설 메소드
		plantMines(count);
	}

	// 지뢰 매설 메소드
	// 매설할 지뢰의 개수를 파라미터로 받음
	private void plantMines(int count) {
		
		int mineCount = 0;
		
		// 지뢰 매설 로직 최적화
		// 랜덤한 한 칸을 선택해서 배치하는 방식은 
		// 매설 비율이 높아 질 수록 소모 시간이 급격하게 늘어나는 문제가 있음
		// 따라서 매설 비율을 50% 를 기준으로 
		// 50% 이하인 경우 지뢰가 아닌 칸을 랜덤하게 찾아 지뢰를 매설하는 방식
		// 50% 이상인 경우 전체를 지뢰로 바꾼 다음
		// 지뢰가 매설된 칸을 찾아 지뢰를 해제하는 방식
		
		// 50% 이하인 경우
		if(size*size/2 >= count){
			// 지뢰가 아닌 칸을 찾아 지뢰를 매설
			while(mineCount <= count) {
				int row = random.nextInt(size);
				int col = random.nextInt(size);
				
				if(!board[row][col].isMine()) {
					board[row][col].plantMine();
					mineCount++;
				}
			}
		}
		// 50% 이상인 경우
		else {
			// 전체를 지뢰로 구성
			for(int row = 0; row < size; row++) {
				for(int col = 0; col < size; col++) {
					board[row][col].plantMine();
				}
			}
			
			mineCount = size*size;
			
			// 지뢰인 칸을 찾아 지뢰를 해제
			while(mineCount > count) {
				int row = random.nextInt(size);
				int col = random.nextInt(size);
				
				if(board[row][col].isMine()) {
					board[row][col].removeMine();
					mineCount--;
				}
			}
		}
	}
	
	// 첫 오픈 시 실행되는 메소드
	@Override
	public void firstOpen(int row, int col) {
		
		// 첫 오픈 값이 지뢰라면
		if(board[row][col].isMine()) {
			
			// 지뢰가 아닌 칸을 찾을 때 까지 반복
			while(true) {
				int nRow = random.nextInt(size);
				int nCol = random.nextInt(size);
				
				// 랜덤하게 뽑은 방식이 지뢰가 아닌 경우 
				if(!board[nRow][nCol].isMine()) {
					
					// 해당 칸은 지뢰로 변경하고
					board[nRow][nCol].plantMine();
					// 첫 오픈 칸을 지뢰 해제함
					board[row][col].removeMine();
					// 반복문 종료
					break;
				}
			}
		}
		
		// 인접 지뢰 계산 로직
		// 모든 보드판을 순회하면서
		// 지뢰인 칸을 발견하면
		// incrementAjacentMines() 메소드를 실행하면서
		// 해당 지뢰의 좌표를 넘김
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(board[r][c].isMine()) {
					incrementAdjacentMines(r, c);
				}
			}
		}
	}
	
	// 지뢰인 셀의 좌표를 받아서 
	// 주변 8칸의 인접 지뢰 개수를 증가 시키는 메소드
	private void incrementAdjacentMines(int row, int col) {
		
		for(int i = 0; i < 8; i++) {
			// 주변 8칸을 순회
			int nRow = row + DIRECT_ROW[i];
			int nCol = col + DIRECT_COL[i];
			
			// 해당 좌표가 보드판의 좌표를 벗어나지 않은 경우
			// 인접 지뢰를 증가시킴
			if(!isOutOfArray(nRow, nCol)) {
				board[nRow][nCol].incrementAdjacentMines();
			}
		}
	}
	
	// 각각의 Cell 이 가지고 있는 정보를 CellView 객체에 담아
	// 반환하는 클래스
	// 출력 시 Cell[][] 자체를 반환하면
	// 받는 쪽에서 데이터 수정이 가능해지기 때문에
	// 불변 객체인 CellView 객체로 구성해 반환함
	@Override
	public CellView[][] getSnapshot() {
		CellView[][] cellView = new CellView[size][size];
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				Cell cell = board[row][col];
				cellView[row][col] = new CellView(cell.getStatus(), cell.isMine(), cell.getAdjacentMines());
			}
		}
		
		return cellView;
	}
	
	// 하나의 셀의 오픈 여부를 반환하는 메소드
	// 파라미터 유효값 검사 포함
	@Override
	public boolean isOpen(int row, int col) {
		checkOutOfArray(row, col);
		return board[row][col].isOpen();
	}

	// 하나의 셀의 숨김 여부를 반환하는 메소드
	// 파라미터 유효값 검사 포함
	@Override
	public boolean isHidden(int row, int col) {
		checkOutOfArray(row, col);
		return board[row][col].isHidden();
	}

	// 하나의 셀의 깃발 여부를 반환하는 메소드
	// 파라미터 유효값 검사 포함
	@Override
	public boolean isFlag(int row, int col) {
		checkOutOfArray(row, col);
		return board[row][col].isFlag();
	}

	// 하나의 셀의 지뢰 여부를 반환하는 메소드
	// 파라미터 유효값 검사 포함
	@Override
	public boolean isMine(int row, int col) {
		checkOutOfArray(row, col);
		return board[row][col].isMine();
	}

	// 하나의 셀을 오픈하는 메소드
	// 파라미터 유효값 검사 포함
	// 만약 인접 지뢰 수가 0개인 경우 주변 8칸도 연쇄적으로 오픈함
	@Override
	public void openCell(int row, int col) {
		checkOutOfArray(row, col);
		board[row][col].openCell();
		if(board[row][col].getAdjacentMines() == 0) {
			chainOpen(row, col);
		}
	}
	
	// 연쇄 오픈 메소드
	private void chainOpen(int row, int col) {
		
		// 인접 지뢰가 0인 cell 의 좌표를 저장할 변수
		Deque<CellPosition> item = new LinkedList<CellPosition>();
		
		// 파라미터로 받은 좌표를 추가
		item.add(new CellPosition(row, col));
		
		// 인접 지뢰가 비어있지 않는 동안 반복 실행
		while(!item.isEmpty()) {
			
			// item 에서 한개 가져옴
			CellPosition position = item.pollFirst();
			
			// 가져온 좌표 주변 8칸 순차적으로 탐색함
			for(int i = 0; i < 8; i++) {
				int nRow = position.row() + DIRECT_ROW[i];
				int nCol = position.col() + DIRECT_COL[i];
				
				// 범위를 벗어낫거나 닫힌 칸이 아니라면 
				// 건너뜀
				if(isOutOfArray(nRow, nCol) || !board[nRow][nCol].isHidden()) {
					continue;
				}
				
				// 범위 안에 있고 닫힌 칸이라면 오픈함
				board[nRow][nCol].openCell();
				
				// 오픈한 칸의 인접 지뢰 칸이 0이라면 
				// 해당 좌표를 item 에 추가함
				if(board[nRow][nCol].getAdjacentMines() == 0) {
					item.add(new CellPosition(nRow, nCol));
				}
			}
		}
	}

	// 하나의 셀의 깃발 설치 / 회수 메소드
	// 파라미터 유효값 검사 포함
	@Override
	public void toggleFlag(int row, int col) {
		checkOutOfArray(row, col);
		board[row][col].toggleFlag();
	}

	// 클리어 여부를 반환하는 메소드
	// 모든 셀이 지뢰 혹은 열림 상태인 경우 클리어 판정
	@Override
	public boolean isClear() {
		return Arrays.stream(board)
					 .flatMap(Arrays::stream)
					 .allMatch(cell->cell.isMine() || cell.isOpen());
	}
	
	// 게임 종료 시 모든 셀의 깃발을 해제하고
	// 모든 지뢰를 오픈하는 메소드
	@Override
	public void allOpen() {
		
		Arrays.stream(board)
			  .flatMap(Arrays::stream)
			  .filter(Cell::isFlag)
			  .forEach(Cell::toggleFlag);
		
		Arrays.stream(board)
			  .flatMap(Arrays::stream)
			  .filter(Cell::isMine)
			  .forEach(Cell::openCell);
	}
	
	// 파라미터의 유효값을 검사하는 메소드
	private boolean isOutOfArray(int row, int col) {
		return row < 0 || row >= size || col < 0 || col >= size;
	}
	
	// 유효하지 않은 파라미터 인 경우 
	// IllegalArgumentException 발생시키는 메소드
	private void checkOutOfArray(int row, int col) {
		if(isOutOfArray(row, col)) {
			throw new IllegalArgumentException(OUT_OF_ARRAY);
		}
	}
}
