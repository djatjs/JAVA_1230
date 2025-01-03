package day04;

import java.util.Scanner;

public class Ex04_Method2 {

	public static void main(String[] args) {
		/*
		 * 100이하의 소수를 출력하는 코드를 메소드를 활용하여 작성하기
		 */
		
		prime();
		
		/*
		 * for (int num=1; num<=100; num++) {
		 * System.out.print(isprime2(num)?num+" ":""); }
		 */
		 
		
		System.out.println();
		
		// 10이 소수인지 아닌지 판별하는 메소드
		//isPrime10();
		int num= 10;
		/*
		 * if(isprime2(num)) { System.out.println(num+" : 소수"); }else {
		 * System.out.println(num+" : 소수아님"); }
		 */
		System.out.println(isprime2(num)? num+" : 소수" : num+" : 소수 아님");
		
		
		Scanner scan = new Scanner(System.in);

		System.out.print("숫자 입력 : ");
		num = scan.nextInt();
		isPrime(num);
		isprime2(num);
		System.out.println(isprime2(num));
	}

	/**
	 * 기능 : 소수 출력 
	 * 리턴 타입 : void 
	 * 매개 변수 : X 
	 * 함수 이름 : prime
	 */
	public static void prime() {
		// 100 이하의 소수를 출력하는 코드

		int num = 0, count = 0;
		for (num = 2; num <= 100; num++) {
			count = 0;
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print(num + " ");
			}
		}
	}

	// 10이 소수인지 아닌지 판별하는 메소드
	public static void isPrime10() {
		int count = 0;
		for (int i = 1; i <= 10; i++) {
			if (10 % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.println(10 + " : 소수");
		} else {
			System.out.println(10 + " : 소수 아님");
		}
	}
	// num이 소수인지 아닌지 판별하는 메소드
	public static void isPrime(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.println(num + " : 소수");
		} else {
			System.out.println(num + " : 소수 아님");
		}
	}
	// num이 소수인지 아닌지 판별하는 메소드2
	public static boolean isprime2(int num) {
		if(num ==1) {
			return false;
		}
		for (int i=2; i<=num; i++) {
			if (num % i ==0) {
				return false;
			}
		}
		return true;
	}
}
