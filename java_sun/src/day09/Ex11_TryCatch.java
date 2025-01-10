package day09;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		
		int[] arr= new int[10];
		
		try {
			//System.out.println(1/0);
			arr[10] = 10;
			
		}catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println("0으로 나눌 수 없습니다.");
			//catch는 순차적으로 하기 때문에 부모클래스가 먼저 오면 에러뜰거임.
		}catch (RuntimeException e) { //조상 클래스
			System.out.println(e);
			System.out.println("이것도 예외지롱");
		}
		catch (Exception e) { //찐조상 클래스
			System.out.println(e);
			System.out.println("이것도 찐예외지롱");
		}
		System.out.println("프로그램 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡ");
		print();

	}
	public static void print() {
		try {
			System.out.println(1/0);
		}catch (Exception e) {
			System.out.println("예외 발생");
			return; 
		}finally {//예외를 만나서 리턴을 실행하기 전에 반드시 수행할 것.  ㅠ                                                  
			System.out.println("프로그램 종료");			
		}
		
	}

}
