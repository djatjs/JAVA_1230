package day05;

import java.util.Scanner;

public class Ex01and02_Day04Homework {
	// 스캐너 여기서 미리 설정해둠
	static Scanner scan = new Scanner(System.in);
	
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
		
		char menu;
		int best_score = 0;
		do {// 메뉴 뺑뺑이
			printMenu();
			menu = scan.next().charAt(0);
			// 메뉴 1번 누르면
			if(menu =='1') {
				int game_score = gameMenu();
				best_score = recordGame(game_score, best_score);
			}
			else if (menu =='2'){
				viewScore(best_score);
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
		System.out.print("메뉴 선택 : ");
	}
	
	// 게임 진행 메소드 
	public static int gameMenu() {
		final int MIN = 1, MAX = 100;
		int num = (int)(Math.random() * (MAX - MIN + 1) + MIN);
		int count =0;
		while(true) {
			System.out.print("입력 : ");
			int input = scan.nextInt();
			count ++;
			if (input == num) {
				System.out.println("정답! 도전 횟수 : "+ count);
				break;
			}
			else if (input > num) {
				System.out.println("Down!");
			}
			else if (input < num) {
				System.out.println("Up!");
			}
		} 
		return count;
	}
	
	// 게임 기록 비교
	public static int recordGame(int gameScore, int bestScore) {
		if(gameScore <bestScore || bestScore ==0) {
			bestScore = gameScore;
		}
		return bestScore;
	}
	
	// 게임 최고 기록 확인
	public static void viewScore(int score) {
		int score1 = score;
		if(score1 == 0) {
			System.out.print("아직 게임을 플레이하지 않았습니다. (메뉴로 가려면 엔터를 입력하세요)");
		}
		else {
			System.out.printf("최고기록 : %d회 (메뉴로 가려면 엔터를 입력하세요)", score1);
		}
        scan.nextLine(); // 엔터 입력 대기
	}

}
