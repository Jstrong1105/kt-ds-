package workflow;

/**
 * 주사위를 굴려 최종 목적지에 먼저 도착하는 플레이어가 승리하는 게임
 * 
 * 위치 값을 가진 4명의 플레이어가 있습니다.
 * 모든 플레이어들의 위치 값은 0부터 시작합니다.
 * 
 * 각 플레이어들은 주사위 두 개를 굴려 나온 수 만큼 이동을 합니다.
 * 도착지의 위치 값은 127 입니다.
 * 
 * ==== 주사위 규칙 ====
 * 1. 두 개의 주사위를 굴린 값이 3, 7 이라면 위치 값은 10 만큼 증가합니다.
 * 2. 두 주사위가 똑같은 숫자가 나온다면 주사위 합의 배수 만큼 이동합니다.
 * 3. 두 주사위 값의 합이 3의 배수일 경우 위치 값은 합의 수 만큼 감소합니다.
 * 
 * 플레이어의 위치 값은 0보다 작아질 수 없습니다.
 * - 현재 위치 값이 8이고, 이동할 칸의 수가 -9 라면, 위치 값은 0이 되어야 합니다.
 * 
 * 플레이어가 주사위를 굴릴 때 마다 주사위의 값, 이동할 칸의 수, 현재 위치 값을 표시합니다.
 */
public class DiceGame {
	
	// 주사위의 최대 값
	private static int MAX_DICE = 10;
	
	// 도착지
	private static int TARGET_ROCATION = 127;
	
	public static void main(String[] args) {
		
		// 4명의 플레이어
		int player1Rocation = 0;
		int player2Rocation = 0;
		int player3Rocation = 0;
		int player4Rocation = 0;
		
		// 두 개의 주사위와 합을 담을 변수
		int dice1 = 0;
		int dice2 = 0;
		int total = 0;
		
		while (true) {
			
			// ============= player1 =====================
			// 주사위 던지기
			// 1 ~ MAX_DICE
			dice1 = (int) (Math.random() * MAX_DICE) + 1;
			dice2 = (int) (Math.random() * MAX_DICE) + 1;
			
			System.out.println("주사위 1 : " + dice1);
			System.out.println("주사위 2 : " + dice2);
			
			// 주사위의 합 구하기
			total = dice1 + dice2;
			
			// 두 주사위의 합이 3의 배수라면
			// 규칙 3
			if ( ( total % 3 ) == 0 ) {
				player1Rocation -= total;
				
				System.out.println("player1 이 이동할 거리는 -" + total + "입니다.");
				
				// 위치가 음수가 된다면
				if(player1Rocation < 0) {
					player1Rocation = 0;
				}
			}
			// 두 주사위가 같다면
			// 규칙 2
			else if (dice1 == dice2) {
				player1Rocation += (total * 2);
				
				System.out.println("player1 이 이동할 거리는 " + (total*2) + "입니다.");
			}
			// 규칙 1
			else {
				player1Rocation += total;
				
				System.out.println("player1 이 이동할 거리는 " + total + "입니다.");
			}
			
			System.out.println("player1 의 위치는 " + player1Rocation + "입니다.");
			
			// player1 이 규칙에 따라 주사위를 던진 후 도착지에 도착했다면
			if(player1Rocation >= TARGET_ROCATION) {
				System.out.println("player1 이 승리했습니다.");
				break;
			}
			
			// ============= player2 =====================
			// 주사위 던지기
			// 1 ~ MAX_DICE
			dice1 = (int) (Math.random() * MAX_DICE) + 1;
			dice2 = (int) (Math.random() * MAX_DICE) + 1;
			
			System.out.println("주사위 1 : " + dice1);
			System.out.println("주사위 2 : " + dice2);
			
			// 주사위의 합 구하기
			total = dice1 + dice2;
			
			// 두 주사위의 합이 3의 배수라면
			// 규칙 3
			if ( ( total % 3 ) == 0 ) {
				player2Rocation -= total;
				
				System.out.println("player2 가 이동할 거리는 -" + total + "입니다.");
				
				// 위치가 음수가 된다면
				if(player2Rocation < 0) {
					player2Rocation = 0;
				}
			}
			// 두 주사위가 같다면
			// 규칙 2
			else if (dice1 == dice2) {
				player2Rocation += (total * 2);
				
				System.out.println("player2 가 이동할 거리는 " + (total*2) + "입니다.");
			}
			// 규칙 1
			else {
				player2Rocation += total;
				
				System.out.println("player2 가 이동할 거리는 " + total + "입니다.");
			}
			
			System.out.println("player2 의 위치는 " + player2Rocation + "입니다.");
			
			// player2 이 규칙에 따라 주사위를 던진 후 도착지에 도착했다면
			if(player2Rocation >= TARGET_ROCATION) {
				System.out.println("player2 이 승리했습니다.");
				break;
			}
			
			// ============= player3 =====================
			// 주사위 던지기
			// 1 ~ MAX_DICE
			dice1 = (int) (Math.random() * MAX_DICE) + 1;
			dice2 = (int) (Math.random() * MAX_DICE) + 1;
			
			System.out.println("주사위 1 : " + dice1);
			System.out.println("주사위 2 : " + dice2);
			
			// 주사위의 합 구하기
			total = dice1 + dice2;
			
			// 두 주사위의 합이 3의 배수라면
			// 규칙 3
			if ( ( total % 3 ) == 0 ) {
				player3Rocation -= total;
				
				System.out.println("player3 이 이동할 거리는 -" + total + "입니다.");
				
				// 위치가 음수가 된다면
				if(player3Rocation < 0) {
					player3Rocation = 0;
				}
			}
			// 두 주사위가 같다면
			// 규칙 2
			else if (dice1 == dice2) {
				player3Rocation += (total * 2);
				
				System.out.println("player3 이 이동할 거리는 " + (total*2) + "입니다.");
			}
			// 규칙 1
			else {
				player3Rocation += total;
				
				System.out.println("player3 이 이동할 거리는 " + total + "입니다.");
			}
			
			System.out.println("player3 의 위치는 " + player3Rocation + "입니다.");
			
			// player3 이 규칙에 따라 주사위를 던진 후 도착지에 도착했다면
			if(player3Rocation >= TARGET_ROCATION) {
				System.out.println("player3 이 승리했습니다.");
				break;
			}
			
			// ============= player4 =====================
			// 주사위 던지기
			// 1 ~ MAX_DICE
			dice1 = (int) (Math.random() * MAX_DICE) + 1;
			dice2 = (int) (Math.random() * MAX_DICE) + 1;
			
			System.out.println("주사위 1 : " + dice1);
			System.out.println("주사위 2 : " + dice2);
			
			// 주사위의 합 구하기
			total = dice1 + dice2;
			
			// 두 주사위의 합이 3의 배수라면
			// 규칙 3
			if ( ( total % 3 ) == 0 ) {
				player4Rocation -= total;
				
				System.out.println("player4 가 이동할 거리는 -" + total + "입니다.");
				
				// 위치가 음수가 된다면
				if(player4Rocation < 0) {
					player4Rocation = 0;
				}
			}
			// 두 주사위가 같다면
			// 규칙 2
			else if (dice1 == dice2) {
				player4Rocation += (total * 2);
				
				System.out.println("player4 가 이동할 거리는 " + (total*2) + "입니다.");
			}
			// 규칙 1
			else {
				player4Rocation += total;
				
				System.out.println("player4 가 이동할 거리는 " + total + "입니다.");
			}
			
			System.out.println("player4 의 위치는 " + player4Rocation + "입니다.");
			
			// player4 이 규칙에 따라 주사위를 던진 후 도착지에 도착했다면
			if(player4Rocation >= TARGET_ROCATION) {
				System.out.println("player4 이 승리했습니다.");
				break;
			}
		}
	}
}



























