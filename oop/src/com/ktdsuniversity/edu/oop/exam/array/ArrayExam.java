package com.ktdsuniversity.edu.oop.exam.array;

public class ArrayExam {
	
	public static void main(String[] args) {
		
		// 배열을 정의하고 생성하는 3가지 방법
		// 1. 자료형[] 배열이름 = new 자료형[배열길이];
		int[] num1 = new int[3];
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		
		// 2. 자료형[] 배열이름 = new 자료형[] {각 인덱스에 들어갈 값들};
		// 						0	1	2	3	4	5	6	7
		int[] num2 = new int[] {50, 30, 60, 10, 20, 55, 7, 88};
		
		// 3. 자료형[] 배열이름 = {각 인덱스에 들어갈 값들};
		//				0    1    2    3    4   5   6
		int[] num3 = {100, 200, 300, 500, 200, 10, 20};
	}
}
