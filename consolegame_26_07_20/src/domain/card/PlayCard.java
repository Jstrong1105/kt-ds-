package domain.card;

import java.util.Objects;

/**
 * 불변 상태인 카드와 
 * 가변 상태인 오픈 유무가 있는 클래스
 */
public class PlayCard {
	
	private final Card card;
	private boolean open;
	
	public PlayCard(Card card) {
		this.card = Objects.requireNonNull(card);
		this.open = false;
	}
	
	public void openCard() {
		open = true;
	}
	
	public void hideCard() {
		open = false;
	}
	
	public String getSuitSymbol() {
		return card.suit().getSymbol();
	}
	
	public String getRankSymbol() {
		return card.rank().getSymbol();
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public Card getCard() {
		return card;
	}
	
	public CardView toView() {
		return new CardView(card, open);
	}
}
