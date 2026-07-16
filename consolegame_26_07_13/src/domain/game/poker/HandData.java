package domain.game.poker;

import java.util.List;
import java.util.Map;

import domain.card.CardRank;
import domain.card.CardSuit;

/**
 * 손패를 받은 다음 전처리를 거치고 
 * 정리한 결과를 담을 객체 
 * 
 * 패키지 프라이빗
 */
record HandData(Map<CardSuit, Integer> suitCount, Map<CardRank, Integer> numberCount
		, Map<Integer, Integer> groupCount, List<CardRank> numberOrder
		, Boolean flush, List<CardRank> flushOrder) {

}
