package com.ktdsuniversity.edu.homework;

/**
 * 상품 판매자
 */
public class Seller {
	
	/**
	 * 매출액
	 */
	int money;
	
	/**
	 * 판매 가격
	 */
	int price;
	
	/**
	 * 상품 재고
	 */
	int stock;
	
	Seller(int money, int price, int stock){
		this.money = money;
		this.price = price;
		this.stock = stock;
	}
	
	public void sell(int count) {
		if(count > stock) {
			count = stock;
		}
		
		stock -= count;
		money += (count * price);
	}
}
