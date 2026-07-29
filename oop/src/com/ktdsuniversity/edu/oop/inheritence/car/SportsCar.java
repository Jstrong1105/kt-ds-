package com.ktdsuniversity.edu.oop.inheritence.car;

/**
 * 스포츠카
 */
public class SportsCar extends Vehicle {
	
	public SportsCar(String name) {
		super(name);
		System.out.println("SportsCar " + name + " 생성");
	}
	
	public void startTurboEngine() {
		System.out.println("터보 모드");
	}
}
