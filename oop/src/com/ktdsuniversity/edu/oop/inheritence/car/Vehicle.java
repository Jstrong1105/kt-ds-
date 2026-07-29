package com.ktdsuniversity.edu.oop.inheritence.car;

/**
 * 자동차
 */
public class Vehicle {
	
	private String name;
	
	public Vehicle(String name) {
		this.name = name;
		System.out.println("Vehilce " + name + " 생성");
	}
	
	public void startEngine() {
		System.out.println("시동 걸기");
	}
	
	public String getName() {
		return this.name;
	}
}
