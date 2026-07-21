package com.ktdsuniversity.edu.oop;

import java.util.Scanner;

import com.ktdsuniversity.edu.oop.exam.Car;

public class Test {

	public static void main(String[] args) {
		
		Car testCar = new Car(10);
		testCar.pressEngineStartButton();
		Scanner keyboard = new Scanner(System.in);
	}
	
}
