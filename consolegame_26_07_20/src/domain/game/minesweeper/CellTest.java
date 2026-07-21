package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CellTest {
	
	Cell of(int row, int col) {
		return new Cell(new CellPosition(row, col));
	}
	
	@Test
	void Cell_reveal검사() {
		Cell cell = of(1,2);
		cell.plantMine();
		cell.reveal();
		assertTrue(cell.isRevealed());
	}
	
	@Test
	void Cell_생성자_null파라미터() {
		assertThrows(NullPointerException.class,() -> new Cell(null));
	}
	
	@Test
	void Cell_인접지뢰수_8초과() {
		Cell cell = of(1,2);
		
		for(int i = 0; i < 8; i++) {
			cell.incrementAdjacentMines();
		}
		
		IllegalStateException e = assertThrows(IllegalStateException.class
				                  , () -> cell.incrementAdjacentMines());
		assertEquals(Cell.NOT_VALID_ADJACENT_MINES, e.getMessage());
	}
	
	@Test
	void Cell_오픈반영() {
		Cell cell = of(1,2);
		
		assertTrue(cell.isHidden());
		cell.openCell();
		assertTrue(cell.isOpen());
	}
	
	@Test
	void Cell_깃발왕복반영() {
		Cell cell = of(1,2);
		
		assertTrue(cell.isHidden());
		cell.toggleFlag();
		assertTrue(cell.isFlag());
		cell.toggleFlag();
		assertTrue(cell.isHidden());
	}
	
	@Test
	void Cell_지뢰왕복() {
		Cell cell = of(1,2);
		cell.plantMine();
		assertTrue(cell.isMine());
		cell.removeMine();
		assertFalse(cell.isMine());
	}
	
	@Test
	void Cell_기본값검사() {
		Cell cell = of(1,2);
		
		assertTrue(cell.isHidden());
		assertEquals(0, cell.getAdjacentMines());
		assertEquals(new CellPosition(1,2), cell.getPosition());
		assertFalse(cell.isMine());
	}
}
