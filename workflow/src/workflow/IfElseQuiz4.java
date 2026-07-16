package workflow;

import java.util.Random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120830
 * if - else 연습 문제 프로그래머스
 * 
 * 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다. 
 * 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다. 
 * 정수 n과 k가 매개변수로 주어졌을 때, 
 * 양꼬치 n인분과 음료수 k개를 먹었다면 
 * 총얼마를 지불해야 하는지 return 하도록 
 * solution 함수를 완성해보세요.
 * 
 * 제한 사항
 * 0 <= n < 1000
 * n/10 <= k < 1000
 */
public class IfElseQuiz4 {
	
	// 양꼬치 가격 상수
	private static final int LAMB_KEBAB_PRICE = 12000;
	
	// 음료수 가격 상수
	private static final int DRINK_PRICE = 2000;
	
	public static void main(String[] args) {
		
		// 난수 발생 객체 생성
		Random random = new Random();
		
		// n 에 랜덤한 난수 생성
		// n : (0 ~ 999)
		int n = random.nextInt(1000);
		int k;
		
		// k 에 랜덤한 난수 생성
		// k : n/10 ~ 999
		while(true) {
			k = random.nextInt(1000);
			
			if (n/10 <= k) {
				break;
			}
		}
		
		// 주문한 금액 계산
		// int totalPrice = (n * LAMB_KEBAB_PRICE) + (k * DRINK_PRICE) - (n/10 * DRINK_PRICE);
		int totalPrice = n * LAMB_KEBAB_PRICE;
		
		if (n/10 >= 1) {
			totalPrice += (k-(n/10)) * DRINK_PRICE;
		}else {
			totalPrice += k * DRINK_PRICE;
		}
		
		System.out.printf("주문한 양꼬치 : %d%n"
				        + "주문한 음료수 : %d%n"
				        + "총 지불 금액 : %d",
						  n,k,totalPrice);
	}
}
