package day06;

public class Ex01_Swap {

	public static void main(String[] args) {
		/* 두 정수의 값을 바꾸는 코드 작성*/
		int num1=10, num2=20;
		
		// num1에 20, num2에 10이 저장되도록 코드 작성하고 출력해서 확인하기
		int change;
		change =num1;
		num1 = num2;
		num2 = change;
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
	}

}
