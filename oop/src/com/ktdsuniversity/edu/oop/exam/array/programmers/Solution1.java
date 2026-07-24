package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 문자들이 담겨있는 배열 arr 이 주어집니다. 
 * arr 의 원소들을 순서대로 이어 붙인 문자열을 return 하는 함수
 * 
 * 제한사항
 * 1 <= arr의 길이 <= 200
 * arr 의 원소는 전부 알파벳 소문자로 이루어진 길이가 0인  문자열
 */
public class Solution1 {
	
	private static String concat(String[] arr) {
		String result = "";
		
		for(String s : arr) {
			result += s;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(concat(new String[] {"a","b","c"}));
		// abc
	}
}
