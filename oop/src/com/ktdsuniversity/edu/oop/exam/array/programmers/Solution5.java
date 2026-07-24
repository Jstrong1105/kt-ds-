package com.ktdsuniversity.edu.oop.exam.array.programmers;

/**
 * 이 문제에서 두 정수 배열의 대소관계를 다음과 같이 정의합니다.
 * 
 * 두 배열의 길이가 다르면 배열의 길이가 긴 쪽이 큽니다.
 * 배열의 길이가 같다면 각 배열에 있는 원소의 합을 비교합니다.
 * 
 * 두 정수 배열 arr1 과 arr2 가 주어질 때 
 * 위에서 정의한 배열의 대소관계에 대하여 arr2가 크다면 -1
 * arr1 이 크다면 1
 * 두 배열이 같다면 0 을 return 하는 메소드
 * 
 * 제한 사항
 * 1 <= arr1 의 길이 <= 100
 * 1 <= arr2 의 길이 <= 100
 * 1 <= arr1 의 원소 <= 100
 * 1 <= arr2 의 원소 <= 100
 */
public class Solution5 {

	public static int comparaTo(int[] arr1, int[] arr2) {
		
		int result = arr1.length - arr2.length;
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		}
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			sum1 += arr1[i];
			sum2 += arr2[i];
		}
		
		result = sum1 - sum2;
		
		if (result > 0) {
			return 1;
		} else if (result < 0) {
			return -1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = {49, 13};
		int[] arr2 = {70, 11, 2};
		System.out.println(comparaTo(arr1, arr2));
		// -1
		
		arr1 = new int[] {100, 17, 84, 1};
		arr2 = new int[] {55, 12, 65, 36};
		System.out.println(comparaTo(arr1, arr2));
		// 1
		
		arr1 = new int[] {1, 2, 3, 4, 5};
		arr2 = new int[] {3, 3, 3, 3, 3};
		System.out.println(comparaTo(arr1, arr2));
		// 0
	}
}
