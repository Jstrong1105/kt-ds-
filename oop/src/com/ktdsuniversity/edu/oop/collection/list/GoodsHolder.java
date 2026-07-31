package com.ktdsuniversity.edu.oop.collection.list;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class GoodsHolder {

	private List<Goods> goods;
	
	public GoodsHolder() {
		this.goods = new ArrayList<>();
		this.loadGoods();
	}
	
	private void loadGoods() {
		// 파일을 읽는다.
		
		File database = new File("C:/Java Exam","goods.txt");
		
		List<String> goodsList = null;
		
		if (database.exists() && database.isFile()) {
			try {
				goodsList = Files.readAllLines(database.toPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			if (goodsList != null) {
				String[] goodsInfo = null;
				for (String s : goodsList) {
					goodsInfo = s.split(",");
					this.addGoods(goodsInfo[0],goodsInfo[1]);
				}
			}
		}
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
	
	public void addGoods(String name, int price, boolean addToFile) {	
		this.addGoods(name, price);
		
		if (addToFile) {
			
			File database = new File("C:/Java Exam","goods.txt");
			
			if ( !database.getParentFile().exists() ) {
				database.getParentFile().mkdirs();
			}
			
			List<String> data = new ArrayList<>();
			data.add("%s,%d".formatted(name,price));
			
			try {
				Files.write(database.toPath(), data, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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