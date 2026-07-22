package com.ktdsuniversity.edu.oop.restaurant;

/**
 * 레스토랑의 손님
 * 
 * 레스토랑 패키지 내부에서만 사용할 예정이기에 패키지 프라이빗으로 구성 
 */
class Consumer {
	
	/** 손님의 나이 */
	private int age;
	
	/** 
	 * 포만도
	 * 편의상 int 구성 
	 * */
	private int fullnessPercent;
	
	/** 
	 * 취기 
	 * 편의상 int 구성
	 * */
	private int drunkPercent;
	
	// 생성자 구성
	Consumer(int age){
		this.age = age;
		this.fullnessPercent = 0;
		this.drunkPercent = 0;
	}
	
	void printStatus() {
		System.out.println("나이: " + age);
		System.out.println("포만도: " + fullnessPercent);
		System.out.println("취기: " + drunkPercent);
	}
	
	// 음식 먹기
	void eatFood(Food food) {
		if(this.fullnessPercent > 100) {
			System.out.println("더 이상 먹을 수 없습니다.");
		} else {
			eatPrint(food.getCategory(), food.getFullnessPercent(), food.getDrunkPercent());
		}
	}
	
	// 주류 먹기
	void eatDrink(Drink drink) {
		if(this.drunkPercent > 60) {
			System.out.println("더 이상 마실 수 없습니다.");
		} else {
			eatPrint(drink.getCategory(), drink.getFullnessPercent(), drink.getDrunkPercent());
		}
	}
	
	private void eatPrint(String category, int fullnessPercent, int drunkPercent) {
		System.out.println(category + "를 먹었습니다.");
		this.fullnessPercent += fullnessPercent;
		if(this.fullnessPercent < 0) {
			this.fullnessPercent = 0;
		}
		this.drunkPercent += drunkPercent;
		if(this.drunkPercent < 0) {
			this.drunkPercent = 0;
		}
		System.out.println("현재 포만도: " + this.fullnessPercent);
		System.out.println("현재 취기: " + this.drunkPercent);
	}
	
	// getter 구성
	int getAge() {
		return this.age;
	}
	
	int getFullnesPercent() {
		return this.fullnessPercent;
	}
	
	int getDrunkPercent() {
		return this.drunkPercent;
	}
}
