package com.ktdsuniversity.edu.oop.exam.string;

public class ConcatTest {
	
	public static void changeStr(StringBuffer str) {
		str.append("바뀌었을까요?");
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		StringBuffer message = new StringBuffer();
		message.append("원본입니다.");
		System.out.println(message);
		changeStr(message);
		System.out.println(message);
	}
}
