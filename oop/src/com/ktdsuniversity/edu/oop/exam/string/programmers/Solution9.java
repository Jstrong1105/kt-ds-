package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 문자열 배열 strArr 이 주어집니다. 
 * 모든 원소가 알파벳으로만 이루어져 있을 때 
 * 배열에서 홀수번째 인덱스의 문자열은 대문자로
 * 배열에서 짝수번째 인덱스의 문자열은 소문자로 
 * 바꿔서 반환하는 메소드
 * 
 * 제한 사항
 * 1 <= strArr <= 20
 * strArr 의 원소는 알파벳으로 이루어진 문자열
 */
public class Solution9 {

	private static String[] getArr(String[] strArr) {
		
		String[] result = new String[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) {
			if (i % 2 == 0) {
				result[i] = strArr[i].toLowerCase();
			} else {
				result[i] = strArr[i].toUpperCase();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String [] arr = getArr(new String[] {"AAA","BBB","CCC","DDD"});
		for(String s : arr) {
			System.out.println(s);
		}
		// aaa
		// BBB
		// ccc
		// DDD
		
		arr = getArr(new String[] {"aBc","AbC"});
		for(String s : arr) {
			System.out.println(s);
		}
		// abc
		// ABC
	}
}
