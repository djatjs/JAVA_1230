package day03;

public class Ex19_NestingPrimeNum {

	public static void main(String[] args) {
		// 100 이하의 소수를 출력하는 코드

		int num = 0, count = 0;
		for (num = 2; num <= 100; num++) {
			count = 0;
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print(num + " ");
			}
		}

		int count1 = 0;
		for (int i = 1; i <= 100; i++) {
			count1 = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count1 += 1;
				}
			}
			if (count1 == 2) {
				System.out.print(i + " ");
			}
		}

	}

}
