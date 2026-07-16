package workflow;

public class IfCondition {
	
	public static void main(String[] args) {
		
		int num1 = 30;
		int num2 = 23;
		
		// num1 과 num2 중에 큰 수를 출력해라
		
		// System.out.println(num1 > num2 ? num1 : num2);
		// 30
		
		num1 = 20;
		
		// num1 이 num2 보다 크다면 num1을 출력한다.
		if(num1 > num2) {
			System.out.println(num1);
		}
		// num1 이 num2 보다 작다면 num2를 출력한다.
		else if(num1 < num2){
			System.out.println(num2);
		}
		else {
			System.out.println("같음");
		}
		// 23
	}
}
