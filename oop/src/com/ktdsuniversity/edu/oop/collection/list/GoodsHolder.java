package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.exceptions.Goods;
import com.ktdsuniversity.edu.oop.exceptions.HolderInitiateException;

public class GoodsHolder {

	private List<Goods> goods;
	
	public GoodsHolder() {
		this.goods = new ArrayList<>();
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
		if( name == null || name.isBlank()) {
			System.out.println("이름이 유효하지 않음");
			return;
		}
		
		this.goods.add(new Goods(name, price));
	}
	
	public void removeGoods(int goodsIndex) {
		if (goodsIndex < 0 || goodsIndex >= this.goods.size()) {
			return;
		}
		this.goods.remove(goodsIndex);
	}
	
	public void printGoodsAt(int index) {
		if ( index < 0 || index >= this.goods.size()) {
			return;
		}
		Goods goods = this.goods.get(index);
		if(goods != null) {
			String message = "%d. %s(%d)".formatted(index + 1, goods.getName(), goods.getPrice());
			System.out.println(message);
		} else {
			System.out.println("값 없음");
		}
	}
	
	public void printGoods() {
		for (int i = 0; i < this.goods.size(); i++) {
			this.printGoodsAt(i);
		}
	}
	
}