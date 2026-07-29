package com.ktdsuniversity.edu.oop.inheritence.contact;

public class Main {
	
	public static void main(String[] args) {
		Contact contact = new Contact("친구1","010-1234-5678");
		String name = contact.getName();
		String phone = contact.getPhone();
		System.out.println(name);
		System.out.println(phone);
		contact.printContact();
		
		EmailContact contact2 = new EmailContact("친구2","010-2345-6789","34343@23232.com");
		name = contact2.getName();
		phone = contact2.getPhone();
		System.out.println(name);
		System.out.println(phone);
		contact.printContact();
	}
}
