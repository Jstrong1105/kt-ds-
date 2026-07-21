package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CellPositionTest {

	@Test
	void 생성자_1번인자_음수() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class
				                     , () -> new CellPosition(-1, 2));
		assertEquals(CellPosition.NOT_VALID_VALUE,e.getMessage());
	}
	
	@Test
	void 생성자_2번인자_음수() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class
				                     , () -> new CellPosition(1, -1));
		assertEquals(CellPosition.NOT_VALID_VALUE, e.getMessage());
	}
}
