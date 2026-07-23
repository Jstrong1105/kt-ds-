package main;

import domain.game.minesweeper.MinesweeperFactory;

/**
 * 프로그램 진입점
 */
public class Main {
	
	public static void main(String[] args) {
		MinesweeperFactory factory = new MinesweeperFactory();
		factory.getGame().doGame();
	}
}
