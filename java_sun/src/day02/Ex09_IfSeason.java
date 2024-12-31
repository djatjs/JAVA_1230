package day02;

import java.awt.datatransfer.MimeTypeParseException;
import java.util.Scanner;

public class Ex09_IfSeason {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 월에 맞는 계절 출력 
		 * 봄 : 3,4,5
		 * 여름 : 6,7,8
		 * 가을 : 9,10,11
		 * 겨울 : 12,1,2
		 * 잘못된 월 : 그 외 */
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하셈");
		int month = scan.nextInt();
		
		// 이건 swich로 바꾸는게 좋겠다
		if (month < 0 || month >13) {
			System.out.println("잘못된 월");
		}
		else if (month == 3 || month == 4 || month == 5) {
			System.out.println(month + " : 봄");
		}
		else if (month == 6 || month == 7 || month == 8) {
			System.out.println(month + " : 여름");
		}
		else if (month == 9 || month == 10 || month == 11) {
			System.out.println(month + " : 가을");
		}
		else if (month == 12 || month == 1 || month == 2) {
			System.out.println(month + " : 겨울");
		}
		
		// if로는 이게 더 좋긴한듯
		if (month < 0 || month >13) {
			System.out.println("잘못된 월");
		}
		else if (month >=3 && month <6) {
			System.out.println(month + " : 봄");
		}
		else if (month >=6 && month <9) {
			System.out.println(month + " : 여름");
		}
		else if (month >=9 && month <12) {
			System.out.println(month + " : 가을");
		}
		else {
			System.out.println(month + " : 겨울");
		}
		
		

	}

}
