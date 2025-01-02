package day03;

import java.security.PublicKey;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.security.auth.callback.ConfirmationCallback;

public class Ex06_ForGCD {

	public static void main(String[] args) {
		/* 두 정수 num1과 num2를 입력받아 최대공약수를 구하는 코드 작성하기
		 * 약수 : 나누어 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 8의 약수 : 1 2 4 8
		 * 12의 약수 : 1 2 3 4 6 12
		 * 8과 12의 공약수 : 1 2 4
		 * 8과 12의 최대 공약수 : 4
		 * */
		
		Scanner scan = new Scanner(System.in);
		int gcd=0; //   약수 담기
		
		
		System.out.print("1번째 숫자 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("2번째 숫자 입력 : ");
		int num2 = scan.nextInt();

		
		for (int i = 1; i<num1; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		
		System.out.println(num1+"과 "+ num2 + "의 최대공약수 : " + gcd);

		
		/* 두 정수 num1과 num2를 입력받아 최소공배수를 구하는 코드 작성하기
		 * 8의 약수 : 8 16 24 ...
		 * 12의 약수 : 12 24 36 ...
		 * 8과 12의 최소 공배수 : 24
		 * */
		
		System.out.print("1번째 숫자 입력 : ");
		int num3 = scan.nextInt();
		System.out.print("2번째 숫자 입력 : ");
		int num4 = scan.nextInt();
		
		for (int i = 1; ; i++) {
			int pnum1 = num3 * i;
			if (pnum1 % num4 == 0) {
				System.out.println(num3+"과 "+ num4 + " 의 최소 공배수 : " + pnum1);
				return;
			}
		}

	}

}
