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
	private static final String NOT_EXIST_POSITION = "존재하지 않는 좌표입니다.";
	
	private static final int[][] DIRECTIONS = {
			{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
	};
	
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
		
		board.clear();
		
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
		
		Collections.shuffle(shuffle);
		
		List<CellPosition> minePosition = shuffle.stream().limit(mineCount).toList();
		
		board.stream()
		     .filter(r -> minePosition.contains(r.getPosition()))
		     .forEach(Cell::plantMine);
	}
	
	// TODO
	private void incrementsAdjacentMines(CellPosition position) {
		for(int i = 0; i < DIRECTIONS.length; i++) {
			int row = position.row() + DIRECTIONS[i][0];
			int col = position.col() + DIRECTIONS[i][1];
		}
	}

	private Cell getCell(CellPosition position) {
		Cell cell = cellIndex.get(position);
		if(cell == null) {
			throw new IllegalArgumentException(NOT_EXIST_POSITION);
		}
		return cell;
	}
	
	@Override
	public boolean isOpen(CellPosition position) {
		return getCell(position).isOpen();
	}

	@Override
	public boolean isFlag(CellPosition position) {
		return getCell(position).isFlag();
	}

	@Override
	public OpenResult openCell(CellPosition position) {
		return getCell(position).openCell();
	}

	@Override
	public void toggleFlag(CellPosition position) {
		getCell(position).toggleFlag();
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
