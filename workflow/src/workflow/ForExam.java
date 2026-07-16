package workflow;

public class ForExam {
	
	public static void main(String[] args) {
		
		// 구구단 2단 출력
		/*
		int dan = 2;
		
		for(int i = 1; i <= 9; i++) {
			// System.out.println(i);
			System.out.printf("%d x %d = %d%n" , dan , i , ( dan * i ) );
		}
		
		// 구구단 2 ~ 9 단 까지 출력
		for(dan = 3; dan <= 9; dan++) {
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %d%n", dan , i , ( dan * i ) );
			}
		}
		*/
		
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		
		System.out.println("1부터 100까지 합은 " + sum + " 입니다.");
		
		sum = 0;
		
		for (int i = 1; i <= 100; i += 2) {
			sum += i;
		}
		
		System.out.println("1부터 100까지 홀수의 합은 " + sum + " 입니다.");
		
		sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 || i % 5 == 0 || i % 6 == 0) {
				sum += i;
			}
		}
		
		System.out.println("1부터 100까지 3,5,6의 배수의 합은 " + sum + " 입니다.");
		
		for (int i = 1; i <= 5; i++) {
			//System.out.println("*".repeat(i));
			
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
