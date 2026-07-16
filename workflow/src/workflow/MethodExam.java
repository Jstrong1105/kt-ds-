package workflow;

public class MethodExam {
	
	public static void main(String[] args) {
		// 단순하게 출력하는 메소드(함수)를 생성하고 호출해본다.
		print();
		
		// 파라미터(인자)가 있는 메소드(함수)를 생성하고 호출해본다.
		powerAndPrint(31);
		
		// 파라미터(인자)가 여러 개 있는 메소드(함수)를 생성하고 호출해본다.
		printNameAndAge("아무개", 83);
		
		// 반환값(결과)이 있는 메소드(함수)를 생성하고 호출한 뒤 결과를 출력해본다.
		System.out.println(devideTwoNumbers(10, 3));
	}
	
	public static void print() {
		System.out.println("Hello World");
		System.out.println(3 + 2);
	}
	
	public static void powerAndPrint(int number) {
		int result = number * number;
		System.out.println(number + " 의 제곱은 " + result + " 입니다.");
	}
	
	public static void printNameAndAge(String name, int age) {
		System.out.println("이름 : " + name + ", 나이 : " + age);
	}
	
	public static double devideTwoNumbers(int num1, int num2) {
		return ( ( 1.0 * num1 ) / num2 );
	}
}
