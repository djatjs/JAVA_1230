package day07;

public class Ex01_For {

	public static void main(String[] args) {
		// 1~16 출력하는 코드
		int max =16;
		int enter=4;
		for(int i=1; i<=max; i++) {
			System.out.print(i+" ");
			if(i%enter==0) {
				System.out.println();
			}
			
		}

	}

}
