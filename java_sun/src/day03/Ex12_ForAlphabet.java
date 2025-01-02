package day03;

public class Ex12_ForAlphabet {

	public static void main(String[] args) {
		/* a부터 z까지 출력하는 코드 작성
		 * abcdef....xyz
		 * */

		// 소문자
		for (char i='a' ; i<='z'; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		// 대문자
		for (char i='A' ; i<='Z'; i++) {
			System.out.print(i);
		}
		
		System.out.println();
		// 따라하기
		for (int i=0; i<26; i++)
		{
			System.out.print((char)('a'+i));
		}
		

	}

}
