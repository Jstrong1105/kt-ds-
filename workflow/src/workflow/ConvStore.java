package workflow;

public class ConvStore {
	
	private static final int A_PRICE = 3000;
	private static final int B_PRICE = 4500;
	
	private static final String SOLD_OUT = "재고수량이 충분하지 않습니다.";
	private static final String NOT_ENOUGH_MONEY = "금액이 부족합니다.";
	
	public static void main(String[] args) {
		
		// A 편의점은 한 종류의 음료수만 판매합니다.
		// 음료수 하나의 가격은 3000원 입니다.
		
		// 5000원을 가지고 있는 손님이 음료수를 3개 구매하려 합니다.
		// 구매할 수 있다면 음료수 가격 X 구매개수 를 출력하고
		// 구매할 수 없다면 "금액이 부족합니다." 를 출력한다.
		
		int money = 5000;
		int count = 3;
		
		System.out.println(buyDrink(money, count,Integer.MAX_VALUE,A_PRICE));
		// 금액이 부족합니다.
		
		// B 편의점은 한 종류의 음료수만 판매합니다.
		// 총 5개의 음료수가 있으며 음료수 하나의 가격은 4500원 입니다.
		
		// 30000원을 가지고 있는 손님이 음료수를 n개 구매하려 합니다.
		// 만약, 손님이 음료수를 5개 이하개를 구매할 수 있으면(금액이 충분하면) 음료수 가격 * 구매개수 를 출력합니다.
		// 그러나 5개 이하개를 구매할 수 없으면(금액이 충분하지 않으면) "금액이 부족합니다." 를 출력합니다.
		// 만약, 손님이 음료수를 6개 구매하려 한다면 "재고수가 충분하지 않습니다." 를 출력합니다.
		
		money = 30000;
		count = 5;
		
		int item = 5;
		
		System.out.println(buyDrink(money, count, item, B_PRICE));
		// 22500

	}
	
	/**
	 * 
	 * @param money  : 손님이 가진 돈
	 * @param count  : 손님이 구매하려는 개수
	 * @param item   : 가게에서 판매 가능한 재고 수량
	 * @param price  : 물품 한개의 가격
	 * @return
	 */
	public static String buyDrink(int money, int count, int item, int price) {
		
		String result = "";
		
		// 구매하려는 수량보다 재고 수량이 적은 경우
		if(count > item) 
			result = SOLD_OUT;
		// 구매하려는 금액보다 보유 금액이 적은 경우
		else if(money < count * price) 
			result = NOT_ENOUGH_MONEY;
		// 구매 가능한 경우
		else 
			result = String.valueOf(count * price);
		
		return result;
	}
}
