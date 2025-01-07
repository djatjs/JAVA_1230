package day06;

import java.sql.ResultSet;
import java.util.Scanner;


public class Ex08_ReverseNumber {

	public static void main(String[] args) {
		// 4자리의 정수를 입력받아 역순으로 출력하는 코드
		/* 입력 : 1234
		 * 결과 : 4321
		 * */
		
		// 4자리 숫자 입력하기
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("4자리 숫자를 입력하시오 : ");
			int num = scanner.nextInt();
			if(num >10000 || num<1000) {
				System.err.println("4자리 숫자가 아님");
			}
			else {
				// 1000, 100, 10, 1로 나누기
				for (int i = 0; i < 4; i++) {
				    int digit = num % 10; // 마지막 자리 추출
				    System.out.print(digit);
				    num /= 10; // 마지막 자리 제거
				}
				System.out.println();
				break;
			}
		}
	
		// ㅡㅡ
		System.out.print("4자리 숫자를 입력하시오 : ");
		int num2 = scanner.nextInt();
		
		int tmp=num2;
		if(!checkNumber(num2,4)) {
			System.err.println("4자리 정수가 아님");
			return;
		}
		while (tmp>0) {
			//1의 자리 숫자 출력
			System.out.print(tmp%10);
			//1의 자리 숫자 제거
			tmp /=10;
			//
		}
		
		// 배열
		int []arr = new int[4];
		tmp = num2;
		for (int i=0; i<arr.length; i++) {
			int lastNum = tmp / (int)pow(10, arr.length-i-1);
			arr[i]=lastNum;
			tmp = tmp % (int)pow(10, arr.length -i-1);
		}
		System.out.println();
		for(int i =arr.length -1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		

	}
	public static boolean checkNumber(int num, int size) {
		int min =1*(int)pow(10, size-1);
		int max=1*(int)Math.pow(10, size);
		if(num >= max || num < min) {
			return false;
		}
		return true;
	}
	// 굳이 안만들어도 되긴함
	public static double pow(int a, int n) {
		if(n==0) {
			return 1;
		}
		int res =1;
		if(n>0) {
			for (int i=0; i<n; i++) {
				res *=a;
			}return res;
		}
		n= -n;
		for(int i=0; i<n;i++) {
			res /= (double)a;
		}
		return res;
	}

}
