package domain.game.minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 지뢰찾기 보드판 구현 클래스
 */
class MineCellBoard implements CellBoard {
	
	private static final String NOT_VALID_RESET = "유효하지 않은 사이즈 혹은 지뢰 수 입니다.";
	
	private final List<Cell> board;
	private final Map<CellPosition, Cell> cellIndex; 
	
	// 생성자
	MineCellBoard(){
		board = new ArrayList<>();
		cellIndex = new HashMap<>();
	}
	
	@Override
	public void reset(int size, int mineCount) {
		if(size <= 0 || mineCount <= 0 || ( mineCount >= (size * size) ) ) {
			throw new IllegalArgumentException(NOT_VALID_RESET);
		}
		
		List<CellPosition> shuffle = new ArrayList<>();
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				board.add(new Cell(new CellPosition(row, col)));
				shuffle.add(new CellPosition(row, col));
				cellIndex.put(new CellPosition(row, col), new Cell(new CellPosition(row, col)));
			}
		}
		
		Collections.shuffle(shuffle);
		
		List<CellPosition> minePosition = shuffle.stream().limit(mineCount).toList();
		
		board.stream()
		     .filter(r -> minePosition.contains(r.getPosition()))
		     .forEach(r -> r.plantMine());
	}

	private Cell getCell(CellPosition position) {
		return Objects.requireNonNull(cellIndex.get(position));
	}
	
	@Override
	public boolean isOpen(CellPosition position) {
		return false;
	}

	@Override
	public boolean isFlag(CellPosition position) {
		return false;
	}

	@Override
	public OpenResult openCell(CellPosition position) {
		return null;
	}

	@Override
	public void toggleFlag(CellPosition position) {
		
	}

	@Override
	public boolean isClear() {
		return false;
	}

	@Override
	public int flagCount() {
		return 0;
	}

	@Override
	public List<CellView> getBoard() {
		return null;
	}
}
