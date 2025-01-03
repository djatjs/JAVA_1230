package day04;

public class Ex06_VariableArgument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(sum(1));
		 System.out.println(sum(1,100));
		 System.out.println(sum(1,100,99));
	}
	// 가변 매개변수와 향상된 for문
	public static int sum(int ... nums) {
		int sum = 0;
		for(int num : nums) {
			sum+=num;
		}
		return sum;
	}

}
