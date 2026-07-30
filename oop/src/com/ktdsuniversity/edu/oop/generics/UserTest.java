package com.ktdsuniversity.edu.oop.generics;

public class UserTest {
	
	public static void main(String[] args) {
		User<Integer, String> user01 = new User<>(1,"정세찬");
		int id = user01.getId();
		String name = user01.getName();
		System.out.println(id + name);
		
		User<Integer, Long> user02 = new User<>(2,300000000L);
		id = user02.getId();
		long l = user02.getName();
		System.out.println(id + "" + l);
		
	}
}
