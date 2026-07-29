package com.ktdsuniversity.edu.oop.inheritence.contact;

public class Contact {
	
	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		System.out.println("Contact 인스턴스 생성");
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void printContact() {
		System.out.println("name: " + this.name);
		System.out.println("phone: " + this.phone);
	}
}
