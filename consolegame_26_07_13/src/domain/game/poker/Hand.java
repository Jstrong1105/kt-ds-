package domain.game.poker;

import java.util.List;

import domain.card.Card;
import domain.card.CardView;
import domain.card.GameCard;

/**
 * 플레이어 한명이 가지고 있는 카드를 관리하는 기능을 수행하는 인터페이스
 * 
 * 패키지 프라이빗
 */
interface Hand {
	
	// 초기화
	void clear();
	
	// 카드 받기
	void addCard(GameCard card);
	
	// 카드 개수 반환하기
	int size();
	
	// 카드 오픈하기
	void openCard(int index);
	
	// 모든 카드 오픈하기
	void openAllCard();
	
	// 족보 계산을 위한 카드 정보 반환
	List<Card> getCards();
	
	// 화면에 출력하기 위한 카드 정보 반환
	List<CardView> getViews();
}
