package com.ktdsuniversity.edu.oop.exam;

public class CraneGameMachine {
	
	boolean isInsertCoin;
	int dolls;
	
	void insertCoin() {
		if(dolls > 0) {
			isInsertCoin = true;
		}
	}
	
	int doGame() {
		if(isInsertCoin) {
			int result = (int) (Math.random() * 2);
			result = 1; // test
			
			if(result > 0) {
				dolls -= 1;
			}
			
			isInsertCoin = false;
			return result;
			
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		CraneGameMachine cgm = new CraneGameMachine();
		
		cgm.dolls = 10;
		cgm.insertCoin();
		int result = cgm.doGame();
		if(result > 0) {
			System.out.println("인형 뽑기 성공");
		} else {
			System.out.println("인형 뽑기 실패");
		}
		System.out.println("남은 인형 " + cgm.dolls);
	}
}
