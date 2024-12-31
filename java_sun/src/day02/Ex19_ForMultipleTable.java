package day02;

public class Ex19_ForMultipleTable {

	public static void main(String[] args) {
		/* 2단 출력하기
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * ...
		 * 2 X 9 =18
		 * 반복횟수 : 9
		 * 규칙성 ""+ 2 + " " + "X" + " " + i + " = " + (2 * i) 
		 * 반복문 종료 후 : 없음
		 * */

		int num = 3;
		for (int i=1; i<=9; i++) {
			System.out.println(num + " X "+ i + " = " + (2 * i) );
		}
	}

}
