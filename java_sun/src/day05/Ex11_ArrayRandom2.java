package day05;

import java.sql.ResultSet;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/*
		 * 1~10 사이의 중복되지 않은 랜덤한 수 6개를 배열에 저장하는 코드
		 */
		int min = 1, max = 10, count = 0;
		int[] arr = new int[6];

		while (count < arr.length) {
			int num = (int) (Math.random() * (max - min + 1) + min);
			boolean result = false;

			for (int i = 0; i < arr.length; i++) {
				if (num == arr[i]) {
					result = true;
					break;
				}
			}

			if (result) {
				continue;
			} else {
				arr[count] = num;
				count++;
			}
		}
		printArray(arr);
		/*
		 * for(int i = 0; i<arr.length; i++) { System.out.print(arr[i] + " "); }
		 * System.out.println();
		 */
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		int[] arr2 = createRandomArray(min, max, 6);
		printArray(arr2);

	}
	
	// 중복 없는 랜덤 배열 만들기
	public static int[] createRandomArray(int min, int max, int size) {
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
	
	// 배열 숫자 나열하기
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// num이 arr배열에 속해있는지 확인
	public static boolean contains(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}

}
