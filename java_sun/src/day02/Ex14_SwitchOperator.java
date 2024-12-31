package day02;

import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		/* 스위치 문을 이용해서 두 정수의 산술 연산 결과를 출력하는 코드 작성
		 *  두 정수와 산술 연산자를 입력하세요.
		 *  1 / 2 = 0.5
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num1 , num2;
		char oper;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요. ex 1 + 2 : ");
		num1 = scan.nextInt();
		oper = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		
		switch (oper) {
		case '+':
			System.out.println(num1 + " "+ oper + " " + num2 + " = " + (num1 + num2));
			break;
		case '-':	
			System.out.println(num1 + " "+ oper + " " + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println(num1 + " "+ oper + " " + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " "+ oper + " " + num2 + " = " + ((double)num1 / num2));
			break;
		case '%':
			System.out.println(num1 + " "+ oper + " " + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println(oper + ": 잘못된 산술 연산자");
		}
		
	}

}
