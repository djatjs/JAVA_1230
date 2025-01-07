package day05;

import java.sql.ResultSet;
import java.util.Scanner;

public class Ex12_Lotto {

	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 수 6개를 생성하고, 1개의 보너스 번호를 생성한다 
		 * 1~45 사이의 정수 6개를 입력받아 입력한 정수가 몇등인지확인하는 코드 작성 
		 * 1등 : 6개 일치 
		 * 2등 : 5개 일치, 보너스 일치 
		 * 3등 : 5개 일치 
		 * 4등 : 4개 일치 
		 * 5등 : 3개 일치 
		 * 꽝 : 나머지
		 */
		
		int min = 1, max = 45;
		
		// 로또 배열 만들기
		int[] lotto = Ex11_ArrayRandom2.createRandomArray(min, max, 6);
		
		// 일단 출력
		Ex11_ArrayRandom2.printArray(lotto);

		// 마지막 7번째 숫자 : 배열 안에 없는 숫자일 때까지 반복
		int bonus = 0;
		do{
			bonus = (int) (Math.random() * (max - min + 1) + min);
		}while(Ex11_ArrayRandom2.contains(lotto, bonus));
		
		// 일단 출력22
		System.out.println("보너스 : " + bonus);
		
		// 입력 받기
		Scanner scan = new Scanner(System.in);
		int[] myNum = new int[6];
		System.out.println("로또 숫자를 입력해주세요(1~45)");
		for (int i=0; i<myNum.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 : ");
			myNum[i]=scan.nextInt();
			System.out.println(myNum[i]+" ");
		}
		
		//랜덤 번호와 입력 번호의 일치하는 개수를 셈
		int count=0;
		for (int i = 0; i < lotto.length; i++) {
			//로또에서 꺼내서 사용자 번호와 일치하는지 확인해서 일치하면 개수 증가
			if(Ex11_ArrayRandom2.contains(lotto, myNum[i])){
				count++;
			}
		}
		
		//일치하는 개수에 따라 등수 출력
		switch(count) {
		case 6:
			System.out.println("1등!");
			break;
		case 5:
			if(Ex11_ArrayRandom2.contains(myNum, bonus)) {
				System.out.println("2등!");
			}else {
				System.out.println("3등!");
			}
			break;
		case 4:
			System.out.println("4등!");
			break;
		case 3:
			System.out.println("5등!");
			break;
		default:
			System.out.println("꽝!");
		}

	}
}
