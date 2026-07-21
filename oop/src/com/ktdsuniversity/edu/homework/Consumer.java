package com.ktdsuniversity.edu.homework;

/**
 * 상품 구매자
 */
public class Consumer {
	
	/**
	 * 소지한 현금
	 */
	int money;
	
	/**
	 * 소지한 장바구니
	 */
	 int bag;
	 
	 Consumer(int money, int bag){
		 this.money = money;
		 this.bag = bag;
	 }
	 
	 public void buy(int count, int price) {
		 if (money >= price) {
			 bag += count;
			 money -= price;
		 }
	 }
}
