package domain.game.minesweeper;

/**
 * 지뢰찾기에서 Cell 들의 배열을 가지고 각각의 Cell 에 액션을 수행하는 인터페이스
 * 
 * 패키지 프라이빗
 */
interface CellBoard {
	
	void init(int size, int count);
	// 보드 초기화
	// 보드판의 크기와 지뢰의 개수를 파라미터로 받음
	
	CellView[][] getSnapshot();
	// 보드 객체 반환
	
	void firstOpen(int row, int col);
	// 처음 선택한 곳이 지뢰인 경우 해당 지뢰를 다른 곳으로 옮기는 메소드
	// 처음 선택한 곳이 지뢰가 아닌 경우 인접 지뢰 개수만 구함
	
	boolean isOpen(int row, int col);
	// 특정 셀의 열림 여부 확인
	
	boolean isHidden(int row, int col);
	// 특정 셀의 숨김 여부 확인
	
	boolean isFlag(int row, int col);
	// 특정 셀의 깃발 여부 확인
	
	boolean isMine(int row, int col);
	// 특정 셀의 지뢰 여부 확인
	
	void openCell(int row, int col);
	// 특정 셀 오픈
	
	void toggleFlag(int row, int col);
	// 특정 셀 깃발 설치 / 회수
	
	boolean isClear();
	// 클리어 여부 확인
	
	void allOpen();
	// 모든 칸 오픈
}
