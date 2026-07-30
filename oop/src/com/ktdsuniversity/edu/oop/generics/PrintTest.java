package com.ktdsuniversity.edu.oop.generics;

import com.ktdsuniversity.edu.oop.exceptions.Goods;

public class PrintTest {
	
	public static void main(String[] args) {
		
		Print<Integer> intPrint = new Print<>(0); 
		Print<Double> doublePrint = new Print<>(0.0);
		Print<Long> longPrint = new Print<>(0L);
		Print<Boolean> booleanPrint = new Print<>(true);
		
		Print<Goods> goodsPrint = new Print<>(new Goods("A", 100));
		Goods goods = goodsPrint.getPrintData();
		goodsPrint.print();
		System.out.println(goods);
	}
}
