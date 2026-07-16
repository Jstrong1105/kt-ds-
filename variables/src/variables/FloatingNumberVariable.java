package variables;

/**
 * 실수 변수 선언 예제 클래스
 */
public class FloatingNumberVariable {

	public static void main(String[] args) {
		
		// 실수 : float, double
		float floatNumber = 3.0F;
		float floatNumber1 = 3;
		float floatNumber2 = 3.44445544353453454354545F;
		double doubleNumber = 3.5456543543543543455345;
		
		System.out.println(floatNumber);     // 3.0
		System.out.println(floatNumber1);    // 3.0
		System.out.println(floatNumber2);    // 3.4444554
		System.out.println(doubleNumber);    // 3.545654354354354
	}
}
