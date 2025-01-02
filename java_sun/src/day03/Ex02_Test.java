package day03;

import java.util.Scanner;

public class Ex02_Test {

	public static void main(String[] args) {
		/* 월을 입력받고 월의 마지막 일을 출력하는 코드 작성
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 잘못된 월 : 1~12가 아닌 월.
		 * */
		 Scanner scan = new Scanner(System.in);
		 int month;
		 int lastDay;
		 
		 System.out.print("월을 입력하시오 : ");
		 month = scan.nextInt();
		 
		 switch (month) {
		 case 1,3,5,7,8,10,12:
			lastDay = 31;
		 	break;
		 case 4,6,9,11:
			 lastDay = 30;
		 	break;
		 case 2:
			 lastDay = 28;
			 break;
		 default:
			 lastDay = 0;
		 }

		 
		 if (lastDay != 0) {
			 System.out.println(month + "월은 " + lastDay + "일 까지 있음");
		 }
		 else {
			 System.out.println(month + "월은 " + "잘못된 월");
		 }
		
	}

}
