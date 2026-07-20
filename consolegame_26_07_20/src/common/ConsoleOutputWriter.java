package common;

import java.util.Objects;

/**
 * 콘솔창에 메시지를 출력한다.
 */
public class ConsoleOutputWriter implements OutputWriter {
	
	@Override
	public void print(String message) {
		System.out.print(Objects.requireNonNull(message));
	}
	
	@Override
	public void println(String message) {
		System.out.println(Objects.requireNonNull(message));
	}
}
