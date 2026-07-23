package domain.game.minesweeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.ConsoleInputReader;
import common.ConsoleOutputWriter;
import common.InputReader;
import common.OutputWriter;
import domain.GameApp;

/**
 * 지뢰찾기 공장 
 * 조립 배송 담당
 */
public class MinesweeperFactory {
	
	public GameApp getGame() {
		
		OutputWriter writer = new ConsoleOutputWriter();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		InputReader reader = new ConsoleInputReader(writer, bf);
		
		CellBoard board = new MineCellBoard();
		CellPrinter printer = new ConsoleCellPrinter(writer);
		
		return new Minesweeper(reader, writer, board, printer);
	}
}
