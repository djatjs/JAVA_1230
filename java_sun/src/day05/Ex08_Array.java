package day05;

import java.util.Scanner;

public class Ex08_Array {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 학생 3명의 국어 성적을 관리 하기 위해 배열을 선언하고,
		// 콘솔을 통해 성적을 입력받고, 입력받은 성적을 출력하는 코드
		int studentCount = 3;
		int [] kors = new int[studentCount];
		int sum =0;
		
		for (int i=0; i<studentCount; i++) {
			System.out.print((i+1)+"번째 학생 : ");
			kors[i] = scan.nextInt();
			System.out.println((i+1)+"번째 학생의 국어 성적 : "+kors[i]);
			sum +=kors[i];
		}
		System.out.println("세 학생의 국어 평균 점수 : " + sum/(double)studentCount);
	}

}
