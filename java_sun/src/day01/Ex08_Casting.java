package day01;

public class Ex08_Casting {
	public static void main(String[] args) {
		// 자동 자료형 변환
		double num1 = 1; // int -> double
		
		int num2 = 'A'; // char -> int
		
		long num3 = 1234; // int -> long
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		//작은곳에서 큰 곳으로 가는건 이상이 없음
		
		// 강제 자료형 변환 : 데이터 손실이 발생할 수 있음
		// int num4 = 3.14; double 값이 int로 변하면 소수점이 사라질 수 있어서 에러 발생
		int num4 = (int)3.14;
		System.out.println(num4);
		
		// int num5 = 123L; long 값이 int로 변하면 표현하지 못하는 부분이 사라질 수 있어서 에러 발생
		int num5 = (int)123L;
		System.out.println(num5);
		
		//강제 자료형 변환 : 원하는 결과값을 위해
		double result = 1/2;
		System.out.println(result); // 근데 정수 나누기 정수는 정수임; 0.5 안나옴.
		
		double result1 = (double)1/2; // 이러면 됨.
		System.out.println(result1);
		
	}

}
