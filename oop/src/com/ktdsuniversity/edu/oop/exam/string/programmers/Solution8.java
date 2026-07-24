package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 알파벳으로 이루어진 문자열 myString 과 pat 이 주어집니다.
 * myString 의 연속된 부분 문자열 중 pat 이 존재하면 1을
 * 그렇지 않으면 0 을 return 하는 함수
 * 
 * 제한 사항
 * 1 <= myString 의 길이 <= 100000
 * 1 <= pat 의 길이 <= 300
 * myString 과 pat 은 모두 알파벳으로 이루어진 문자열
 */
public class Solution8 {

	private static int isContainsIgnoreCase(String myString, String pat) {
		
		if (myString.length() < pat.length()) {
			return 0;
		}
		
		if (myString.toLowerCase().contains(pat.toLowerCase())) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isContainsIgnoreCase("AbCdEfG", "aBc"));
		// 1
		System.out.println(isContainsIgnoreCase("aaAA", "aaaaa"));
		// 0
	}
}
