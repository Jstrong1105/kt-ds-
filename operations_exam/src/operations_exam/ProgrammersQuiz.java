package operations_exam;

public class ProgrammersQuiz {

	public static void main(String[] args) {
		
		// Q https://school.programmers.co.kr/learn/courses/30/lessons/120804
		/*
		 * 정수 num1, num2가 매개변수 주어집니다. 
		 * num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성해주세요.
		*/
		int num1 = 1;
		int num2 = 5;
		int result1 = num1 * num2;
		System.out.println(result1);
		// 5
		
		// Q https://school.programmers.co.kr/learn/courses/30/lessons/120820
		/*
		 * 머쓱이는 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 
		 * 2022년 기준 선생님의 나이 age가 주어질 때, 
		 * 선생님의 출생 연도를 return 하는 solution 함수를 완성해주세요
		 * */
		int age = 26;
		int birthYear = 2022 - age + 1;
		System.out.println(birthYear);
		// 1997
		
		// Q https://school.programmers.co.kr/learn/courses/30/lessons/120803
		/*
		 * 정수 num1과 num2가 주어질 때, 
		 * num1에서 num2를 뺀 값을 return하도록 soltuion 함수를 완성해주세요.
		 * */
		int num3 = 7;
		int num4 = 10;
		int result2 = num3 - num4;
		System.out.println(result2);
		// -3
		
		// Q https://school.programmers.co.kr/learn/courses/30/lessons/120810
		/*
		 * 정수 num1, num2가 매개변수로 주어질 때, 
		 * num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
		 * */
		int num5 = 15;
		int num6 = 4;
		int result3 = num5 % num6;
		System.out.println(result3);
		// 3
		
		// Q https://school.programmers.co.kr/learn/courses/30/lessons/120805
		/*
		 * 정수 num1, num2가 매개변수로 주어질 때, 
		 * num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
		 * */
		int num7 = 9;
		int num8 = 4;
		int result4 = num7 / num8;
		System.out.println(result4);
		// 2
	}
}
