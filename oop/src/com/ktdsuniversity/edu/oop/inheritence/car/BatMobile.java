package com.ktdsuniversity.edu.oop.inheritence.car;

/**
 * 배트 모빌
 */
public class BatMobile extends SportsCar {
	
	public BatMobile(String name) {
		super(name);
		System.out.println("BatMobile " + name + " 생성");
	}
	
	public void outBatPort() {
		System.out.println("배트포트 분리");
	}
}
