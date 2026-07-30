package com.ktdsuniversity.edu.oop.restaurant;

/**
 * 레스토랑에서 판매하는 주류
 * 
 */
public class Drink {
	
	/** 주류종류 */
	private String category;
	
	/** 포만도 편의상 int 구성*/
	private int fullnessPercent;
	
	/** 취기 편의상 int 구성 */
	private int drunkPercent;
	
	// 생성자 구성
	public Drink(String category, int fullnessPercent, int drunkPercent){
		this.category = category;
		this.fullnessPercent = fullnessPercent;
		this.drunkPercent = drunkPercent;
	}
	
	// getter 구성
	public String getCategory() {
		return this.category;
	}
	
	public int getFullnessPercent() {
		return this.fullnessPercent;
	}
	
	public int getDrunkPercent() {
		return this.drunkPercent;
	}
}
