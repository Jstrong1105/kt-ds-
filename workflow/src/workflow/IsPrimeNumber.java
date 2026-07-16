package workflow;

import java.util.Scanner;

public class IsPrimeNumber {
	
	public static void main(String[] args) {
		
		// 사용자에게 입력을 받는 변수 선언
		Scanner scanner = new Scanner(System.in);
		
		// 소수 여부를 판단해서 결과를 담아둘 변수 선언
		boolean isPrime = true;
		
		// 사용자에게 안내할 메시지를 담아둘 변수 선언
		String prompt = "2 이상의 정수를 입력하세요.";
		
		// 사용자에게 안내 메시지 출력
		System.out.print(prompt);
		
		// 사용자 입력을 저장
		int answer = scanner.nextInt();
		
		// 사용자가 입력한 값을 2부터 차례대로 나누어서 
		// 해당 숫자로 나누어 지는 경우 
		// 소수가 아니라고 판단
		// 특정 숫자의 약수는 해당 숫자의 절반을 넘을 수 없기 때문에
		// 해당 숫자의 절반까지만 계산
		for(int i = 2; i <= ( answer/2 ); i++) {
			// 나누어 떨어지는 수를 발견하면 
			// for 반복문 종료
			if( ( answer % i ) == 0) {
				isPrime = false;
				break;
			}
		}
		
		// 결과에 따라 사용자에게 안내 메시지 출력
		if (isPrime) {
			System.out.println(answer + "는 소수 입니다.");
		}else {
			System.out.println(answer + "는 소수가 아닙니다.");
		}
	}
}
