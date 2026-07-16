package domain;

/**
 * 한번의 루프에서 두번의 액션이 발생하는 게임 템플릿
 * ex : 지뢰찾기
 * 1번째 액션 : 한칸 선택
 * 2번째 액션 : 열기, 깃발 설치하기, 찬스 사용하기
 * 
 * 실행 흐름을 상위 클래스에서 결정하는 템플릿 메소드 패턴
 */
public abstract class DoubleActionTemplate extends GameTemplate{

	@Override
	public final void run() {
		
		// 최초 1회 재시작 여부 없이 시작
		do {
			
			// 데이터 초기화
			init();
			
			// 게임 루프 변수 설정
			startGame();
			
			while(isRunning()) {
				
				// 화면 출력
				render();
				// 첫번째 액션
				// 첫번째 액션에서 게임이 종료되지 않음
				firstAction();
				// 화면 출력
				render();
				// 두번째 액션
				secondAction();
			}
			
		} while (restart());
	}

	// 첫번째 액션
	protected abstract void firstAction();
	// 두번째 액션
	protected abstract void secondAction();
}
