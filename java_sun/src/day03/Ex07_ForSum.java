package day03;

public class Ex07_ForSum {

	public static void main(String[] args) {
		/* 1부터 10까지의 합을 구하는 코드
		 * */
		int num =10;
		int sum = 0;
		for (int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println("1부터 "+ num +"까지의 합 : " + sum);

		
		// 홀수
		sum=0;
		for (int i = 1; i<=num; i+=2) {
			// System.out.print(i + " ");
			sum += i;
		}
		System.out.println("1부터 "+ num +"까지의 홀수 합 : " + sum);
		

		// 짝수
		sum=0;
		for (int i = 2; i<=num; i+=2) {
			// System.out.print(i + " ");
			sum += i;
		}
		System.out.println("1부터 "+ num +"까지의 짝수 합 : " + sum);
	}

}
