package day09;

public class Ex13_Exception {

	public static void main(String[] args) {
		
		 try{
			 test1(); //네번째 예외 발생

		 }catch (Exception e) {
			 System.out.println(e.getMessage());//"예외 발생" 출력
			// TODO: handle exception
			 e.printStackTrace(); //어디서 예외 발생했는지 알려줌
		}
		System.out.println("프로그램 종료");		

	}
	public static void test1() {
		test2(); //세번째 예외 발생
	}
	public static void test2() {
		test3(); //두번째 예외 발생
	}
	public static void test3() {
		throw new RuntimeException("예외 발생"); //첫번째 예외 발생
	}
	
}
