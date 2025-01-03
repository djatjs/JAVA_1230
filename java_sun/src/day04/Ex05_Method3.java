package day04;

public class Ex05_Method3 {

	public static void main(String[] args) {
		// 2~9 구구단 출력 메소드
		int num= 2;
		gugudan(num);
		
		System.out.println();
		gugudan();
	}
	
	
	//2~9까지 다 출력
	public static void gugudan() {
		for (int i=1; i<=9; i++) {
			for (int j =2; j<=9; j++) {
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
			}
			System.out.println();
		}
		return;
	}

	//num단 출력
	public static void gugudan(int num) {
		for (int i =2; i<=9; i++) {
			System.out.printf("%d X %d = %d \n", num, i, num*i);
		}
		return;
	}

}
