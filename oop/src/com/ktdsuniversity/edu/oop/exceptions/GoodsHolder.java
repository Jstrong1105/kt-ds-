package com.ktdsuniversity.edu.oop.exceptions;

public class GoodsHolder {

	private Goods[] goods;
	private int goodsIndex;
	
	public GoodsHolder(int goodsCount) {
		if (goodsCount <= 0) {
			HolderInitiateException hie = 
				new HolderInitiateException("잘못된 인덱스 개수입니다. 0보다 큰 값을 입력하세요.");
			throw hie;
		}
		this.goods = new Goods[goodsCount];
	}
	
	public void addGoods(String name, String price) {
		if (price == null || price.isBlank()) {
			System.out.println("잘못된 가격");
			return;
		}
		price = price.replaceAll("[^0-9]", "");
		if (!price.isBlank()){
			//int tempPrice = Integer.parseInt(price);
			long tempPrice = Long.parseLong(price);
			if (tempPrice > Integer.MAX_VALUE || tempPrice < Integer.MIN_VALUE) {
				return;
			} 
			int intPrice = (int) tempPrice;
			
			this.addGoods(name, intPrice);
		}
	}
	
	public void addGoods(String name, int price) {
		if (this.goodsIndex == this.goods.length) {
			System.out.println("배열 다참");
			return;
		}
		
		if( name == null || name.isBlank()) {
			System.out.println("이름이 유효하지 않음");
			return;
		}
		
		this.goods[this.goodsIndex++] = new Goods(name, price);
	}
	
	public void removeGoods(int goodsIndex) {
		if (goodsIndex < 0 || goodsIndex >= this.goods.length) {
			System.out.println("범위 벗어남");
			return;
		}
		this.goods[goodsIndex] = null;
	}
	
	public void printGoodsAt(int index) {
		if ( index < 0 || index >= this.goods.length) {
			System.out.println("범위 벗어남");
			return;
		}
		Goods goods = this.goods[index];
		if(goods != null) {
			String message = "%d. %s(%d)".formatted(index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		} else {
			System.out.println("값 없음");
		}
	}
	
	public void printGoods() {
		for (int i = 0; i < this.goods.length; i++) {
			this.printGoodsAt(i);
		}
	}
	
}