package day02;

public class Ex03_OperatorConditional {

	public static void main(String[] args) {
		int num = 43;
		// num이 홀수면 false, 짝수면 true
		boolean isEven = num % 2 == 0;
		System.out.println(num+"는 짝수? "+ isEven);
		
		// num이 홀수면 홀수라 출력하고, 짝수면 짝수라고 출력하기
		String result = (num % 2 == 0)?  "짝수" : "홀수";
		System.out.println(num+" : "+result );

	}

}
