package day23;

public class Ex08_Exception {

	public static void main(String[] args) {
		//다음 코드를 실행했을 때 생기는 예외에 대한 원인과 해결 방법 설명하기
		int num1=1, num2 =0;
		try {
			System.out.println(num1+ "/"+num2+"="+ num1/num2);			
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누려는데 그게 되겠냐");
		}
		System.out.println("프로그램 종료");
	}

}
