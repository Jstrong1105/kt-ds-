package class_quiz;

public class Student {
	
	int java;
	int python;
	int cpp;
	int csharp;
	
	public Student(int java, int python, int cpp, int csharp) {
		this.java = java;
		this.python = python;
		this.cpp = cpp;
		this.csharp = csharp;
	}
	
	public int getSumAllScores(){
		return java + python + cpp + csharp;
	}
	
	public double getAverage(int sum) {
		double result = sum / 4.0;
		
		return setDecimal(result, 2);
	}
	
	public double getCourseCredit(double average) {
		double result = (average - 55) / 10;
		
		return setDecimal(result,2);
	}
	
	public String getABCDF(double credit) {
		String result = "";
		
		double[] rankCut = {4.1, 3.6, 3.1, 2.6, 1.6, 0.6, 0.1};
		String[] rank = {"A+", "A", "B+", "B", "C", "D", "F"};
		
		for(int i = 0; i < rankCut.length; i++) {
			if(credit >= rankCut[i]) {
				result = rank[i];
				break;
			}
		}
		
		return result;
	}
	
	private double setDecimal(double num, int decimal) {
		
		double value = 1.0;
		
		if (decimal >= 0) {
			for (int i = 0; i < decimal; i++) {
				value *= 10;
			}
		} else {
			for (int i = 0; i < -decimal; i++) {
				value /= 10;
			}
		}
		
		int result = (int) (num * value);
		
		return result / value;
	}
	
	public static void main(String[] args) {
		
		Student st = new Student(100,90,80,70);
		
		int sum = st.getSumAllScores();
		double average = st.getAverage(sum);
		double credit = st.getCourseCredit(average);
		String rank = st.getABCDF(credit);
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println("학점 : " + credit);
		System.out.println("등급 : " + rank);
	}
}
