package com.ktdsuniversity.edu.homework;

/**
 * 메인 
 */
public class ClassHomework {
	
	public static void main(String[] args) {
		
		// 손님 2명 생성
		Consumer[] consumers = new Consumer[2];
		consumers[0] = new Consumer(10000, 0);
		consumers[1] = new Consumer(20000, 0);
		
		// 판매자 2명 생성
		Seller[] sellers = new Seller[2];
		sellers[0] = new Seller(0, 4000, 5);
		sellers[1] = new Seller(0, 5000, 4);
		
		for(int i = 0; i < consumers.length; i++)
		{
			System.out.println( (i+1) + "번 손님의 구매");
			// i 번째 손님의 구매
			int seller = getRandom(i); // 판매할 판매자
			int count = getRandom(5); // 구매할 개수
			int money = consumers[i].money; // 손님이 가진 현금
			int price = sellers[seller].price; // 판매가 판매하는 금액
			int total = count * price; // 구매할 총 금액
			int has = sellers[seller].stock; // 판매자가 가진 재고
			
			System.out.println("구매할 개수 : " + count);
			System.out.println("구매할 판매자 : " + (seller+1) + "번");
			
			// 구매할 총 금액보다 보유 현금이 많다면 구매 가능
			if(money >= total) {
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
		
		double result = ( Math.random() * range ) + 1;
		
		return (int)result;
	}
}
