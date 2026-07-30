package com.ktdsuniversity.edu.oop.collection.list;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

public class ComicsTest {
	
	public static void main(String[] args) {
		ComicsBookCafe cafe = new ComicsBookCafe(5000);
		cafe.addBook(new ComicsBook("책 1", false, 500));
		cafe.addBook(new ComicsBook("책 2", false, 500));
		cafe.addBook(new ComicsBook("책 3", false, 500));
		cafe.addBook(new ComicsBook("책 4", false, 500));
		cafe.addBook(new ComicsBook("책 5", false, 500));
		cafe.addBook(new ComicsBook("책 6", false, 500));
		cafe.addBook(new ComicsBook("책 7", false, 500));
		
		cafe.printBookList();
		
		Visitor visitor = new Visitor(4000);
		
		cafe.rental(visitor, 0);
		cafe.rental(visitor, 1);
		cafe.rental(visitor, 2);
		cafe.rental(visitor, 3);
		cafe.rental(visitor, 4);
		cafe.rental(visitor, 5);
		cafe.rental(visitor, 6);
		
		cafe.printBookList();
	}
}
