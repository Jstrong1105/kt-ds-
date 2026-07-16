package workflow;

public class DiceGameArray {
	
	// 주사위의 최대 값
	private static int MAX_DICE = 10;
	
	// 도착지
	private static int TARGET_ROCATION = 127;
	
	// 플레이어 수
	private static int PLAYER_SIZE = 4;
	
	private static int roleDice() {
		
		int dice1 = (int) (Math.random() * MAX_DICE) + 1;
		int dice2 = (int) (Math.random() * MAX_DICE) + 1;
		
		int total = dice1 + dice2;
		
		if (total % 3 == 0) {
			total *= -1;
		} else if ( dice1 == dice2 ) {
			total *= 2;
		} 
		
		return total;
	}
	
	private static boolean isNotArrive(int[] playerRocation) {
		
		/*
		 * for(int rocation : playerRocation) { 
		 * 	if(rocation >= TARGET_ROCATION) { 
		 * 	return false; 
		 * 	} 
		 * }
		 */
		
		for(int i = 0; i < playerRocation.length; i++) {
			if(playerRocation[i] >= TARGET_ROCATION) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] playerRocations = new int[PLAYER_SIZE];
		
		int round = 0;
		
		int player;
		
		while(true) {
			
			player = round % PLAYER_SIZE; 
			
			int total = roleDice(); 
					
			playerRocations[player] += total;
			
			if(playerRocations[player] < 0) {
				playerRocations[player] = 0;
			}
			System.out.println("이동 거리 : " + total);
			System.out.println("플레이어 " + (player+1) + "의 위치 " + playerRocations[player]);
			
			if(isNotArrive(playerRocations)) {
				round++;
			}else {
				break;
			}
		}
	}
}



























