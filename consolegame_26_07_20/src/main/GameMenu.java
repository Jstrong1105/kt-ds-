package main;

import java.util.function.Function;

import common.GameIO;
import domain.GameApp;
import domain.game.minesweeper.MinesweeperFactory;

/**
 * 각각의 게임들 모음
 */
public enum GameMenu {
	
	MINESWEEPER("지뢰찾기","지뢰를 피하세요.", (io) -> new MinesweeperFactory(io).getGame())
	;
	
	private final String gameName;
	private final String gameDescription;
	private final Function<GameIO,GameApp> factory;
	
	private GameMenu(String gameName, String gameDescription, Function<GameIO,GameApp> factory) {
		this.gameName = gameName;
		this.gameDescription = gameDescription;
		this.factory = factory;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public String getGameDescription() {
		return gameDescription;
	}
	
	public GameApp getGame(GameIO io) {
		return factory.apply(io);
	}
}
