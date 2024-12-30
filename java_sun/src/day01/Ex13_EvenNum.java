package day01;

public class Ex13_EvenNum {

	public static void main(String[] args) {
		// 주어진 num가 짝수이면 true를 아니면 false가 출력되도록 코드 작성하기
		/*
		 * 출력 예시 1
		 * 3은 짝수인가? false
		 * 출력 예시 2
		 * 4는 짝수인가? true
		 * */
		int num1 = 3, num2 = 4;
		boolean isEven; 
		
		isEven = num1 %2 == 0;
		System.out.println(num1 + "은 짝수인가? " + isEven);
		// System.out.println(num1 + "은 짝수인가? " + (boolean)(num1%2==0));
		
		isEven = num2 %2 == 0;
		System.out.println(num2 + "은 짝수인가? " + isEven);
	}

}
