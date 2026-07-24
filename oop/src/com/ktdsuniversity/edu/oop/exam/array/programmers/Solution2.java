package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 정수로 이루어진 리스트 num_list 가 주어집니다.
 * nun_list 에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return 하는 메소드
 * 
 * 제한사항
 * 6 <= num_list 의 길이 <= 30
 * 1 <= num_list 의 원소 <= 100
 */
public class Solution2 {

	/*
	 * ex 9 8 7 6 5 4 3 2 1 
	 * 정렬하면 1 2 3 4 5 6 7 8 9
	 * 반환하면 6 7 8 9
	 */
	private static int[] orderAsc(int [] num_list) {
		
		for(int i = 0; i < num_list.length - 1; i++) {
			
			int min = i;
			
			for(int j = (i + 1); j < num_list.length; j++) {
				if(num_list[min] > num_list[j]) {
					min = j;
				}
			}
			
			int emp = num_list[i];
			num_list[i] = num_list[min];
			num_list[min] = emp;
		}
		
		int [] result = new int[num_list.length - 5];
	
		for(int i = 0; i < result.length; i++) {
			result[i] = num_list[i+5];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] result = orderAsc(new int[] {12, 4, 15, 46, 38, 1, 14, 56, 32, 10});
		for(int i : result) {
			System.out.println(i);
		}
		// 15
		// 32
		// 38
		// 46
		// 56
	}
}
