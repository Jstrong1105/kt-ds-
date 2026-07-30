package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.cafe.ComicsBook;

/**
 * 만화 카페에 대여하러온 사람 
 */
public class Visitor {
	
	/** 가진 돈 */
	private int money;
	
	/** 빌린 책 */
	private List<ComicsBook> books;
	
	// 생성자
	public Visitor(int money){
		this.money = money;
		books = new ArrayList<>();
	}
	
	// 가진 돈 알려주기
	public int getMoney() {
		return money;
	}
	
	// 돈 지불하기
	public void pay(int money) {
		this.money -= money;
	}
}
