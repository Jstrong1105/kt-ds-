package domain.game.pokergamble;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.card.CardRank;

class HandResultTest {

	private HandResult result;
	private List<CardRank> kickers;
	
	@BeforeEach
	void 초기화() {
		kickers = new ArrayList<>();
	}
	
	@Test
	void 결과_null() {
		assertThrows(NullPointerException.class, () -> result = new HandResult(null, null));
	}

	@Test
	void 키커_null() {
		assertThrows(NullPointerException.class, () -> result = new HandResult(HandRank.BACK_STRAIGHT, null));
	}
	
	@Test
	void 키커수_오류() {
		
		// 키커 수 0
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {	
			result = new HandResult(HandRank.FLUSH, kickers);
		});
		assertEquals(HandResult.NOT_VALID_KICKERS, e.getMessage());
		
		kickers.add(CardRank.ACE);
		kickers.add(CardRank.EIGHT);
		kickers.add(CardRank.FOUR);
		kickers.add(CardRank.JACK);
		
		// 키커 5개여야 하는 FLUSH 에 키커 4개 짜리 넘김
		e = assertThrows(IllegalArgumentException.class, () -> {	
			result = new HandResult(HandRank.FLUSH, kickers);
		});
		assertEquals(HandResult.NOT_VALID_KICKERS, e.getMessage());
	}
	
	@Test
	void 승패판독_족보다름() {
		kickers.add(CardRank.ACE);
		result = new HandResult(HandRank.ROYAL_FLUSH, kickers);
		HandResult o = new HandResult(HandRank.STRAIGHT, kickers);
		assertEquals(1, result.compareTo(o));
	}
	
	@Test
	void 승패판독_키커다름() {
		kickers.add(CardRank.ACE);
		kickers.add(CardRank.KING);
		kickers.add(CardRank.JACK);
		kickers.add(CardRank.FIVE);
		kickers.add(CardRank.THREE);
		result = new HandResult(HandRank.FLUSH, kickers);
		
		List<CardRank> oKickers = new ArrayList<>();
		oKickers.add(CardRank.ACE);
		oKickers.add(CardRank.KING);
		oKickers.add(CardRank.JACK);
		oKickers.add(CardRank.FIVE);
		oKickers.add(CardRank.TWO);
		HandResult o = new HandResult(HandRank.FLUSH, oKickers);
		assertEquals(1, result.compareTo(o));
	}
	
	@Test
	void getShowName_확인() {
		kickers.add(CardRank.ACE);
		result = new HandResult(HandRank.ROYAL_FLUSH, kickers);
		assertEquals("로얄플러시", result.getShowName());
		result = new HandResult(HandRank.STRAIGHT, kickers);
		assertEquals("A 스트레이트", result.getShowName());
		kickers.add(CardRank.FIVE);
		result = new HandResult(HandRank.FULL_HOUSE, kickers);
		assertEquals("A,5 풀하우스", result.getShowName());
	}
}
