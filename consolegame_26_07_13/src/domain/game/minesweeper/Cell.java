package domain.game.minesweeper;

/**
 * 지뢰찾기에서 한칸을 담당하는 Cell 객체 클래스
 * 
 * 지뢰 여부, 위치, 현재 상태, 인접 지뢰 개수 등을 속성으로 가짐
 * 열기, 깃발 설치/회수, 속성 조회 등 기능을 제공
 * 
 * 패키지 프라이빗
 */
class Cell {
	
	// 주요 속성 구성
	// 지뢰 여부 : 사용자가 처음 입력한 값이 지뢰인 경우 지뢰를 해제하는 기믹으로 인해 final 로 구성하지 않음
	private boolean mine;
	// 셀의 상태
	private CellStatus status;
	// 인접한 칸의 지뢰 개수
	private int adjacentMines;
	
	// 생성자
	// 좌표 값을 받아 생성
	// 기본값 
	Cell(){
		this.mine = false;
		this.status = CellStatus.HIDDEN;
		this.adjacentMines = 0;
	}
	
	// getter
	boolean isMine() {
		return mine;
	}
	int getAdjacentMines() {
		return adjacentMines;
	}
	CellStatus getStatus() {
		return status;
	}
	// 아래 getter 는 외부에서
	// getStatus 이후 한번 더 비교해야하는
	// 과정을 줄여주기 위한 헬퍼 메소드
	boolean isOpen() {
		return status == CellStatus.OPEN;
	}
	boolean isHidden() {
		return status == CellStatus.HIDDEN;
	}
	boolean isFlag() {
		return status == CellStatus.FLAG;
	}
	
	// setter
	void plantMine() {
		this.mine = true;
	}
	void removeMine() {
		this.mine = false;
	}
	// status 의 상태전이는 enum 내부에서 관리함
	void openCell() {
		status = status.openCell();
	}
	void toggleFlag() {
		status = status.toggleFlag();
	}
	// adjacentMines 는 주변 8칸을 조회해서 한번에 대입하는 방식이 아닌
	// 지뢰를 발견하면 주변 8칸의 인접 지뢰 개수를 +1 하는 방식으로 구현
	void incrementAdjacentMines() {
		adjacentMines++;
	}
}
