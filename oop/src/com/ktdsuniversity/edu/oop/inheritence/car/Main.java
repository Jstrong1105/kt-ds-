package com.ktdsuniversity.edu.oop.inheritence.car;

public class Main {
	
	public static void startEngine(Vehicle car) {
		car.startEngine();
	}
	
	public static void startTurboEngine(Vehicle car) {
		if(car instanceof SportsCar sportCar) {
			sportCar.startTurboEngine();
		}
	}
	
	public static void checkBattery(Vehicle car) {
		if(car instanceof Ev evCar) {
			evCar.checkBattery();
		}
	}
	
	public static void main(String[] args) {
		Vehicle car1 = new Vehicle("차1");
		Vehicle car2 = new Ev("차2",1.0);
		Vehicle car3 = new SportsCar("차3");
		Vehicle car4 = new BatMobile("차4");
		
		startEngine(car1);
		startTurboEngine(car3);
		startTurboEngine(car4);
		checkBattery(car2);
	}
}
