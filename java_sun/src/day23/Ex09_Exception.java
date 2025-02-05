package day23;

public class Ex09_Exception {

	public static void main(String[] args) {
		//0으로 나눴을 때 0으로 나눌 수 없다고 출력
		double num1 =1L, num2 =0L;
		
		try {
			if(num2==0) {
				throw new Exception();
			}
			System.out.println(num1+ "/"+num2+"="+ num1/num2);
		} catch (Exception e) {
			System.out.println("0으로 나눌 수 없음");
		}
	}
	public void ZeroException() {
		
	}

}
