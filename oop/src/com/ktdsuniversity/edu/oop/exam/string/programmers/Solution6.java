package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 한 자리 정수로 이루어진 문자열 num_str 이 주어질 때 
 * 각 자리 수의 합을 return 하는 함수 
 * 
 * 제한 사항
 * 3 <= num_str <= 100
 */
public class Solution6 {
	
	private static int sum(String num_str) {
		
		int result = 0;
			
		for(int i = 0; i < num_str.length(); i++) {
			result += Integer.parseInt(num_str.substring(i, (i+1) ));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(sum("123456789"));
		// 45
		System.out.println(sum("10000000000"));
		// 1
	}
}
