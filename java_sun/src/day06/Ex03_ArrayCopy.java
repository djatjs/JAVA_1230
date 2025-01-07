package day06;

public class Ex03_ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = new int[] {1,3,5,7,9};
		int [] arr2 = new int[arr1.length];
		print(arr1);
		
		
		//arr1에 있는 값을 arr2에 복사하는 코드(반복문)
		arr2 = copyArr(arr1, arr2);
		print(arr2);
		
		// 얕은 복사
		//arr2, 복사시작할 번지, arr3, 붙여놓을 시작번지, 길이
		int [] arr3 = new int[arr2.length];
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		print(arr3);
		
		
		// arr3 0번지부터 2개 복사해서 arr4의 2번지부터 2개 덮어쓰기
		int [] arr4 = new int[arr3.length];
		System.arraycopy(arr3, 0, arr4, 2, 2);
		print(arr4);

	}
	public static void print(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] copyArr(int arr1[], int arr2[]) {
		for (int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

}
