package day06;


import java.util.Arrays;
import java.util.Scanner;

public class Ex07_BaseballGame {

	public static void main(String[] args) {
		/* 숫자 야구
		 * S : 숫자가 있고, 위치가 같은 경우
		 * B : 숫자는 있지만 위치가 다른 경우
		 * 3O : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 
		 * 랜덤 수 : 3 7 1
		 * 입력 : 1 2 3
		 * 2B
		 * 입력 : 4 5 6
		 * 3O
		 * 입력 : 8 7 9
		 * 1S
		 * 입력 : 3 1 7
		 * 1S2B
		 * 입력 : 3 7 1
		 * 3S
		 * 프로그램 종료
		 * */
		
		//랜덤 배열 생성
		int[] com = createRandomArray(1, 9, 3);
		System.out.println(Arrays.toString(com));
		
		int[] user = new int[3];
		
		int strike, ball;
		
		do {
			strike=0;
			ball=0;
			
			//정수입력
			if(!inputNum(user)) {
				continue;
			}
			
			//스트라이크 판별
			strike= getStrike(com,user);

			//볼 판별 
			ball =getBall(com,user);

			// 게임 결과
			printResult(strike, ball);
			
			
		}while(strike<3);
		System.out.println("프로그램 종료");

	}
	//출력
	public static void printResult(int strike, int ball) {
		if (strike !=0) {
			System.out.println(strike+"S");
		}
		if (ball !=0) {
			System.out.println(ball+"B");
		}
		if (strike ==0 && ball ==0) {
			System.out.println("3O");
		}
		System.out.println();
		
	}
	//배열 입력
	public static boolean inputNum(int[] user) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 3개 입력 (1~9, 중복 X) : ");
		boolean outOfBounds = false;
		boolean dulicated = false;
		
		for(int i=0; i<user.length; i++) {
			int tmp =scan.nextInt();
			
			if (tmp <1 || tmp>9) {
				outOfBounds = true;
			}
			if (contains(user, tmp)) {
				dulicated =true;
			}
			user[i] = tmp;
		}
		if(outOfBounds || dulicated) {
			System.err.println("겹치거나 범위를 벗어난 수가 있습니다.");
		}
		return !(outOfBounds && dulicated);
	}
	//중복 없는 랜덤 배열 만들기
	public static int[] createRandomArray(int min, int max, int size) {
		if(max <min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		// 
		if(max-min +1 <size) {
			return null;
		}
		if (size <= 0) {
			return null;
		}

		int[] arr = new int[size];
		int count = 0;
		
		while (count < arr.length) {
			int num = (int) (Math.random() * (max - min + 1) + min);
			boolean result = false;

			if (contains(arr, num)) {// 포함되어 있다면
				continue; // 넘기셈
			} else {
				arr[count] = num;
				count++;
			}
		}
		return arr;
	}
	//num이 arr배열에 속해있는지 확인
	public static boolean contains(int[] arr, int num) {
		for (int tmp : arr) {
			if (tmp== num) {
				return true;
			}
		}
		return false;
	}
	//배열 출력
	public static void print(int [] arr) {
		for (int i=0; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.print(tmp+" ");
		}
		System.out.println();
	}
	//스트라이크
	public static int getStrike(int[] com, int[]user) {
		int strike =0;
		for (int i =0; i<com.length; i++) {
			if(com[i]==user[i]) {
				strike ++;
			}
		}return strike;
	}
	//볼
	public static int getBall(int[] com, int[]user) {
		//같은 개수 판별 = 스트라이크+볼
		int strike = getStrike(com, user);
		int count =0;
		for (int tmp : com) {
			if(contains(user, tmp)) {
				count++;
			}
		}
		//볼 = 같은 개수 - 스트라이크
		int ball = count - strike;
		return ball;
	}
}
