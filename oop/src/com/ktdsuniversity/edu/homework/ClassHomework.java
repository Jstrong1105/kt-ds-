package com.ktdsuniversity.edu.homework;

/**
 * 메인 
 */
public class ClassHomework {
	
	public static void main(String[] args) {
		
		int consumerCount = getRandom(10) + 1; // 1 ~ 10명 손님 생성 
		Consumer[] consumers = new Consumer[consumerCount];
		for(int i = 0; i < consumerCount; i++) {
			consumers[i] = new Consumer(getRandom(50000),0); 
			// 보유 현금이 0 ~ 50000원 , 장바구니가 0인 손님 생성
		}
		
		int sellerCount = getRandom(10) + 1; // 1 ~ 10명 판매자 생성
		Seller[] sellers = new Seller[sellerCount];
		for(int i = 0; i < sellerCount; i++) {
			sellers[i] = new Seller(0, (getRandom(4000) + 1000) , (getRandom(5) + 5) );
			// 매출액 0 , 판매금액 1000 ~ 5000, 재고 5 ~ 10 인 판매자 생성
		}
		
		for(int i = 0; i < consumers.length; i++)
		{
			// i 번째 손님의 구매
			int seller = getRandom(sellerCount);// 판매할 판매자
			int count = getRandom(5) + 1; 		// 구매할 개수 1 ~ 5 개  
			int money = consumers[i].money; 	// 손님이 가진 현금
			int price = sellers[seller].price; 	// 판매가 판매하는 금액
			int total = count * price; 			// 구매할 총 금액
			int has = sellers[seller].stock; 	// 판매자가 가진 재고
			
			System.out.println( (i+1) + "번 손님의 구매");
			System.out.println("구매할 개수 : " + count);
			System.out.println("구매할 판매자 : " + (seller+1) + "번");
			System.out.println("판매 금액 : " + price);
			System.out.println("보유 재고 : " + has);
			
			if(has == 0) {
				System.out.println("재고 소진");
			}
			// 구매할 총 금액보다 보유 현금이 많다면 구매 가능
			else if(money >= total) {
				// 구매할 개수보다 판매자가 가진 재고가 적다면
				// 판매자가 가진 모든 재고를 구매
				if(count > has) {
					count = has;
					total = count * price; 
				}
				sellers[seller].sell(count);
				consumers[i].buy(count, total);
				
				System.out.println("구매 금액 : " + total);
				System.out.println("보유 현금 : " + money );
				System.out.println("구매 성공");
				System.out.println("구매자의 남은 현금 : " + consumers[i].money);
				System.out.println("구매자의 장바구니 : " + consumers[i].bag);
				System.out.println("판매자의 매출 : " + sellers[seller].money);
				System.out.println("판매자의 재고 : " + sellers[seller].stock);
			}
			// 구매할 총 금액보다 보유 현금이 적다면 구매 불가
			else {
				System.out.println("구매 금액 : " + total);
				System.out.println("보유 현금 : " + money);
				System.out.println("구매 실패");
			}
		}
	}
	
	public static int getRandom(int range) {
		
		double result = ( Math.random() * range );
		
		return (int)result;
	}
}
