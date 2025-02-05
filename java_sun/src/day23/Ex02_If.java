package day23;

public class Ex02_If {

	public static void main(String[] args) {
		//짝수면 짝수라 출력하고, 2로 나눈 값 출력.
		//홀수면 홀수라 출력하고 +1한 값 출력
		
		int num = 3;
		
		if(num % 2== 0) {
			System.out.println(num+" : 짝수");
			System.out.println(num/2);
		}
		if(num % 2 != 0) {
			System.out.println(num+" : 홀수");
			System.out.println(num+1);
		}
	}

}
