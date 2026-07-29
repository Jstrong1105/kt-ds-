package domain.game.pokergamble;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import domain.card.Card;
import domain.card.CardRank;
import domain.card.CardSuit;

/**
 * HandEvaluator 인터페이스를 구현한 구현 클래스 
 * 
 * 5 장 혹은 7 장 기준 구현되었음
 * 9 장 까지 가능하지만
 * 10장 부터는 flush 관련 판독에서 부정확한 판정이 발생할 수 있음
 */
class DefaultHandEvaluator implements HandEvaluator {

	// 테스트를 위한 패키지 프라이빗
	static final String NOT_VALID_CARDS = "판독할 수 없는 카드입니다.";
	static final String FAIL_EVALUATE = "족보 판독에 실패했습니다.";
	
	private final List<Function<HandData, Optional<HandResult>>> evals = List.of(
		this::evalStraightFlush
		, this::evalFourOfAKind
		, this::evalFullHouse
		, this::evalFlush
		, this::evalStraight
		, this::evalThreeOfAKind
		, this::evalTwoPair
		, this::evalOnePair
		, this::evalHighCard
	);
	
	@Override
	public HandResult evaluate(List<Card> cards) {
		
		if(cards == null || cards.size() < 5) {
			throw new IllegalArgumentException(NOT_VALID_CARDS);
		}
		
		HandData data = prepareData(cards);
		
		// 아래 구문을 완전히 이해하기 전까지 주석 유지
		// flatMap 을 학습하고 구현한 방식
		// evals: List<Function<HandData, Optional<HandRank>>>
		// evals.stream(): Stream<Function<HandData, Optional<HandRank>>>
		// .flatMap()
		// f.apply(data): Optional<HandRank>
		// Optional<HandRank>.stream(): Stream<HandRank>
		// .flatMap: Stream 을 반환하는 메소드를 받아서
		// Stream 에 있는 값들을 모아서 Stream 으로 구성한다.
		// Stream 이 비어 있는 경우 추가되지 않는다.
		return evals.stream()
					.flatMap(f -> f.apply(data).stream())
					.findFirst()
					.orElseThrow(() -> new IllegalStateException(FAIL_EVALUATE));
					// 하이카드에서 무조건 결과를 반환하므로 해당 에러는 일반적으로 발생할 수 없음
	}
	
	private HandData prepareData(List<Card> cards) {
		Map<CardSuit, Integer> suitCount = new EnumMap<CardSuit, Integer>(CardSuit.class);
		Map<CardRank, Integer> rankCount = new EnumMap<CardRank, Integer>(CardRank.class);
		Map<Integer, Integer> groupCount = new HashMap<Integer, Integer>();
		List<CardRank> rankOrder = new ArrayList<>();
		boolean flush = false;
		List<CardRank> flushOrder = new ArrayList<>();
		
		for(Card card : cards) {
			suitCount.put(card.suit(), suitCount.getOrDefault(card.suit(), 0) + 1);
			rankCount.put(card.rank(), rankCount.getOrDefault(card.rank(), 0) + 1);
			rankOrder.add(card.rank());
		}
		
		for(Integer group : rankCount.values()) {
			groupCount.put(group, groupCount.getOrDefault(group, 0) + 1);
		}

		rankOrder = rankOrder.stream()
							 .distinct()
							 // .sorted( (a,b) -> Integer.compare(b.getOrder(), a.getOrder()) )
							 .sorted(Comparator.comparingInt(CardRank::getOrder).reversed())
							 .toList();
		
		for(CardSuit suit : CardSuit.values()) {
			if (suitCount.getOrDefault(suit, 0) >= 5) {
				flush = true;
				for(Card card : cards) {
					if (card.suit() == suit) {
						flushOrder.add(card.rank());
					}
				}
			}
		}
		
		flushOrder = flushOrder.stream()
							   .distinct()
							   // .sorted( (a,b) -> Integer.compare(b.getOrder(), a.getOrder()) )
							   .sorted(Comparator.comparingInt(CardRank::getOrder).reversed())
							   .toList();
		
		return new HandData(rankCount, groupCount, rankOrder, flush, flushOrder);
	}
	
	/** 
	 * 사전에 중복 제거 및 내림차순 정렬되어있는 List<CardRank>를 받아서 
	 * 스트레이트를 만족한다면 스트레이트를 이루는 가장 큰 CardRank 를  
	 * 스트레이트를 만족하지 않는다면 Optional.empty 를 반환
	 *  
	 * @param ranks 중복 제거 및 내림차순 정렬되어 있는 CardRank 목록
	 * @return 스트레이트를 이루는 가장 큰 카드 or 빈 Optional
	 */
	private Optional<CardRank> findStraightRank(List<CardRank> ranks){
		
		if (ranks.size() < 5) {
			return Optional.empty();
		}
		
		int n = 0;
		
		// i :  0  1  2  3  4  5  6  7 
		// n :  1  2  3  0  1  2  3  4
		// r : 14 13 12 11  9  8  7  6  5
		for (int i = 0; i < ranks.size() - 1; i++) {
			if (ranks.get(i).getOrder() - ranks.get(i+1).getOrder() == 1) {
				n++;
			} else {
				n = 0;
			} 
			if ( n == 4) {
				// jUnit 테스트로 return 키워드 미작성 찾음
				return Optional.of(ranks.get(i-3));
			}
		}
		
		if(ranks.contains(CardRank.ACE) && ranks.contains(CardRank.TWO)
			&& ranks.contains(CardRank.THREE) && ranks.contains(CardRank.FOUR)
			&& ranks.contains(CardRank.FIVE)) {
			return Optional.of(CardRank.FIVE);
		}
		
		return Optional.empty();
	}
	
	private Optional<HandResult> evalStraightFlush(HandData data){
		
		if (!data.flush()) {
			return Optional.empty();
		}
		
		Optional<CardRank> straightRank = findStraightRank(data.flushOrder());
		if (straightRank.isEmpty()) {
			return Optional.empty();
		}
		
		CardRank rank = straightRank.get();
		
		if (rank == CardRank.ACE) {
			return Optional.of(new HandResult(HandRank.ROYAL_FLUSH, List.of(rank)));
		} else {
			return Optional.of(new HandResult(HandRank.STRAIGHT_FLUSH, List.of(rank)));
		}
	}
	
	private Optional<HandResult> evalFourOfAKind(HandData data){
		
		boolean fourOfAKind = data.groupCount().getOrDefault(4, 0) > 0;
		
		if (!fourOfAKind) {
			return Optional.empty();
		}
		
		CardRank four = data.rankOrder()
							.stream()
							.filter(k -> data.rankCount().get(k) >= 4)
							.findFirst()
							.orElseThrow(); // 상단의 포카드 통과 시 반드시 존재함
		
		CardRank kicker = data.rankOrder()
							  .stream()
							  .filter(r -> r != four)
							  .findFirst()
							  .orElseThrow(); // 5장 이상 받은 경우 반드시 존재함
							  
		return Optional.of(new HandResult(HandRank.FOUR_OF_A_KIND, List.of(four, kicker)));
	}
	
	private Optional<HandResult> evalFullHouse(HandData data){
		
		int groupThree = data.groupCount().getOrDefault(3, 0);
		int groupTwo = data.groupCount().getOrDefault(2, 0);
		
		// jUnit 테스트로 조건 오타 확인함
		boolean fullHouse = groupThree >= 1 && (groupThree >= 2 || groupTwo >= 1);
		
		if(!fullHouse) {
			return Optional.empty();
		}
		
		CardRank three = data.rankOrder()
							 .stream()
							 .filter(k -> data.rankCount().get(k) >= 3)
							 .findFirst()
							 .orElseThrow(); // 상단의 fullHouse 조건을 만족하면 반드시 존재함
							 
		CardRank two = data.rankOrder()
						   .stream()
						   .filter(k -> k != three)
						   .filter(k -> data.rankCount().get(k) >= 2)
						   .findFirst()
						   .orElseThrow(); // 상단의 fullHouse 조건을 만족하면 반드시 존재함
						
		return Optional.of(new HandResult(HandRank.FULL_HOUSE, List.of(three, two)));
	}
	
	private Optional<HandResult> evalFlush(HandData data){
		
		if(!data.flush()){
			return Optional.empty();
		}
	
		List<CardRank> kickers = data.flushOrder()
									 .stream()
									 .limit(5)
									 .toList();
		
		return Optional.of(new HandResult(HandRank.FLUSH, kickers));
	}
	
	private Optional<HandResult> evalStraight(HandData data){
		
		Optional<CardRank> straight = findStraightRank(data.rankOrder());
		
		if(straight.isEmpty()) {
			return Optional.empty();
		}
		
		CardRank rank = straight.get();
		HandRank result;
		
		if (rank == CardRank.ACE) {
			result = HandRank.MOUNTAIN;
		} else if (rank == CardRank.FIVE) {
			result = HandRank.BACK_STRAIGHT;
		} else {
			result = HandRank.STRAIGHT;
		}
		
		return Optional.of(new HandResult(result, List.of(rank)));
	}
	
	private Optional<HandResult> evalThreeOfAKind(HandData data){
		if (data.groupCount().getOrDefault(3, 0) < 1) {
			return Optional.empty();
		}
		
		List<CardRank> kickers = new ArrayList<>();
		
		CardRank three = data.rankOrder()
							 .stream()
							 .filter(r -> data.rankCount().get(r) >= 3 )
							 .findFirst()
							 .orElseThrow(); // 상단 if 구문 통과 시 반드시 존재함
		
		List<CardRank> others = data.rankOrder()
									.stream()
									.filter(r -> r != three)
									.limit(2)
									.toList(); // 5장 이상 받으면 반드시 존재함
		
		// jUnit 테스트로 add 미작성 찾음
		kickers.add(three);
		kickers.addAll(others);

		return Optional.of(new HandResult(HandRank.THREE_OF_A_KIND, kickers)); 
	}
	
	private Optional<HandResult> evalTwoPair(HandData data){
		
		if (data.groupCount().getOrDefault(2, 0) < 2) {
			return Optional.empty();
		}
		
		CardRank highPair = data.rankOrder()
								.stream()
								.filter(r -> data.rankCount().get(r) >= 2)
								.findFirst()
								.orElseThrow(); // 상단 if 문 통과 시 반드시 존재함
		
		CardRank lowPair = data.rankOrder()
							   .stream()
							   .filter(r -> r != highPair)
							   .filter(r -> data.rankCount().get(r) >= 2)
							   .findFirst()
							   .orElseThrow(); // 상단 if 문 통과 시 반드시 존재함
		
		CardRank other = data.rankOrder()
							 .stream()
							 .filter(r -> r != highPair)
							 .filter(r -> r != lowPair)
							 .findFirst()
							 .orElseThrow(); // 5장 이상 받으면 반드시 존재함
		
		// jUnit 테스트로 투페어에서 트리플 반환하고 있는 오타 발견
		return Optional.of(new HandResult(HandRank.TWO_PAIR, List.of(highPair, lowPair, other)));
	}
	
	private Optional<HandResult> evalOnePair(HandData data){
		
		// jUnit 테스트로 조건식 오타 수정
		if (data.groupCount().getOrDefault(2, 0) < 1) {
			return Optional.empty();
		}
		
		CardRank pair = data.rankOrder()
							.stream()
							.filter(r -> data.rankCount().get(r) >= 2)
							.findFirst()
							.orElseThrow(); // 상단 if 문 통과 시 반드시 존재함
		
		List<CardRank> others = data.rankOrder()
									.stream()
									.filter(r -> r != pair)
									.limit(3)
									.toList(); // 5 장 이상 받은 경우 반드시 존재함
		
		List<CardRank> kickers = new ArrayList<>();
		kickers.add(pair);
		kickers.addAll(others);
		
		return Optional.of(new HandResult(HandRank.ONE_PAIR, kickers));
	}
	
	private Optional<HandResult> evalHighCard(HandData data){
		List<CardRank> kickers = data.rankOrder()
									 .stream()
									 .limit(5)
									 .toList(); // 5장 이상 받은 경우 반드시 존재함
		
		return Optional.of(new HandResult(HandRank.HIGH_CARD, kickers));
	}
}
