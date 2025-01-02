package day03;

import java.util.Scanner;

public class Ex04_ForDivisor {

	public static void main(String[] args) {
		/* 입력받은 num의 약수 출력하는 코드 작성
		 * 약수 : 나누었을 때 나머지가 0이 되는 수
		 * 12의 약수 : 1 2 3 4 6 12
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("숫자 입력 : ");
		num = scan.nextInt();
		
		System.out.print(num + "의 약수 : ");
		for (int i= 1; i<=num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

}
