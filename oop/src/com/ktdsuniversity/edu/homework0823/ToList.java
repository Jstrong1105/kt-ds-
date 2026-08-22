package com.ktdsuniversity.edu.homework0823;

import java.util.ArrayList;
import java.util.List;

public class ToList {

	public static void main(String[] args) {
		
		List<Integer> list = getRandomNumbers(1, 45);
		
		list.stream()
			.limit(5)
			.forEach(i ->{
				System.out.print(i);
				System.out.print(", ");
			});
		list.stream()
		    .skip(5)
		    .limit(1)
		    .forEach(i -> {
		    	System.out.print(i);
		    });
	}
	
	public static List<Integer> getRandomNumbers(int min, int max){
		
		if (min > max) {
			throw new IllegalArgumentException("인자 오류");
		}
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = min ; i <= max; i++) {
			list.add(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			int randomIndex = (int) (Math.random() * list.size());
			int emp = list.get(i);
			list.set(i, list.get(randomIndex));
			list.set(randomIndex, emp);
		}
		
		return list;
	}
}
