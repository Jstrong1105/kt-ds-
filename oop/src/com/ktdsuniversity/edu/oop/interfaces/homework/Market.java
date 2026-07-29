package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * 마트 인터페이스
 */
public interface Market {
	
	/** 판매 물품 조회 */
	Product[] getSellProduct();
	
	/** 
	 * 구매 가능 여부 반환
	 * 미성년자가 주류 구매 혹은
	 * 유통기한이 지난 경우 구매 불가 
	 * */
	boolean canBuy(Consumer consumer, Product product);
	
	/** 고객 정보와 제품 정보를 받아 최종 가격을 반환하는 메소드 */
	double getTotalPrice(Consumer consumer);
}
