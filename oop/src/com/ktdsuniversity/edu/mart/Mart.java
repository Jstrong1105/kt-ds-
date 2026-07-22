package com.ktdsuniversity.edu.mart;

public class Mart {
	
	public static void main(String[] args) {
		Seller auction = new Seller(10, 1000, 0, 0);
		Seller naverSmartStore = new Seller(20, 1500, (3 * 1500), 3);
		
		Buyer me = new Buyer(17000, 0);
		
		// 내가 auction 에서 3개를 구매한다. 
		me.buy(3, auction);
		
		me.printStatus();
		auction.printStatus();
		
		// 내가 naverSmartStore 에서 2개를 구매한다.
		me.buy(2, naverSmartStore);
		
		me.printStatus();
		naverSmartStore.printStatus();
		
		System.out.println("=============");
		
		// 내가 auction 에서 2개를 구매한다.
		int boughtCount = me.buy(2, auction);
		System.out.println(boughtCount + "개 구매 완료");
		
		System.out.println("=============");
		
		// 내가 auction 에서 9개를 구매한다.
		boughtCount = me.buy(9, auction);
		System.out.println(boughtCount + "개 구매 완료");
		
		me.printStatus();
		auction.printStatus();
	}
}
