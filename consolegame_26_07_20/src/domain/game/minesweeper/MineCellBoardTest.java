package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * MineCellBoard 테스트 
 */
class MineCellBoardTest {
	
	CellBoard board;
	
	@BeforeEach
	void init() {
		board = new MineCellBoard();
	}
	
	CellPosition of(int row, int col) {
		return new CellPosition(row,col);
	}
	
	@ParameterizedTest
	@CsvSource({
		"-1,10",
		"0,10",
		"10,-1",
		"10,0",
		"1,1",
		"10,100",
		"10,101"
	})
	void reset_유효하지않은_인자(int size, int mineCount) {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> board.reset(size, mineCount));
		assertEquals(MineCellBoard.NOT_VALID_RESET, e.getMessage());
	}
	
	@ParameterizedTest
	@CsvSource({
				"9,10",
				"10,9",
				"10,10"
			})
	void openCell_없는_좌표_오픈(int row, int col) {
		board.reset(10, 10);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> board.openCell(of(row,col)));
		assertEquals(MineCellBoard.NOT_EXIST_POSITION, e.getMessage());
	}
	
	@ParameterizedTest
	@CsvSource({
		"9,9",
		"1,9",
		"9,3",
		"0,8",
		"3,0",
		"0,0"
	})
	void openCell_유효한_경계값_오픈(int row, int col) {
		board.reset(10,10);
		assertDoesNotThrow(() -> board.openCell(of(row,col)));
	}
	
	@Test
	void openCell_깃발_위치_오픈() {
		board.reset(10, 10);
		board.toggleFlag(of(0,0));
		assertEquals(OpenResult.BLOCKED, board.openCell(of(0,0)));
	}	
}
