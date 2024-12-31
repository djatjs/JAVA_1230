package day02;

public class Ex04_IfEven {
	public static void main(String[] args) {
		// if문을 이용한 홀짝 판별 예제
		int num = 1;
		
		if (num % 2 == 0){
			System.out.println(num + " : 짝수");
		}
		if (!(num % 2 == 0)) {
			System.out.println(num + " : 홀수");
		}
		
	}

}
