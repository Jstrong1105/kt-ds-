package com.ktdsuniversity.edu.homework0823;

public class ToArray {
	
	public static void main(String[] args) {
		
		int[] array = getRandomNumbers(1, 45);
		
		for (int i = 0; i < 6; i++) {
			System.out.print(array[i]);
			if (i != 5) {
				System.out.print(", ");
			}
		}
	}
	
	public static int[] getRandomNumbers(int min, int max) {
		
		if (min > max) {
			throw new IllegalArgumentException("인자 오류");
		}
		
		int size = max - min + 1;
		
		int[] array = new int[size];
		
		int index = 0;
		
		for (int i = min; i <= max ; i++) {
			array[index] = i;
			index++;
		}
		
		for (int i = 0; i < size; i++) {
			int randomIndex = (int) (Math.random() * size);
			int emp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = emp;
		}
		
		return array;
	}
}
