package domain.game.pokergamble;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import domain.card.CardRank;

/**
 * 족보 판독에 필요한 정보를 담은레코드
 */
record HandData(Map<CardRank, Integer> rankCount
			  , Map<Integer, Integer> groupCount, List<CardRank> rankOrder
			  , boolean flush, List<CardRank> flushOrder) {
	HandData{
		Objects.requireNonNull(rankCount);
		Objects.requireNonNull(groupCount);
		Objects.requireNonNull(rankOrder);
		Objects.requireNonNull(flushOrder);
	}
}
