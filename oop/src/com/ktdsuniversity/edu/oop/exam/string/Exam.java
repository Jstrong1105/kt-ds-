package com.ktdsuniversity.edu.oop.exam.string;

public class Exam {
	
	public static void main(String[] args) {
		
		// address 에 "서울" 이 포함되어 있는 지 확인
		String address = "서울특별시 서초구 효령로 176";
		boolean result = address.contains("서울");
		System.out.println(result);
		// true
		
		// address 가 "176" 으로 끝나는 지 확인
		result = address.endsWith("176");
		System.out.println(result);
		// true
		
		// name 이 "ktdsuniversity" 와 일치하는 지 확인
		String name = "ktdsuniversity";
		result = name.equals("ktdsuniversity");
		System.out.println(result);
		// true
		
		// name 이 "KtDsUniversity" 와 일치하는 지 확인 (대소문자 구분 X)
		result = name.equalsIgnoreCase("KtDsUniversity");
		System.out.println(result);
		// true
		
		// 문자 c의 인덱스 찾기
		String alphabets = "abcdefg";
		int index = alphabets.indexOf("c");
		System.out.println(index);
		// 2
		
		// 문자 C의 인덱스 찾기
		index = alphabets.indexOf("C");
		System.out.println(index);
		// -1
		
		// 문자 def 의 인덱스 찾기
		index = alphabets.indexOf("def");
		System.out.println(index);
		// 3
		
		// str 이 비어있거나 공백으로만 이루어져 있는지 확인
		String str = "  ";
		result = str.isBlank();
		System.out.println(result);
		// true
		
		// str 이 공백으로 비워져 있는지 확인
		result = str.isEmpty();
		System.out.println(result);
		// false
		
		// message 와 name 을 , 으로 연결하기
		String message = "안녕하세요";
		name = "홍길동님";
		
		String helloMessage = String.join(", ", message, name);
		System.out.println(helloMessage);
		// 안녕하세요, 홍길동님
		
		
		// message 에서 "a" 의 마지막 인덱스 찾기
		message = "abcdefgaijkb";
		index = message.lastIndexOf("a");
		System.out.println(index);
		// 7
		
		// message 에서 "jj" 의 마지막 인덱스 찾기
		index = message.lastIndexOf("jj");
		System.out.println(index);
		// -1 
		
		// message 의 문자열 길이 구하기
		index = message.length();
		System.out.println(index);
		// 12
		
		// phone 이 숫자인지 확인하기
		String phone = "01012341234";
		result = phone.matches("^[0-9]+$");
		System.out.println(result);
		// true
		
		// message 에서 홍길동을 ktds 로 변경하기
		message = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
		message = message.replace("홍길동", "ktds");
		System.out.println(message);
		// 안녕하세요, ktds님, 안녕히 가세요, ktds님.
		
		// phone 에서 숫자가 아닌 문자를 공백문자("")로 변경하기
		phone = "010-1234-1234";
		phone = phone.replaceAll("[^0-9]", "");
		System.out.println(phone);
		// 01012341234
		
		// phone 을 "-"로 잘라 배열에 할당하기
		phone = "010-1234-1234";
		
		String[] tel = phone.split("-");
		for(String n : tel) {
			System.out.println(n);
		}
		// 010
		// 1234
		// 1234
		
		// phone 이 +82 로 시작하는지 확인하기
		phone = "+82-010-1234-1234";
		result = phone.startsWith("+82");
		System.out.println(result);
		// true
		
		// datetime 에서 2023(연) 글자만 잘라내어 할당하기
		String datetime = "2023-05-02 14:56:13";
		String year = datetime.substring(0,4);
		System.out.println(year);
		// 2023
		
		// datetime 에서 14(시) 글자만 잘라내어 할당하기
		String hour = datetime.substring(11,13);
		System.out.println(hour);
		// 14
		
		// datetime 에서 14:56:13 (시:분:초) 글자만 잘라내어 할당하기
		String time = datetime.substring(11);
		System.out.println(time);
		// 14:56:13
		
		// datetime 에서 앞뒤 공백 모두 제거하기
		datetime = "  2023-05-02 14:56:13   ";
		datetime = datetime.trim();
		System.out.println(datetime);
		// 2023-05-02 14:56:13
		
		// int 타입 1을 문자열로 변경하기
		int num = 1;
		String s = String.valueOf(num);
		System.out.println(s);
		// 1
		
		// format 바인딩
		String format = "%s에서 교육하는 %s과정";
		String a = String.format(format, "ktdsuniversity","java");
		System.out.println(a);
		// ktdsuniversity에서 교육하는 java과정
		
		// formatted 바인딩
		String b = format.formatted("ktdsuniversity","java");
		System.out.println(b);
		// ktdsuniversity에서 교육하는 java과정
		
		int bigNumber = Integer.MAX_VALUE;
		String c = ("%,d").formatted(bigNumber);
		System.out.println(c);
		// 2,147,483,647
	}
}

























