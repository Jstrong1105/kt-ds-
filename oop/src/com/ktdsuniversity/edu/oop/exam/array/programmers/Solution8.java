package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string 이 매개변수로 주어질 때
 * my_string 에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return 하는 메소드
 * 
 * 제한 사항
 * my_string 은 영소문자와 공백으로만 이루어져 있습니다.
 * 1 <= my_string 의 길이 <= 1000
 * my_string 의 맨 앞과 맨 뒤에도 공백이 있을 수 있습니다.
 * my_string 에는 단어가 하나 이상 존재합니다.
 */
public class Solution8 {

	private static String[] split(String my_string) {
		
		String emp = my_string.trim();
		
		while(true) {
			if(emp.contains("  ")) {
				emp = emp.replace("  "," ");
			} else {
				break;
			}
		}
		
		return emp.split(" ");
	}
	
	public static void main(String[] args) {
		String [] arr = split("   i      love      you");
		for(String s : arr) {
			System.out.println(s);
		}
		// i
		// love
		// you
		
		arr = split("   programmers");
		for(String s : arr) {
			System.out.println(s);
		}
		// programmers
		 
	}
}
