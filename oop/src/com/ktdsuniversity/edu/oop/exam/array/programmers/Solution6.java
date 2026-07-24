package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 아무 원소도 들어있지 않은 빈 배열 X 가 있습니다. 
 * 양의 정수 배열 arr 가 매개변수로 주어질 때 
 * arr 의 앞에서부터 차례대로 원소를 보면서 원소가 a 라면 X 의 맨 뒤에 a 를 a 번 추가하는 일을
 * 반복한 뒤의 배열 X 를 return 하는 메소드
 * 
 *  제한 사항
 *  1 <= arr 의 길이 <= 100
 *  1 <= arr 의 원소 <= 100 
 */
public class Solution6 {
	
	private static int[] getX(int[] arr) {
		
		int length = 0;
		
		for(int i : arr) {
			length += i;
		}
		
		int[] result = new int[length];
		
		int index = 0;
		
		for(int i : arr) {
			for(int j = 0; j < i; j++) {
				result[index++] = i;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] result = getX(new int[] {5, 1, 4});
		for(int i : result) {
			System.out.println(i);
		}
		// 5
		// 5
		// 5
		// 5
		// 5
		// 1
		// 4
		// 4
		// 4
		// 4
	}
}
