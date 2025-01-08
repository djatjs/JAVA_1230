package day07;

public class Ex03_PrimeNum {

	public static void main(String[] args) {
		// 정수 num가 소수인지 아닌지 판별하는 코드

		int num =7;
		int count = countForPrime(num);
		isPrime(num, count);
		
		
		// 다른 방식
		if(isPrimeNumber(num)) {
			System.out.println(num +" : 소수" );
		}
		else {
			System.out.println(num +" : 소수 아님" );
		}
		
		// 100 이하의 소수를 판별하기 위해 배열을 활용해서 작성하기
		// i가 소수면 i번지에 true를, i가 소수가 아니면 i번지에 false를 저장
		boolean[] primeArray = new boolean[101];
		for(int i=0; i<primeArray.length; i++) {
			primeArray[i]=isPrimeNumber(i);
			// System.out.println(i +"는 소수인가요? : "+primeArray[i]);
			
			//primeArray를 이용하여 소수들만 출력하는 코드
			if(primeArray[i]) {
				System.out.print(i +" " );
			}
		}
		System.out.println();
		// 이것도 소수 출력하는거임
		printPrimeArray(primeArray);
		
		
	}
	
	// 소수는 1과 본인만으로만 나누어 떨어지는 되는 수임 -> count==2여야함
	public static int countForPrime(int num) {
		int count =0;
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				count++;
			}
		}return count;
	}
	
	public static void isPrime(int num, int count) {
		if(count ==2) {
			System.out.println(num +" : 소수" );
		}
		else {
			System.out.println(num +" : 소수 아님" );
		}
	}
	
	//다른 방식
	public static boolean isPrimeNumber(int num) {
		int i;
		for(i=2; i<num; i++) {
			if(num%i==0) {
				break;
			}
		}
		if(i ==num) {
			return true;
		}
		return false;
	}
	
	
	public static void printPrimeArray(boolean[] primeArray) {
		for(int i=0; i<primeArray.length; i++) {
			if(primeArray[i]) {
				System.out.print(i +" " );
			}
		}
	}

}
