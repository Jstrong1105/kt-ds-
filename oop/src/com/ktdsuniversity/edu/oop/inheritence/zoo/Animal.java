package com.ktdsuniversity.edu.oop.inheritence.zoo;

/**
 * 모든 동물이 가지고 있는 공통 속성
 */
public class Animal {
	
	private String name;
	private int age;
	private String sex;
	private float weight;
	private String type;
	private String birthDate;
	
	public Animal(String name, int age, String sex, float weight, String type, String birthDate) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.type = type;
		this.birthDate = birthDate;
	}
	
	public void move() {
		System.out.println(this.name + "이(가) 움직입니다.");
	}
	
	public void eat() {
		System.out.println(this.name + "이(가) 먹습니다.");
	}
	
	public void sleep() {
		System.out.println(this.name + "이(가) 잡니다.");
	}
	
	public void play() {
		System.out.println(this.name + "이(가) 놉니다.");
	}
	
	public void printStat() {
		System.out.println("이름: " + this.name);
		System.out.println("나이: " + this.age);
		System.out.println("성별: " + this.sex);
		System.out.println("체중: " + this.weight);
		System.out.println("종: " + this.type);
		System.out.println("생일: " + this.birthDate);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getBirthDate() {
		return this.birthDate;
	}
}
