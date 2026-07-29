package domain.game.pokergamble;

import java.util.List;

import domain.card.CardRank;

/**
 * 포커 족보 목록 및 순서
 * 
 * 패키지 프라이빗
 */
enum HandRank {
	ROYAL_FLUSH("로얄플러시",12,1)
	, STRAIGHT_FLUSH("스트레이트플러시",11,1)
	, FOUR_OF_A_KIND("포카드",10,2)
	, FULL_HOUSE("풀하우스",9,2)
	, FLUSH("플러시",8,5)
	, MOUNTAIN("마운틴",7,1)
	, STRAIGHT("스트레이트",6,1)
	, BACK_STRAIGHT("백스트레이트",5,1)
	, THREE_OF_A_KIND("트리플",4,3)
	, TWO_PAIR("투페어",3,3)
	, ONE_PAIR("원페어",2,4)
	, HIGH_CARD("탑",1,5)
	;
	
	private final String rankName;
	private final int order;
	private final int kickerCount;
	
	private HandRank(String rankName,int order, int kickerCount) {
		this.rankName = rankName;
		this.order = order;
		this.kickerCount = kickerCount;
	}
	
	String getRankName() {
		return this.rankName;
	}
	
	int getKickerCount() {
		return this.kickerCount;
	}
	
	int getOrder() {
		return this.order;
	}
	
	String getShowName(List<CardRank> kickers) {
		return switch(this) {
		case ROYAL_FLUSH, MOUNTAIN, BACK_STRAIGHT -> getRankName();
		case STRAIGHT_FLUSH, FOUR_OF_A_KIND, FLUSH
		   , STRAIGHT, THREE_OF_A_KIND, ONE_PAIR, HIGH_CARD -> kickers.get(0).getSymbol() + " " + getRankName();
		case FULL_HOUSE, TWO_PAIR -> kickers.get(0).getSymbol() + "," + kickers.get(1).getSymbol() + " " + getRankName();
		};
	}
}
