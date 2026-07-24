package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 정수로 이루어진 문자열 n_str 이 주어질 때 
 * n_str 에 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return 하는 함수
 * 
 * 제한 사항
 * 2 <= n_str <= 10
 * n_str 이 "0" 으로만 이루어진 경우는 없다
 */
public class Solution5 {
	
	private static String deleteZero(String n_str) {
		return Integer.parseInt(n_str) + "" ;
	}
	
	public static void main(String[] args) {
		System.out.println(deleteZero("0010"));
		// 10
		System.out.println(deleteZero("854020"));
		// 854020
	}
}
