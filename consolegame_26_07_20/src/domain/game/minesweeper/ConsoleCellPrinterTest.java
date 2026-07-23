package domain.game.minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ConsoleAnsi;
import common.FakeOutputWriter;

class ConsoleCellPrinterTest {

	private ConsoleCellPrinter printer;
	private FakeOutputWriter writer;
	
	@BeforeEach
	void 초기화() {
		writer = new FakeOutputWriter();
	}
	
	CellPosition cpOf(int row, int col) {
		return new CellPosition(row, col);
	}
	
	CellView cvOf(CellStatus status, int adjacentMines) {
		return new CellView(status,adjacentMines);
	}
	
	@Test
	void printCell_없는_좌표() {
		
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> printer.printCell(cells, 3, new CellPosition(0, 0)));
		
		assertEquals(ConsoleCellPrinter.NOT_EXIST_POSITION, e.getMessage());
	}
	
	@Test
	void printCell_선택_포함() {
		
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		printer.printCell(cells, 2, new CellPosition(0, 0));
		assertTrue(writer.output().contains(ConsoleAnsi.BG_YELLOW_TXT_GREEN));
	}
	
	@Test
	void printCell_선택_없음() {
		
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		printer.printCell(cells, 2, null);
		
		assertFalse(writer.output().contains(ConsoleAnsi.BG_YELLOW_TXT_GREEN));
	}
	
	@Test
	void printCell_깃발_있음() {
		
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.FLAG,0));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		printer.printCell(cells, 2, null);
		
		assertTrue(writer.output().contains(ConsoleCellPrinter.FLAG_SYMBOL));
	}
	
	@Test
	void printCell_열림_있음() {
		
		// 0 ~ 8
		int adjacentMines = 2;
		
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.OPEN,adjacentMines));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		printer.printCell(cells, 2, null);
		
		assertTrue(writer.output().contains(ConsoleCellPrinter.OPEN_SYMBOL[adjacentMines]));
	}
	
	@Test
	void printCell_지뢰_열림() {
		Map<CellPosition, CellView> cells = new HashMap<>();
		cells.put(cpOf(0,0), cvOf(CellStatus.MINE_REVEALED,0));
		cells.put(cpOf(0,1), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,0), cvOf(CellStatus.HIDDEN,0));
		cells.put(cpOf(1,1), cvOf(CellStatus.HIDDEN,0));
		
		printer = new ConsoleCellPrinter(writer);
		printer.printCell(cells, 2, null);
		
		assertTrue(writer.output().contains(ConsoleCellPrinter.MINE_SYMBOL));
	}
}
