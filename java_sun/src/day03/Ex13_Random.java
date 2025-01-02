package day03;

import java.util.Random;

public class Ex13_Random {

	public static void main(String[] args) {
		/* min~max 사이의 랜덤한 수를 생성하는 코드
		 * */
		int min = 1, max = 7;
		
		
		
		// Math,random()는 0이상 1미만의 랜덤한 실수를 제공
		/* 0 <= r < 1
		 * 각 항에 (max - min + 1)을 곱함.
		 * 0 <= r * (max - min + 1) < (max - min + 1)
		 * 각 항에 min을 더함
		 * min <= (max - min + 1) + min < max +1 
		 * 
		 * 그냥 간단하게 생각하면 int a = random.nextInt(99) + 2; 
		 * 이거 같은 경우 2부터 99개를 나타내는걸로 이해하면 됨 -> 2~100까지의 랜덤 숫자인거.
		 * */
		
		
		
		int r = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(r);
		
		// 랜덤 클래스 (max - min + 1) + min 사용
		Random random = new Random();
		
		int a = random.nextInt(30 - 20 + 1) + 20;
		System.out.println(a);

	}

}
