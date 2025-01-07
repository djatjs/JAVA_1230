package day06;

public class Ex02_ArrayMax {

	public static void main(String[] args) {
		/* 배열에 저장된 값 중 가장 큰 값을 출력하는 코드*/
		int [] arr= new int[] {-1,-20,-9,-10,-3,-4};
		
		int max= Integer.MIN_VALUE;
		for (int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println("배열에 저장된 값 중 가장 큰 값 : "+max);
	
		// 절대값이 가장 큰 값은?
		
		int [] abs= new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			abs[i] = Math.abs(arr[i]);
			System.out.print(abs[i]+" ");
		}
		System.out.println();
		int abMax= Integer.MIN_VALUE;
		for (int i=0; i<abs.length; i++) {
			if(abs[i]>max) {
				abMax=abs[i];
			}
		}
		System.out.println("배열에 저장된 값 중 절대값이 가장 큰 값 : "+abMax);
	}

}
