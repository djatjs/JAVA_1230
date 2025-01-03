package day04;

import java.util.Scanner;

public class Ex02_MethodSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=100,b=300;
		// 함수 호출 : 함수 리턴값이 있으면 
		//변수 = 함수명();
		int result = sum(a,b);
		
		//함수 호출 : 함수 리턴값이 없다면
		//함수명();
		say();
		
		System.out.println(result);
		System.out.println(sum(5,2));
		
	}
	
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수 : 두 정수 -> int num1, int num2
	 * 리턴타입 : 두 정수의 합 -> 정수 -> int
	 * 메소드명 : sum
	 * */
	
	public static int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	public static void say() {
		System.out.println("GoodDay");
	}

}
