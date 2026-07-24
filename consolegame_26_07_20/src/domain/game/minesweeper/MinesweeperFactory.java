package domain.game.minesweeper;

import common.GameIO;
import common.InputReader;
import common.OutputWriter;
import domain.GameApp;

/**
 * 지뢰찾기 공장 
 * 조립 담당
 */
public class MinesweeperFactory {
	
	private final OutputWriter writer;
	private final InputReader reader;
	private final CellBoard board;
	private final CellPrinter printer;
	
	public MinesweeperFactory(GameIO io) {
		this.writer = io.writer();
		this.reader = io.reader();
		this.board = new MineCellBoard();
		this.printer = new ConsoleCellPrinter(this.writer);
	}
	
	public MinesweeperFactory(OutputWriter writer, InputReader reader, CellBoard board, CellPrinter printer) {
		this.writer = writer;
		this.reader = reader;
		this.board = board;
		this.printer = printer;
	}
	
	public GameApp getGame() {
		return new Minesweeper(reader, writer, board, printer);
	}
}
