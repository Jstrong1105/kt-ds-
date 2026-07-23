package domain.game.minesweeper;

import java.util.Map;

/**
 * Map<CellPosition, CellView> 를 받아서 출력하는 기능을 수행하는 인터페이스 
 */
interface CellPrinter {
	
	/**
	 * 
	 * @param cells 출력할 cells 들의 정보
	 * @param size  출력할 보드의 사이즈
	 * @param choice 선택되어있는 위치 null 허용
	 */
	void printCell(Map<CellPosition, CellView> cells, int size, CellPosition choice);
}
