package day03;

public class Ex21_NestingStrar {

	public static void main(String[] args) {
		// ***** 5줄 출력
		// 1. 중첩 for
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		/*
		 * 2번. 
		 * * 
		 * ** 
		 * *** 
		 * **** 
		 * ***** 
		 * 출력하기
		 */
		System.out.println();

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println();

		// 3번. 
		// 방향 바꾸기
		// 공백 먼저 5-i만큼 넣고 다음에 i만큼 별 넣기
		for (int i = 1; i <= 5; i++) {
			// i=1일때 공백 4개. -> (5-i)번 반복
			for (int j = 1; j <= (5 - i); j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		// 4번. 
		// 위 아래 뒤집기
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print('*');
			}
			System.out.println();
		}

		// 5번. 피라미드
		// 3번이랑 비슷한데 별 부분을 바꿔보자
		for (int i = 1; i <= 10; i++) {
			// i=1일때 공백 4개. -> (5-i)번 반복
			for (int j = 1; j <= (10 - i); j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println();

	}

}
