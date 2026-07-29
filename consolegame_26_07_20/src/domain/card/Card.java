package domain.card;

import java.util.Objects;

/**
 * 트럼프 카드 레코드
 * 불변 형태
 */
public record Card(CardSuit suit, CardRank rank) {
	public Card{
		// 해당 구문에서 에러가 발생한 다는 것은 코드 작성에 문제가 있다는 의미
		// 외부에서 잡아내려는 용도가 아니라 어플을 죽임
		Objects.requireNonNull(suit);
		Objects.requireNonNull(rank);
	}
}
