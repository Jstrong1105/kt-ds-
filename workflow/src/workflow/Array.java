package workflow;

public class Array {
	
	public static void main(String[] args) {
		
		// 숫자 여러개 주어진다.
		// 5, 6, 9, 11, 12, 13, ....
		// 주어진 숫자들이 소수인지 확인한다.
		int num1 = 5;
		int num2 = 6;
		int num3 = 9;
		int num4 = 11;
		int num5 = 12;
		int num6 = 13;
		
		// 6개의 변수를 하나의 변수로 병합 -> 배열
		int[] array = {num1,num2,num3,num4,num5,num6};
		
		// 배열 내부의 할당된 모든 숫자들을 출력한다.
		for(int i = 0; i < 6; i++) {
			System.out.println(array[i]);
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for(int i : array) {
			System.out.println(i);
		}
		
		for(int i : array) {
			if(isPrime(i)) {
				System.out.println(i + "는 소수 입니다.");
			} else {
				System.out.println(i + "는 소수가 아닙니다.");
			}
		}
	}
	
	public static boolean isPrime(int num) {
		
		boolean prime = true;
		
		for (int i = 2; i <= ( num / 2 ); i++){
			if (num % i == 0) {
				prime = false;
				break;
			}
		}
		
		return prime;
	}
}
