package day23;

import java.util.Scanner;

public class Ex12_String {

	public static void main(String[] args) {
		//잘못된 부분 찾아 수정
		Scanner scan = new Scanner(System.in);
		String str="";
		do {
			System.out.print("입력 : ");
			str = scan.next();
			System.out.println("출력 : "+str);
		}while(!str.equals("EXIT"));
	}

}
