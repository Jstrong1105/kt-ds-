package com.ktdsuniversity.edu.oop.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tag {
	
	public static void main(String[] args) {
		
		// 의류에 붙어있는 택 정보를 Map 을 이용해 표현.
		
		Map<String, Object> tags = new HashMap<>();
		tags.put("사이즈", 30);
		tags.put("소재", "폴리에스테르");
		tags.put("가격", 59000);
		
		System.out.println(tags);
		System.out.println(tags.size());
		
		tags.put("가격", 69000);
		System.out.println(tags);
		System.out.println(tags.size());
		
		String 소재 = (String) tags.get("소재");
		System.out.println(소재);
		
		String 브랜드 = (String) tags.get("브랜드");
		System.out.println(브랜드);
		
		int 가격 = (int) tags.get("가격");
		System.out.println(가격);
		
		// int 할인가 = (int) tags.get("할인가");
		// System.out.println(할인가);
		
		if (tags.containsKey("할인가")) {
			int 할인가 = (int) tags.get("할인가");
			System.out.println(할인가);
		}
		
		int 할인가 = (int) tags.getOrDefault("할인가", 0);
		System.out.println(할인가);
		
		List<Map<String, Object>> clothes = new ArrayList<>();
		
		Map<String, Object> tags1 = new HashMap<>();
		tags1.put("가격", 15000);
		tags1.put("소재", "나일론");
		tags1.put("사이즈", 32);
		
		clothes.add(tags1);
		
		for (int i = 0; i < clothes.size(); i++) {
			printTags(clothes.get(i));;
		}
		
		// 클래스로 만드는 것이 더 쉽다.
		Map<String, List<Map<String, List<Map<String, Map<String, Object>>>>>> 옷 = new HashMap<>();
	}
	
	public static void printTags(Map<String, Object> tag) {
		System.out.println("소재: " + tag.get("소재"));
		System.out.println("가격: " + tag.get("가격"));
		System.out.println("사이즈: " + tag.get("사이즈"));
	}
}
