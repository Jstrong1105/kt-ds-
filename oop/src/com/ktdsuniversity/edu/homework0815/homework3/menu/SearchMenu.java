package com.ktdsuniversity.edu.homework0815.homework3.menu;


import java.util.function.Consumer;

import com.ktdsuniversity.edu.board.util.Reader;
import com.ktdsuniversity.edu.homework0815.homework3.BookGenre;
import com.ktdsuniversity.edu.homework0815.homework3.Library;

public enum SearchMenu {
	
	출판사("출판사 검색", (lib) ->{
		String pub = Reader.readString("검색할 출판사: ");
		lib.printBooksFilter((b) -> b.getPublisher().equals(pub));
	})		
	, 저자("저자 검색", (lib) -> {
		String writer = Reader.readString("검색할 저자: ");
		lib.printBooksFilter((b) -> b.getWriter().equals(writer));
	})
	, 장르("장르 검색", (lib) -> {
		BookGenre genre = lib.getGenre();
		lib.printBooksFilter((b) -> b.getGenre() == genre);
	})
	;
	
	private final String type;
	private Consumer<Library> service;
	 
	SearchMenu(String type, Consumer<Library> service){
		this.type = type;
		this.service = service;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void order(Library lib) {
		this.service.accept(lib);
	}
}
