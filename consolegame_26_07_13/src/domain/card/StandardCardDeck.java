package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * CardDeck 인터페이스를 구현한 클래스
 * 
 * 카드 생성 및 셔플, 드로우 기능 구현
 */
public class StandardCardDeck implements CardDeck{
	
	// 에러 메시지
	private static final String DECK_EMPTY_ERROR = "카드 덱이 비어있습니다.";

	// 카드 덱 객체
	private final List<Card> cardDeck;
	
	// 랜덤 객체
	private final Random random;
	
	// 기본 생성자
	public StandardCardDeck() {
		this(new Random());
	}
	
	// 테스트를 위한 랜덤 객체 주입 생성자
	public StandardCardDeck(Random random) {
		this.cardDeck = new ArrayList<>();
		this.random = random;
		init();
	}
	
	// 카드 생성 및 셔플
	@Override
	public void init() {
		
		// 기존 카드 덱 정리
		cardDeck.clear();
		
		// 52장 카드 생성
		for(CardSuit suit : CardSuit.values()) {
			for(CardRank rank : CardRank.values()) {
				cardDeck.add(new Card(suit,rank));
			}
		}
		
		// 카드 셔플
		Collections.shuffle(cardDeck,random);
	}
	
	// 카드 드로우
	@Override
	public Card drawCard() {
		// 빈 카드덱 검사
		if(cardDeck.isEmpty()) {
			throw new IllegalStateException(DECK_EMPTY_ERROR);
		}
		
		// 앞에서 부터 나누어주면 모든 카드를 한칸씩 당겨와야 하는 손해가 발생하기 때문에
		// 뒤에서 부터 나누어줌
		return cardDeck.removeLast();
	}
}
