package domain.game.minesweeper;

import common.IOUtil;

class ConsoleCellPrinter implements CellPrinter{
	
	// ANSI 색상 코드
	private static final String CHOICE = "\033[103;92m";
	private static final String GREEN = "\033[92m";
	private static final String BLUE = "\033[94m";
	private static final String RED = "\033[91m";
	private static final String RESET = "\033[0m";
	
	// CellView 의 상태에 따라 화면에 출력할 문자열
	private static final String HIDDEN_CELL = "■";
	private static final String FLAG_CELL = "P";
	private static final String MINE_CELL = "※";
	private static final String[] OPEN_CELL = {
								  "□"	// 인접 지뢰 개수에 따른 표시 분기
								  ,GREEN + "①" + RESET
								  ,BLUE + "②" + RESET
								  ,RED + "③" + RESET
								  ,RED + "④" + RESET
								  ,RED + "⑤" + RESET
								  ,RED + "⑥" + RESET
								  ,RED + "⑦" + RESET
								  ,RED + "⑧" + RESET};
	
	// 에러 메시지
	private static final String NULL_BOARD_ERROR = "보드가 비어있습니다.";
	
	// 콘솔 창에 지뢰찾기 보드판을 출력하는 메소드
	@Override
	public void renderBoard(CellView[][] board, CellPosition choice) {
		
		// 에러 검사
		if(board == null || board.length <= 0) {
			throw new IllegalArgumentException(NULL_BOARD_ERROR);
		}
		
		// 보드판의 사이즈 확인
		int size = board.length;
		
		// 출력할 문자열 구성
		StringBuffer sb = new StringBuffer();
		
		// 상단 문자열 
		sb.append("==".repeat(size));
		sb.append("지뢰찾기");
		sb.append("==".repeat(size));
		sb.append("\n");
		sb.append("====".repeat(size));
		sb.append("========");
		sb.append("\n");
		
		// 상단 숫자 
		sb.append("     ");
		for(int i = 1; i <= size; i++) {
			sb.append(String.format(" %2d", i));
		}
		
		// 상단 구분선
		sb.append("\n");
		sb.append("    ");
		sb.append("┌─");
		sb.append("───".repeat(size));
		sb.append("─┐");
		sb.append("\n");

		// 보드 출력
		for(int row = 0; row < size; row++) {
			
			// 보드 좌측 숫자와 구분선
			sb.append(String.format(" %2d │ ", (row+1)));
			
			// 실제 보드 구성
			for(int col = 0; col < size; col++) {
				
				if (choice != null && row == choice.row() && col == choice.col()) {
					sb.append(CHOICE);
				}
				
				sb.append(" " + getText(board[row][col]) + " ");
				
				if (choice != null && row == choice.row() && col == choice.col()) {
					sb.append(RESET);
				}
			}
			
			// 보드 우측 구분선
			sb.append(" │ \n");
		}
		
		// 보드 하단 구분선
		sb.append("    ");
		sb.append("└─");
		sb.append("───".repeat(size));
		sb.append("─┘");
		sb.append("\n");
		
		// 실제 출력
		IOUtil.print(sb.toString());
	}
	
	// cell 의 상태에 따라 화면에 출력할 문자열을 반환하는 메소드
	private String getText(CellView cell) {
		
		return switch(cell.status()) {
			case HIDDEN -> HIDDEN_CELL;
			case FLAG -> FLAG_CELL;
			case OPEN ->{
				if(cell.mine()) {
					yield MINE_CELL;
				}else {
					yield OPEN_CELL[cell.adjacentMines()];
				}
			}
		};
	}
}
