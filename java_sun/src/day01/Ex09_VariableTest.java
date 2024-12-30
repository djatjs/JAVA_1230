package day01;

public class Ex09_VariableTest {

	public static void main(String[] args) {
		// 학생의 국어, 영어, 수학 성적을 저장하기 위한 변수 선언하기
		int korScore = 90, engScore= 100, mathScore= 81;
		
		// 학생의 국어, 영어, 수학 성적의 평균을 저장하기 위한 변수 선언하기
		double average;
		
		// 학생의 학점을 저장하기 위한 변수를 선언하세요.
		average = (korScore + engScore + mathScore)/3;
		char grade = ' ';
		if (average > 90)
		{
			grade = 'A';
		}
		else if (average > 80) {
			grade = 'B';
		}
		else if (average > 70) {
			grade = 'C';
		}
		else if (average > 60) {
			grade = 'D';
		}
		else if (average > 50) {
			grade = 'F';
		}
		System.out.println(grade);
		
	}

}
