package domain.card;

import java.util.List;

/**
 * 카드 목록을 받아서 화면에 출력하는 기능을 담당하는 인터페이스
 */
public interface CardPrinter {
	
	// 카드 출력
	void printCard(List<CardView> cards);
}
