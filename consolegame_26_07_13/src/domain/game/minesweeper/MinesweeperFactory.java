package domain.game.minesweeper;

import domain.GameApp;

/**
 * 지뢰찾기 구현체를 생성하는 클래스
 * 
 * 패키지 내에서 유일한 public 클래스
 * 
 * 외부와의 연결을 담당
 */
public class MinesweeperFactory {
	
	public GameApp getGame() {
		CellBoard board = new ArrayCellBoard();
		CellPrinter printer = new ConsoleCellPrinter();
		GameApp game = new MinesweeperApp(printer, board);
		return game;
	}
}
