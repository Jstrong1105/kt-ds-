package domain.card;

import java.util.Objects;

/**
 * 불변 객체인 카드와
 * 가변 값인 오픈 유무를 가진 클래스
 * 이 클래스의 관심사는 오픈 유무 뿐이다.
 * 데이터를 불변 형태로 전달하는 기능 포함
 */
public class PlayCard {
	
	private final Card card;
	private boolean open;
	
	public PlayCard(Card card) {
		// 코드 작성 실수를 잡기 위한 코드
		this.card = Objects.requireNonNull(card);
		this.open = false;
	}	
	
	public void openCard() {
		open = true;
	}
	
	public void hideCard() {
		open = false;
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