package day03;

public class Ex08_Continue {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수 출력하는 예제
		 * */
		int num= 10;
		
		for (int i=1; i<=num; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.print(i+ " ");
		}

	}

}
