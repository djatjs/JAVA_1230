package day07;

public class Ex02_For {

	public static void main(String[] args) {
		// 1~10 합 구하기
		int sum=0;
		int max=10;
		for(int i=1; i<=max; i++) {
			// -2 -4 -6 -8 -10(짝수일 때 빼기)
			if(i%2==0) {
				sum-=i;
			}else{
				sum+=i;
			}
		}
		System.out.println(sum);
	}

}
