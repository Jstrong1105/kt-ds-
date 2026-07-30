package com.ktdsuniversity.edu.oop.collection.list;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.oop.inheritence.car.BatMobile;
import com.ktdsuniversity.edu.oop.inheritence.car.Ev;
import com.ktdsuniversity.edu.oop.inheritence.car.SportsCar;
import com.ktdsuniversity.edu.oop.inheritence.car.Vehicle;

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
		
		List<Vehicle> cars = new ArrayList<>();
		cars.add(new Vehicle("차1"));
		cars.add(new Ev("차2",100d));
		cars.add(new SportsCar("차3"));
		cars.add(new BatMobile("차4"));
		
		for (Vehicle car : cars) {
			startEngine(car);
			startTurboEngine(car);
			startTurboEngine(car);
			checkBattery(car);
		}
	}
}
