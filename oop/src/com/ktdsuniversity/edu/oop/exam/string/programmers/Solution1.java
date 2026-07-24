package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 어떤 문자열 A가 다른 문자열 B안에 속하면 A를 B의 부분 문자열이라고 합니다.
 * 예를 들어 "abc"는 문자열 "aabcc"의 부분 문자열입니다.
 * 
 * 문자열 str1과 str2가 주어질 때
 * str1이 str2의 부분 문자열이라면 1을
 * 부분 문자열이 아니라면 0을 return 하도록 하는 함수를 완성해주세요.
 * 
 * 제한 사항 1 <= str1 <= str2 <= 20
 * str1 과 str2 는 영어 소문자로만 이루어져 있습니다.
 */
public class Solution1 {
	
	public static int isContains(String str1, String str2) {
		if (str2.contains(str1)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isContains("abc", "aabcc"));
		// 1
		
		System.out.println(isContains("abc", "aabbcc"));
		// 0
	}
}
