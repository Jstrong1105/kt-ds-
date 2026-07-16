package operations_exam;

/*
 * 섭씨온도를 나타내는 celsius 변수와
 * 화씨온도를 나타내는 fahrenhet 변수가 있습니다.
 * celisius 변수에는 30 이 할당되어 있습니다.
 * 섭씨 30도를 화씨 온도로 변경하면
 * 화씨 86도가 됩니다.
 * 섭씨온도를 화씨온도로 변경해
 * fahrenheit 변수에 할당하고 출력해보세요
 * 변경공식 : (섭씨 x 9/5) + 32 = 화씨
 */
public class ArithmaticProblem3 {

	public static void main(String[] args) {
		
		int celsius = 30;
		double fahrenheit = getFahrenheit(celsius);
		
		System.out.println(fahrenheit);
		// 86.0
	}
	
	private static double getFahrenheit(int celsius) {
		return (celsius * 9.0) / 5.0 + 32;
	}
}
