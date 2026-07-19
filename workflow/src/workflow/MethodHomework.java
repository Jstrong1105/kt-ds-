package workflow;

/**
 * 메소드 과제 2026-07-19 
 * 
 * 하나의 클래스에 아래 메소드를 모두 만들어 호출합니다.
 * 
 * 작성한 자바 파일은 본인의 깃헙 레파지토리에 등록하고 주소를 댓글로 첨부하세요.
 * 
 * 1. 정수형 변수 2개를 파라미터로 받아, 값을 출력하는 메소드.
 * 2. 정수형 변수 2개를 파라미터로 받아, 합계를 출력하는 메소드.
 * 3. 정수형 변수 3개를 파라미터로 받아, 합계를 반환하는 메소드.
 * 4. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 출력하는 메소드.
 * 5. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 반환하는 메소드.
 * 6. 실수형 변수 1개와 정수형 파라미터 1개를 받아 소수점 이하 자리수를 변경하여 반환하는 메소드.
 * 
 *    -> 예> 소수점 변경(10.33333333, 2) ==> 10.33 
 * 
 *    -> 예> 소수점 변경(10.33333333, 3) ==> 10.333
 * 
 *    -> 예> 소수점 변경(10.33333333, 1) ==> 10.3
 * 
 *    -> 예> 소수점 변경(10.33333333, 0) ==> 10.0
 * 
 * 7. 실수형 변수 2개를 파라미터로 받아, 가장 큰 수만 반환하는 메소드.
 * 8. 실수형 변수 4개를 파라미터로 받아, 가장 작은 수만 반환하는 메소드.
 * 9. 정수 배열을 파라미터로 받아, 2,5,8 배수인 숫자만 출력하는 메소드.
 * 10. 문자열 1개와 정수형 변수 1개를 파라미터로 받아, 문자열을 정수형 변수만큼 반복 출력하는 메소드.
 * 11. 정수형 변수 1개를 파라미터로 받아, 해당 정수의 구구단을 출력하는 메소드.
 * 12. 정수형 변수 1개를 파라미터로 받아, 4부터 정수형 변수까지의 범위 중 소수(Prime Number)만 출력하는 메소드.
 * 13. 정수형 배열 변수 1개와 정수형 변수 1개를 파라미터로 받아, 해당 배열의 정수형변수 인덱스에 의 값을 반환하는 메소드.
 * 
 *     -> 예> 값(길이가 5인 배열, 2) ==> 배열의 2번 인덱스의 값
 * 
 *     -> 예> 값(길이가 5인 배열, 4) ==> 배열의 4번 인덱스의 값
 * 
 *     -> 예> 값(길이가 5인 배열, 5) ==> 0
 * 
 *     -> 예> 값(길이가 5인 배열, -1) ==> 0
 * 
 *     -> 예> 값(길이가 5인 배열, 1) ==> 배열의 1번 인덱스의 값
 * 
 *     -> 예> 값(길이가 5인 배열, 0) ==> 배열의 0번 인덱스의 값
 * 
 *     -> 예> 값(길이가 5인 배열, 3) ==> 배열의 3번 인덱스의 값
 * 
 *     -> 예> 값(길이가 5인 배열, 7) ==> 0
 * 
 * 14. 정수형 배열 변수 1개를 파라미터로 받아, 가장 처음 나오는 3의 배수만 반환하는 메소드    - 정수형 배열 변수내부에 3의 배수가 없을 경우 -1 을 반환.
 * 15. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복값만 출력하는 메소드.
 * 
 *     -> 중복([1,2,3,4,5], [9,7,454,1,2,3]) ==> 1 2 3
 * 
 * 16. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
 * 
 * 		-> 고유([1,2,3,4,5], [9,7,454,1,2,3]) ==> 4, 5, 9. 7, 454
 * 
 * 17. 정수형 배열 변수 1개를 파라미터로 받아, 모든 값들을 배수로 만드는 (반환x) 메소드
 * 
 * 		-> 호출 이후에 main 메소드 내부에서 배열 내부의 값들을 모두 출력.
 */    
public class MethodHomework {

	// 1. 정수형 변수 2개를 파라미터로 받아, 값을 출력하는 메소드.
	public static void printTwoNumber(int num1, int num2) {
		System.out.println("첫번째 수 : " + num1);
		System.out.println("두번째 수 : " + num2);
	}
	
	// 2. 정수형 변수 2개를 파라미터로 받아, 합계를 출력하는 메소드.
	public static void printAddTwoNumber(int num1, int num2) {
		System.out.println(num1 + "," + num2 + "의 합 : " + ( num1 + num2 ) );
	}
	
	// 3. 정수형 변수 3개를 파라미터로 받아, 합계를 반환하는 메소드.
	public static int addThreeNumber(int num1, int num2, int num3) {
		return (num1 + num2 + num3);
	}

	// 4. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 출력하는 메소드.
	public static void printDivisionTwoNumber(int num1, int num2) {
		
		System.out.println(num1 + " / " + num2 + " = " + ( num1 / (double) num2 ) );
	}
	
	// 5. 정수형 변수 2개를 파라미터로 받아, 나누기의 결과(실수)를 반환하는 메소드.
	public static double divisionTwoNumber(int num1, int num2) {
		
		return num1 / (double) num2;
	}
	
	// 6. 실수형 변수 1개와 정수형 파라미터 1개를 받아 소수점 이하 자리수를 변경하여 반환하는 메소드.
	public static double setDigit(double number, int digit) {

		double value = 1.0;
		
		if (digit >= 0){
			for(int i = 0; i < digit; i++) {
				value *= 10;
			}
		}
		else {
			for(int i = 0; i < -digit; i++){
				value /= 10;
			}
		}

		int result = (int) (number * value);
			
		return result / value;	
	}
	
	// 7. 실수형 변수 2개를 파라미터로 받아, 가장 큰 수만 반환하는 메소드.
	public static double findMaxNumber(double num1, double num2) {
		
		double result = num1;
		
		if(result < num2) {
			result = num2;
		}
		
		return result;
	}
	
	// 8. 실수형 변수 4개를 파라미터로 받아, 가장 작은 수만 반환하는 메소드.
	public static double findMinNumber(double num1, double num2
			                         , double num3, double num4) {
		double result = num1;
		
		if(result > num2) {
			result = num2;
		}
		
		if(result > num3) {
			result = num3;
		}
		
		if(result > num4) {
			result = num4;
		}
		
		return result;
	}
	
	// 9. 정수 배열을 파라미터로 받아, 2,5,8 배수인 숫자만 출력하는 메소드.
	public static void printMultiple(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			if( (i % 2 == 0) || (i % 5 == 0) || (i % 8 == 0) ) {
				System.out.println(i);
			}
		}
	}
	
	// 10. 문자열 1개와 정수형 변수 1개를 파라미터로 받아, 문자열을 정수형 변수만큼 반복 출력하는 메소드.
	public static void printRepeat(String prompt, int count) {
		
		for(int i = 0; i < count; i++) {
			System.out.println(prompt);
		}
	}
	
	// 11. 정수형 변수 1개를 파라미터로 받아, 해당 정수의 구구단을 출력하는 메소드.
	public static void printTable(int dan) {
		
		for(int i = 1; i < 10; i++) {
			System.out.println(dan + " x " + i + " = " + ( dan * i ) );
		}
	}
	
	// 12. 정수형 변수 1개를 파라미터로 받아, 4부터 정수형 변수까지의 범위 중 소수(Prime Number)만 출력하는 메소드.
	public static void printPrime(int num) {
		
		for(int i = 4; i <= num; i++) {
			
			if(isPrime(i)) {
				System.out.println(i + " 는 소수입니다.");
			}
		}
	}
	
	// 12-1
	// 12 문제에서 활용하는 메소드
	private static boolean isPrime(int num) {
		
		boolean prime = true;
		
		for(int i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				prime = false;
				break;
			}
		}
		
		return prime;
	}
	
	// 13. 정수형 배열 변수 1개와 정수형 변수 1개를 파라미터로 받아, 해당 배열의 정수형변수 인덱스에 의 값을 반환하는 메소드.
	public static int getArray(int[] array, int index) {
		
		// index 가 음수이거나 배열 범위를 벗어난 경우
		if ( (index < 0) || (index >= array.length) ) {
			return 0;
		}
		
		return array[index];
	}
	
	// 14. 정수형 배열 변수 1개를 파라미터로 받아, 가장 처음 나오는 3의 배수만 반환하는 메소드    - 정수형 배열 변수내부에 3의 배수가 없을 경우 -1 을 반환.
	public static int getThreeMultiple(int[] array) {
		
		int result = -1;
		
		for(int i = 0; i < array.length; i++) {
			
			if ( array[i] % 3 == 0 ) {
				result = array[i];
				break;
			}
		}
		
		return result;
	}
	
	// 15. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복값만 출력하는 메소드.
	public static void printDuplication(int[] array1, int[] array2) {
		
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.print(array2[j] + " ");
				}
			}
		}
	}
	
	// 16. 정수형 배열 변수 2개를 파라미터로 받아, 각 배열에 중복되지 않는 값만 출력하는 메소드.
	public static void printUnique(int[] array1, int[] array2) {
		
		for(int i = 0; i < array1.length; i++) {
			
			boolean unique = true;
			
			for(int j = 0; j < array2.length; j++) {
				
				if(array1[i] == array2[j]) {
					unique = false;
					break;
				}
			}
			
			if(unique) {
				System.out.print(array1[i] + ", ");
			}
		}
	}
	
	// 17. 정수형 배열 변수 1개를 파라미터로 받아, 모든 값들을 배수로 만드는 (반환x) 메소드
	public static void allDouble(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i] * 2;
		}
	}
	
	public static void main(String[] args) {
		
		printTwoNumber(1, 2);
		printAddTwoNumber(1, 2);
		System.out.println(addThreeNumber(1, 2, 3));
		System.out.println(divisionTwoNumber(10, 3));
		System.out.println(setDigit(3.1415926535, 2));
		System.out.println(findMaxNumber(3.14, 4.35));
		System.out.println(findMinNumber(1.0, 2.21, 3.354, 34.433));
		
		int[] array1 = new int[10];
		array1[0] = 1;
		array1[1] = 3;
		array1[2] = 2;
		array1[3] = 8;
		array1[4] = 43;
		array1[5] = 21;
		array1[6] = 9;
		array1[7] = 6;
		array1[8] = 5;
		array1[9] = 434;
		
		int[] array2 = new int[8];
		array2[0] = 10;
		array2[1] = 32;
		array2[2] = 1;
		array2[3] = 75;
		array2[4] = 6;
		array2[5] = 3;
		array2[6] = 432;
		array2[7] = 7;
	
		printMultiple(array1);
		printRepeat("Hello Wolrd", 3);
		printTable(9);
		printPrime(13);
		System.out.println(getArray(array2, 3));
		System.out.println(getThreeMultiple(array1));
		printDuplication(array1,array2);
		printUnique(array1,array2);
		allDouble(array2);
		
		for(int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
	}
}
