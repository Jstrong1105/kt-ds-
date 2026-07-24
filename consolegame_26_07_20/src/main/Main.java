package main;

/**
 * 프로그램 진입점
 */
public class Main {
	
	public static void main(String[] args) {
		try {
			new GameStore().order();
			
		} catch (Exception e) {
			System.out.println("프로그램 종료");
			e.printStackTrace();
		}
	}
}
