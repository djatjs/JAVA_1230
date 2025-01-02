package day03;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.crypto.Cipher;

public class Ex05_ForPrimeNum {

	public static void main(String[] args) {
		/* 입력받은 정수가 소수인지 아닌지 판별하는 코드
		 * 소수 : 약수가 1과 자기 자신인 수
		 * 소수 : 2 3 5 7 11 17 ...
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("숫자 입력 : ");
		num = scan.nextInt();
		
		// 방법1
		int count = 0;
		for (int i= 1; i<=num; i++) {
			if (num  % i == 0) {
				count ++;
			}
		}
		
		if (count == 2 ) {
			System.out.println(num + " : 소수");
		}
		else {
			System.out.println(num + " : 소수 아님");
		}
		
		
		// 방법2
		count = 0;
		for (int i= 2; i<num; i++) {
			if (num  % i == 0) {
				count ++;
			}
		}
		
		if (count == 0 && num != 1) {
			System.out.println(num + " : 소수");
		}
		else {
			System.out.println(num + " : 소수 아님");
		}

	}

}
