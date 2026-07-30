package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

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
	}
}
