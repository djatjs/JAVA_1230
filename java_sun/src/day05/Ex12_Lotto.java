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

		int[] lotto = new int[7];
		int bonus = 0; // 이건 배열에 저장된거랑도 안겹쳐야됨
		int min = 1, max = 45;

		int count = 0;
		while (count < lotto.length - 1) {
			Boolean result = false;
			int num = (int) (Math.random() * (max - min + 1) + min);
			for (int i = 0; i < lotto.length - 1; i++) { // 중복 확인
				if (num == lotto[i]) {
					result = true; // 겹친다면
					break;
				} // else는 위에 이미 false로 설정해둬서 필요없음
			}
			if (result) {// 포함한다면
				// continue;
			} else {
				lotto[count] = num;
				count++;
			}
		}
		while (lotto[6] ==0) {
			Boolean result = false;
			bonus = (int) (Math.random() * (max - min + 1) + min);
			for (int i = 0; i < lotto.length - 1; i++) {
				if (bonus == lotto[i]) {
					result = true; // 겹친다면
					break;
				}

			}
			if (result) {// 포함한다면
				// continue;
			} else {
				count++;
				lotto[6] = bonus;
			}

		}
		// 일단 출력
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
		
		// 입력 받기
		Scanner scan = new Scanner(System.in);
		int[] myNum = new int[6];
		System.out.println("1~45까지 숫자를 입력해주세요");
		for (int i=0; i<myNum.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 : ");
			myNum[i]=scan.nextInt();
			System.out.println(myNum[i]+" ");
		}

	}
}
