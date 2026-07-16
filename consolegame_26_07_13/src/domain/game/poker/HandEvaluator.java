package domain.game.poker;

import java.util.List;

import domain.card.Card;

/**
 * 카드 뭉치를 받아서 족보를 판독해
 * 5장 or 7장
 * 결과를 반환하는 기능을 수행하는 인터페이스
 */
interface HandEvaluator {
	
	HandResult evaluate(List<Card> cards);
}
