package day09;

import java.text.MessageFormat;
import java.util.Scanner;


public class Ex12_TryCatch2 {

	static	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 메소드를 작성하시오
		 * 단 예외 처리 적용
		 * */
		int num1, num2;
		char op;
		do {
			try {
				System.out.print("입력 : ");
				num1 = scan.nextInt();
				op = scan.next().charAt(0);
				num2 = scan.nextInt();
				calculator(num1, num2, op);
			}catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch (RuntimeException e) {
				System.out.println(MessageFormat.format("{0}", e.getMessage()));
				scan.nextLine();
			}catch (Exception e) {
				//System.out.println("정수 부분에는 정수만 입력해주세요");
				System.out.println(MessageFormat.format("{0}", e.getMessage())); //함수에서 Exception로 해둬서 이래둠
				scan.nextLine();
			}
		}while(true);
		
		
		
		
	}
	public static void calculator(int num1, int num2, char op) throws Exception {
		System.out.print("결과 : ");
		switch(op) {
		case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println(num1/(double)num2);
			break;
		case '%':
			System.out.println(num1%num2);
			break;
		default : 
			//System.out.println("잘못된 연산자로 인해 계산 불가");
			throw new Exception("산술 연산자가 아님");
		}
	}
}
