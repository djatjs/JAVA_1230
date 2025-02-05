package day23;

public class Ex04_Method {

	public static void main(String[] args) {
		//두 정수의 합을 구하는 메소드 생성 후 테스트
		int num1=1, num2=2;
		sum(num1, num2);
		
		//세 정수의 합을 구하는 메소드 생성 후 테스트
		int num3= 3;
		sum(num1, num2 ,num3);
	}
//	public static void sum(int num1, int num2) {
//		System.out.println(num1+num2);
//	}
//	public static void sum(int num1, int num2, int num3) {
//		System.out.println(num1+num2+num3);
//	}
	public static void sum(int ... nums) {
		int sum = 0;
		for(int num : nums) {
			sum=+num;
		}
		System.out.println(sum);
	}

}
