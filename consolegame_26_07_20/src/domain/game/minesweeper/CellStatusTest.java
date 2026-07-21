package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CellStatusTest {
	
	@Test
	void CellStatus_상태전이검사() {
		assertEquals(CellStatus.OPEN, CellStatus.HIDDEN.openCell());
		assertEquals(CellStatus.FLAG, CellStatus.HIDDEN.toggleFlag());
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.HIDDEN.reveal());
		
		assertEquals(CellStatus.FLAG, CellStatus.FLAG.openCell());
		assertEquals(CellStatus.HIDDEN, CellStatus.FLAG.toggleFlag());
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.FLAG.reveal());
		
		assertEquals(CellStatus.OPEN, CellStatus.OPEN.openCell());
		assertEquals(CellStatus.OPEN, CellStatus.OPEN.toggleFlag());
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.OPEN.reveal());
		
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.MINE_REVEALED.openCell());
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.MINE_REVEALED.toggleFlag());
		assertEquals(CellStatus.MINE_REVEALED, CellStatus.MINE_REVEALED.reveal());
	}
}
