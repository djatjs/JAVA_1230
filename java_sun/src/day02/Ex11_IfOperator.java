package day02;

import java.util.Scanner;

public class Ex11_IfOperator {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받는 코드 작성
		 * 예시
		 * 두 정수와 산술 연산자를 입력하세요. ( 1 + 2 ) : 3 * 4
		 * */
		
		int num1, num2;
		char oper;
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		
		num1 =scan.nextInt();
		oper =scan.next().charAt(0);
		num2 =scan.nextInt();
		
//		System.out.println("" + num1 + " " + oper + " " + num2);
		

		/*연산자가 + 이면 두 수의 합 
		 *연산자가 - 이면 두 수의 차
		 *연산자가 * 이면 두 수의 곱
		 *연산자가 / 이면 두 수의 나눈 값
		 *연산자가 % 이면 두 수의 나머지
		 *산술 연산자가 아니면 잘못된 산술연산자라고 출력
		 * */
		
		if (oper == '+') {
			System.out.println("" + num1 + " " + oper + " " + num2 + " = " + (num1 + num2));
		}
		else if (oper == '-') {
			System.out.println("" + num1 + " " + oper + " " + num2 + " = " + (num1 - num2));
		}
		else if (oper == '*') {
			System.out.println("" + num1 + " " + oper + " " + num2 + " = " + (num1 * num2));
		}
		else if (oper == '/') {
			System.out.println("" + num1 + " " + oper + " " + num2 + " = " + ((double)num1 / num2));
		}
		else if (oper == '%') {
			System.out.println("" + num1 + " " + oper + " " + num2 + " = " + (num1 % num2));
		}
		else {
			System.out.println(oper + ": 잘못된 산술 연산자");
		}
	
	}
	
		
	
}
