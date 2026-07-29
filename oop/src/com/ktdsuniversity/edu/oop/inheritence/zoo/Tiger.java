package com.ktdsuniversity.edu.oop.inheritence.zoo;

/**
 * 호랑이
 */
public class Tiger extends Animal {
	
	public Tiger(String name, int age, String sex, float weight, String type, String birthDate) {
		super(name, age, sex, weight, type, birthDate);
	}
	
	public void hunt() {
		System.out.println(super.getName() + "이(가) 사냥합니다.");
	}

	public void howl() {
		System.out.println(super.getName() + "이(가) 울부짖습니다.");
	}
}
