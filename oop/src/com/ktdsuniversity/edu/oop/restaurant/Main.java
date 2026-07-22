package com.ktdsuniversity.edu.oop.restaurant;

/**
 * main
 */
public class Main {
	
	public static void main(String[] args) {
		
		// 식당 생성
		Restaurant res = new Restaurant();
		
		// 손님 수 2 ~ 4 
		int consumerCount = getRandom(3) + 2;
		Consumer[] consumers = new Consumer[consumerCount];
		for (int i = 0; i < consumerCount; i++) {
			// 손님 한명의 나이 15 ~ 24
			int age = getRandom(10) + 15;
			consumers[i] = new Consumer(age);
			System.out.println( (i+1) + "번 손님");
			consumers[i].printStatus();
			System.out.println();
		}
		
		// 주문 가능 메뉴
		int menu = 1;
		// 성인 포함 시 주류 주문 가능
		menu += hasAdult(consumers);
		
		// 식당 입장
		System.out.println("식당 입장");
		while(true) {
			for(int i = 0; i < consumerCount; i++) {
				// 메뉴 주문
				int menuOrder = getRandom(menu);
				int order = getRandom(4);
				
				// Food 주문
				if (menuOrder == 0) {
					if (consumers[i].getFullnesPercent() <= 100)
					{
						System.out.println( (i+1) + "번 손님 주문");
						consumers[i].eatFood(res.getFood(order));
						System.out.println();
					} 
				}
				// Drink 주문
				else if (menuOrder == 1) {
					if (consumers[i].getDrunkPercent() <= 60)
					{
						System.out.println( (i+1) + "번 손님 주문");
						consumers[i].eatDrink(res.getDrink(order));
						System.out.println();
					}
				}
				// 버그
				else {
					System.out.println("버그발생");
				}
			}
			
			if(isOver(consumers)) {
				System.out.println("식당 퇴장");
				break;
			}
		}
		
		for(int i = 0; i < consumers.length; i++){
			System.out.println( (i+1) + "번 손님");
			consumers[i].printStatus();
			System.out.println();
		}
	}
	
	// 랜덤한 정수를 반환하는 메소드
	private static int getRandom(int range) {
		return (int) (Math.random() * range);
	}
	
	// 성인 유무를 판단해 1, 0 을 반환하는 메소드
	private static int hasAdult(Consumer[] consumers) {
		for(int i = 0; i < consumers.length; i++) {
			if(consumers[i].getAge() >= 19) {
				return 1;
			}
		}
		return 0;
	}
	
	// 모든 손님이 더이상 먹을 수 없는 상태인지 확인하는 메소드
	private static boolean isOver(Consumer[] consumers) {
		boolean result = true;
		
		int adult = hasAdult(consumers);
		
		for(int i = 0; i < consumers.length; i++) {
			if(adult == 0)
			{
				if(consumers[i].getFullnesPercent() <= 100) {
					result = false;
					break;
				}
			} else {
				if(consumers[i].getFullnesPercent() <= 100 || consumers[i].getDrunkPercent() <= 60) {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
}
