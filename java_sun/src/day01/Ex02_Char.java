package day01;

public class Ex02_Char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char ch1; // 문자 변수 ch1 선언. 사용 X
		// System.out.println(ch1); 하면 에러 뜸. 변수 초기화 안하면
		// The local variable ch1 may not have been initialized라고 뜸.
		ch1 = '1'; // 저장 하고 나서 출력.
		System.out.println(ch1);
		
		
		char ch2 = '선'; 
		System.out.println(ch2);
		
		
		char ch3 = '\u0041'; 
		System.out.println(ch3);
		
		char ch4 = '\\', ch5 = '\n', ch6 = '\"'; 
		System.out.println(ch4);
		System.out.print(ch5);
		System.out.println(ch6);
	}

}
