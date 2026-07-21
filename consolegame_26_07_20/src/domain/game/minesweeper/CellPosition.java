package domain.game.minesweeper;

/**
 * 한칸의 셀이 가지는 위치 값을 표현한 레코드
 */
record CellPosition(int row, int col) {
	
	// 테스트 접근을 위한 패키지 프라이빗
	static final String NOT_VALID_VALUE = "유효하지 않은 좌표 값입니다.";
	
	CellPosition{
		
		if (row < 0 || col < 0) {
			throw new IllegalArgumentException(NOT_VALID_VALUE);
		}
	}
}
