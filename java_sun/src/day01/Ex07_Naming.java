package day01;

public class Ex07_Naming {

	public static void main(String[] args) {
		int num= 10;
		int Num = 11; // 대소문자 구분. 서로 다른 변수
		System.out.println(num+Num);
		
		// int int; 예약어(키워드)는 사용 불가.
		// int 1num = 10; 변수명은 숫자로 시작 못함
		
		int _num = 10; //특수문자는 _와 $만 가능
		
		// int n um =10; 되겠냐?
		// int %num = 10; 되겠냐고
		// int num = 20; 중복 선언 불가
		num = 20; //이렇게 하던지		

	}

}
