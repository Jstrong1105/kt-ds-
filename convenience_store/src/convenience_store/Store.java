package convenience_store;

/**
 * 편의점
 */
public class Store {

	/**
	 * 상품을 보관하는 창고
	 */
	Item[] garage = new Item[6];
	
	/**
	 * 진열장 A
	 */
	Display sectionA = new Display();
	
	/**
	 * 진열장 B
	 */
	Display sectionB = new Display();
	
	/**
	 * 직원 A
	 */
	Employee kim = new Employee();
	
	/**
	 * 직원 B
	 */
	Employee lee = new Employee();
	
	/**
	 * 잔고
	 */
	int safe = 40_000;
	
	// 상품을 입고시킨다. ==> 창고에 상품을 추가한다.
	/**
	 * 편의점의 창고에 상품을 입고시킨다.
	 * 
	 * @param index 창고의 칸 번호
	 * @param itemName 입고된 상품의 이름
	 * @param itemPrice 입고된 상품의 가격
	 * @param stock 입고된 상품의 개수
	 */
	public void storeItem(int index, String itemName, int itemPrice, int stock) {
		garage[index] = new Item();
		garage[index].name = itemName;
		garage[index].price = itemPrice;
		garage[index].stock = stock;
	}
	
	// 어떤 아이템을 어디에 몇개 진열할것이냐.
	/**
	 * 상품 진열
	 * @param itemIndex 창고에 입고된 상품의 인덱스번호
	 * @param sectionName 진열대 이름 (A: A진열대, B: B진열대)
	 * @param displayCount 진열할 상품의 개수
	 */
	public void displayItem(int itemIndex, String sectionName, int displayCount) {
		garage[itemIndex].stock -= displayCount;
		if (sectionName.equals("A")) {
			for (int i = 0; i < sectionA.items.length; i++) {
				if (sectionA.items[i] == null) {
					sectionA.items[i] = new Item();
					sectionA.items[i].name = garage[itemIndex].name;
					sectionA.items[i].price = garage[itemIndex].price;
					sectionA.items[i].stock = displayCount;
					break;
				}
			}
//			int sectionIndex = (int) (Math.random() * sectionA.items.length);
//			sectionA.items[sectionIndex] = new Item();
//			sectionA.items[sectionIndex].name = garage[itemIndex].name;
//			sectionA.items[sectionIndex].price = garage[itemIndex].price;
//			sectionA.items[sectionIndex].stock = displayCount;
		} else if (sectionName.equals("B")) {
			for (int i = 0; i < sectionB.items.length; i++) {
				if (sectionB.items[i] == null) {
					sectionB.items[i] = new Item();
					sectionB.items[i].name = garage[itemIndex].name;
					sectionB.items[i].price = garage[itemIndex].price;
					sectionB.items[i].stock = displayCount;
					break;
				}
			}
//			int sectionIndex = (int) (Math.random() * sectionB.items.length);
//			sectionB.items[sectionIndex] = new Item();
//			sectionB.items[sectionIndex].name = garage[itemIndex].name;
//			sectionB.items[sectionIndex].price = garage[itemIndex].price;
//			sectionB.items[sectionIndex].stock = displayCount;
		}
	}
	
	/**
	 * 상품을 판매한다.
	 * @param sectionName 진열대 이름 (A: A진열대, B: B진열대)
	 * @param sectionItemIndex 진열대의 상품 인덱스
	 * @param sellCount 판매 개수
	 */
	public void sell(String sectionName, int sectionItemIndex, int sellCount) {
		if (sectionName == "A") {
			int itemStock = sectionA.items[sectionItemIndex].stock;
			if (itemStock >= sellCount) {
				sectionA.items[sectionItemIndex].stock -= sellCount;
				safe += sectionA.items[sectionItemIndex].price * sellCount;
			}
		} else if (sectionName == "B") {
			int itemStock = sectionB.items[sectionItemIndex].stock;
			if (itemStock >= sellCount) {
				sectionB.items[sectionItemIndex].stock -= sellCount;
				safe += sectionB.items[sectionItemIndex].price * sellCount;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Store gs25 = new Store();
		gs25.storeItem(0, "하리보 스타믹스", 2000, 10);
		gs25.storeItem(1, "포카칩 오리지널", 1500, 5);
		gs25.storeItem(2, "프링글스 오리지널", 3500, 8);
		gs25.storeItem(3, "초코송이", 1200, 16);
		
		gs25.displayItem(0, "A", 5); // 하리보 스타믹스를 A 진열대에 5개 진열
		gs25.displayItem(1, "A", 3); // 포카칩 오리지널을 A 진열대에 3개 진열
		gs25.displayItem(2, "B", 4); // 프링글스 오리지널을 B 진열대에 4개 진열
		gs25.displayItem(3, "B", 10); // 초코송이를 B 진열대에 10개 진열
		
		gs25.kim.name = "김경환";
		gs25.kim.salary = 15000;
		gs25.kim.time = 45;
		
		gs25.lee.name = "이동욱";
		gs25.lee.salary = 15000;
		gs25.lee.time = 37;
		
		gs25.sell("A", 0, 3); // A 진열대의 0번 칸의 상품을 3개 판매
		gs25.sell("B", 1, 2); // B 진열대의 1번 칸의 상품을 2개 판매
	}
	
}