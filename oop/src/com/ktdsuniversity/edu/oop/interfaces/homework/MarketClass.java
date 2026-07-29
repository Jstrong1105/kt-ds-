package com.ktdsuniversity.edu.oop.interfaces.homework;

/**
 * Market 클래스
 */
public class MarketClass implements Market {

	private Product[] products;
	
	public MarketClass() {
		this.products = new Product[] {
				new ProductClass("일반식품", "Geforce RTX 5090", 1000, "", Double.MIN_VALUE, 0, 0.0),
				new ProductClass("신선식품", "사과", 2000, "2026.08.04", 18.0, 0, 0.0),
				new ProductClass("냉동식품", "아이스크림", 3000, "2026.08.11", -7.0d, 0, 0.0),
				new ProductClass("주류식품", "맥주", 4000, "2026.08.27", Double.MIN_VALUE, 19, 4.5),
		};
	}
	
	@Override
	public Product[] getSellProduct() {
		return this.products;
	}

	@Override
	public boolean canBuy(Consumer consumer, Product product) {
		return consumer.getAge() > product.getBuyAge();
	}

	@Override
	public double getTotalPrice(Consumer consumer) {
		int minPrice = Integer.MAX_VALUE;
		double total = 0.0;
		for (Product product : consumer.getProducts()) {
			if(canBuy(consumer, product)) {
				total += product.getPrice();
				if(product.getPrice() < minPrice) {
					minPrice = product.getPrice();
				}
			} else {
				System.out.println("구매 나이 제한");
			}
		}
		
		if (consumer.getType().equals("신규손님")) {
			total *= 0.9;
		} else if (consumer.getType().equals("단골손님")) {
			total -= minPrice;
		}
		
		return total;
	}
}
