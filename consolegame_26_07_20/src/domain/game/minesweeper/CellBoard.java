package domain.game.minesweeper;

import java.util.List;

/**
 * 지뢰찾기 보드판 
 * 
 * Cell 목록을 가지고 있음
 * 각각의 Cell 에 상호작용 할 수 있는 기능 제공
 * 각각의 Cell 의 정보를 제공
 * 
 */
interface CellBoard {
	
	/**
	 * 보드판을 초기화하는 메소드
	 * @param size지뢰 찾기 보드판의 가로, 세로 크기
	 * @param mineCount 지뢰의 개수
	 * @throws IllegalArgumentException mineCount 가 size * size 보다 크거나 같은 경우, size 가 0 이하 인 경우, mineCount 가 0 이하 인 경우
	 */
	void reset(int size, int mineCount);
	
	boolean isOpen(CellPosition position);
	
	boolean isFlag(CellPosition position);
	
	OpenResult openCell(CellPosition position);
	
	void toggleFlag(CellPosition position);
	
	boolean isClear();
	
	int flagCount();
	
	List<CellView> getBoard();
}
