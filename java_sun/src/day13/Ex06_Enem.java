package day13;

import java.util.Scanner;

public class Ex06_Enem {

	/* 열거형
	 * - 상수 데이터들의 집합
	 * - enum을 이용하여 선언
	 * - 사용하는 값을 제한할 수 있음
	 * enum 열거형명{
	 * 	값1, 값2, 값3, ..., 값n
	 * }
	 * */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("계절 입력 : (봄:SPIRNG, 여름:SUMMER, 가을:FALL, 겨울:WINTER)");
		String str = scan.next();
		Season season = Season.valueOf(str);
		
		//valueOf(문자열) : 입력한 문자열과 이름이 같은 열거형 값이 있다면 해당 객체로 리턴. 없으면 예외 발생
		
		switch(season) {
		case SPIRNG:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		}
		
		System.out.println("계절 입력 : (1:봄, 2:여름, 3:가을, 4:겨울)");
		int num = scan.nextInt();

		/* 열거형.values() : ,
		 * 열거형객체.ordinal() : 열거형 객체의 순서를 알려줌. 0부터 시작
		 * */
		for(Season tmp : Season.values()) {
			if(num==tmp.ordinal()+1) {
				season = tmp;
			}
		}
		
		switch(season) {
		case SPIRNG:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		}
	}

}
enum Season{
	SPIRNG, SUMMER, FALL, WINTER
}