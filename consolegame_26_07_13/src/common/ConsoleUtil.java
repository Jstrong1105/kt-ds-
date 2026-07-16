package common;

/**
 * 콘솔 창을 컨트롤하는 유틸리티
 */
public final class ConsoleUtil {

	// 인스턴스 생성을 방지하는 생성자 프라이빗
	private ConsoleUtil() {
		
	}
	
	public static void clearConsole() {
		IOUtil.print("\033[2J\033[3J\033[H");
	}
}
