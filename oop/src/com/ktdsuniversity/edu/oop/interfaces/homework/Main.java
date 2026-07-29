package com.ktdsuniversity.edu.oop.interfaces.homework;

public class Main {
	
	public static void main(String[] args) {
		
		Market market = new MarketClass();
		
		for (Product product : market.getSellProduct()) {
			System.out.println(product);
		}
		
		Consumer normalConsumer = new ConsumerClass("일반고객", "A", 3000, 15);
		Consumer newConsumer = new ConsumerClass("신규고객", "B", 4000, 21);
		Consumer oldConsumer = new ConsumerClass("단골고객", "C", 20000, 32);
		
		normalConsumer.addProducts(market.getSellProduct()[0]);
		normalConsumer.addProducts(market.getSellProduct()[1]);
		normalConsumer.addProducts(market.getSellProduct()[2]);
		normalConsumer.addProducts(market.getSellProduct()[3]);
		
		if(normalConsumer.getMoney() > market.getTotalPrice(normalConsumer)) {
			System.out.println("구매 완료");
		}
		
		newConsumer.addProducts(market.getSellProduct()[0]);
		newConsumer.addProducts(market.getSellProduct()[1]);
		newConsumer.addProducts(market.getSellProduct()[2]);
		newConsumer.addProducts(market.getSellProduct()[3]);
		
		if(newConsumer.getMoney() > market.getTotalPrice(newConsumer)) {
			System.out.println("구매 완료");
		}
		
		oldConsumer.addProducts(market.getSellProduct()[0]);
		oldConsumer.addProducts(market.getSellProduct()[1]);
		oldConsumer.addProducts(market.getSellProduct()[2]);
		oldConsumer.addProducts(market.getSellProduct()[3]);
		
		if(oldConsumer.getMoney() > market.getTotalPrice(oldConsumer)) {
			System.out.println("구매 완료");
		}
	}
}

