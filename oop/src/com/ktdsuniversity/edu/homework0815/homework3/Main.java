package com.ktdsuniversity.edu.homework0815.homework3;

import com.ktdsuniversity.edu.homework0815.homework3.menu.MainMenu;
import com.ktdsuniversity.edu.homework0815.homework3.util.Reader;

public class Main {
	public static void main(String[] args) {
		
		Library library = new Library();
		MainMenu[] menus = MainMenu.values();
		int exit = menus.length + 1;
		
		while(true) {
			System.out.println("======= 도서 관리 =======");
			
			for(int i = 0; i < menus.length; i++) {
				System.out.printf("%d. %s%n", (i+1), menus[i].getMenu() );
			}
			System.out.printf("%d. 종료%n", exit);
			
			int answer = Reader.readInt("메뉴 선택: ", 1, exit);
			
			if (answer == exit) {
				System.out.println("프로그램 종료");
				library.save();
				break;
			} else {
				menus[answer-1].order(library);
				Reader.readString("작업 완료");
			}
		}
	}
}
