package workflow;

/**
 * 메소드 과제
 * 
 * 2026.07.16
 * 
 * 	1. 정수 두 개를 받아서 사칙연산(+,-,X,/) 의 결과를 출력하는 메소드를 만들고 호출해보세요.
 *  2. 정수 한 개를 받아서 짝수라면 true, 홀수라면 false 를 반환하는 메소드를 만들고 호출해보세요.
 *  3. 정수 세 개를 받아서 가장 큰 수를 출력하는 메소드를 만들고 호출해보세요.
 *  4. 정수 한 개를 받아서 소수(prime number)라면 true를 아니라면 false 를 반환하는 메소드를 만들고 호출해보세요.
 *  
 *  하나의 클래스에 main 을 포함한 5개의 메소드 생성
 *  
 *  작성한 코드를 본인의 깃헙 레파지토리에 Push 하고, 해당 주소를 댓글로 첨부하세요
 */
public class MethodQuiz {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 7;
		int num3 = 15;
		
		// printOperation : 두 개의 정수를 입력 받아 사칙연산의 결과를 출력하는 메소드
		printOperation(num1,num2);
		
		// isEven(int num) : num 이 짝수인지 검사해서 boolean 을 반환하는 메소드 
		if(isEven(num3)) {
			System.out.println(num3 + " 는 짝수입니다.");
		} else {
			System.out.println(num3 + " 는 홀수입니다.");
		}
		
		// maxNumber(int num1, int num2, int num3) : 세 개의 정수를 입력 받아 가장 큰 수를 반환하는 메소드 
		int maxNumber = maxNumber(num1, num2, num3);
		
		System.out.println(num1 + ", " + num2 + ", " + num3 + " 중 가장 큰 숫자는 " + maxNumber + " 입니다.");
		
		// isPrime(int num) : 정수를 입력받아 소수 여부를 반환하는 메소드 
		if(isPrime(num1)) {
			System.out.println(num1 + "는 소수입니다.");
		} else {
			System.out.println(num1 + "는 소수가 아닙니다.");
		}
	}
	
	// 두 개의 정수를 입력 받아 사칙연산의 결과를 출력하는 메소드
	public static void printOperation(int num1, int num2) {
		System.out.println(num1 + " + " + num2 + " = " + ( num1 + num2 ) );
		System.out.println(num1 + " - " + num2 + " = " + ( num1 - num2 ) );
		System.out.println(num1 + " x " + num2 + " = " + ( num1 * num2 ) );
		System.out.println(num1 + " / " + num2 + " = " + ( num1 * 1.0 / num2 ) );
	}
	
	// 짝수 여부를 확인해서 반환하는 메소드
	public static boolean isEven(int number) {
		return (number % 2 == 0);
	}
	
	// 3 개의 정수를 입력 받아 가장 큰 수를 반환하는 메소드
	public static int maxNumber(int num1, int num2, int num3) {
		
		// 1번 정수를 저장
		int result = num1;
		
		// 1번과 2번을 비교해 더 큰 숫자를 저장
		if(result < num2) {
			result = num2;
		}
		
		// 저장된 숫자와 3번을 비교해 더 큰 숫자를 저장
		if(result < num3) {
			result = num3;
		}
		
		// 저장된 숫자를 반환
		return result;
	}
	
	// 정수를 입력 받아 소수 여부를 판단해서 boolean 을 반환하는 메소드
	public static boolean isPrime(int num) {
		
		if(num < 2) {
			return false;
		}
		
		boolean prime = true;
		
		for(int i = 2; i <= (num/2); i++) {
			if(num % i == 0) {
				prime = false;
				break;
			}
		}
		
		return prime;
	}
}
