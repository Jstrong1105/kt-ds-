package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * MineCellBoard 테스트 
 */
class MineCellBoardTest {
	
	// 테스트에 사용할 시드
	private static final long SEED = 1105L;
	/*
	 *  사이즈 10 일때 1105 시드 사용 시 배치되는 지뢰 위치
	    CellPosition[row=0, col=3]
		CellPosition[row=0, col=7]
		CellPosition[row=0, col=9]
		CellPosition[row=1, col=0]
		CellPosition[row=1, col=1]
		CellPosition[row=1, col=2]
		CellPosition[row=1, col=3]
		CellPosition[row=1, col=5]
		CellPosition[row=3, col=3]
		CellPosition[row=3, col=6]
		CellPosition[row=4, col=2]
		CellPosition[row=4, col=4]
		CellPosition[row=5, col=0]
		CellPosition[row=5, col=3]
		CellPosition[row=5, col=4]
		CellPosition[row=5, col=5]
		CellPosition[row=5, col=7]
		CellPosition[row=5, col=8]
		CellPosition[row=6, col=1]
		CellPosition[row=6, col=9]
		CellPosition[row=7, col=1]
		CellPosition[row=7, col=2]
		CellPosition[row=7, col=3]
		CellPosition[row=7, col=6]
		CellPosition[row=7, col=7]
		CellPosition[row=8, col=3]
		CellPosition[row=8, col=9]
		CellPosition[row=9, col=1]
		CellPosition[row=9, col=3]
		CellPosition[row=9, col=5]
	 */
	/*
	 * size 10 , 지뢰 수 30 일때 1105 시드 사용 시 firstOpen 으로 바뀌는 지뢰의 위치
	 * CellPosition[row=5, col=1]
	 */
	
	MineCellBoard board;
	
	@BeforeEach
	void init() {
		board = new MineCellBoard(new Random(SEED));
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
	
	@Test
	void openCell_첫입력시_지뢰오픈() {
		board.reset(10, 30);
		assertEquals(OpenResult.SAFE, board.openCell(of(0,3)));
		assertEquals(OpenResult.EXPLODED, board.openCell(of(5,1)));
		assertEquals(30, board.getMinePositions().size());
	}
	
	@Test
	void openCell_연쇄오픈() {
		board.reset(10,30);
		board.openCell(of(2,9));
		assertTrue(board.isOpen(of(2,7)));
	}
	
	@Test
	void flag_설치이후_open_first() {
		board.reset(10, 30);
		board.toggleFlag(of(0,3));
		assertEquals(OpenResult.BLOCKED, board.openCell(of(0,3)));
		assertEquals(OpenResult.SAFE, board.openCell(of(0,7)));
		assertEquals(OpenResult.EXPLODED, board.openCell(of(5,1)));
	}
	
	@Test
	void flag_갯수() {
		board.reset(10, 30);
		board.toggleFlag(of(0,0));
		board.toggleFlag(of(0,1));
		board.toggleFlag(of(0,1));
		board.toggleFlag(of(0,3));
		assertEquals(2, board.flagCount());
	}
	
	@Test
	void clear_검사() {
		board.reset(10, 1); // 지뢰가 한개라면 연쇄 오픈 기능으로 인해 한칸만 열어도 전부 열림
		// 지뢰 위치 CellPosition[row=4, col=4]
		assertEquals(List.of(of(4,4)), board.getMinePositions());
		board.openCell(of(9,9)); // 9,9 위치 근처에 지뢰가 없기에 가능함
		assertTrue(board.isClear());
	}
	
	@Test
	void 인접지뢰검사() {
		board.reset(10, 30);
		board.openCell(of(9,9));
		assertEquals(1, board.getAdjacentMines(of(9,9))); // 지뢰 배치 표 기준
		assertEquals(2, board.getAdjacentMines(of(5,5))); // 지뢰 배치 표 기준
	}
}
