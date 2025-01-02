package day03;

public class Ex18_gugudan {
	public static void main(String[] args) {
		// 2~9단 출력하기
		for (int i =2; i<=9; i++) { //단계
			System.out.println(i+"단");
			for (int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println();
		}
		
		// 가로로 나타내기
		for (int i=1; i<=9; i++) {
			for (int j =2; j<=9; j++) {
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
			}
			System.out.println();
		}	
	
	
	
	
	}
}
