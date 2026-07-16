package domain.game.poker;

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
 * HandEvaluator 인터페이스를 상속받아 구현한 클래스
 * 
 * 한국식 족보인 마운틴 - 스트레이트 - 백스트레이트 순서 족보 비교
 * 
 * 카드 뭉치를 받아서 모양의 개수나 숫자의 개수 들을 사전에 수집한 뒤 HandData 에 저장하고
 * HandData 를 받아 각각의 족보 여부를 판독해 가장 먼저 만족하는 족보를 반환한다.
 * 
 * 족보 판독 순서가 바뀔 경우 ex : 풀하우스보다 트리플을 먼저 검사한다면 트리플 역시 맞는 족보이기 
 * 때문에 트리플로 판독이 발생한다. 
 * 
 * 족보 판독 순서는 실제 족보 순서와 일치해야 한다.
 * 
 * 패키지 프라이빗
 */
class KoreanHandEvaluator implements HandEvaluator{
	
	// 에러 메시지
	private static final String NOT_VALID_CARDS = "유효하지 않은 카드 목록";
	private static final String NOT_VALID_RESULT = "족보 판독 실패";
	
	/*
	 * 족보 판독 순서
	 * 족보 판독 순서를 수정한 경우 
	 * 족보 판독에 에러 발생
	 */
	private final List<Function<HandData, Optional<HandResult>>> judges = List.of(
			this::straightFlush
			, this::fourOfAKind
			, this::fullHouse
			, this::flush
			, this::straight
			, this::threeOfAKind
			, this::twoPair
			, this::onePair
			, this::highCard);
	
	@Override
	public HandResult evaluate(List<Card> cards) {
		
		// 중복을 제외한 카드의 숫자가 5장 미만이라면
		if ( cards.stream().distinct().toList().size() < 5 ){
			throw new IllegalArgumentException(NOT_VALID_CARDS);
		}
		
		HandData data = prepareData(List.copyOf(cards));
		
		return judges.stream()
				     .map( judge -> judge.apply(data) )
				     .flatMap( Optional::stream )
				     .findFirst()
				     .orElseThrow(()->new IllegalStateException(NOT_VALID_RESULT));
	}
	
	// 데이터 전처리
	private HandData prepareData(List<Card> cards) {
		// 데이터 초기화
		Map<CardSuit, Integer> suitCount = new EnumMap<>(CardSuit.class);
		Map<CardRank, Integer> numberCount = new EnumMap<>(CardRank.class);
		Map<Integer, Integer> groupCount = new HashMap<>();
		List<CardRank> numberOrder = new ArrayList<>();
		boolean flush = false;
		List<CardRank> flushOrder = new ArrayList<>();
		
		// 모양의 개수와
		// 숫자의 개수
		// 각각의 숫자를 분석
		for ( Card card : cards ) {
			
			CardSuit suit = card.suit();
			CardRank rank = card.rank();
			
			suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
			numberCount.put(rank, numberCount.getOrDefault(rank, 0) + 1);
			numberOrder.add(rank);
		}
		
		// 숫자를 내림차순 정렬
		numberOrder.sort(Comparator.comparingInt(CardRank::getOrder).reversed());
		
		// 숫자 그룹 분석
		for ( int group : numberCount.values() ) {
			groupCount.put(group, groupCount.getOrDefault(group, 0) + 1);
		}
		
		// 플러시 유무 확인
		for ( CardSuit suit : CardSuit.values() ) {
			if ( suitCount.getOrDefault(suit, 0) >= 5 ) {
				flush = true;
				
				for ( Card card : cards ) {
					if ( card.suit() == suit ) {
						flushOrder.add(card.rank());
					}
				}
				
				flushOrder.sort(Comparator.comparingInt(CardRank::getOrder).reversed());
				
				break;
			}
		}
		
		// 추출한 정보를 HandData 에 담아서 반환
		return new HandData(suitCount,numberCount,groupCount,numberOrder,flush,flushOrder);
	}
	
	// 스트레이트를 이루는 가장 큰 숫자를 찾아서
	// Optional<CardRank> 로 반환하는 메소드
	// 파라미터로 들어오는 ranks 가 
	// 사전에 내림차순으로 정렬되어 있어야 한다.
	private Optional<CardRank> findStraightHigh(List<CardRank> ranks) {
		
		// 파라미터로 들어온 ranks 에서 중복을 제거
		// 스트레이트 검사 시 중복은 필요 없기 때문
		List<CardRank> distinct = ranks.stream().distinct().toList();
		
		// 중복 제거 후 
		// 카드가 5개가 안된다면 바로 리턴
		if ( distinct.size() < 5 ) {
			return Optional.empty();
		}
		
		int n = 0;
		
		/* 
		  	i      :  0 1 2 3 4 5
			minus  :  1 2 1 1 1 1     (9-8, 8-6, 6-5, 5-4, 4-3, 3-2)
			n      :  1 0 1 2 3 4
		 */
		// (i) 번 째와 (i + 1) 번쨰를 비교해서
		// 1 차이가 나는 경우 n++;
		// 1 차이가 안나는 경우 n 초기화
		// n 이 4가 된 경우 
		// 스트레이트 판정
		for ( int i = 0; i < distinct.size() - 1; i++ ) {
			
			int minus = distinct.get(i).getOrder() - distinct.get(i+1).getOrder();
			
			if ( minus == 1 ) {
				n++;
			} else {
				n = 0;
			}
			
			if ( n == 4 ) {
				return Optional.of(distinct.get(i-3)); 
			}
		}
		
		// 특수 규칙 적용
		// 백스트레이트
		// 카드에 ACE , TWO , THREE , FOUR , FIVE 가 있는 경우 
		// 백 스트레이트 판정
		if ( distinct.containsAll(List.of(CardRank.ACE,CardRank.TWO,CardRank.THREE
				,CardRank.FOUR,CardRank.FIVE) ) ){
			return Optional.of(CardRank.FIVE);
		}
		
		return Optional.empty();
	}
	
	// 데이터를 받아서 스트레이트 플러시 여부를 반환하는 메소드
	private Optional<HandResult> straightFlush(HandData data) {
		
		// 플러시를 만족하지 않는 다면 
		if ( !data.flush() ) {
			return Optional.empty();
		}
		
		// 스트레이트를 이루는 가장 큰 숫자를 찾음
		Optional<CardRank> high = findStraightHigh(data.flushOrder());
		
		// 찾지 못했다면
		if ( high.isEmpty() ) {
			return Optional.empty();
		}
		
		HandRank rank;
		
		CardRank kicker = high.get();
		
		// 스트레이트를 이루는 가장 큰 숫자가 ACE 인 경우
		// ROYAL_FLUSH
		if ( kicker == CardRank.ACE ) {
			rank = HandRank.ROYAL_FLUSH;
		} else {
			rank = HandRank.STRAIGHT_FLUSH;
		}
		
		return Optional.of(new HandResult(rank, List.of(kicker)));
	}
	
	// 데이터를 받아서 포카드 유무를 판정하는 메소드
	private Optional<HandResult> fourOfAKind(HandData data) {

		//  4장을 이룬 카드가 한개도 없다면 
		if ( data.groupCount().getOrDefault(4, 0) < 1 ) {
			return Optional.empty();
		}
		
		// 4장을 이룬 카드의 Rank 찾기
		// 상단의 if 구문을 통과했다면 반드시 존재함
		CardRank quad = data.numberOrder()
				            .stream()
				            .filter( r -> data.numberCount().get(r) >= 4 )
				            .findFirst()
				            .orElseThrow();
		
		// 4장을 이룬 카드를 제외한 가장 큰 숫자를 찾기
		// 5장 이상의 카드를 받았다면 반드시 존재함
		CardRank kicker = data.numberOrder()
				              .stream()
				              .filter( r -> r != quad )
				              .findFirst()
				              .orElseThrow();
		
		return Optional.of(new HandResult(HandRank.FOUR_OF_A_KIND,List.of(quad,kicker)));
	}
	
	// 데이터를 받아서 풀하우스 유무를 판정하는 메소드
	private Optional<HandResult> fullHouse(HandData data) {
		
		int groupThree = data.groupCount().getOrDefault(3, 0);
		int groupTwo = data.groupCount().getOrDefault(2, 0);
		
		// 풀하우스 조건 검사
		// 3장을 이룬 그룹이 1개 2장을 이룬 그룹이 1개 
		// 혹은 3장을 이룬 그룹이 2개
		boolean fullHouse = ( groupThree >= 1) && ( groupThree >= 2 || groupTwo >= 1 );
		
		if ( !fullHouse ) {
			return Optional.empty();
		} 
		
		// 3장 그룹을 이룬 가장 큰 숫자
		// 상단의 if 문 통과 시 반드시 존재
		CardRank triple = data.numberOrder()
				              .stream()
				              .filter( r -> data.numberCount().get(r) >= 3 )
				              .findFirst()
				              .orElseThrow();
		
		// 2장 그룹을 이룬 숫자 중 triple 을 제외한 가장 큰 숫자
		// 상단의 if 문 통과 시 반드시 존재
		CardRank two = data.numberOrder()
				           .stream()
				           .filter( r -> r != triple )
				           .filter( r -> data.numberCount().get(r) >= 2 )
				           .findFirst()
				           .orElseThrow();
		
		return Optional.of(new HandResult(HandRank.FULL_HOUSE, List.of(triple,two)));
	}
	
	// 데이터를 받아서 플러시 유무를 판정하는 메소드
	private Optional<HandResult> flush(HandData data) {
		
		// 플러시가 아니라면
		if ( !data.flush() ) {
			return Optional.empty();
		}
		
		// 플러시 모양을 가진 숫자 중 5개만 추출
		// 5장 이상을 받았다면 반드시 존재
		List<CardRank> kickers = data.flushOrder()
				                     .stream()
				                     .limit(5)
				                     .toList();
		
		return Optional.of(new HandResult(HandRank.FLUSH, kickers));
	}
	
	// 데이터를 받아서 스트레이트 유무를 판정하는 메소드
	private Optional<HandResult> straight(HandData data) {
		
		// 스트레이트를 이루는 가장 큰 숫자를 반환
		Optional<CardRank> high = findStraightHigh(data.numberOrder());
		
		// 스트레이트를 이루는 숫자가 없다면
		if(high.isEmpty()) {
			return Optional.empty();
		}
		
		CardRank kicker = high.get();
		
		HandRank rank;
		
		// 스트레이트를 이루는 숫자에 따른 분기
		if ( kicker == CardRank.ACE ) {
			rank = HandRank.MOUNTAIN;
		} else if ( kicker == CardRank.FIVE ) {
			rank = HandRank.BACK_STRAIGHT;
		} else {
			rank = HandRank.STRAIGHT;
		}
		
		return Optional.of(new HandResult(rank, List.of(kicker)));
	}
	
	// 데이터를 받아서 트리플 유무를 판정하는 메소드
	private Optional<HandResult> threeOfAKind(HandData data) {
		
		int groupThree = data.groupCount().getOrDefault(3, 0);
		
		// 3장 그룹을 이룬 카드가 없다면
		if( groupThree < 1 ) {
			return Optional.empty();
		}
		
		// 3장을 이루는 카드
		// 상단 if 문 통과 시 반드시 존재
		CardRank tripleCard = data.numberOrder() 
								  .stream()
								  .filter( r -> data.numberCount().get(r) >= 3)
								  .findFirst()
								  .orElseThrow();
		
		// 3장을 이룬 카드를 제외한 가장 큰 숫자 2개
		// 5장 이상을 받은 경우 반드시 존재
		List<CardRank> rest = data.numberOrder()
									 .stream()
									 .filter( r -> r != tripleCard )
									 .limit(2)
									 .toList();
		
		List<CardRank> kickers = new ArrayList<>();
		kickers.add(tripleCard);
		kickers.addAll(rest);
		
		return Optional.of(new HandResult(HandRank.THREE_OF_A_KIND, kickers));
	}
	
	// 데이터를 받아서 투페어 유무를 판정하는 메소드
	private Optional<HandResult> twoPair(HandData data) {
		
		int groupTwo = data.groupCount().getOrDefault(2, 0);
		
		// 2장 그룹을 이룬 카드가 2개 미만이라면
		if( groupTwo < 2 ) {
			return Optional.empty();
		}
		
		// 2장 그룹을 이룬 카드 중 가장 큰 카드
		// 상단 if 문 통과 시 반드시 존재
		CardRank highPair = data.numberOrder()
								.stream()
								.filter( r -> data.numberCount().get(r) >= 2 )
								.findFirst()
								.orElseThrow();
		
		// 2장 그룹을 이룬 카드 중 2번째로 큰 카드
		// 상단 if 문 통과 시 반드시 존재
		CardRank lowPair = data.numberOrder()
							   .stream()
							   .filter( r -> r != highPair )
							   .filter( r -> data.numberCount().get(r) >= 2) 
							   .findFirst()
							   .orElseThrow();
		
		// 2장 그룹을 이룬 카드를 제외한 가장 큰 카드
		// 5장 이상을 받은 경우 반드시 존재
		CardRank kicker = data.numberOrder()
							  .stream()
							  .filter( r -> r != highPair )
							  .filter( r -> r != lowPair )
							  .findFirst()
							  .orElseThrow();
		
		return Optional.of(new HandResult(HandRank.TWO_PAIR, List.of ( highPair,lowPair,kicker ) ));
	}
	
	// 데이터를 받아서 원페어 유무를 판정하는 메소드
	private Optional<HandResult> onePair(HandData data) {
		
		int groupTwo = data.groupCount().getOrDefault(2, 0);
		
		// 2장 그룹을 이룬 카드가 1개 미만이라면
		if ( groupTwo < 1 ) {
			return Optional.empty();
		}
		
		// 2장 그룹을 이룬 카드 중 가장 큰 카드
		// 상단 if 문 통과 시 반드시 존재
		CardRank pair = data.numberOrder()
							.stream()
							.filter( r -> data.numberCount().get(r) >= 2 )
							.findFirst()
							.orElseThrow();
		
		// 2장 그룹을 이룬 카드를 제외한 카드 중
		// 가장 큰 카드 3개
		// 5장 이상을 받은 경우 반드시 존재
		List<CardRank> rest = data.numberOrder()
									 .stream()
									 .filter( r -> r != pair)
									 .limit(3)
									 .toList();
		
		List<CardRank> kickers = new ArrayList<>();
		kickers.add(pair);
		kickers.addAll(rest);
		
		return Optional.of(new HandResult(HandRank.ONE_PAIR, kickers));
	}
	
	// 데이터를 받아서 하이카드 유무를 판정하는 메소드
	private Optional<HandResult> highCard(HandData data) {
		
		// 카드들 중 가장 큰 5개
		// 5장 이상을 받은 경우 반드시 존재
		List<CardRank> kickers = data.numberOrder()
									 .stream()
									 .limit(5)
									 .toList();
		
		return Optional.of(new HandResult(HandRank.HIGH_CARD, kickers));
	}
}




















