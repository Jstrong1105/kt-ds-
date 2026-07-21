package com.ktdsuniversity.edu.oop.vendingmachine;

/**
 * 자판기
 * 음료가 들어있는 자판기에 돈을 넣고 음료의 번호를 입력하면
 * 음료가 추출된다.
 * 거스름돈이 남았을 경우 사용자에게 돌려준다.
 */
public class VendingMachine {
	
	ItemHolder holder;
	
	public VendingMachine(ItemHolder holder) {
		this.holder = holder;
	}
	
	// 자판기에 새로운 라면을 추가한다. 
	public void addNewItem(int index, Item newItem) {
		holder.items[index] = newItem;
	}
	
	public static void main(String[] args) {
		Item[] 라면들 = new Item[10];
		라면들[0] = new Item("ITEM-1", "진라면 매운맛", 4800, 5);
		라면들[1] = new Item("ITEM-2", "불닭 매운면", 4300, 3);
		라면들[2] = new Item("ITEM-3", "진라면 순한맛", 4800, 7);
		ItemHolder 라면홀더 = new ItemHolder(라면들);
		VendingMachine 한강라면 = new VendingMachine(라면홀더);
		
		한강라면.addNewItem(3, new Item("ITEM-4", "진라면 약간매운맛", 4800, 2));
	}
}
