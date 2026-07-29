package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * 손님 클래스
 */
public class ConsumerClass implements Consumer {

	private String type;
	private String name;
	private int money;
	private Product[] products;
	private int age;
	
	public ConsumerClass(String type, String name, int money, int age) {
		this.type = type;
		this.name = name;
		this.money = money;
		this.age = age;
		this.products = new Product[4];
	}
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public void addProducts(Product product) {
		
		for(int i = 0; i < products.length; i++) {
			if(this.products[i] == null) {
				this.products[i] = product;
				return;
			}
		}
		
		System.out.println("더 이상 구매할 수 없습니다.");
	}

	@Override
	public Product[] getProducts() {
		return this.products;
	}

	@Override
	public int getAge() {
		return this.age;
	}
}
