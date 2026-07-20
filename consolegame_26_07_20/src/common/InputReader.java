package common;

/**
 * 콘솔창에서 입력을 받는 기능을 수행하는 인터페이스 정의
 * 입력을 받는 메소드는 입력 값이 null 인 경우 (Ctrl z 등) IllegalStateException 을 던진다.
 */
public interface InputReader {

	/**
	 * 사용자에게 문자열을 입력받는 메소드
	 * @param prompt 사용자 안내 메시지
	 * @return 사용자가 입력한 문자열
	 */
	String readString(String prompt);
	
	/**
	 * 사용자에게 숫자를 입력받는 메소드  
	 * 사용자가 숫자를 입력할 때 까지 무한 반복
	 * @param prompt 사용자 안내 메시지
	 * @return 사용자가 입력한 숫자
	 */
	int readInt(String prompt);
	
	/**
	 * 사용자에게 제한된 범위에서 숫자를 입력받는 메소드
	 * 사용자가 범위내에 숫자를 입력할 때 까지 무한 반복
	 * @param prompt 사용자 안내 메시지
	 * @param min    최소 입력 숫자(포함)
	 * @param max    최대 입력 숫자(포함)
	 * @return       사용자가 입력한 숫자
	 * @throws IllegalArgumentException min 이 max 보다 큰 경우 에러 
	 */
	int readIntRange(String prompt, int min, int max);
	
	/**
	 * 사용자에게 boolean 을 입력받는 메소드
	 * 사용자가 true / false 에 해당하는 값을 입력할 때까지 무한 반복한다.
	 * 대소문자를 구분하지 않는다. 
	 * @param prompt 사용자 안내 메시지
	 * @param trueAnswer  true 를 반환할 문자열
	 * @param falseAnswer false를 반환할 문자열
	 * @return 사용자가 입력한 boolean 값
	 */
	boolean readBoolean(String prompt, String trueAnswer, String falseAnswer);
	
	/**
	 * 사용자에게 엔터를 입력받을 때까지 대기하는 메소드 
	 * @param prompt 사용자 안내 메시지
	 */
	void pause(String prompt);
}