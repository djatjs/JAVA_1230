package day02;

public class Ex07_IfNum {

	public static void main(String[] args) {
		int num= 1;
		// num>0면 양수 0이면 0, num<0면 음수로 출력
		if (num > 0) {
			System.out.println(num + " : 양수");
		}
		else if(num == 0) {
			System.out.println(num + " : 0");
		}
		else {
			System.out.println(num + " : 음수");
		}

	}

}
