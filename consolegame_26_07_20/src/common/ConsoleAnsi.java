package common;

/**
 * 콘솔창에서 사용하는 Ansi 코드 문자열을 모아둔 클래스
 */
public final class ConsoleAnsi {

	private ConsoleAnsi() {
	}
	
	public static final String RESET = "\u001B[0m";
	
	public static final String TXT_RED = "\u001B[91m";
	public static final String TXT_GREEN = "\u001B[92m";
	public static final String TXT_BLUE = "\u001B[94m";

	public static final String BG_YELLOW_TXT_GREEN = "\u001B[103;92m";
	
	public static final String SCREEN_CLEAR = "\u001B[H\u001B[2J\u001B[3J"; 
}
