package com.ktdsuniversity.edu.oop.cafe;

/**
 * 만화 카페 클래스
 */
class ComicsBookCafe {
	
	/** 만화 카페 소지금 */
	private int money;
	
	/** 만화 카페에 있는 책 목록 */
	private ComicsBook[] bookList;
	
	// 생성자
	ComicsBookCafe(int money, ComicsBook[] bookList){
		this.money = money;
		this.bookList = bookList;
	}
	
	// 보유하고 있는 만화책 목록 출력하기
	void printBookList() {
		System.out.println("카페 소지금: " + money);
		for(int i = 0; i < this.bookList.length; i++) {
			if(this.bookList[i] != null) {
				ComicsBook book = this.bookList[i];
				System.out.println( (i+1) + "번 책");
				System.out.println("책 이름: " + book.getBookName());
				System.out.println("책 대여비: " + book.getPrice());
				if(book.isRental()) {
					System.out.println("대여 중");
				} else {
					System.out.println("대여 가능");
				}
			}
			System.out.println();
		}
	}
	
	// 만화책 가격 알려주기
	int getPrice(int index) {
		if(this.bookList[index] != null) {
			return this.bookList[index].getPrice();
		} else {
			return -1;
		}
	}
	
	void rental(Visitor visitor, int index) {
		
		System.out.println("대여할 책 번호: " + (index+1) );
		
		if(this.bookList[index].isRental()) {
			System.out.println("이미 대여됨");
			return;
		}
		
		int price = this.bookList[index].getPrice();
		
		System.out.println("가격: " + price);
		System.out.println("손님이 가진 돈: " + visitor.getMoney());
		
		if(visitor.getMoney() >= price) {
			visitor.pay(price);
			this.money += price;
			System.out.println("받은 돈: " + price);
			System.out.println("가게 매출: " + this.money);
			System.out.println("손님 남은 돈: " + visitor.getMoney());
			this.bookList[index].rentalBook();
			System.out.println("대여 완료");
		}else {
			System.out.println("잔액 부족");
		}
		System.out.println();
	}
}
