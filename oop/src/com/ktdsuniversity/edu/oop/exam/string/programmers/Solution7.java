package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 알파벳으로 이루어진 문자열 myString 이 주어집니다.
 * 모든 알파벳을 소문자로 변환하여 return 하는 함수
 * 
 * 제한 사항
 * 1 <= myString 의 길이 <= 100000
 * myString 은 알파벳으로 이루어진 문자열
 */
public class Solution7 {
	
	private static String toLower(String myString) {
		return myString.toLowerCase();
	}
	
	public static void main(String[] args) {
		System.out.println(toLower("aBcDeFg"));
		// abcdefg
		System.out.println(toLower("aaa"));
		// aaa
	}
}
