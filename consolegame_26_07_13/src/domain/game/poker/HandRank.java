package domain.game.poker;

/**
 * 카드의 족보 목록
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
	
	// 속성 
	// 이름
	private final String rankName;
	// 등급
	private final int rankPower;
	// 키커의 수
	private final int kickerCount;
	
	// 생성자
	private HandRank(String rankName, int rankPower, int kickerCount) {
		this.rankName = rankName;
		this.rankPower = rankPower;
		this.kickerCount = kickerCount;
	}
	
	// getter
	public String getRankName() {
		return rankName;
	}
	
	public int getRankPower() {
		return rankPower;
	}
	
	public int getKickerCount() {
		return kickerCount;
	}
}
