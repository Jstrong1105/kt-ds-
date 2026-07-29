package com.ktdsuniversity.edu.oop.inheritence.car;

/**
 * 전기차
 */
public class Ev extends Vehicle {
	
	private double battery;
	
	public Ev(String name, double battery) {
		super(name);
		this.battery = battery;
		System.out.println("Ev " + name + " 생성");
	}
	
	public void checkBattery() {
		System.out.println("현재 배터리: " + battery);
	}
}
