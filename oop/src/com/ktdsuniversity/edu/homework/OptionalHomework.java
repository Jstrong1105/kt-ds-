package com.ktdsuniversity.edu.homework;

/**
 * 선택적 과제 
 */
public class OptionalHomework {
	
	public static void main(String[] args) {
		
		// 1. 정수형 배열 변수를 만들고 값을 할당해 보세요.
		//int[] q1 = new int[5];
		//q1[0] = 1;
		//q1 = new int[] {1,2,3};
		int[] q1 = {1,2,3,4,5,6,7,8,9,10};
		
		// 2. 정수형 배열 변수의 합을 계산해 출력해보세요.
		int q2 = 0;
		for (int i : q1) {
			q2 += i;
		}
		System.out.println(q2);
		
		// 3. 실수형 배열 변수를 만들고 랜덤한 값을 할당해보세요.
		double[] q3 = new double[5];
		for (int i = 0; i < q3.length; i++) {
			
			q3[i] = Math.random() * 10;
		}
		
		// 4. 실수형 배열 변수의 합을 계산해 출력해보세요.
		double q4 = 0.0;
		for (double i : q3) {
			q4 += i;
		}
		System.out.println(q4);
		
		// 5. 실수형 배열 변수 내의 가장 큰 값을 출력해보세요.
		double q5 = Double.MIN_VALUE;
		for (double i : q3) {
			if (q5 < i) {
				q5 = i;
			}
		}
		System.out.println(q5);
		
		// 6. 실수형 배열 변수 내의 가장 작은 값을 출력해보세요.
		double q6 = Double.MAX_VALUE;
		for (double i : q3) {
			if (q5 > i) {
				q6 = i;
			}
		}
		System.out.println(q6);
		
		// 7. 문자열형 배열 변수를 만들어 값을 할당해 보세요.
		String[] q7 = {"Hello", "World", "Java", "Oracle", "Eclipse"};
		
		// 8. 문자열형 배열 변수 내의 값 중 길이가 가장 긴 문자열을 출력해보세요.
		String q8 = "";
		for (String s : q7) {
			if (q8.length() < s.length()) {
				q8 = s;
			}
		}
		System.out.println(q8);
		
		// 9. 정수형 배열 변수를 만들고 랜덤한 값을 할당해보세요.
		int[] q9 = new int[10];
		for (int i = 0; i < q9.length; i++) {
			q9[i] = (int) Math.random() * 10;
		}
		
		// 10. 정수형 배열 변수 내의 값 중 평균 이상의 값들만 출력해보세요.
		double q10 = 0.0;
		for (int i : q9) {
			q10 += i;
		}
		q10 /= q9.length;
		for (int i : q9) {
			if (i >= q10) {
				System.out.println(i);
			}
		}
		
		// 11. 상품을 표현하는 클래스를 만들어보세요.
		class Product{
			private String name;
			private int price;
			
			Product(String name, int price){
				this.name = name;
				this.price = price;
			}
		}
		
		// 12. 상품을 표현하는 클래스의 배열 변수를 만들어 보세요.
		Product[] q12 = new Product[3];
		q12[0] = new Product("Geforce RTX 5090",7854000);
		q12[1] = new Product("사과",2000);
		q12[2] = new Product("사탕",200);
		
		// 13. 상품을 표현하는 클래스의 배열 변수에서 가장 비싼 상품의 이름을 출력해보세요.
		int index = 0;
		for (int i = 1; i < q12.length; i++) {
			if (q12[index].price < q12[i].price ) {
				index = i;
			}
		}
		System.out.println(q12[index].name);
		
		// 14. 상품을 표현하는 클래스의 배열 변수내의 모든 상품의 이름을 출력해보세요.
		for (Product product : q12) {
			System.out.println(product.name);
		}
		
		// 15. 숫자 형태의 문자열 배열 변수를 만들어보세요.
		String[] q15 = {"1","2","3","4","5","6","7","8","9","10"};
		
		// 16. 숫자 형태의 문자열 배열 변수의 값을 정수로 변환한 뒤 정수의 합과 평균을 출력
		int sum15 = 0;
		double avg15 = 0d;
		for (String s: q15) {
			sum15 += Integer.parseInt(s);
		}
		avg15 = (double)sum15 / q15.length;
		System.out.println(sum15);
		System.out.println(avg15);
		
		// 17. 불린 형태의 배열 변수를 만들고 값을 랜덤하게 할당해보세요.
		boolean[] q17 = new boolean[5];
		for (int i = 0; i < q17.length; i++) {
			q17[i] = (Math.random() > 0.5);
		}
		
		// 18. 불린 형태의 배열 변수 내에서 true의 개수는 몇 개 인지 세어 출력해보세요.
		int q18 = 0;
		for (boolean b : q17) {
			if(b) {
				q18++;
			}
		}
		System.out.println(q18);
		
		// 19. 불린 형태의 배열 변수 내에서 false 가 존재하는 비율은 몇 %인지 계산해 출력해보세요.
		int q19 = 0;
		for (boolean b : q17) {
			if(!b) {
				q19++;
			}
		}
		
		double percent = (double)q19 / q17.length;
		System.out.println(percent);
		
		// 20. 문자열 형태의 배열 변수를 만들고 값을 랜덤하게 할당해보세요.
		String[] q20 = new String[10];
		for (int i = 0; i < q20.length; i++) {
			int length = (int) (Math.random() * 30);
			q20[i] = getRandomString(length);
			System.out.println(q20[i]);
		}
		
		// 21. 문자열 형태의 배열 변수 내의 모든 문자열의 길이를 합한 값을 계산해 출력해보세요.
		int q21 = 0;
		for (String s : q20) {
			q21 += s.length();
		}
		System.out.println(q21);
	}
	
	public static String getRandomString(int length) {
		
		char[] texts = "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ0123456789".toCharArray();
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < length; i++) {
			char c = texts[ ( (int) (Math.random() * texts.length) ) ]; 
			sb.append(c);
		}
		return sb.toString();
	}
}