package main;

import java.util.function.Supplier;

import domain.GameApp;
import domain.game.minesweeper.MinesweeperFactory;
import domain.game.poker.PokerGambleFactory;

/**
 * 게임 목록을 가지고 원하는 게임을 반환하는 enum
 */
public enum GameMenu {

	MINESWEEPER(()->{
		return new MinesweeperFactory().getGame();
	},"지뢰찾기","지뢰를 모두 찾으세요.")
	, POKERGAMBLE(()->{
		return new PokerGambleFactory().getGame();
	},"포커겜블","목표 코인을 달성하세요.")
	;
	
	private final Supplier<GameApp> factory;
	private final String gameName;
	private final String gameDescription;
	
	private GameMenu(Supplier<GameApp> factory, String gameName, String gameDescription) {
		this.factory = factory;
		this.gameName = gameName;
		this.gameDescription = gameDescription;
	}
	
	public GameApp getGame() {
		return factory.get();
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public String getGameDescription() {
		return gameDescription;
	}
}
