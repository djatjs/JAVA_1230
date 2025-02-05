package day23;

public class Ex01_If {

	public static void main(String[] args) {
		//홀짝 판별 예제. 잘못된 부분 찾아 수정하기.
		int num = 3;
		if(num % 2== 0) {
			System.out.println(num+" : 짝수");
		}
		if(num % 2 != 0) {
		System.out.println(num+" : 홀수");
		}
	}

}
