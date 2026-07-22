package com.ktdsuniversity.edu.oop.cafe;

/**
 * 만화책 클래스
 */
class ComicsBook {
	
	/** 책 이름*/
	private String bookName;
	
	/** 대여 여부 */
	private boolean rental;
	
	/** 대여비 */
	private int price;
	
	// 생성자
	ComicsBook(String bookName, boolean rental, int price){
		this.bookName = bookName;
		this.rental = rental;
		this.price = price;
	}
	
	// 대여하기
	void rentalBook() {
		rental = true;
	}
	
	// 반납하기
	void returnBook() {
		rental = false;
	}
	
	// getter
	String getBookName() {
		return this.bookName;
	}
	
	boolean isRental() {
		return this.rental;
	}
	
	int getPrice() {
		return this.price;
	}
}
