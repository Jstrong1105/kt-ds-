package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 숫자로만 이루어진 문자열 n_str 이 주어질 때
 * n_str 을 정수로 변환하여 return 하는 함수를 완성
 * 
 * 제한 사항
 * 1 <= n_str <= 5
 * n_str 은 0 ~9의 숫자로만 이루어짐
 */
public class Solution4 {

	private static int toNumber(String n_str) {
		return Integer.parseInt(n_str);
	}
	
	public static void main(String[] args) {
		System.out.println(toNumber("10"));
		// 10
		System.out.println(toNumber("8542"));
		// 8542
	}
}
