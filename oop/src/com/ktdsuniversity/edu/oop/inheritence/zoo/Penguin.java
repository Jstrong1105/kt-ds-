package com.ktdsuniversity.edu.oop.inheritence.zoo;

/**
 * 펭귄
 */
public class Penguin extends Animal {
	
	public Penguin(String name, int age, String sex, float weight, String type, String birthDate) {
		super(name, age, sex, weight, type, birthDate);
	}
	
	public void swim() {
		System.out.println(super.getName() + "이(가) 수영합니다.");
	}
}
