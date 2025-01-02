package day03;

public class Ex20_NestingAlphabet {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 하시오.
		 * a
		 * ab
		 * abc
		 * abcd
		 * ....
		 * adbcef...xyz
		 * */

		char ch, lastCh= 'z';
		for(lastCh = 'a'; lastCh <='z'; lastCh++) {
			for (ch ='a'; ch<=lastCh; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
		// 꼼수 - 첫번째 for문 세로줄, 두번째 for문 가로줄
		for(char i='a'; i<='z'; i++) {
			for(char j='a'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		
	}


}
