package day04;

import java.util.Scanner;

public class Ex11_MyPractice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char menu;
		int count;
		final int MIN = 1, MAX = 100;
		
		
		do {// 메뉴 뺑뺑이
			printMenu();
			menu = scan.next().charAt(0);
			if (menu == '1') { // 메뉴 1번 누르면 게임 시작
					int num = (int) (Math.random() * (MAX - MIN + 1) + MIN);
					count = 0;// 카운트 초기화
					while (true) {
						System.out.print("입력 : ");
						int input = scan.nextInt();
						count += 1;
						if (input == num) {
							System.out.println("정답! 도전 횟수 : " + count);
							break;
						} else if (input > num) {
							System.out.println("Down!");
							continue;
						} else if (input < num) {
							System.out.println("Up!");
							continue;
						}
					}

			} else if (menu == '2') {

			}
		} while (menu != '3');
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

}
