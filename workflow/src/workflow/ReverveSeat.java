package workflow;

public class ReverveSeat {
	
	public static void main(String[] args) {
		
		int[] seats = new int[50];
		
		// 랜덤하게 좌석을 배정
		// 0 - 예약 가능한 좌석
		// 1 - 예약 불가능한 좌석
		for(int i = 0; i < seats.length; i++) {
			seats[i] = (int) (Math.random() * 2);
		}
		
		// TODO 배열의 정보 값을 출력
		// 0 0 1 0 1 1 1 1 0 0 1 0 1 0 0 0 1 0 1 1 1 ....
		
		for(int i = 0; i < seats.length; i++) {
			System.out.print(seats[i] + " ");
		}
		
		// TODO 예약 가능한 좌석의 수를 출력
		// n 개의 좌석을 예약할 수 있습니다.
		int n = 0;
		for(int i = 0; i < seats.length; i++) {
			if(seats[i] == 0) {
				n++;
			}
		}
		System.out.println();
		System.out.println(n + " 개의 좌석을 예약할 수 있습니다.");
		
		// TODO 예약 불가능한 좌석의 수를 출력
		// n 개의 좌석이 이미 예약 되어 있습니다.
		n = 0;
		for(int i = 0; i < seats.length; i++) {
			if(seats[i] == 1) {
				n++;
			}
		}
		System.out.println(n + " 개의 좌석이 이미 예약 되어 있습니다.");
		
		String longText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library in London, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software like Aldus PageMaker and Microsoft Word including versions of Lorem Ipsum.";
		char[] letters = longText.toCharArray();
		
		n = 0;
		
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == 's') {
				n++;
			}
		}
		System.out.println("소문자 s 는 " + n + "개 있습니다.");
	}
}
