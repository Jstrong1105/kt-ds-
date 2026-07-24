package domain.card;

import java.util.Objects;

/**
 * 트럼프 카드 레코드
 * 모양과 랭크를 가지고 있다.
 */
public record Card(CardSuit suit, CardRank rank) {
	public Card{
		Objects.requireNonNull(suit);
		Objects.requireNonNull(rank);
	}
}
