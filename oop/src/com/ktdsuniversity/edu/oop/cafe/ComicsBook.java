package com.ktdsuniversity.edu.oop.cafe;

/**
 * 만화책 클래스
 */
public class ComicsBook {
	
	/** 책 이름*/
	private String bookName;
	
	/** 대여 여부 */
	private boolean rental;
	
	/** 대여비 */
	private int price;
	
	// 생성자
	public ComicsBook(String bookName, boolean rental, int price){
		this.bookName = bookName;
		this.rental = rental;
		this.price = price;
	}
	
	// 대여하기
	public void rentalBook() {
		rental = true;
	}
	
	// 반납하기
	public void returnBook() {
		rental = false;
	}
	
	// getter
	public String getBookName() {
		return this.bookName;
	}
	
	public boolean isRental() {
		return this.rental;
	}
	
	public int getPrice() {
		return this.price;
	}
}
