package day06;

public class Ex05_EnhancedFor {

	public static void main(String[] args) {
		int []arr = new int [] {1,15,8,7,3};
		print(arr);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		print2(arr);
	}
	
	
	
	public static void print(int [] arr) {
		for (int i=0; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.print(tmp+" ");
		}
		System.out.println();
	}
	// 보통 전체 조회할 때 씀. 수정 불가
	public static void print2(int [] arr) {
		for (int tmp : arr) {
			System.out.print(tmp+" ");
		}
		System.out.println();
	}

}
