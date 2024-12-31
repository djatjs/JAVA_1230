package day02;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		/*정수 num이 2의배수인지, 3의 배수인지, 6의 배수인지, 그 무엇도 아닌지 판별하기 
		 * 2 : 2의 배수
		 * 3 : 3의 배수
		 * 5 : 그 무엇도 아님
		 * 6 : 6의 배수
		 * */
		
		int num =8;
		
		// 중첩 if
		if (num % 2 == 0) { // 일단 2의 배수
			if (num % 3 == 0) { // 그중에 6의 배수
				System.out.println(num + " : 6의 배수");
			}
			else { 
				System.out.println(num + " : 2의 배수");
			}
		}
		else if (num % 3 == 0) { // 3의 배수
			System.out.println(num + " : 3의 배수");
		}
		else { // 그 무엇도 아님
			System.out.println(num + " : 2, 3, 6의 배수가 아님");
		}
		
		
		// 서순 상관 X (근데 맞추긴했음 ㅋㅋ)
		if (num % 2 == 0 && num % 3 == 0) {
			System.out.println(num + " : 6의 배수");
		}
		else if (num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + " : 2의 배수");
		}
		else if (num % 2 != 0 && num % 3 == 0) {
			System.out.println(num + " : 3의 배수");
		}
		else
		{
			System.out.println(num + " : 2, 3, 6의 배수가 아님");
		}
		
		
		// 서순 지킴
		if (num % 6 == 0) {
			System.out.println(num + " : 6의 배수");
		}
		else if (num % 2 == 0) {
			System.out.println(num + " : 2의 배수");
		}
		else if (num % 3 == 0) {
			System.out.println(num + " : 3의 배수");
		}
		else {
			System.out.println(num + " : 2, 3, 6의 배수가 아님");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
