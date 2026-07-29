package domain.game.pokergamble;

import java.util.List;
import java.util.Objects;

import domain.card.CardRank;

/**
 * 족보 판독 결과를 저장할 레코드
 */
record HandResult(HandRank rank, List<CardRank> kickers) {
	
	// 테스트를 위한 패키지 프라이빗
	static final String NOT_VALID_KICKERS = "키커 수가 유효하지 않습니다.";
	
	HandResult{
		Objects.requireNonNull(rank);
		Objects.requireNonNull(kickers);
		
		if(kickers.size() != rank.getKickerCount()) {
			throw new IllegalArgumentException(NOT_VALID_KICKERS);
		}
	}
	
	int compareTo(HandResult o) {
		int result = Integer.compare(this.rank.getOrder(), o.rank.getOrder());
		if(result != 0) {
			return result;
		} else {
			for(int i = 0; i < this.kickers.size(); i++) {
				result = Integer.compare(this.kickers.get(i).getOrder(), o.kickers.get(i).getOrder());
				if(result != 0) {
					return result;
				}
			}
			return result;
		}
	}
	
	String getShowName() {
		return rank.getShowName(kickers);
	}
}
