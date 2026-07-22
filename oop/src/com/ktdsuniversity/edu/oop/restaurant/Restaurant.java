package com.ktdsuniversity.edu.oop.restaurant;

/**
 * 레스토랑
 * 
 * 패키지 프라이빗
 */
class Restaurant {
	
	private Food[] foods;
	
	private Drink[] drinks;
	
	Restaurant(){
		foods = new Food[4];
		foods[0] = new Food("육고기",25,0);
		foods[1] = new Food("채소",13,-5);
		foods[2] = new Food("과일",13,-5);
		foods[3] = new Food("생선",7,0);
		
		drinks = new Drink[4];
		drinks[0] = new Drink("소주",-7,17);
		drinks[1] = new Drink("맥주",8,6);
		drinks[2] = new Drink("위스키",-7,40);
		drinks[3] = new Drink("꼬냑",-7,40);
	}

	Food getFood(int index) {
		return foods[index];
	}
	
	Drink getDrink(int index) {
		return drinks[index];
	}
}
