package com.ktdsuniversity.edu.oop.exam.string;

import java.util.Scanner;

public class WordRelay {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		String before;
		String next;
		int count = 0;
		
		before = getRandomString();
		
		System.out.println("현재 단어의 마지막 문자로 시작하는 단어를 입력하세요. (3글자 이상)");
		
		while(true) {
			System.out.println("현재 단어: " + before);
			System.out.print("단어 입력: ");
			next = keyboard.nextLine().trim();
			
			if(pass(before,next)) {
				before = next;
				count++;
				
			} else {
				System.out.println("이어나간 횟수: " + count);
				break;
			}
		}
	}
	
	public static String getRandomString() {
		return "자전거";
	}
	
	public static boolean pass(String before, String next) {
		
		if (next.length() < 3) {
			return false;
		}
		
		// String endWord = before.substring(before.length()-1);
		// return next.startsWith(endWord);
		
		String startWord = next.substring(0,1);
		return before.endsWith(startWord);
	}
}
