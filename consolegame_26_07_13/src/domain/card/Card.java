package domain.card;

import java.util.Objects;

/**
 * 카드 한장을 나타내는 record 
 */
public record Card(CardSuit suit, CardRank rank) {
	
	public Card{
		Objects.requireNonNull(suit);
		Objects.requireNonNull(rank);
	}
}
