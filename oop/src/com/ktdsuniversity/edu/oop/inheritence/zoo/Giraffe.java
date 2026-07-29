package com.ktdsuniversity.edu.oop.inheritence.zoo;

/**
 * 기린 
 */
public class Giraffe extends Animal {
	
	public Giraffe(String name, int age, String sex, float weight, String type, String birthDate) {
		super(name, age, sex, weight, type, birthDate);
	}
	
	public void kick() {
		System.out.println(super.getName() + "이(가) 발차기를 합니다.");
	}
	
	public void run() {
		System.out.println(super.getName() + "이(가) 뜁니다.");
	}
}
