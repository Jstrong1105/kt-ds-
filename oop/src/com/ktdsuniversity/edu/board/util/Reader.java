package com.ktdsuniversity.edu.board.util;

import java.util.Scanner;

/**
 * 입력 받기 
 */
public final class Reader {
	
	private static final Scanner READER;
	
	static {
		READER = new Scanner(System.in);
	}
	
	// 외부 인스턴스 생성을 방지하는 생성자 private
	private Reader() {
		
	}
	
	/**
	 * 사용자에게 안내메시지를 출력하고 문자를 입력받는 메소드
	 * @param prompt 사용자에게 출력할 안내 메시지
	 * @return 사용자 입력 문자열
	 */
	public static String readString(String prompt) {
		System.out.print(prompt);
		return READER.nextLine();
	}
	
	/**
	 * 사용자에게 안내메시지를 출력하고 숫자를 입력받는 메소드
	 * 숫자가 아닌 값을 입력하면 다시 입력받는다.
	 * @param prompt
	 * @return
	 */
	public static int readInt(String prompt) {
		while(true) {
			try {
				return Integer.parseInt(readString(prompt));
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
	/**
	 * 스캐너 닫기
	 */
	public static void close() {
		READER.close();
	}
}
