package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * 고객 인터페이스
 */
public interface Consumer {
	
	/** 고객 종류 조회 */
	String getType();
	
	/** 이름 조회 */
	String getName();
	
	/** 보유 현금 조회 */
	int getMoney();
	
	void addProducts(Product product);
	
	/** 제품 조회 */
	Product[] getProducts();
	
	/** 나이 조회 */
	int getAge();
}
