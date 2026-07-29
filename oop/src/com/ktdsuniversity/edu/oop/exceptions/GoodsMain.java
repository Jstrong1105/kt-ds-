package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsMain {
	
	public static void main(String[] args) {
		GoodsHolder capsuleHolder = new GoodsHolder(10);
		capsuleHolder.addGoods("네스프레소 솔티드 캬라멜 커피", "팔천구백원");
		capsuleHolder.addGoods(null, "9000");
		capsuleHolder.addGoods("네스프레소 카페라테", "9_000");
		capsuleHolder.addGoods(" ", "9000");
		capsuleHolder.addGoods("돌체구스토 아메리카노", "ds 7fgfd80sgsg0");
		capsuleHolder.addGoods("카누 에스프레소", "dsfds sd80fdsf 00 fsdf");
		capsuleHolder.addGoods("일리 에스프레소", "3000000000");
		capsuleHolder.addGoods("일리 에스프레소", null);
		
		capsuleHolder.printGoods();
		capsuleHolder.printGoodsAt(-1);
		capsuleHolder.printGoodsAt(0);
		capsuleHolder.printGoodsAt(1);
		capsuleHolder.printGoodsAt(2);
		capsuleHolder.printGoodsAt(3);
		capsuleHolder.printGoodsAt(99);
		
		capsuleHolder.removeGoods(0);
		capsuleHolder.removeGoods(1);
		capsuleHolder.removeGoods(2);
		capsuleHolder.removeGoods(3);
		capsuleHolder.removeGoods(-1);
		capsuleHolder.removeGoods(99);
		
		capsuleHolder.printGoods();
	}
}
