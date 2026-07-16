package domain.game.minesweeper;

/**
 * CellPrinter 에서 사용하는 CellView 객체
 * Cell 자체를 넘길 경우 CellPrinter 에서 Cell 데이터 자체에 접근이 가능해지기 때문에
 * Cell 에서 출력에 필요한 정보만 추출해서 CellView 객체로 만들어서 전송
 * 
 * record 로 구성해 불변 보장
 * 불변 보장이 아니더라도 CellView 객체가 수정되어도 실제 Cell 에는 영향이 없음
 * 
 * 패키지 프라이빗
 */
record CellView(CellStatus status, boolean mine, int adjacentMines) {
	CellView{
		if(adjacentMines < 0 || adjacentMines > 8) {
			throw new IllegalArgumentException("인접 지뢰 수가 유효한 범위를 벗어났습니다.");
		}
	}
}
