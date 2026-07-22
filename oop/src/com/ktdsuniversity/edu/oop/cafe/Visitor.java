package com.ktdsuniversity.edu.oop.cafe;

/**
 * 만화 카페에 대여하러온 사람 
 */
class Visitor {
	
	/** 가진 돈 */
	private int money;
	
	/** 빌린 책 */
	private ComicsBook[] books;
	
	// 생성자
	Visitor(int money){
		this.money = money;
		books = new ComicsBook[10];
	}
	
	// 가진 돈 알려주기
	int getMoney() {
		return money;
	}
	
	// 돈 지불하기
	void pay(int money) {
		this.money -= money;
	}
}
