package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 콘솔 창에서 입출력을 담당하는 유틸리티 클래스
 * 외부에서 변경하지 못하도록 final 클래스로 구성
 *  */
public final class IOUtil {

	// 생성자 프라이빗으로 유틸리티 클래스의 인스턴스 생성 방지
	// 해당 클래스의 모든 메소드는 static 으로 선언
	private IOUtil() {}

	// 사용자 입력을 담당하는 입력 리더기
	// 콘솔 프로그램의 특성상 프로그램의 종료 시 까지 입력을 받아야 하기때문에
	// 별도로 입력 스트림을 닫는 처리를 하지 않고
	// 프로그램 종료 시 자동으로 닫히도록 구성
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

	// 에러 메시지
	private static final String PROMPT_NULL_ERROR = "출력 문자열이 비어있습니다.";
	private static final String IO_ERROR = "입출력 에러가 발생했습니다.";	
	private static final String NUMBER_FORMAT_ERROR = "숫자만 입력해주세요.\n"; 
	private static final String NUMBER_RANGE_ERROR = "%d ~ %d 사이로 입력하세요.\n";
	private static final String BOOLEAN_ANSWER_ERROR = "%s 또는 %s 를 입력하세요.\n";
	
	private static final String END_KEYWORD = "exit";
	// 시스템 종료 키워드 (테스트용)
	
	/**
	 * 사용자에게 문자열을 출력하는 메소드
	 * 
	 * @param prompt : 출력할 문자열
	 */
	public static void print(String prompt) {
		
		// 유효값 검사
		if(prompt == null){
			throw new IllegalArgumentException(PROMPT_NULL_ERROR);
		}
		
		// 파라미터로 받은 문자열 출력
		System.out.print(prompt);
	}
	
	/**
	 * 사용자에게 안내 메시지를 출력하고 
	 * 사용자가 엔터를 누를 때 까지 프로그램을 정지하는 메소드
	 * 사용자가 입력한 값은 무시된다.
	 * 
	 * @param prompt : 사용자 안내 메시지
	 */
	public static void pause(String prompt) {

		try {
			
			// 안내 메시지 출력
			print(prompt);
			
			// 엔터 입력 시 까지 대기
			READER.readLine();
			
		// 예외 처리(입출력 스트림 에러)
		} catch (IOException e) {
			throw new IllegalStateException(IO_ERROR);
		}
	}
	
	/**
	 * 사용자에게 안내 메시지를 출력하고
	 * 사용자 입력을 받아 문자열로 반환하는 메소드
	 * 
	 * @param prompt : 사용자 안내 메시지
	 * @return       : 사용자 입력 문자열
	 */
	public static String readString(String prompt) {
		
		try {
			
			// 『:』 자동 삽입
			// 입력하세요 -> 입력하세요 : 
			prompt = String.format("%s : ", prompt);
			
			// 안내 메시지 출력
			// 안내 메시지가 비어있을 경우 해당 메소드에서 예외 발생 -> 프로그램 종료 
			print(prompt);
			
			// 사용자 입력 읽기
			String answer = READER.readLine();

			// 사용자 입력 유효값 검사
			// ctrl + z , ctrl + c 등 입력 시 null 
			// 빈 값 입력은 유효한 입력으로 판정함
			if(answer == null) {
				answer = "";
			}
			
			// 종료 키워드와 동일한지 검사
			// 동일하다면 프로그램 강제 종료
			if(END_KEYWORD.equalsIgnoreCase(answer)) {
				System.exit(0);
			}
			
			// 입력 값 반환
			return answer;
			
		// 예외 처리 (입출력 스트림 에러)
		} catch (IOException e) {
			throw new IllegalStateException(IO_ERROR);
		}
	}
	
	/**
	 * 사용자에게 안내 메시지를 출력하고
	 * 사용자가 입력한 값을 숫자로 반환하는 메소드
	 * 숫자를 입력하지 않은 경우 잘못된 입력임을 안내하고
	 * 다시 입력을 받음
	 * 유효한 숫자를 입력할 때 까지 무한 반복함 
	 * 
	 * @param prompt : 사용자 안내 메시지
	 * @return       : 사용자 입력 숫자
	 */
	public static int readInt(String prompt) {
		
		// 입력을 받을 때 까지 무한 반복
		while(true) {
			
			try {
				// 사용자가 입력한 값을 숫자로 변환해 반환
				return Integer.parseInt(readString(prompt));
				
			// 사용자 입력 값이 숫자 형식이 아닌 경우 발생하는 예외 처리
			} catch (NumberFormatException e) {
				print(NUMBER_FORMAT_ERROR);
			}
		}
	}
	
	/**
	 * 안내 메시지에 자동으로 범위 표시를 추가해주고
	 * 사용자에게 안내 메시지를 출력한 이후
	 * 사용자에게 범위 내의 숫자를 입력받아 반환하는 메소드
	 * 숫자가 아니거나 범위를 벗어난 경우 안내 메시지를 출력하고 다시 입력받음
	 * 유효한 범위의 숫자를 입력할 때 까지 무한 반복함
	 * 
	 * @param prompt : 사용자 안내 메시지
	 * @param min    : 최소 숫자 범위
	 * @param max    : 최대 숫자 범위
	 * @return       : 사용자 입력 숫자
	 */
	public static int readIntRange(String prompt, int min, int max) {
		
		// 입력 범위 자동 삽입
		// 숫자 입력 -> 숫자 입력 (2~4) 
		prompt = String.format("%s (%d~%d) ", prompt,min,max);
		
		// 입력을 받을 때 까지 무한 반복
		while(true) {	
			// 사용자가 입력한 값을 저장
			int answer = readInt(prompt);
			
			// 사용자가 입력한 숫자가 유효한 범위를 벗어난 경우
			if(answer < min || answer > max) {
				print(String.format(NUMBER_RANGE_ERROR, min,max));
			}
			// 사용자가 입력한 숫자가 유효한 범위인 경우
			else {
				return answer;
			}
		}
	}
	
	/**
	 * 안내 메시지에 자동으로 답변 예시를 추가하고
	 * 사용자에게 안내 메시지를 출력한 이후 
	 * 사용자에게 문자열을 입력 받아 boolean 값을 반환하는 메소드
	 * trueAnswer 또는 falseAnswer 이 아닌 문자열을 입력한 경우
	 * 안내 메시지를 출력하고 다시 입력을 받음
	 * 
	 * @param prompt      : 사용자 안내 메시지
	 * @param trueAnswer  : true 답변 문자
	 * @param falseAnswer : false 답변 문자
	 * @return            : true / false
	 */
	public static boolean readBoolean(String prompt, String trueAnswer, String falseAnswer) {
		
		// 안내 메시지에 입력 가능한 답변 자동 추가
		// 입력하세요 -> 입력하세요 (Y/N)
		prompt = String.format("%s (%s/%s)", prompt,trueAnswer,falseAnswer);
		
		// 입력을 받을 때 까지 무한 반복
		while(true)
		{
			// 사용자 입력 값을 저장
			String answer = readString(prompt);
			
			// 사용자 입력 값에 따른 처리
			if(answer.equalsIgnoreCase(trueAnswer)) {
				return true;
			}
			else if(answer.equalsIgnoreCase(falseAnswer)) {
				return false;
			}
			// 유효한 값이 아닌 경우 안내 메시지 출력 이후 다시 입력 받음
			else {
				print(String.format(BOOLEAN_ANSWER_ERROR, trueAnswer,falseAnswer));
			}
		}	
	}
}
