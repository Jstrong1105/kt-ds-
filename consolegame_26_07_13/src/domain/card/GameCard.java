package domain.card;

import java.util.Objects;

/**
 * 불변 값인 카드와
 * 가변 값인 open 유무를 담는 클래스
 */
public class GameCard {
	
	// 카드 객체
	private final Card card;
	// 오픈 유무
	private boolean open;
	
	// 생성자
	public GameCard(Card card) {
		this.card = Objects.requireNonNull(card);	
		open = false;
	}
	
	public CardView toView() {
		return new CardView(card, open);
	}
	
	// setter
	public void openCard() {
		open = true;
	}
	
	public void hideCard() {
		open = false;
	}
	
	// getter
	public boolean isOpen() {
		return open;
	}
	
	public Card getCard() {
		return card;
	}
}
