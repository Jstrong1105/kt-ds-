package domain.game.minesweeper;

import java.util.Map;
import java.util.Objects;

import common.ConsoleAnsi;
import common.OutputWriter;

/**
 * CellPrinter 인터페이스를 구현한 클래스
 * CellView 를 문자열로 구성한 이후 
 * OutputWriter 를 주입 받아 출력
 */
class ConsoleCellPrinter implements CellPrinter {
	
	// 테스트를 위한 패키지 프라이빗
	static final String NOT_EXIST_POSITION = "존재하지 않는 좌표입니다.";
	
	static final String HIDDEN_SYMBOL = "■";
	static final String FLAG_SYMBOL = "P";
	static final String MINE_SYMBOL = "※";
	static final String[] OPEN_SYMBOL = 
								{"□"
								,ConsoleAnsi.TXT_GREEN + "①" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_BLUE + "②" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "③" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "④" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "⑤" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "⑥" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "⑦" + ConsoleAnsi.RESET
								,ConsoleAnsi.TXT_RED + "⑧" + ConsoleAnsi.RESET
								};
	
	private final OutputWriter writer;
	
	ConsoleCellPrinter(OutputWriter writer){
		this.writer = Objects.requireNonNull(writer);
	}
	
	@Override
	public void printCell(Map<CellPosition, CellView> cells, int size, CellPosition choice) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				CellPosition position = new CellPosition(row, col);
				CellView cell = cells.get(position);
				if (cell == null) {
					throw new IllegalArgumentException(NOT_EXIST_POSITION);
				}
				
				if (position.equals(choice)) {
					sb.append(ConsoleAnsi.BG_YELLOW_TXT_GREEN);
				}
				
				sb.append(" ").append(getSymbol(cell)).append(" ");
				
				if (position.equals(choice)) {
					sb.append(ConsoleAnsi.RESET);
				}
			}
			sb.append("\n");
		}
		
		this.writer.print(sb.toString());
	}
	
	private String getSymbol(CellView cell) {
		return switch(cell.status()) {
			case HIDDEN -> HIDDEN_SYMBOL;
			case FLAG -> FLAG_SYMBOL;
			case MINE_REVEALED -> MINE_SYMBOL;
			case OPEN -> OPEN_SYMBOL[cell.adjacentMines()];
		};
	}
}
