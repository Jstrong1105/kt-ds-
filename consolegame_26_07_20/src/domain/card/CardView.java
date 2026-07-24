package domain.card;

import java.util.Objects;

/**
 * 카드의 정보와 오픈 상태를 불변 상태로 전달하는 뷰
 */
public record CardView(Card card, boolean open) {
	public CardView{
		Objects.requireNonNull(card);
	}
}
