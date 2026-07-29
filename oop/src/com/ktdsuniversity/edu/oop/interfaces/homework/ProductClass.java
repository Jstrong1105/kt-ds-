package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * 제품 클래스
 */
public class ProductClass implements Product {

	private String category;
	private String name;
	private int price;
	private String expirationDate;
	private double saveTemp;
	private int buyAge;
	private double hasAlcohol;
	
	public ProductClass(String category, String name, int price, String expirationDate
						, double saveTemp, int buyAge, double hasAlcohol) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.expirationDate = expirationDate;
		this.saveTemp = saveTemp;
		this.buyAge = buyAge;
		this.hasAlcohol = hasAlcohol;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("종류 ").append(this.category).append("\n");
		sb.append("이름: ").append(this.name).append("\n");
		sb.append("가격: ").append(this.price).append("\n");
		if(!this.expirationDate.equals("")) {
			sb.append("유통기한: ").append(this.expirationDate).append("\n");
		}
		if(this.saveTemp != Double.MIN_VALUE) {
			sb.append("보관온도: ").append(this.saveTemp).append("\n");
		}
		if(this.buyAge != 0) {
			sb.append("구매나이: ").append(this.buyAge).append("\n");
		}
		if(this.hasAlcohol != 0.0) {
			sb.append("알코올 함량: ").append(this.hasAlcohol).append("\n");
		}
		
		return sb.toString();
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public String getExpirationDate() {
		return this.expirationDate;
	}

	@Override
	public double getSaveTemp() {
		return this.saveTemp;
	}

	@Override
	public int getBuyAge() {
		return this.buyAge;
	}

	@Override
	public double getHasAlcohol() {
		return this.hasAlcohol;
	}
}
