package domain.card;

import java.util.Objects;

/**
 * 카드의 모양과 숫자, 열림 유무를 불변 형태로 만들어 전달하기 위한 레코드
 */
public record CardView(Card card, boolean open) {
	public CardView{
		// 이 에러는 외부에서 잡아내기 위한 에러가 아닌 개발자 코드 실수를 잡아내기 위한 코드
		Objects.requireNonNull(card);
	}
	
	public String getSuitSymbol() {
		return card.suit().getSymbol();
	}
	
	public String getRankSymbol() {
		return card.rank().getSymbol();
	}
}
