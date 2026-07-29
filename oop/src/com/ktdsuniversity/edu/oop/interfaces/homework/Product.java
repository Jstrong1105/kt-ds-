package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * 제품 인터페이스
 */
public interface Product {
	
	/** 종류 조회 (일반, 신선, 냉동, 주류) */
	String getCategory();
	
	/** 이름 조회 */
	String getName();
	
	/** 가격 조회 */
	int getPrice();
	
	/** 유통기한 조회 */
	String getExpirationDate();
	
	/** 저장 온도 조회 */
	double getSaveTemp();
	
	/** 구매가능 나이 조회 */
	int getBuyAge();
	
	/** 알코올 함량 조회 */
	double getHasAlcohol();
}
