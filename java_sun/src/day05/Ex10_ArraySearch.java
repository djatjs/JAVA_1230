package day05;

public class Ex10_ArraySearch {

	public static void main(String[] args) {
		// 배열에 num이 있는지 없는지 판별하는 코드
		
		int[] arr = new int[] {1,2,3,4,5};
		int count =0;
		int num =5;
		
		boolean result = false;
		
		// contain 메소드로 대체 가능
		for (int i=0;i<arr.length;i++) {
			if(arr[i] == num) {
				result= true;
				break;
			}result= false;
		}
		
		
		//일단 확인
		if(result) {
			System.out.println("배열안에 num 있음");
		}else {
			System.out.println("배열안에 num 없음");
		}
		// contain 메소드도 확인
		if(contains(arr, num)) {
			System.out.println("배열안에 num 있음");
		}else {
			System.out.println("배열안에 num 없음");
		}
		//메소드 오버로딩
		if(contains(arr, 3, num)) {
			System.out.println("배열안에 num 있음");
		}else {
			System.out.println("배열안에 num 없음");
		}
	}
	/*배열에 num이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열과 num=> int[] arr, int num
	 * 리턴타입 : boolean
	 * 메소드명 : contains */
	public static boolean contains(int[] arr, int num) {
		for (int i=0;i<arr.length;i++) {
			if(arr[i] == num) {
				return true;
			}
		}return false;
	}
		
	/*배열 중 0번지 부터 n개를 비교하여 num이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 비교개수, num=> int[] arr, int count,int num
	 * 리턴타입 : boolean
	 * 메소드명 : contains */
	public static boolean contains(int[] arr, int count, int num) {
		// 배열의 크기보다 큰 숫자가 count로 오면 count를 배열의 크기로 변경
		if (arr.length<count) {
			count=arr.length;
		}
		for (int i=0; i<count; i++) {
			if(arr[i] == num) {
				return true;
			}
		}return false;
	}

}
