package workflow;

public class CU {

	// 포인트 결제 메소드
	public static int buyPoint(int amount, int point) {
		
		int pointToUse = point;
		if (point >= amount) {
			pointToUse = amount;
		}
		point -= pointToUse;
		amount -= pointToUse;
		
		System.out.println("차감 포인트: " + pointToUse);
		System.out.println("잔여 포인트: " + point);
		System.out.println("잔여 결제 금액: " + amount);
		
		return amount;
	}
	
	// 체크 카드 결제 메소드
	public static int buyCheckCard(int amount, int remainAccount) {
		
		if (remainAccount < amount) {
			System.out.println("잔액이 부족합니다.");
			return amount;
		} else {
			remainAccount -= amount;
			System.out.println("체크카드 결제 완료");
			System.out.println("계좌 잔액: " + remainAccount);
			return 0;
		}
	}
	
	// 5만원 이상 신용 카드 결제 서명 메소드
	public static void creditSign(int amount) {
		System.out.println("할부 / 일시불?");
		// 할부 == 0, 일시불 == 1
		int payType = (int)(Math.random() * 2);
		if (payType == 0) {
			System.out.println("할부를 선택했습니다.");
			int duration = (int)(Math.random() * 4) + 2;
			System.out.println(duration + "개월 할부 결제 합니다.");
			System.out.println(duration + "개월 동안 월 " + (amount / duration) + "원 결제 합니다.");
		} else {
			System.out.println("일시불을 선택했습니다.");
		}
		System.out.println("서명하세요.");
	}
	
	// 신용 카드 결제 메소드
	public static int buyCreditCard(int amount,int CARD_LIMIT, int cardPaidMoney) {
		
		if (amount >= 50_000) {
			creditSign(amount);
		}
		
		if (CARD_LIMIT < amount + cardPaidMoney) {
			System.out.println("한도 초과!");
			return amount;
		} else {
			// 신용카드로 결제했을 때 카드 결제금액을 최종 결제 금액만큼 증가.
			cardPaidMoney += amount;
			System.out.println("신용카드 결제 완료");
			System.out.println("현재 사용금액: " + cardPaidMoney);
			return 0;
		}
	}
	
	// 현금 결제 메소드
	public static int buyCash(int cash, int amount) {
		
		if (cash >= amount) {
			System.out.println("남은 잔액: " + ( cash - amount ) + "원");
			return 0;
		} else {
			System.out.println("현금이 부족합니다.");
			return amount;
		}
	}
	
	// 결제 기능을 수행하는 메소드
	public static int pay(int amount, int cash, int CARD_LIMIT
			, int cardPaidMoney, int remainAccount, int point) {
		
		int payment = (int) (Math.random() * 5);
		System.out.println("결제를 시작합니다.");
		System.out.println("결제 금액: " + amount);
		System.out.println();
		
		// 결제 수단 선택
		if (payment == 0) {
			System.out.println("현금 결제 선택");
			System.out.println("현재 잔액: " + cash + "원");
			// 현금으로 결제했을 때 보유한 현금을 최종 결제 금액만큼 차감
			// TODO 현금 결제 기능을 하는 메소드 작성
			// TODO amount = 현금 결제 후 잔여 결제 금액을 반환
			amount = buyCash(cash, amount);
			
		} else if (payment == 1) {
			System.out.println("신용 카드 결제 선택");
			// 신용카드 & 결제금액 5만원 이상일 경우 할부 또는 일시불 선택
			// TODO 신용카드 결제 기능을 하는 메소드 작성
			// TODO amount = 신용카드 결재 후 잔여 결제 금액을 반환
			amount = buyCreditCard(amount, CARD_LIMIT, cardPaidMoney);
			
		} else if (payment == 2) {
			System.out.println("체크 카드 결제 선택");
			// TODO 체크카드 결제 기능을 하는 메소드 작성
			// TODO amount = 체크카드 결제 후 잔여 결제 금액을 반환
			amount = buyCheckCard(amount, remainAccount);
			
		} else if (payment == 3) {
			// TODO 포인트 선결제 기능을 하는 메소드 작성
			// TODO amount = 포인트 선결제 후 잔여 결제 금액을 반환
			System.out.println("포인트 선결제 선택");
			// 포인트 선결제 했을 때 포인트를 최종 결제 금액만큼 차감.
			amount = buyPoint(amount, point);
			
		} else {
			System.out.println("결제 포기 선택");
			amount = 0;
		}
		
		// 남은 잔여 결재 금액
		return amount;
	}
	
	// 적립될 포인트 계산하기
	public static int addPoint(int amount) {
		
		int earnPoint = (int)(amount * 0.1f);
		
		System.out.println("적립 포인트: " + earnPoint + "점");
		
		return earnPoint;
	}
	
	// 할인률이 적용된 구매 금액 계산하기
	public static int buyItems(int[] items, float[] dc) {
		
		int amount = 0;
		
		for (int i = 0; i < items.length; i++) {
			int itemPrice = (int) (items[i] * (1 - dc[i]));
			amount += itemPrice;
		}
		
		return amount;
	}
	
	// 구매해야하는 봉투의 수를 구하고
	// 해당 개수의 가격을 구하기
	public static int buyPlasticBag(int[] items, int SPLIT_COUNT, int BAG_PRICE ) {
		
		int bagCount = items.length / SPLIT_COUNT;
		if (items.length % SPLIT_COUNT > 0) {
			bagCount++;
		}
		
		System.out.println("봉투 " + bagCount + "개 구매");
		System.out.println("봉투가격: " + bagCount * BAG_PRICE + "원");
		
		return bagCount * BAG_PRICE;
	}
	
	public static void main(String[] args) {
		// 편의점.drawio 파일을 토대로 작성한 코드.
		
		// 시작.
		// 손님이 바구니에 담아온 상품의 가격 정보.
		int[] items = new int[5];
		items[0] = 5000;
		items[1] = 1800;
		items[2] = 3200;
		items[3] = 30000;
		items[4] = 1300;
		
		// 손님이 바구니에 담아온 상품의 할인 정보
		float[] dc = new float[5];
		dc[0] = 0;
		dc[1] = 0.1f; // 1800원 상품을 10% 할인.
		dc[2] = 0.2f; // 3200원 상품을 20% 할인.
		dc[3] = 1; // 30000원 상품을 100% 할인.
		dc[4] = 0;
		
		// 봉투가격
		final int BAG_PRICE = 100;
		// 한 봉투에 넣을 수 있는 상품의 수
		final int SPLIT_COUNT = 2;
		
		// 고객의 자금 상황
		// 카드 한도
		final int CARD_LIMIT = 1_000_000;
		// 현재까지 사용한 카드 결제 금액
		int cardPaidMoney = 150_000;
		
		// 체크 카드 계좌 잔액
		int remainAccount = 4000;
		
		// 보유한 현금
		int cash = 30_000;
		
		// 보유한 포인트
		int point = 1_750;
		
		// 최종 결제 금액
		int amount = 0;
		
		// 봉투 필요여부(필요 == 0, 불필요 == 1)
		int needBag = (int) (Math.random() * 2);
		if (needBag == 0) {
			amount += buyPlasticBag(items, SPLIT_COUNT, BAG_PRICE);
		}
		
		// 손님이 가져온 상품 목록의 결제 금액 계산해서 amount에 할당.
		// 할인율 계산 필요.
		amount += buyItems(items, dc);
		
		System.out.println("결제 금액: " + amount + "원");
		System.out.println();
		
		// 포인트 적립 (0 ==> 적립, 1 ==> 적립 안함)
		int addPoint = (int) (Math.random() * 2);
		// 적립을 할 경우 (addPoint == 0)이라면 총 결제 금액에서 10% 적립.
		if (addPoint == 0) {
			point += addPoint(amount);
			System.out.println("누적 포인트: " + point + "점");
			System.out.println();
		}
		
		// 결제 수단 선택 (0 ==> 현금, 1 ==> 신용카드, 2 ==> 체크카드, 3 ==> 포인트 선결제, 4 ==> 포기)
		while (amount > 0) {
			amount = pay(amount, cash, CARD_LIMIT, cardPaidMoney, remainAccount, point);
		}
	}
	
}