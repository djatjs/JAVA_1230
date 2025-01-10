package day09;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/*
		 * 파일명을 수정하는 기능을 구현하시오
		 * 수정하려는 파일명을 입력받고(확장자 포함)
		 * 수정하려는 파일명을 입력받아(확장자 제외)
		 * 파일명을 수정하시오.
		 * 
		 * 입력 : test.txt
		 * 수정 : 연습
		 * 결과 : 연습.txt
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String input= scan.nextLine();
		int index = input.lastIndexOf(".");
		System.out.print("수정 : ");
		String input2 = scan.nextLine();
		
		//확장자 있는지 확인
		if(index<0) {
			System.out.println("확장자가 없는 파일명입니다.");
			return;
		}
		//이름 받아놓기
		String fileName = input.substring(0,index);

		//이름 교체
		input = input.replace(fileName, input2);
		
		System.out.println("결과 : " + input);
		
		
	}

}
