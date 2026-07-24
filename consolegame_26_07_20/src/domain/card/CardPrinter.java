package domain.card;

import java.util.List;

/**
 * 카드뷰 목록을 받아서 출력하는 인터페이스
 */
public interface CardPrinter {

	void printCard(List<CardView> cards);
}
