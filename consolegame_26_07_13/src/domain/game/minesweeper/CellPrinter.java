package domain.game.minesweeper;

/**
 * 지뢰찾기에서 CellView[][] 를 받아
 * 콘솔 창에 출력을 수행하는 기능을 정의한 인터페이스
 */
interface CellPrinter {
	
	// 화면 출력 메소드
	void renderBoard(CellView[][] board,CellPosition choice);
}
