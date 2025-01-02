package day03;

public class Ex15_WhileEven {
	public static void main(String[] args) {
		// 1~10 까지 짝수 출력
		int i =1;
		while(i<=10) {
			if(i % 2 == 0) System.out.print(i + " ");
			i++;
		}
		System.out.println();
		
		
		i=0;
		// while 문에서 continue 만나면 증감식이 아닌 조건식으로 이동
		while(++i<=10) {
			if(i % 2 != 0){
				continue; 
			}
			System.out.print(i + " ");			
		}
	}
}
