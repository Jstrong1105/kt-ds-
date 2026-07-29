package domain.game.pokergamble;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;
import domain.card.CardView;
import domain.card.PlayCard;

/**
 * HandCard 인터페이스를 구현한 클래스
 * 
 * 손패 관리, 출력 정보, 카드 정보 등을 반환 하는 기능을 수행
 */
class DefaultHandCard implements HandCard {

	private List<PlayCard> cards;
	
	public DefaultHandCard() {
		this.cards = new ArrayList<>();
	}
	
	@Override
	public void clear() {
		cards.clear();
	}
	
	@Override
	public void addCard(PlayCard card) {
		cards.add(card);
	}

	@Override
	public int getSize() {
		return cards.size();
	}

	@Override
	public void openAll() {
		cards.stream()
			 .forEach(PlayCard::openCard);
	}
	
	@Override
	public List<CardView> getCardView() {
		return cards.stream()
					.map(PlayCard::toView)
					.toList();
	}

	@Override
	public List<Card> getCard() {
		return cards.stream()
					.map(PlayCard::getCard)
					.toList();
	}
}
