package day03;

import java.util.function.BiConsumer;

public class Ex03_ForEvenNum {

	public static void main(String[] args) {

		/* 10 이하의 짝수 출력하는 코드 작성
		 * 반복 횟수 : i는  1부터 10까지 1씩 증가
		 * */
		
		for (int i=1; i <=10; i++) {
			if (i % 2 == 0) {
				System.out.print(i+ " ");
			}
		}
		System.out.println();
		
		
		/* 반복 횟수 : i는  2부터 10까지 2씩 증가
		 * */
		for (int i=2; i <=10; i+=2) {
			System.out.print(i+ " ");
		}
		System.out.println();

		
		/* 반복 횟수 : i는  1부터 5까지 1씩 증가
		 * */
		for (int i=1; i <=5; i++) {
			System.out.print(i+ " ");
		}
		
		

	}

}
