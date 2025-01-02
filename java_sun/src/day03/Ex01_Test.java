package day03;

import java.util.Scanner;

public class Ex01_Test {

	public static void main(String[] args) {
		/* 세 학생의 국어 성적을 입력받아 총점과 평균을 구하는 코드 작성
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		int score;
		int sum = 0;
		
		for (int i = 1; i <= 3; i++) {
			System.out.print(i + "번째 학생의 성적을 입력하세요 : ");
			score = scan.nextInt();
			sum += score;
		}
		System.out.println("총점 : " +  sum);
		System.out.println("평균 : " +  (sum/3.0)); // 그냥 3이라고 하면 정수로 나눠서 정확하지만은 아니게 나옴 #자료형변환
		

	}

}
