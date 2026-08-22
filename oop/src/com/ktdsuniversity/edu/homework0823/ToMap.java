package com.ktdsuniversity.edu.homework0823;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToMap {
	public static void main(String[] args) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 1; i < 6; i++) {
			map.put(i, ToList.getRandomNumbers(1, 45));
		}
		
		map.forEach((k,v) -> {
			System.out.print(k + "회차 => ");
			v.stream()
			 .limit(5)
			 .forEach(i -> {
				 System.out.print(i);
				 System.out.print(", ");
			 });
			 v.stream()
			  .skip(5)
			  .limit(1)
			  .forEach(System.out::println);
		});
	}
}
