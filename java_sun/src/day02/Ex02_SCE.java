package day02;

import java.awt.desktop.AboutHandler;

public class Ex02_SCE {

	public static void main(String[] args) {
		int num1 = 10 , num2 = 20;
		
		boolean result = num1 < 0 && (num2 =-1) < 0;
		// SCE에 의해 num1이 양수이면 num2가 안바뀌고, 음수이면 -1으로 바뀜
		System.out.println("결과값 : "+ result);
		System.out.println("num1 : "+ num1 + " num2 : "+ num2);
		
	}

}
