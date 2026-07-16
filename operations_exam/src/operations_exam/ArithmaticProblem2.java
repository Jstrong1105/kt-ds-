package operations_exam;

/*
 * 산술 연산자를 이용해
 * processTime을 분(Minute), 초(second)
 * 를 구한다음 minutes, seconds 변수에 할당하고
 * 출력해보세요
 */
public class ArithmaticProblem2 {
	
	public static void main(String[] args) {
		
		final int MINUTE_TO_SECOND = 60;
		
		int processTime = 145;
		int minutes = processTime / MINUTE_TO_SECOND;
		int seconds = processTime % MINUTE_TO_SECOND;
		
		System.out.printf("%d분 %d초",minutes,seconds);
		// 2분 25초
	}
}
