package com.ktdsuniversity.edu.oop.cafe;

/**
 * 메인 
 */
public class ComicsMain {

	public static void main(String[] args) {
		// 책의 개수 1 ~ 3
		int count = getRandom(3) + 1; 
		
		ComicsBook[] bookList = new ComicsBook[count];
		for(int i = 0; i < count; i++) {
			// 대여비 1000 ~ 3999
			bookList[i] = new ComicsBook( ("만화 " + (i+1) ), false, (getRandom(3000) + 1000) );
		}
		
		// 만화 카페
		ComicsBookCafe cafe = new ComicsBookCafe(0, bookList);
		
		// 만화책 목록 출력
		cafe.printBookList();
		
		// 손님 보유 현금 1000 ~ 5999
		Visitor visitor = new Visitor(getRandom(5000) + 1000);
		
		// 대여할 책의 번호
		int comics = getRandom(count);
		
		cafe.rental(visitor,  comics);
		
		// 만화책 목록 출력
		cafe.printBookList();
	}
	
	private static int getRandom(int range) {
		return (int) (Math.random() * range);
	}
}
