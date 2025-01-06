package day05;

import java.sql.ResultSet;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/* 1~10 사이의 중복되지 않은 랜덤한 수 6개를 배열에 저장하는 코드
		 * */
		int min =1, max=10, count=0;
		int [] arr = new int[6];
		
		while(count<arr.length) {
			int num = (int)(Math.random() * (max - min + 1) + min);
			boolean result = false;
			for (int i=0; i<arr.length;i++) {
				if(num==arr[i]) {
					result = true;
					break;
				}
			}
			if(result) {
				continue;
			}
			else {
				arr[count]=num;
				count++;
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	public static void printArray(int[]arr) {
		for (int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
	//아니 메소드로 못바꾸겠음;;;;;;;;;;;;;
	
	public static int[] createArray(int min, int max, int count) {
		int count1 =0;
		int [] array = new int[6]; 
		while(count1 < array.length) {
			boolean result = false;
			int num = (int)(Math.random() * (max - min + 1) + min);
			
			for (int i=0; i<array.length;i++) {
				if(array[i]==num) {
					result = true;
					break;
				}
			}if(result) {
				continue;
			}else {
				array[count1]=num;
				count1++;
			}
		}return array;
	}

}
