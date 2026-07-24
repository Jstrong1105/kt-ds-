package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 정수 배열 arr 과 정수 n 이 매개변수로 주어집니다.
 * arr 의 길이가 홀수라면 arr 의 모든 짝수 인덱스 위치에 n 을 더한 배열을
 * arr 의 길이가 짝수라면 arr 의 모든 홀수 인덱스 위치에 n 을 더한 배열을
 * return 하는 함수
 * 
 * 제한 사항
 * 1 <= arr 의 길이 <= 1000
 * 1 <= arr 의 원소 <= 1000
 * 1 <= n <= 1000
 */
public class Solution4 {

	private static int[] getArr(int[] arr, int n) {
		
		boolean even = (arr.length % 2 == 0);
		
		for (int i = 0; i < arr.length; i++) {
			if( (i % 2 == 0) != even) {
				arr[i] += n;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] result = getArr(new int[] {49, 12, 100, 276, 33}, 27);
		for(int i : result) {
			System.out.println(i);
		}
		// 76
		// 12
		// 127
		// 276
		// 60
		result = getArr(new int[] {444, 555, 666, 777}, 100);
		for(int i : result) {
			System.out.println(i);
		}
		// 444
		// 655
		// 666
		// 877
	}
}
