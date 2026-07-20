package common;

/**
 * 사용자에게 문자를 출력하는 기능을 수행하는 인터페이스
 */
public interface OutputWriter {
	
	/**
	 * 사용자에게 안내 메시지를 출력함 (개행 X) 
	 * @param message 안내 메시지
	 * @throws NullPointerException message 가 null 인 경우
	 */
	void print(String message);
	
	/**
	 * 사용자에게 안내 메시지를 출력함 (개행 O)
	 * @param message 안내 메시지
	 * @throws NullPointerException message 가 null 인 경우
	 */
	void println(String message);
}
