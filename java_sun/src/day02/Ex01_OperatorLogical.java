package day02;

import java.awt.DisplayMode;
import java.time.chrono.IsoChronology;

public class Ex01_OperatorLogical {

	public static void main(String[] args) {
		// 성적을 저장하기 위한 정수 변수를 선언하고, 80으로 초기화
		int score = 80;
		
		// 성적이 80이상이고, 90미만이면 참
		boolean inB = (score >= 80 && score <90);
		System.out.println(score + "는 B입니까? " + inB);
		
		
		// 나이가 19세 이상이면 성인으로 판별하는 예제
		int age = 10;
		boolean isAdult = age >= 19;
		System.out.println(age + "살은 성인일까요? " + isAdult);
		
		// 나이가 19세 이상이 아니면 청소년으로 판별하는 예제(!연산자)
		System.out.println(age + "살은 미성년자인가요? " + !isAdult);
		
		// 정수가 0이상인지 판별하는 예제(|| 연산자)
		int num = 0;
		boolean isPositive = num >0 || num ==0;
		// boolean isPositive = num >= 0;
		System.out.println(num + "는 0이상인가요? "+ isPositive);
	}

}
