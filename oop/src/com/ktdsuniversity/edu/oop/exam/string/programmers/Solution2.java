package com.ktdsuniversity.edu.oop.exam.string.programmers;

/**
 * 부분 문자열이란 문자열에서 연속된 일부분에 해당하는 문자열을 의미합니다.
 * 예를 들어 문자열 "ana", "ban", "anana", "banana", "n" 은 모두
 * "banana"의 부분 문자열이지만 
 * "aaa", "bnana", "wxyz" 는 
 * "banana"의 부분 문자열이 아닙니다.
 * 
 * 문자열 my_string 과 target 이 주어질 때, target 이 문자열 my_string의
 * 부분 문자열이라면 1을 아니라면 0을 return 하는 함수를 작성해주세요
 * 
 * 제한 사항
 * 1 <= my_string의 길이 <= 100
 * my_string 은 영문자로만 이루어져 있습니다.
 * 1 <= target의 길이 <= 100
 * target 은 영문자로만 이루어져 있습니다. 
 */
public class Solution2 {
	
	public static int isContains(String my_string, String target) {
		if (my_string.contains(target)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isContains("banana", "ana"));
		// 1
		System.out.println(isContains("banana", "wxyz"));
		// 0
	}
}
