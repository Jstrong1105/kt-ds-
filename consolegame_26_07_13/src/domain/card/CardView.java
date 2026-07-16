package domain.card;

import java.util.Objects;

/**
 * CardPrinter 에서 사용할 카드의 정보를 담는 record
 * 객체 자체를 넘기면 받은 쪽에서 정보를 수정할 수 있기 때문에
 * 객체의 정보를 reocrd 로 구성한 뒤 넘겨 수정할 수 없도록 만듬
 */
public record CardView(Card card, boolean open) {
	public CardView{
		Objects.requireNonNull(card);
	}
	
	public String getSuitSymbol() {
		return card.suit().getSymbol();
	}
	
	public String getSuitColor() {
		return card.suit().getColor();
	}
	
	public String getRankSymbol() {
		return card.rank().getSymbol();
	}
	
	public int getRankOrder() {
		return card.rank().getOrder();
	}
}
