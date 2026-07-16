package workflow;

/**
 * 교재 133p
 * 
    // 국어, 영어, 수학, 프로그래밍의 합계와 평균을 각각 계산해 할당하고
    // 아래 기준에 따라 성적을 출력해보세요.
    // 평균점수 95점 이상: A+
    // 평균점수 90점 이상: A
    // 평균점수 85점 이상: B+
    // 평균점수 80점 이상: B
    // 평균점수 70점 이상: C
    // 평균점수 70점 미만: F
 */
public class IfElseQuiz1 {

	public static void main(String[] args) {
		
		int korScore = 90;
		int engScore = 88;
		int mathScore = 70;
		int progScore = 80;
		
		int sum = korScore + engScore + mathScore + progScore;
		double avg = sum / 4.0;
		
		System.out.printf("평균 점수 %.2f점 이상: %s",avg,getScore(avg));
		// 평균 점수 82.00점 이상: B
	}
	
	public static String getScore(double avg) {
		if(avg >= 95)
			return "A+";
		else if(avg >= 90)
			return "A";
		else if(avg >= 85)
			return "B+";
		else if(avg >= 80)
			return "B";
		else if(avg >= 70)
			return "C";
		else 
			return "F";
	}
}
