package day02;

public class Ex15_SwitchGrade {

	public static void main(String[] args) {
		/* 주어진 성적에 맞는 학점 출력
		 *  A : 90 ~ 109
		 *  B : 80 ~ 89
		 *  C : 70 ~ 79
		 *  D : 69 ~ 69
		 *  F : -9 ~ 59 
		 *  잘못된 성적 : 110 이상, -9 미만
		 * */
		
		int score = -9;
		
		switch (score/10) {
		case 9,10: // 
			System.out.println(score + "점 : A");
			break;
		case 8:
			System.out.println(score + "점 : B");
			break;
		case 7:
			System.out.println(score + "점 : C");
			break;
		case 6:
			System.out.println(score + "점 : D");
			break;
		case 0,1,2,3,4,5:
			System.out.println(score + "점 : F");
			break;
		default:
			System.out.println(score + "점 : 잘못된 성적");
				
		
		}

	}

}
