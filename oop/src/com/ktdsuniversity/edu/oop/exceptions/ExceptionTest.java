package com.ktdsuniversity.edu.oop.exceptions;

public class ExceptionTest {
	
	public static void main(String[] args) {
		
		String name = null;
		// name이라는 인스턴스의 값이 null 이라면 "이름을 입력해주세요" 를 출력한다
		// name이라는 인스턴스의 값이 null 이 아니라면 값을 출력한다.
		if( name == null ) {
			System.out.println("이름을 입력해주세요.");
		} else {
			System.out.println(name);
		}
		
		String job = "";
		// job이라는 인스턴스의 값이 "" 이라면 "직업을 입력해주세요" 를 출력한다.
		// job이라는 인스턴스의 값이 "" 이 아니라면 값을 출력한다.
		if (job == null || job.equals("")) {
			System.out.println("직업을 입력해주세요.");
		} else {
			System.out.println(job);
		}
		
		String address = "   ";
		// address라는 인스턴스의 값이 공백으로만 이루어져 있다면 "주소를 입력해주세요"를 출력한다.
		// 아니라면 값을 출력한다.
		if ( address == null || address.isBlank()) {
			System.out.println("주소를 입력해주세요.");
		} else {
			System.out.println(address);
		}
	}
}
