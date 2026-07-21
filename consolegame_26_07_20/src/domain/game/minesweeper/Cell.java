package domain.game.minesweeper;

import java.util.Objects;

/**
 * 지뢰찾기 한칸 객체
 */
class Cell {
	
	// 테스트 접근을 위한 패키지 프라이빗
	static final String NOT_VALID_ADJACENT_MINES = "인접 지뢰 수는 8을 초과할 수 없습니다.";
	
	private final CellPosition position;
	private CellStatus status;
	private boolean mine;
	private int adjacentMines;
	
	Cell(CellPosition position){
		this.position = Objects.requireNonNull(position);
		this.status = CellStatus.HIDDEN;
		this.mine = false;
		this.adjacentMines = 0;
	}
	
	// 속성 변경
	OpenResult openCell() {
		CellStatus next = status.openCell();
		if(next == status) {
			return OpenResult.BLOCKED;
		}
		
		status = next;
		if(mine) {
			return OpenResult.EXPLODED;
		} else {
			return OpenResult.SAFE;
		}
	}
	
	void toggleFlag() {
		status = status.toggleFlag();
	}
	
	void plantMine() {
		mine = true;
	}
	
	void removeMine() {
		mine = false;
	}
	
	void incrementAdjacentMines() {
		if(adjacentMines >= 8) {
			throw new IllegalStateException(NOT_VALID_ADJACENT_MINES);
		}
		adjacentMines++;
	}
	
	// 조회
	boolean isMine() {
		return mine;
	}
	
	int getAdjacentMines() {
		return adjacentMines;
	}
	
	CellPosition getPosition() {
		return position;
	}
	
	boolean isOpen() {
		return status == CellStatus.OPEN;
	}
	
	boolean isHidden() {
		return status == CellStatus.HIDDEN;
	}
	
	boolean isFlag() {
		return status == CellStatus.FLAG;
	}
	
	boolean isRevealed() {
		return status == CellStatus.MINE_REVEALED;
	}
	
	void reveal() {
		if(mine) {
			status = status.reveal();
		}
	}
	
	CellView toView() {
		return new CellView(status,position,adjacentMines);
	}
}
