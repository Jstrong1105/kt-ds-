package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class ListExam {
	
	public static void main(String[] args) {
		
		// 정수를 관리하는 리스트 생성
		List<Integer> decimalList = new ArrayList<>();
		
		// 리스트에 몇 개의 정수가 있나?
		int size = decimalList.size();
		System.out.println(size);
		
		// 리스트에 정수 하나를 추가
		decimalList.add(1200);
		decimalList.add(2400);
		
		// 리스트에 몇 개의 정수가 있나?
		size = decimalList.size();
		System.out.println(size);
		
		// 리스트의 0번 인덱스의 값을 가져온다.
		int value0 = decimalList.get(0);
		System.out.println(value0);
		
		// 리스트의 1번 인덱스의 값을 가져온다.
		int value1 = decimalList.get(1);
		System.out.println(value1);
		
		// 리스트의 2번 인덱스의 값을 가져온다.
		if (decimalList.size() > 2) {
			int value2 = decimalList.get(2);
			System.out.println(value2);
		}
		
		// 리스트의 0번 인덱스를 삭제한다.
		// 리스트의 0번 인덱스를 삭제하고, 해당 인덱스에 있던 값을 반환시킨다.
		int removedValue = decimalList.remove(0);
		System.out.println(removedValue + " 삭제됨");
		
		// 삭제한 이후의 리스트 개수를 출력해본다.
		size = decimalList.size();
		System.out.println(size +"개 정수가 있음");
		
		// 리스트의 1번 인덱스를 가져온다.
		value1 = decimalList.get(0);
		System.out.println(value1);
		
		// 리스트의 10개의 랜덤 값을 추가한다.
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		decimalList.add((int)(Math.random() * 1000));
		
		System.out.println(decimalList.size() +"개 정수가 있음");
		decimalList.clear();
		System.out.println(decimalList.size() +"개 정수가 있음");
		
		// 리스트에 100, 200, 300, 400, 500, 600 숫자를 순서대로 할당한다.
		decimalList.add(100);
		decimalList.add(200);
		decimalList.add(300);
		decimalList.add(400);
		decimalList.add(500);
		decimalList.add(600);
		
		// 리스트에 100 이 존재하는가?
		if (decimalList.contains(100)) {
			System.out.println("100이 존재합니다.");
		}
		// 리스트에 200 이 존재하는가?
		if (decimalList.contains(200)) {
			System.out.println("200이 존재합니다.");
		}
		// 리스트에 305 가 존재하는가?
		if (decimalList.contains(305)) {
			System.out.println("305가 존재합니다.");
		}
		
		// 리스트에 들어있는 모든 항목을 출력한다.
		System.out.println(decimalList);
		
		for(int i : decimalList) {
			System.out.println(i);
		}
		
		List<Goods> goodsList = new ArrayList<>();
		
		Goods goods1 = new Goods("1",1);
		Goods goods2 = new Goods("1",1);
		
		System.out.println(goods1.equals(goods2));
		
		// goodsList 에 Goods 인스턴스를 추가한다.
		goodsList.add(new Goods("Geforce RTX 5090", 7843000));
		// goodsList 에 Goods 인스턴스를 추가한다.
		goodsList.add(new Goods("AMD 라이젠 9 9950X3D", 905500));
		// goodsList 에 Goods 인스턴스를 추가한다.
		goodsList.add(new Goods("ASUS ROG CROSSHAIR X870E HERO", 870000));
		
		// goodsList 의 0번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		System.out.println(goodsList.get(0).getName() + " : " + goodsList.get(0).getPrice());
		// goodsList 의 1번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		System.out.println(goodsList.get(1).getName() + " : " + goodsList.get(1).getPrice());
		// goodsList 의 2번째 인덱스에 있는 Goods 인스턴스를 가져와 출력한다.
		System.out.println(goodsList.get(2).getName() + " : " + goodsList.get(2).getPrice());
		
		// goodsList 의 모든 Goods 인스턴스를 출력한다. (for 이용)
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getName() + " : " + goodsList.get(i).getPrice());
		}
		
		// goodsList 에서 상품의 이름이 Geforce RTX 5090 이고 가격이 7843000 인 상품이 존재하는가?
		if (goodsList.contains(new Goods("Geforce RTX 5090", 7843000))) {
			System.out.println("있음");
		}
	}
}










