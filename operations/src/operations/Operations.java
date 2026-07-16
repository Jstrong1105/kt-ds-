package operations;

public class Operations {
	
	public static void main(String[] args) {
		
		int num = 10;
		System.out.println(num++);
		System.out.println(++num);
		// 10
		// 12
		
		System.out.println(num--);
		System.out.println(--num);
		// 12
		// 10
		
		int num3 = 3;
		int num4 = 5;
		int operResult = num++ + num3 * num4;
		
		System.out.println(operResult);
		// 25
		
		// 나누기와 나머지를 구한다.
		int num1 = 10;
		int num2 = 3;
		
		int mod = num1 % num2;
		System.out.println(mod);
		// 1
		
		int bigNumber = 10_0000_0000;
		int powerResult = bigNumber * bigNumber;
		System.out.println(powerResult);
		// -1486618624
		
		int maxIntValue = Integer.MAX_VALUE;
		int minIntValue = Integer.MIN_VALUE;
		
		System.out.println(maxIntValue);
		System.out.println(minIntValue);
		//  2147483647
		// -2147483648

		maxIntValue++;
		System.out.println(maxIntValue);
		// -2147483648
		
		minIntValue--;
		System.out.println(minIntValue);
		// 2147483647
		
		
		
		// 정수 변수 두개 만들어서 다른 정수 변수에 연산의 결과를 저장한 후 출력한다.
		int firstNumber = 10;
		int secondNumber = 20;
		
		int result;
		
		result = firstNumber + secondNumber;
		System.out.println(result);
		// 30
		
		result = firstNumber - secondNumber;
		System.out.println(result);
		// -10
		
		result = firstNumber * secondNumber;
		System.out.println(result);
		// 200
		
		result = firstNumber / secondNumber;
		System.out.println(result);
		// 0
		
		result = firstNumber % secondNumber;
		System.out.println(result);
		// 10
		
		float firstFloat = 10.5f;
		float secondFloat = 5.0f;
		
		float floatResult;
		
		floatResult = firstFloat / secondFloat;
		System.out.println(floatResult);
		// 2.1
		
		int kor = 90;
		int math = 80;
		int sci = 93;
		
		// float avg =(kor+math+sci) / 3;
		float avg = (kor+math+sci) / 3f;
		
		System.out.println(avg);
		// 87.0
		// 87.666664
		
		// Screaning Snake Case
		final float SUBJECT_COUNT = 3f;
		// subjectCount = 10f;
		
		avg = (kor+math+sci) / SUBJECT_COUNT;
	}
}
