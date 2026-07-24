package domain.game.minesweeper;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.FakeInputReader;
import common.FakeOutputWriter;

class MinesweeperTest {
	
	// 테스트에 사용할 시드
	private static final long SEED = 1105L;
	/*
	 *  사이즈 10 일때 1105 시드 사용 시 배치되는 지뢰 위치
	    CellPosition[row=0, col=9]
		CellPosition[row=1, col=1]
		CellPosition[row=1, col=5]
		CellPosition[row=3, col=3]
		CellPosition[row=4, col=4]
		CellPosition[row=5, col=4]
		CellPosition[row=5, col=5]
		CellPosition[row=6, col=9]
		CellPosition[row=7, col=2]
		CellPosition[row=9, col=3]
	 */
	
	/*
	 * size 10 , 지뢰 수 10 일때 1105 시드 사용 시 firstOpen 으로 바뀌는 지뢰의 위치
	 * CellPosition[row=8, col=7]
	 */
		
	private Minesweeper game;
	private FakeInputReader reader;
	private FakeOutputWriter writer;
	private MineCellBoard board;
	private CellPrinter printer;
	
	@BeforeEach
	void init() {
		this.reader = new FakeInputReader();
		this.writer = new FakeOutputWriter();
		this.board = new MineCellBoard(new Random(SEED));
		this.printer = new ConsoleCellPrinter(writer);
		this.game = new Minesweeper(reader,writer,board,printer);
	}
	
	@Test
	void 첫선택지뢰_두번쨰선택지뢰() {
		reader.setAnswer(
						"10","10"
						,"1","10"
						,"1"
						,"9","8"
						,"1"
						,"N");
		game.doGame();
		
		assertTrue(writer.output().contains(Minesweeper.FAIL_PROMPT));
		assertFalse(board.getMinePositions().contains(new CellPosition(0, 9)));
	}
}
