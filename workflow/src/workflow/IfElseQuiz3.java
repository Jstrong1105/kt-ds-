package workflow;

import java.util.Random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120829
 * if - else 연습 문제 프로그래머스
 * 
 *  각에서 0도 초과 90도 미만은 예각, 90도는 직각, 
 *  90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다. 
 *  각 angle이 매개변수로 주어질 때 
 *  예각일 때 1, 직각일 때 2, 
 *  둔각일 때 3, 평각일 때 4를 
 *  return하도록 solution 함수를 완성해주세요.
 *  
 *  제한 사항
 *  각도 angle 변수의 값은 0 ~ 180
 *  angle 은 정수
 */
public class IfElseQuiz3 {
	
	public static void main(String[] args) {
		
		// 난수 발생 객체
		Random random = new Random();
		
		// 랜덤한 각도 (1~180)
		int angle = random.nextInt(180) + 1;
		
		// 결과를 담을 변수 선언 및 초기화
		int result = 0;
		
		// angle 에 따른 분기 처리
		if (angle < 90) {
			result = 1;
		}
		else if (angle == 90) {
			result = 2;
		}
		else if (angle < 180) {
			result = 3;
		}
		else if (angle == 180) {
			result = 4;
		}
		else {
			result = -1;
		}
		
		// 결과 출력
		System.out.printf("각도 %d : %d",angle,result);
	}
}
