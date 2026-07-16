package domain;

/**
 * 라운드를 반복하다가
 * 특정 조건을 만족하면 종료하는 흐름을 가진 템플릿
 */
public abstract class RoundActionTemplate extends GameTemplate{
	
	private boolean roundRunning;
	
	@Override
	public final void run() {
		
		do {
			
			// 게임 데이터 초기화
			init();
			
			// 게임 루프 변수 설정
			startGame();
			
			while(isRunning()) {
				
				roundInit();
				startRound();
				
				while(roundRunning) {
					
					render();
					play();
					update();
				}
				
				check();
			}
			
		} while (restart());
	}
	
	protected void startRound() {
		roundRunning = true;
	}
	
	protected void endRound() {
		roundRunning = false;
	}
	// 라운드 시작 전 초기화
	protected abstract void roundInit();
	
	// 액션
	protected abstract void play();
	
	// 액션에 대한 처리
	protected abstract void update();
	
	// 라운드 종료 이후 검사
	protected abstract void check();
}
