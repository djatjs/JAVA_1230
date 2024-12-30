package day01;

public class Ex06_String {

	public static void main(String[] args) {
		String str1 = "Hello World!";
		System.out.println(str1);
		
		String str2 = ""; //비어있을 수도 있음.
		System.out.println(str2);
		
		String str3 = "A"; //한글자일 수도 있음.
		System.out.println(str3);

		String str4 = null; //없을 수도 있음
		System.out.println(str4); // null이라는 문자열이 출력되는게 아님. 그냥 상태.
		
		char ch1 = '1';
		char operator = '+';
		char ch2 = '2';
		System.out.println(ch1 + operator + ch2); // +가 왜 4로 취급되는거지
		System.out.println(ch1 + operator + ch2 + "");
		// int로 변해서 더해짐?
		System.out.println(""+ ch1 + operator + ch2);
		// 문자열의 차인가?
	}

}
