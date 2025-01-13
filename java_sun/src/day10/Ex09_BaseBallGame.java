package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex09_BaseBallGame {

	public static void main(String[] args) {
		/* 숫자 야구 게임 구현
		 * */
		int min = 1, max = 9;
		Scanner scan = new Scanner(System.in);
		
		//랜덤 숫자
		//set로 랜덤 숫자 3개 받기
		ArrayList<Integer> com = creatRandom(min, max);
		int strike=0, ball=0;
		int num=0;
		
		ArrayList<Integer> user = new ArrayList<Integer>();
		
		//반복
		while(strike !=3) {
			//clear()로 리스트에 있는 값 초기화
			user.clear();
			//입력
			while(user.size()<3) {
				System.out.print("사용자 숫자 입력 : ");
				num = scan.nextInt();
				if(!user.contains(num)) {
					user.add(num);
				}else {
					System.out.println("다시 입력하시오");
				}
			}
			
			//스트라이크 개수 판별
			strike=getstrike(com, user);
			//get(번지)

			//볼의 개수 판별
			//일치하는 숫자 개수(위치 상관 X)-스트라이크 개수
			ball= getBall(com, user);
		
			//결과 출력
			gameResult(strike, ball);
		}
	}

	private static int getstrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		int strike=0;
		for (int i=0;i<3;i++) {
			if(com.get(i)==user.get(i)) {
				strike++;
			}
		}
		return strike;
	}
	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		int count=0;
		//contains 쓰면 되지 않을까
		for(int i=0;i<3;i++) {
			if(com.contains(user.get(i))) {
				count++;
				continue;
			}
		}
		int ball = count -getstrike(com, user);
		return ball;
	}

	private static ArrayList<Integer> creatRandom(int min, int max) {
		//세트로 숫자 랜덤으로 받기
		HashSet<Integer>set = new HashSet<Integer>();
		while(set.size()<3) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
		}
		//리스트로 옮기고 셔플
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;
		
	}
	
	private static void gameResult(int strike, int ball) {
		switch(strike) {
		case 3:
			System.out.println("3S");
			break;
		case 2:
			if(ball==1) {
				System.out.println("2S1B");
			}
			else {
				System.out.println("2S");
			}
			break;
		case 1:
			if(ball ==2) {
				System.out.println("1S2B");
			}
			else if(ball ==1) {
				System.out.println("1S1B");
			}
			else {
				System.out.println("1S");
			}
			break;
		case 0:{
			if(ball ==3) {
				System.out.println("3B");
			}
			else if(ball ==2) {
				System.out.println("2B");
			}
			else{
				System.out.println("1B");
			}
			break;
		}
		default:
			System.out.println("OUT");
		}
		
		
		if(strike!=0){
			System.out.println(strike+"S");
		}
		if(ball !=0) {
			System.out.println(ball+"B");
		}
		if(strike==0 && ball==0) {
			System.out.println("OUT");
		}
		System.out.println();
	}
	
}
