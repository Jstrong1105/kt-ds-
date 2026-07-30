package com.ktdsuniversity.edu.oop.generics;

public class User<I, N> {
	
	private I id;
	private N name;
	
	public User(I id, N name) {
		this.id = id;
		this.name = name;
	}
	
	public I getId() {
		return this.id;
	}
	
	public N getName() {
		return this.name;
	}
}
