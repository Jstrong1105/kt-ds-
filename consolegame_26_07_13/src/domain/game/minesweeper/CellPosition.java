package domain.game.minesweeper;

/**
 * 한칸의 Cell 의 위치를 나타내는 객체
 * 
 * Cell 이 가지고 있는 용도가 아니라
 * 인접 지뢰 로직에서 활용함
 * 
 * 패키지 프라이빗
 */
record CellPosition(int row, int col) {
	CellPosition{
		if(row < 0 || col < 0) {
			throw new IllegalArgumentException("음수 값은 좌표로 사용될 수 없습니다.");
		}
	}
}
