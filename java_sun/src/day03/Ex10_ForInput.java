package day03;

import java.util.Scanner;

public class Ex10_ForInput {

	public static void main(String[] args) {
		/* 문자를 입력받아 입력받은 문자가 'q'면 종료되도록 코드 작성.
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; ;i++) {
			System.out.print("문자를 입력하시오 : ");
			char str = scan.next().charAt(0);
			if (str == 'q') {
				System.out.print("프로그램 종료");
				break;
			}
		}

	}

}
