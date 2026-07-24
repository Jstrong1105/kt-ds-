package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 문자열 myString 이 주어집니다.
 * myString 을 문자 "x" 를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를
 * 순서대로 저장한 배열을 return 하는 메소드
 * 
 * 제한 사항
 * 1 <= myString 의 길이 <= 100000
 * myString 은 알파벳 소문자로 이루어진 문자열입니다.
 */
public class Solution7 {
	
	private static int[] get(String myString) {
		
		String[] arr = myString.split("x");
		
		int length = arr.length;
		
		if(myString.endsWith("x")) {
			length++;
		}
		
		int[] result = new int[length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i].length();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] result = get("oxooxoxxox");
		for(int i : result) {
			System.out.println(i);
		}
		// 1
		// 2
		// 1
		// 0
		// 1
		// 0 
		
		result = get("xabcxdefxghi");
		for(int i : result) {
			System.out.println(i);
		}
		// 0
		// 3
		// 3
		// 3
	}
}
