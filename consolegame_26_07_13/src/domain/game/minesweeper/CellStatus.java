package domain.game.minesweeper;

/**
 * 지뢰찾기 셀이 가지는 상태 값 목록
 * 상태 값 전이 규칙을 보유하고 있음
 * 
 * 패키지 프라이빗
 */
enum CellStatus {
	
	OPEN
	, HIDDEN
	, FLAG
	;
	
	// 셀 오픈
	CellStatus openCell() {
		return switch(this) {
			case HIDDEN -> OPEN;
			case FLAG, OPEN -> this; // 변화 없음
		};
	}
	
	// 셀 깃발 설치/회수
	CellStatus toggleFlag() {
		return switch(this) {
			case OPEN -> this; // 변화 없음
			case FLAG -> HIDDEN;
			case HIDDEN -> FLAG;
		};
	}
}
