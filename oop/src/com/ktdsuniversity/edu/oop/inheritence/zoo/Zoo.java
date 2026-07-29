package com.ktdsuniversity.edu.oop.inheritence.zoo;

public class Zoo {
	
	private Animal[] animals;
	
	public Zoo() {
		this.animals = new Animal[3];
		this.animals[0] = new Giraffe("기린1", 3, "수컷", 127.3f, "아프리카 기린", "2024.01.03");
		this.animals[1] = new Penguin("펭귄1", 2, "암컷", 7.4f, "남극 펭귄", "2025.11.26");
		this.animals[2] = new Tiger("호랑이1", 7, "수컷", 75.6f, "백두산 호랑이", "2020.04.05");
	}
	
	public Animal[] getAnimals() {
		return animals;
	}

	public static void printStats(Animal animal) {
		animal.printStat();
	}
	
	public static void move(Animal animal) {
		animal.move();
	}
	
	public static void eat(Animal animal) {
		animal.eat();
	}
	
	public static void sleep(Animal animal) {
		animal.sleep();
	}
	
	public static void play(Animal animal) {
		animal.play();
	}
	
	public static void kick(Animal animal) {
		if (animal instanceof Giraffe gir) {
			gir.kick();
		}
	}
	
	public static void swim(Animal animal) {
		if (animal instanceof Penguin pen) {
			pen.swim();
		}
	}
	
	public static void hunt(Animal animal) {
		if (animal instanceof Tiger tiger) {
			tiger.hunt();
		}
	}
	
	public static void howl(Animal animal) {
		if (animal instanceof Tiger tiger) {
			tiger.howl();
		}
	}
	
	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		
		for(Animal animal : zoo.getAnimals()) {
			printStats(animal);
			move(animal);
			eat(animal);
			sleep(animal);
			play(animal);
			kick(animal);
			swim(animal);
			hunt(animal);
			howl(animal);
			System.out.println();
		}
	}
}
