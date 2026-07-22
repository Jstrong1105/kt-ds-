package com.ktdsuniversity.edu.mart;

public class Seller {
	
	// 멤버 변수: 단일상품의 재고, 단일상품의 단가, 총 매출액, 총 판매개수
	/** 재고 */
	int stock;
	
	/** 단가 */
	int unitPrice;
	
	/** 총 매출액 */
	int amount;
	
	/** 총 판매개수 */
	int salesCount;
	
	/**
	 * 판매자 인스턴스 생성
	 * @param stock      상품 재고
	 * @param unitPrice  상품 단가
	 * @param amount     총 매출액
	 * @param salesCount 총 판매 개수
	 */
	public Seller(int stock, int unitPrice, int amount, int salesCount) {
		this.stock = stock;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.salesCount = salesCount;
	}
	
	// 기능: 판매
	/**
	 * 판매
	 * @param orderQuantity 판매 개수
	 */
	public void sell(int orderQuantity) {
		if(this.stock > 0) {
			this.amount += this.unitPrice * orderQuantity;
			this.stock -= orderQuantity;
			this.salesCount += orderQuantity;
		}
	}
	
	/**
	 * 판매자의 정보를 출력
	 */
	public void printStatus() {
		System.out.println("판매자의 정보");
		System.out.println("현재 재고: " + this.stock);
		System.out.println("판매 단가: " + this.unitPrice);
		System.out.println("총 매출액: " + this.amount);
		System.out.println("총 판매개수: " + this.salesCount);
	}
}
