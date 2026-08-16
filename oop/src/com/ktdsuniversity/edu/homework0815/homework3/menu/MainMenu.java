package com.ktdsuniversity.edu.homework0815.homework3.menu;

import java.util.function.Consumer;

import com.ktdsuniversity.edu.homework0815.homework3.Library;

public enum MainMenu {
	
	도서입고("도서 입고",(lib) -> {
		lib.addBook();
	})
	, 도서조회("도서 조회",(lib) -> {
		lib.printBooks();
	})
	, 도서검색("도서 검색",(lib) -> {
		lib.printFindBook();
	})
	, 도서대여("도서 대여",(lib) -> {
		lib.rentalBook();
	})
	, 도서반납("도서 반납",(lib) -> {
		lib.returnBook();
	})
	, 회원조회("회원 조회",(lib) -> {
		lib.printUsers();
	})
	, 회원가입("회원 가입",(lib) -> {
		lib.addUser();
	})
	;
	
	private final String menu;
	private final Consumer<Library> service;
	
	MainMenu(String menu, Consumer<Library> service){
		this.menu = menu;
		this.service = service;
	}
	
	public String getMenu() {
		return this.menu;
	}
	
	public void order(Library lib) {
		this.service.accept(lib);
	}
}
