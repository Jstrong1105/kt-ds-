package domain.game.minesweeper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * 지뢰찾기 보드판 구현 클래스
 */
class MineCellBoard implements CellBoard {
	
	// 상수
	// 테스트를 위한 패키지 프라이빗
	static final String NOT_VALID_RESET = "유효하지 않은 사이즈 혹은 지뢰 수 입니다.";
	static final String NOT_EXIST_POSITION = "존재하지 않는 좌표입니다.";
	
	// 방향 상수 (8방향 탐색에 사용)
	private static final int[][] DIRECTIONS = {
			{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
	};
	
	// Cell 들의 정보를 가지고 있는 board 객체
	private final List<Cell> board;
	
	// Cell 탐색에 사용될 cellIndex
	private final Map<CellPosition, Cell> cellIndex; 
	
	// 랜덤 객체 (테스트 시 랜덤 시드 주입)
	private final Random random;
	
	// 첫 입력 판정 변수
	private boolean first;
	
	// 인자 없는 생성자
	MineCellBoard(){
		this(new Random());
	}
	
	// 랜덤 시드 주입 생성자
	MineCellBoard(Random random){
		board = new ArrayList<>();
		cellIndex = new HashMap<>();
		this.random = random;
	}
	
	@Override
	public void reset(int size, int mineCount) {
		// 인터페이스에서 정의한 규칙
		if(size <= 0 || mineCount <= 0 || ( mineCount >= (size * size) ) ) {
			throw new IllegalArgumentException(NOT_VALID_RESET);
		}
		
		// 데이터 초기화
		board.clear();
		cellIndex.clear();
		first = true;
		
		List<CellPosition> shuffle = new ArrayList<>();
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				CellPosition pos = new CellPosition(row, col);
				Cell cell = new Cell(pos);
				board.add(cell);
				shuffle.add(pos);
				cellIndex.put(pos, cell);
			}
		}
		
		Collections.shuffle(shuffle, random);
		
		List<CellPosition> minePosition = shuffle.stream().limit(mineCount).toList();
		
		// 지뢰 매설 로직
		board.stream()
		     .filter(r -> minePosition.contains(r.getPosition()))
		     .forEach(Cell::plantMine);
	}
	
	/**
	 * 인접한 8칸의 셀들을 반환하는 메소드
	 * 보드 범위를 벗어난 경우는 포함되지 않는다.
	 * @param position 기준이 되는 셀의 위치
	 * @return 인접한 셀들
	 */
	private List<Cell> getAdjacentCells(CellPosition position){
		List<Cell> result = new ArrayList<>();
		
		for(int[] d : DIRECTIONS) {
			int row = position.row() + d[0];
			int col = position.col() + d[1];
			
			// 범위 자체가 유효하지 않은 경우
			if(row < 0 || col < 0) {
				continue;
			}
			
			// 해당 범위에 Cell 이 존재하지 않는 경우 추가하지 않음
			getCell(new CellPosition(row, col)).ifPresent(result::add);
		}
		
		return result;
	}
	
	/**
	 * 특정 위치의 셀을 Optional 로 반환하는 메소드
	 * 존재하지 않는 셀인 경우 빈 Optional 을 반환한다.
	 * @param position 확인할 포지션
	 * @return Optional<Cell>
	 */
	private Optional<Cell> getCell(CellPosition position) {
		return Optional.ofNullable(cellIndex.get(position));
	}
	
	/**
	 * 특정 위치의 셀을 얻어오는 메소드
	 * 해당 위치의 셀이 존재하지 않는 경우 IllegalArgumentException 이 발생한다.
	 * @param position 얻어올 셀의 위치
	 * @return 해당 위치의 셀
	 */
	private Cell getCellOrThrow(CellPosition position) {
		return getCell(position).orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_POSITION));
	}

	@Override
	public boolean isOpen(CellPosition position) {
		return getCellOrThrow(position).isOpen();
	}

	@Override
	public boolean isFlag(CellPosition position) {
		return getCellOrThrow(position).isFlag();
	}
	
	@Override
	public OpenResult openCell(CellPosition position) {
		Cell cell = getCellOrThrow(position);
		
		// 첫 입력인 경우 실행하는 영역
		// 해당 칸이 지뢰인 경우 다른 곳으로 지뢰를 옮긴다.
		if(first && !cell.isFlag()) {
			firstOpen(position);
		}
		
		OpenResult result = cell.openCell();
		if(result == OpenResult.EXPLODED || result == OpenResult.BLOCKED){
			return result;
		}
		
		// 오픈한 셀의 인접 지뢰가 0 인 경우 실행하는 영역
		if(cell.getAdjacentMines() == 0) {
			adjacentOpen(position);
		}
		
		return result;
	}
	
	/**
	 * 첫 오픈 시 실행되는 메소드
	 * 첫 오픈 위치의 셀이 지뢰인 경우 다른 곳으로 지뢰를 옮긴다.
	 * 인접 지뢰의 수를 계산한다.
	 * @param position 첫 오픈 위치
	 */
	private void firstOpen(CellPosition position) {
		// 처음 오픈한 셀
		Cell cell = getCellOrThrow(position);
		
		if(cell.isMine()) {
			List<Cell> notMines = board.stream()
									   .filter(c -> !c.isMine())
									   .toList();
			
			Cell newCell = notMines.get(random.nextInt(notMines.size()));
			
			cell.removeMine();
			newCell.plantMine();
		}
		
		first = false;
		
		// 인접 지뢰 증가 로직
		board.stream()
			 .filter(Cell::isMine)
			 .forEach(r -> incrementAdjacentMines(r.getPosition()));
	}
	
	/**
	 * 지뢰의 좌표를 입력받아 근처 8칸의 인접 지뢰 수를 증가 시키는 메소드
	 * @param position 지뢰의 좌표
	 */
	private void incrementAdjacentMines(CellPosition position) {
		List<Cell> adjacentCells = getAdjacentCells(position);
		for(Cell cell : adjacentCells) {
			cell.incrementAdjacentMines();
		}
	}
	
	/**
	 * 인접한 지뢰가 0인 셀 근처 8칸을 연쇄적으로 오픈하는 메소드
	 * @param position 인접 지뢰가 0인 셀
	 */
	private void adjacentOpen(CellPosition position) {
		
		// 인접한 지뢰가 0인 좌표를 저장할 변수
		Deque<CellPosition> positions = new ArrayDeque<>();
		positions.add(position);
		
		while(!positions.isEmpty()) {
			// 저장된 좌표에서 한개 가져옴
			CellPosition pos = positions.poll();
			// 가져온 좌표 근처 8칸의 셀들
			List<Cell> adjacentCells = getAdjacentCells(pos);
			for(Cell cell : adjacentCells) {
				// 가져온 셀이 HIDDEN 상태인 경우 오픈함
				if(cell.isHidden()) {
					cell.openCell();
					// 오픈한 셀의 인접 지뢰가 0인 경우 해당 셀의 좌표도 저장함
					if(cell.getAdjacentMines() == 0) {
						positions.add(cell.getPosition());
					}
				}
			}
		}
	}

	@Override
	public void toggleFlag(CellPosition position) {
		getCellOrThrow(position).toggleFlag();
	}

	@Override
	public boolean isClear() {
		return board.stream()
					.allMatch(r-> r.isOpen() || r.isMine());
	}

	@Override
	public int flagCount() {
		return (int) board.stream()
						  .filter(Cell::isFlag)
						  .count();
	}

	@Override
	public List<CellView> getBoard() {
		return board.stream()
					.map(Cell::toView)
					.toList();
	}
}
