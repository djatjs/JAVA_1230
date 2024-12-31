package day02;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 월에 맞는 계절 출력 
		 * 봄 : 3,4,5
		 * 여름 : 6,7,8
		 * 가을 : 9,10,11
		 * 겨울 : 12,1,2
		 * 잘못된 월 : 그 외 */
		
		int month =13;
		
		switch (month) {
		case 3: case 4: case 5: // case 3, 4, 5
			System.out.println(month + " : 봄");
			break;
				
		case 6: case 7: case 8:
			System.out.println(month + " : 여름");
			break;
			
		case 9: case 10: case 11:
			System.out.println(month + " : 가을");
			break;
			
		case 12: case 1: case 2:
			System.out.println(month + " : 겨울");
			break;
			
		default:
			System.out.println(month+ " : 잘못된 월");
		}
		

	}

}
