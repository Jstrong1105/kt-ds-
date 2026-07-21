package com.ktdsuniversity.edu.oop.vendingmachine;

/**
 * 자판기에서 판매하는 상품의 정보
 */
public class Item {
	
	/**
	 * 상품 번호
	 */
	String itemId;
	
	/**
	 * 상품명
	 */
	String itemName;
	
	/**
	 * 상품 가격
	 */
	int itemPrice;
	
	/**
	 * 상품 재고
	 */
	int itemStock;
	
	// 생성자
	public Item(String itemId, String itemName, int itemPrice, int itemStock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
	}
}
