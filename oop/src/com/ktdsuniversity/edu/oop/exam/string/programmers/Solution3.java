package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 정수 n 이 주어질 때 
 * n 을 문자열로 변환하여 return 하도록 함수를 작성해주세요
 * 
 * 제한 사항
 * 1 <= n <= 10000
 */
public class Solution3 {
	
	private static String changeString(int n) {
		return n + "";
	}
	
	public static void main(String[] args) {
		System.out.println(changeString(123));
		// 123
		System.out.println(changeString(2573));
		// 2573
	}
}
