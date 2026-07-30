package com.ktdsuniversity.edu.oop.generics;

/**
 * 주어진 데이터를 단순히 출력하는 기능
 */
public class Print<D> {
	
	private D printData;
	
	public Print(D printData) {
		this.printData = printData;
	}
	
	public void print() {
		System.out.println(this.printData);
	}
	
	public D getPrintData() {
		return this.printData;
	}
}
