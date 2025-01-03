package day04;

import java.util.Scanner;

public class Ex10_Homework {

	public static void main(String[] args) {
		/* 다음과 같이 실행되도록 프로그램을 작성하세요
		 * 
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 (몇번 만에 맞췄는지)
		 * 3. 프로그램 종료
		 * 메뉴 선택  : 1
		 * 입력 : 50
		 * Down!
		 * 입력 : 25
		 * 정답!
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 (몇번 만에 맞췄는지)
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 최고기록 : 2회 (엔터로 가려면 엔터를 입력하세요)
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 (몇번 만에 맞췄는지)
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 프로그램을 종료합니다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		char menu;
		do {// 메뉴 뺑뺑이
			printMenu();
			menu = scan.next().charAt(0);
			// 메뉴 1번 누르면
			if(menu =='1') {
				gameMenu();
			}
			else if (menu =='2'){
				
			}
		}while(menu != '3');
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	// 메뉴 출력 메소드
	public static void printMenu() {
		System.out.println("ㅡㅡ 메뉴 ㅡㅡ");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고 기록 확인 (몇번 만에 맞췄는지)");
		System.out.println("3. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
	}
	
	// 게임 진행 메소드 (일단 카운트는 세긴하는데 어떻게 반환하지.. void로 해야 sysout이런거 할텐데)
	public static void gameMenu() {
		Scanner scan = new Scanner(System.in);
		final int MIN = 1, MAX = 100;
		int num = (int)(Math.random() * (MAX - MIN + 1) + MIN);
		int count =0;
		while(true) {
			System.out.print("입력 : ");
			int input = scan.nextInt();
			count +=1;
			if (input == num) {
				System.out.println("정답! 도전 횟수 : "+ count);
				break;
			}
			else if (input > num) {
				System.out.println("Down!");
				continue;
			}
			else if (input < num) {
				System.out.println("Up!");
				continue;
			}
		}
	}
	
	// 게임 최고 기록 확인
	public static void viewScore() {
		
	}
	
}
