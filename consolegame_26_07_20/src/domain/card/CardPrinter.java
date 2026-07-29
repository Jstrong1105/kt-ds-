package domain.card;

import java.util.List;

/**
 * 카드를 받아 그림을 그리고 출력하는 메소드 
 * OutputWriter 를 사용함
 * 
 * 간단하게 그리는 형태와 
 * 실제 카드처럼 좌상단, 우하단에 모양, 숫자가 있는 형태 구상 중
 */
public interface CardPrinter {
	
	/**
	 * 카드 뭉치를 받아 출력하는 메소드
	 * @param cards 카드 뭉치
	 * @throws IllegalArgumentException 파라미터가 null 혹은 비어 있는 경우 발생
	 */
	void printCard(List<CardView> cards);
}
