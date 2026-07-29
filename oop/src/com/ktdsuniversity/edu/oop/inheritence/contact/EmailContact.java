package com.ktdsuniversity.edu.oop.inheritence.contact;

public class EmailContact extends Contact {
	
	private String email;
	
	public EmailContact(String name, String phone, String email) {
		super(name,phone);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
