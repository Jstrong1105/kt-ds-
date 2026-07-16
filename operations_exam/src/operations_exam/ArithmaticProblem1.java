package operations_exam;

/*        
	산술연산자를 이용해
	minutes와 seconds의 값을 초로 변환해 
	time 변수에 할당하고 출력해보세요.
 */
public class ArithmaticProblem1 {
	
	public static void main(String[] args) {
		
		int minutes = 5;
		int seconds = 50;
		int time = minutes * 60 + seconds;
		System.out.println(time);
		// 350
	}
}
