package day01;

public class Ex03_Num {

	public static void main(String[] args) {
		byte num1 =1;
		// num1 = 12345; 저장할 수 있는 범위를 넘어서 에러 뜰거임.
		System.out.println(num1);
		
		int num2 = 123456789;
		// 무난하게 int 쓰는게 좋음 ㅇㅇ
		System.out.println(num2);
		
		// int num3 = 1234567890123456789; int도 저장가능한 범위 넘어가면 안되긴 함 
		long num3 = 1234567890123456789l; // 접미사 l 안 붙이면 에러 뜸. int로 보기 때문에.
		System.out.println(num3);
		
		float num4 = 3.14f; // 접미사 f 안 붙이면 에러 뜸. double로 보기 때문에.
		System.out.printf("%.9f\n",num4); // 소수점 6자까지 정확하다고 함.
		
		double num5 = 3.14;
		System.out.printf("%.20f\n",num5); // 얜 11자리까지 정확하긴 함.
		
		// 십진수 표현이 아닌 값을 정수에 저장해보기
		int num6 = 0x10;
		System.out.println(num6); //16진수 10 ->16
		
		int num7 = 010;
		System.out.println(num7); //8진수 10 ->8
		
		int num8 = 0b10;
		System.out.println(num8); //2진수 10 ->2
	
		int num9 = 'A';
		System.out.println(num9); //'A'에 해당하는 정수값(0041) 저장 -> 65
		
		double num10 = 1e3;
		System.out.println(num10); //1*10^3 -> 1000
	}

}
