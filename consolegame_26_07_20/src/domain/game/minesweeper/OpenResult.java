package domain.game.minesweeper;

/**
 * 셀 한칸을 열었을 때 나올 수 있는 결과
 */
enum OpenResult {
	SAFE
	, EXPLODED
	, BLOCKED;
}
