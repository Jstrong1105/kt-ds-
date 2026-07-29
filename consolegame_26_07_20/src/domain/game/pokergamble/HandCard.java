package domain.game.pokergamble;

import java.util.List;

import domain.card.Card;
import domain.card.CardView;
import domain.card.PlayCard;

/**
 * 각각의 플레이어의 손에 있는 카드를 관리하는 인터페이스
 */
interface HandCard {
	
	/** 카드 초기화 */
	void clear();
	
	/** 카드 추가하기 */
	void addCard(PlayCard card);
	
	/** 가지고 있는 카드 개수 반환 */
	int getSize();
	
	/** 모든 카드 오픈하기 */
	void openAll();
	
	/** 출력을 위한 정보 반환 */
	List<CardView> getCardView();
	
	/** 판독을 위한 정보 반환 */
	List<Card> getCard();
}
