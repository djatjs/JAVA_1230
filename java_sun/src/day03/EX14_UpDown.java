package day03;

import java.util.Random;
import java.util.Scanner;

public class EX14_UpDown {

	public static void main(String[] args) {
		/* 1~100 사이의 랜덤한 수를 생성해서 맞추는 게임 생성
		 * 예시
		 * 랜덤한 수 : 30
		 * 입력 : 50
		 * 출력 : DOWN!
		 * 입력 : 10
		 * 출력 : UP!
		 * 입력 : 30
		 * 출력 : 정답!
		 * */
		
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int num = random.nextInt(100)+1;
		// int num = random.nextInt(100 - 1 +1)+1;
		// 1부터 100개 
		
		System.out.println("1~100 사이의 랜덤한 수를 생성해서 맞추는 게임");
		
		while(true) { // for(;;)와 같음
			System.out.print("숫자를 입력하세요 : ");
			int your = scan.nextInt();
			if (your == num) {
				System.out.println("정답!");
				break;
			}
			else if (your > num) {
				System.out.println("Down!");
			}
			else if (your < num) {
				System.out.println("Up!");
			}
		}
		
		

	}

}
