package domain.game.poker;

import java.util.List;
import java.util.Objects;

import domain.card.CardRank;

/**
 * 판독 결과를 담을 객체 선언
 * 
 * 패키지 프라이빗
 */
record HandResult(HandRank rank, List<CardRank> kickers) implements Comparable<HandResult>{
	
	// 에러 메시지
	private static final String KICKER_COUNT_ERROR = "키커 수가 유효하지 않습니다.";
	
	HandResult{
		Objects.requireNonNull(kickers);
		kickers = List.copyOf(kickers);
		if(rank.getKickerCount() != kickers.size()) {
			throw new IllegalArgumentException(KICKER_COUNT_ERROR);
		}
	}
	
	// 비교메소드 재구성
	@Override
	public int compareTo(HandResult o) {
		// 족보 비교
		int result = this.rank.getRankPower() - o.rank.getRankPower();
		// 족보가 다르다면 족보 비교 결과 반환
		if(result != 0) {
			return result;
		}
		// 족보가 같다면 
		for(int i = 0; i < kickers.size(); i++) {
			// 키커를 순서대로 비교
			result = this.kickers.get(i).getOrder() - o.kickers.get(i).getOrder();
			// 키커가 다르다면 키커 비교 결과 반환
			if(result != 0) {
				return result;
			}
		}
		// 키커까지 전부 같다면 무승부
		return 0;
	}
	
	@Override
	public String toString() {
		return switch (rank) {
			case ROYAL_FLUSH, MOUNTAIN, BACK_STRAIGHT -> rank.getRankName();
			case STRAIGHT_FLUSH, FLUSH, STRAIGHT, THREE_OF_A_KIND, ONE_PAIR, HIGH_CARD
			, FOUR_OF_A_KIND ->  kickers.get(0).getSymbol() + " " + rank.getRankName();
			case FULL_HOUSE, TWO_PAIR -> 
					kickers.get(0).getSymbol() + "," 
					+ kickers.get(1).getSymbol() 
					+ " " + rank.getRankName();
		};
	}
}
