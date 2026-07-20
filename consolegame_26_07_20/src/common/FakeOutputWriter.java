package common;

import java.util.Objects;

/**
 * 테스트를 위한 가짜 Writer 클래스
 * 콘솔 창에 출력하는 대신 StringBuilder 객체에 저장을 함
 * output() 메소드로 저장된 문자열 반환 
 */
public class FakeOutputWriter implements OutputWriter {
	
	private final StringBuilder out = new StringBuilder();
	
	@Override
	public void print(String message) {
		out.append(Objects.requireNonNull(message));
	}
	
	@Override
	public void println(String message) {
		out.append(Objects.requireNonNull(message)).append("\n");
	}
	
	public String output() {
		return out.toString();
	}
}
