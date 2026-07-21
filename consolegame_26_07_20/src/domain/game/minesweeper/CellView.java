package domain.game.minesweeper;

import java.util.Objects;

/**
 * 한칸의 셀 정보를 불변 타입으로 보여줄 레코드
 */
record CellView(CellStatus status, CellPosition position, int adjacentMines) {
	
	CellView{
		Objects.requireNonNull(status);
		Objects.requireNonNull(position);
	}
}
