package Ex02_MyCode2;

import java.util.Scanner;

import homework.v2.ConsoleProgram;

public class UserProgram implements ConsoleProgram{
	private Scanner scan = new Scanner(System.in);
	@Override
	public void run() {
		
		int menu=0;
		do {
			printMenu();
			menu=scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
		}while(menu !=3);
	}

	@Override
	public void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 단어 검색\n"
				+ "2. 단어 검색 내역 확인\n"
				+ "3. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			System.out.println("로그아웃됨");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

}
