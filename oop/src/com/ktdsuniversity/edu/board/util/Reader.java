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
	
	private Reader() {
		
	}
	
	public static String readString(String prompt) {
		System.out.print(prompt);
		return READER.nextLine();
	}
	
	public static int readInt(String prompt) {
		while(true) {
			try {
				return Integer.parseInt(readString(prompt));
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
	public static void close() {
		READER.close();
	}
}
