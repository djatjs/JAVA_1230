package day10;

import java.util.HashSet;

public class Ex05_Set2 {

	public static void main(String[] args) {
		/* 1~9 랜덤한 수를 생성하여 중복되지 않게 3개 만들기
		 * */
		int max=9, min=1;
		HashSet<Integer> set = new HashSet<Integer>(3);
		
		while(set.size()<3) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r); //contains 굳이 안써도됨. 애초에 set가 중복을 허용하지 않으니까. 바로 add 해버리기
		}
		System.out.println(set);
		

	}

}
