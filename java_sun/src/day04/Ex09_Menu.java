package day04;

import java.util.Scanner;

public class Ex09_Menu {

	public static void main(String[] args) {
		/* 다음과 같이 실행되는 코드 작성
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 1
		 * 문자를 입력하세요(종료하려면 q) : 1
		 * 문자를 입력하세요(종료하려면 q) : a
		 * 문자를 입력하세요(종료하려면 q) : q
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 2
		 * 프로그램 종료합니다.
		 * */
		Scanner scan = new Scanner(System.in);
		char menu; 
		
		do {
			printMenu();
			menu= scan.next().charAt(0);
			runMenu(menu);
		}while(menu !='2');
	}

	
	
	
	
	// 메뉴를 콘솔에 출력하는 메소드
	public static void printMenu() {
		System.out.println("ㅡㅡ 메뉴 ㅡㅡ");
		System.out.println("1. 프로그램 실행");
		System.out.println("2. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/**
	 *  메뉴에 따라 기능을 수행하는 메소드
	 *  @param program
	 *  @return 없음
	 * */
	public static void runMenu(char menu) {
		Scanner scan = new Scanner(System.in);
		char ch;
		switch (menu) { 
		case '1': 
			do {
				System.out.print("문자를 입력하세요(종료 : q) : ");
				ch = scan.next().charAt(0);
			}
			while(ch != 'q');
			break;
		case '2': 
			System.out.println("프로그램을 종료합니다");
			break;
		default:
			// System.out.println("잘못된 입력");
		}
	}
}
