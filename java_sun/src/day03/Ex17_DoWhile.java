package day03;

import java.util.Scanner;

public class Ex17_DoWhile {

	public static void main(String[] args) {
		/* 문자를 입력받아 문자가 q일 때 종료하는 코드
		 * */
		
		Scanner scanner = new Scanner(System.in);
		char ch;
		
		do {
			System.out.print("문자 입력하세요 : ");
			ch = scanner.next().charAt(0);
		}while(ch != 'q');
		
		System.out.println("프로그램 종료.");
	}
}
