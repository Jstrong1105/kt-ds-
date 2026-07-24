package com.ktdsuniversity.edu.oop.inheritence.zoo;

public class Penguin {
	
	private String name;
	private String sex;
	private int age;
	private float weight;
	private float tall;
	
	public void swim() {
		System.out.println(this.name + " 수영함");
	}
	
	public void walk() {
		System.out.println(this.name + " 걷는다.");
	}
	
	public void eat() {
		System.out.println(this.name + " 먹는다.");
		this.weight++;
	}
}
