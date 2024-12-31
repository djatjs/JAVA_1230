package day02;

public class Ex08_IfGrade {

	public static void main(String[] args) {
		/*성적 특정기
		 * A : 90~100
		 * B : 80~89
		 * C : 70~79
		 * D : 60~69
		 * F : 0~59
		 * 잘못된 점수 : 0보다 작거나 100보다 큰 경우 */ 
		
		int score = 100;
		String grade;
		
		if (score<0 || score >100) {
			System.out.println("잘못된 점수");
		} 
		else if (score >= 90) {
			grade = "A";
			System.out.println(score +" : "+ grade);
		}
		else if (score >=80) {
			grade = "B";		
			System.out.println(score +" : "+ grade);
		}
		else if (score >=70) {
			grade = "C";
			System.out.println(score +" : "+ grade);
		}
		else if (score >=60) {
			grade = "D";			
			System.out.println(score +" : "+ grade);
		}
		else if (score < 60) {
			grade = "F";			
			System.out.println(score +" : "+ grade);
		}
		
	}

}
