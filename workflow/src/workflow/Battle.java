package workflow;

public class Battle {
	
	public static void main(String[] args) {
		/*
		 * BOSS 와 PLAYER 가 전투를 합니다.
		 * BOSS 의 체력과 PLAYER 의 체력 중 하나라도 0 이하가 된다면 게임은 종료됩니다.
		 * 
		 * BOSS 가 PLAYER 에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * PLAYER 가 BOSS 에게 공격을 합니다. (데미지는 랜덤한 정수 값)
		 * 
		 * 공격이 끝난 이후 서로의 체력을 출력합니다.
		 */
		
		int bossHp = 100;
		int playerHp = 100;
		
		while(true) {
			
			double damage = Math.random() * 100;
			
			playerHp -= (int) damage;
			
			if(playerHp <= 0) {
				System.out.println("플레이어가 사망했습니다.");
				break;
			}
			
			damage = Math.random() * 100;
			
			bossHp -= (int) damage;
			
			if(bossHp <= 0) {
				System.out.println("보스가 사망했습니다.");
				break;
			}
			
			System.out.println("보스의 체력 : " + bossHp);
			System.out.println("플레이어의 체력 : " + playerHp);
		}
	}
}
