package com.ktdsuniversity.edu.oop;

import java.util.Scanner;

import com.ktdsuniversity.edu.oop.exam.Car;

class Test {

	public static void main(String[] args) {
		
		Car testCar = new Car(10);
		testCar.pressEngineStartButton();
		System.out.println(testCar.speed);
		Scanner keyboard = new Scanner(System.in);
	}
	
}
