package day04;

import java.util.Scanner;

public class Ex03_Method {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 정수 입력받음
		System.out.print("1번째 숫자 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("2번째 숫자 입력 : ");
		int num2 = scan.nextInt();

		// 함수 호출(리턴 타입이 있으니까 변수 = 함수();)
		int gcdResult = gcd(num1, num2);
		int lcmResult = lcm(num1, num2);
		int lcmResult2 = lcm2(num1, num2);
		// 둘 다 결국 같은 결과이긴함
		System.out.printf("%d와 %d의 최대공약수 : %d%n", num1, num2, gcdResult);
		//System.out.println(num1+"와 "+ num2 + "의 최대공약수 : " + gcd(num1,num2));
		System.out.println(num1+"와 "+ num2 + "의 최소 공배수 : "+ lcmResult);
		//System.out.println(num1+"와 "+ num2 + "의 최소 공배수 : "+ lcm(num1,num2));
		System.out.println(num1+"와 "+ num2 + "의 최소 공배수 : "+ lcmResult2);
		System.out.println(num1+"와 "+ num2 + " 사이의 랜덤 값 : " + random(num1,num2));
		
	}

	
	
	/**
	 * 기능 : 최대공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 ->int num1, int num2
	 * 리턴타입 : 정수-> int
	 * 매소드명 : gcd
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 최대 공약수
	 * */
	public static int gcd(int num1, int num2) {
		int gcd = 0;
		for (int i = 1; i<=num1; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
	/**
	 * 기능 : 최대공배수를 알려주는 메소드
	 * 매개변수 : 두 정수 ->int num1, int num2
	 * 리턴타입 : 정수-> int
	 * 매소드명 : lcm
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 최소공배수
	 * */
	public static int lcm(int num1, int num2) {
		for (int i= num1; ; i+=num1) {
			if(i % num2 == 0) {
				return i;
			}
		}
	}
	
	public static int lcm2(int num1, int num2) {
		// 메소드 재사용 가능
		/* 최대 공약수를 알 때 최소 공배수를 계산
		 * A : Ga, B : Gb
		 * L : Gab => A*B/G
		 * */
		return num1*num2/gcd(num1, num2);
	}
	
	/**
	 * 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하는 메소드
	 * 매개변수 : 최소값, 최대값 -> int min, int max 
	 * 리턴타입 : 정수 -> int
	 * 메소드명 : random
	 * */
	public static int random(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
}
