package domain.game.poker;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;
import domain.card.CardView;
import domain.card.GameCard;

/**
 * Hand 인터페이스를 구현한 클래스
 * 
 * 패키지 프라이빗
 */
class DefaultHand implements Hand {
	
	// 한명의 플레이어가 가지고 있는 손패 목록
	private final List<GameCard> hand;
	
	// 생성자
	DefaultHand() {
		this.hand = new ArrayList<>();
	}
	
	@Override
	public void clear() {
		hand.clear();
	}
	
	@Override
	public void addCard(GameCard card) {
		hand.add(card);
	}
	
	@Override
	public int size() {
		return hand.size();
	}
	
	@Override
	public void openCard(int index) {
		hand.get(index).openCard();
	}
	
	@Override
	public void openAllCard() {
		hand.stream().forEach(GameCard::openCard);
	}
	
	@Override
	public List<Card> getCards() {
		return hand.stream()
				   .map(GameCard::getCard)
				   .toList();
	}
	
	@Override
	public List<CardView> getViews() {
		return hand.stream()
				   .map(GameCard::toView)
				   .toList();
	}
}
