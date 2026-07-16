package domain;

import common.IOUtil;

/**
 * 모든 게임 템플릿이 가지고 있는 공통 기능을 모아둔 추상 클래스
 */
public abstract class GameTemplate implements GameApp{
	
	protected static final String RESTART_MESSAGE = "다시 시작하시겠습니까?";
	protected static final String RESTART_TRUE = "Y";
	protected static final String RESTART_FALSE = "N";
	
	// 게임 실행 흐름 제어 변수
	private boolean running;
	
	protected boolean isRunning() {
		return running;
	}
	
	// 게임 시작 메소드
	protected void startGame() {
		running = true;
	}
	
	// 게임 종료 메소드
	protected void endGame() {
		running = false;
	}
	
	// 게임 다시 시작 메소드
	protected boolean restart() {
		
		return IOUtil.readBoolean(RESTART_MESSAGE,RESTART_TRUE,RESTART_FALSE);
	}
	
	// 게임 초기화 메소드
	protected abstract void init();
	// 게임을 콘솔 화면에 출력하는 메소드
	protected abstract void render();
}
