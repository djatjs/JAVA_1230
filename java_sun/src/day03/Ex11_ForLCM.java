package day03;

import java.util.Scanner;

import javax.naming.InitialContext;

public class Ex11_ForLCM {

	public static void main(String[] args) {
		/* 정수 num1과 num2를 입력받고 두 정수의 최소 공배수를 구하는 코드 작성
		 * A의 배수 : 어떤 수를 A로 나누었을 떄 나머지가 0이 되는 수
		 * 공배수 : 공통으로 있는 배수
		 * 최소공배수 : 공배수 중 가장 작은 공배수
		 * 8의 배수 : 8 16 24 ...
		 * 12의 배수 : 12 24 36 ...
		 * 8과 12의 최소 공배수 : 24
		 * */
		
		// 이건 좀 이해하기 어려울듯
		// num1을 2배 3배 4배 ... 하다보면 처음으로 num2로 나누어 떨어지는 시점이 올거임. 그 숫자가 최소공배수.
		Scanner scan = new Scanner(System.in);
		int lcm = 0;
		int count = 0;
		
		System.out.print("1번째 숫자 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("2번째 숫자 입력 : ");
		int num2 = scan.nextInt();

		for (int i = 1; ; i++) {
			int pnum = num1 * i;
			count +=1;
			if(pnum % num2 == 0) {
				lcm = pnum;
				System.out.println(num1+"과 "+ num2 + "의 최소 공배수 : "+ lcm);
				System.out.println("반복횟수 : " + count);
				break;
			}
		}
		
		System.out.println();
		count = 0;
		// 이게 더 간결하긴 하네. 근데 반복횟수로 따지면 비효율적
		System.out.print("1번째 숫자 입력 : ");
		int num3 = scan.nextInt();
		System.out.print("2번째 숫자 입력 : ");
		int num4 = scan.nextInt();
		
		for (int i=1; ; i++) {
			count +=1;
			if(i % num3 == 0 && i % num4 == 0) {
				System.out.println(num3+"과 "+ num4 + "의 최소 공배수 : "+ i);
				System.out.println("반복횟수 : " + count);
				break;
			}
		}
		
		System.out.println();
		count = 0;
		
		// 효율적인 방법. 맨 위에꺼랑 같은 원리임
		for (int i= num3; ; i+=num3) {
			count +=1;
			if(i % num4 == 0) {
				System.out.println(num3+"과 "+ num4 + "의 최소 공배수 : "+ i);
				System.out.println("반복횟수 : " + count);
				break;
			}
		}
		
	}

}
