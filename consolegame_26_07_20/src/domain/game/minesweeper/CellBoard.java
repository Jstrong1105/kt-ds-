package domain.game.minesweeper;

import java.util.Map;

/**
 * 지뢰찾기 보드판 
 * 
 * Cell 목록을 가지고 있음
 * 각각의 Cell 에 상호작용 할 수 있는 기능 제공
 * 각각의 Cell 의 정보를 제공
 * 파라미터로 전달받은 CellPosition 에 해당하는 Cell 이 없는 경우
 * IllegalArgumentException 이 발생한다.
 */
interface CellBoard {
	
	/**
	 * 보드판을 초기화하는 메소드
	 * @param size 지뢰 찾기 보드판의 가로, 세로 크기
	 * @param mineCount 지뢰의 개수
	 * @throws IllegalArgumentException mineCount 가 size * size 보다 크거나 같은 경우, size 가 0 이하 인 경우, mineCount 가 0 이하 인 경우
	 */
	void reset(int size, int mineCount);
	
	/**
	 * 한칸의 열림 여부를 반환하는 메소드
	 * @param position 열림 여부를 확인할 위치
	 * @return 열림 여부
	 */
	boolean isOpen(CellPosition position);
	
	/**
	 * 한칸의 깃발 여부를 반환하는 메소드
	 * @param position 열림 여부를 확인할 위치
	 * @return 깃발 여부
	 */
	boolean isFlag(CellPosition position);
	
	/**
	 * 한칸을 오픈하고 그 결과를 반환하는 메소드
	 * @param position 오픈할 위치
	 * @return 지뢰 or 무시 or 열림
	 */
	OpenResult openCell(CellPosition position);
	
	/**
	 * 한칸의 깃발 상태를 전환하는 메소드
	 * @param position 전환할 위치
	 */
	void toggleFlag(CellPosition position);

	/**
	 * 클리어 여부를 반환하는 메소드
	 * @return 클리어 여부
	 */
	boolean isClear();
	
	/**
	 * 설치된 깃발의 개수를 반환하는 메소드
	 * @return 설치된 깃발의 개수
	 */
	int flagCount();
	
	/**
	 * 게임이 종료되어서 모든 지뢰를 공개하는 메소드
	 */
	void openMine();
	
	/**
	 * 보드판의 사이즈를 반환하는 메소드
	 * @return 보드판의 사이즈
	 */
	int getSize();
	
	/**
	 * 셀의 정보를 불변 뷰에 담아 반환하는 메소드
	 * @return 셀의 정보들
	 */
	Map<CellPosition, CellView> getBoard();
}
