package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

/**
 * Console 창에서 사용자에게 입력을 받음
 * 
 * null 입력 -> IllegalStateException : 입력 스트림 종료 -> 프로그램 종료
 * min > max -> IllegalArgumentException : 개발자의 호출 문제 -> 프로그램 종료
 */
public class ConsoleInputReader implements InputReader {
	
	/*
	 * 테스트를 위해 패키지 프라이빗으로 변경
	 */
	static final String NUMBER_FORMAT_ERROR = "숫자만 입력해주세요.";
	static final String NUMBER_RANGE_ERROR = "%d ~ %d 사이로 입력하세요.";
	static final String NOT_VALID_RANGE = "min(%d) > max(%d)";
	static final String BOOLEAN_ANSWER_ERROR = "%s 또는 %s 를 입력하세요.";
	static final String NULL_STREAM = "입력 소스 종료";
	
	private final OutputWriter writer;
	
	private final BufferedReader reader;
	
	// 생성자
	public ConsoleInputReader(OutputWriter writer, BufferedReader reader) {
		this.writer = Objects.requireNonNull(writer);
		this.reader = Objects.requireNonNull(reader);
	}
	
	@Override
	public String readString(String prompt) {
		
		try {
			writer.print(prompt);
			String answer = reader.readLine();
			
			if (answer == null) {
				throw new IllegalStateException(NULL_STREAM);
			}
			return answer;
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public int readInt(String prompt) {
		
		while(true) {
			try {
				return Integer.parseInt(readString(prompt)); 
				
			} catch (NumberFormatException e) {
				writer.println(NUMBER_FORMAT_ERROR);
			}
		}
	}

	@Override
	public int readIntRange(String prompt, int min, int max) {
		if(min > max) {
			String errMsg = String.format(NOT_VALID_RANGE, min, max);
			throw new IllegalArgumentException(errMsg);
		}
		
		String numberPrompt = String.format("%s (%d~%d)", prompt, min, max);
		
		while(true) {
			int number = readInt(numberPrompt);
			
			if (number < min || number > max) {
				String errMsg = String.format(NUMBER_RANGE_ERROR, min, max);
				writer.println(errMsg);
			} else {
				return number;
			}
		}
	}

	@Override
	public boolean readBoolean(String prompt, String trueAnswer, String falseAnswer) {
		String boolPrompt = String.format("%s (%s/%s)", prompt, trueAnswer, falseAnswer);
		
		while(true) {
			String answer = readString(boolPrompt);
			
			if (trueAnswer.equalsIgnoreCase(answer)) {
				return true;
			} else if (falseAnswer.equalsIgnoreCase(answer)) {
				return false;
			} else {
				String errMsg = String.format(BOOLEAN_ANSWER_ERROR, trueAnswer, falseAnswer);
				writer.println(errMsg);
			}
		}
	}

	@Override
	public void pause(String prompt) {
		readString(prompt);
	}
}