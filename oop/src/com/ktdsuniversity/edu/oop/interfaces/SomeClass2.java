package com.ktdsuniversity.edu.oop.interfaces;

public class SomeClass2 implements SomeInterface {

	@Override
	public void doSomething1() {
		System.out.println("1 실행");
	}

	@Override
	public void doSomething2() {
		System.out.println("2 실행");
	}

	@Override
	public void doSomething3() {
		System.out.println("3 실행");
	}

	@Override
	public int getSomething() {
		return 653589793;
	}

	@Override
	public String getString() {
		return "3.141592653589793";
	}
}
