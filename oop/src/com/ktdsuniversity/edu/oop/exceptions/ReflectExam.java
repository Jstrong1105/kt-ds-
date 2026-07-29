package com.ktdsuniversity.edu.oop.exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectExam {

	public static void main(String[] args) { 
		
		// Reflection: 다이나믹 로딩
		// -> 클래스, 멤버변수, 생성자, 메소드 
		// -> 동적 로딩 => 클래스의 도움 없이 인스턴스를 생성하거나 호출하는 방법
		
		// GoodsHolder holder = new GoodsHolder(10);
		
		try {
			Class holderClass = Class.forName("com.ktdsuniversity.edu.oop.exceptions.GoodsHolder");
			Constructor<GoodsHolder> 생성자 = holderClass.getDeclaredConstructor(int.class);
			Object holder = 생성자.newInstance(4);
			System.out.println(holder);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		}
	}
}
