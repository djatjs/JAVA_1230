package day17.ver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.asList(4,5,6);
		Record r = playGame(list);

	}

	private static Record playGame(ArrayList<Integer> nums) {
		int strike, ball;
		List<Integer> user = new ArrayList<Integer>();
		
		do {
			user.clear();
			System.out.println("입력 : ");
			//사용자가 중복되지 않게 입력했다고 가정
			while(user.size()<3) {
				user.add(scan.nextInt());
			}
			strike = getStrike(nums, user);
			ball = getBall(nums, user);
			printResult(strike, ball);
			
		}while(strike <3);
		return null;
	}
	private static int getStrike(ArrayList<Integer> nums, List<Integer> user) {
		int count=0;
		for(int i=0; i<nums.size(); i++) {
			if(nums.get(i)==user.get(i)) {
				count++;
			}
		}
		return count;
	}

	private static int getBall(ArrayList<Integer> nums, List<Integer> user) {
		int count=0;
		for(int num : nums) {
			if(user.contains(num)) {
				count++;
			}
		}
		return count - getStrike(nums, user);
	}

	private static void printResult(int strike, int ball) {
		if(strike !=0) {
			System.out.println(strike +"S");
		}
		if(ball !=0) {
			System.out.println(ball+"B");
		}
		if(strike ==0 && ball ==0) {
			System.out.println("OUT");
		}
		System.out.println();
		
	}

	private static int random(int min, int max) {
		if(max<min) {
			int tmp = min;
			min= max;
			max=tmp;
		}
		return (int)(Math.random()*(max-min+1)+max);
	}

	

}
