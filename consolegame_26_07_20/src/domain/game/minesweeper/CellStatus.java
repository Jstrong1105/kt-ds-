package domain.game.minesweeper;

/**
 * 셀이 가지는 상태 값
 * 
 * 상태 전이 포함
 */
enum CellStatus {
	OPEN
	, HIDDEN
	, FLAG
	, MINE_REVEALED
	; 
	
	CellStatus openCell() {
		return switch(this) {
			case OPEN, FLAG, MINE_REVEALED -> this;
			case HIDDEN -> OPEN;
		};
	}
	
	CellStatus toggleFlag() {
		return switch(this) {
			case OPEN, MINE_REVEALED -> this;
			case HIDDEN -> FLAG;
			case FLAG -> HIDDEN;
		};
	}
	
	CellStatus reveal() {
		return MINE_REVEALED;
	}
}
