package day03;

public class Ex21_NestingStrar {

	public static void main(String[] args) {
		// ***** 5줄 출력
		// 중첩 for
		for(int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/*
		 *  *
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 *  출력
		 * */
		System.out.println();
		
		
		for (int i=1; i<=5;i++) {
			for (int j=1; j<=i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
