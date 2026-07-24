package common;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 테스트를 위한 가짜 인풋 리더
 * 콘솔창에서 입력을 받는 대신
 * 사전에 설정한 문자열을 반환함
 * pause 는 입력을 소비하지 않는다.
 */
public class FakeInputReader implements InputReader {
	
	private final Deque<String> answer = new ArrayDeque<>(); 
	
	public void setAnswer(String ...answer) {
		this.answer.addAll(List.of(answer));
	}
	
	private String next() {
		if(answer.isEmpty()) {
			throw new IllegalStateException("입력 소진 (시나리오 오류)");
		}
		
		return answer.poll();
	}
	
	@Override
	public void pause(String prompt) {
	}
	
	@Override
	public String readString(String prompt) {
		return this.next();
	}
	
	@Override
	public boolean readBoolean(String prompt, String trueAnswer, String falseAnswer) {
		String answer = next();
		
		if (answer.equalsIgnoreCase(trueAnswer)) {
			return true;
		} else if (answer.equalsIgnoreCase(falseAnswer)) {
			return false;
		} else {
			throw new IllegalStateException("잘못된 입력 (시나리오 오류)");
		}
	}
	
	@Override
	public int readInt(String prompt) {
		return Integer.parseInt(this.next());
	}
	
	@Override
	public int readIntRange(String prompt, int min, int max) {
		int num = Integer.parseInt(this.next());
		if (num < min || num > max) {
			throw new IllegalStateException("잘못된 입력 (시나리오 오류)");
		}
		return num;
	}
}
