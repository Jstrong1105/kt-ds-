package domain.game.pokergamble;

import java.util.List;

import domain.card.Card;

/**
 * 카드 뭉치를 받아서 족보를 판독하고 그 결과를 반환하는 기능을 수행하는 인터페이스
 */
interface HandEvaluator {
	
	/**
	 * 판독 메소드
	 * @param cards 판독할 카드 뭉치
	 * @return 판독한 결과
	 * @throws IllegalArgumentException 파라미터가 null 이거나 5장 미만인 경우 발생
	 */
	HandResult evaluate(List<Card> cards);
}
