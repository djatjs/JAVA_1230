package day05;

public class Ex05_Static2 {

	public static void main(String[] args) {
		System.out.println(sum1(1, 2));
		// System.out.println(sum2(1, 2));
		
		
		Ex05_Static2 s = new Ex05_Static2();
		System.out.println(s.sum2(1, 2));
		
		// main도 static으로 됨. 굳이 객체 안만들어도 기능 사용가능.
		Ex01and02_Day04Homework.main(args);
		
	}
	public static int sum1(int num1, int num2) {
		return num1+ num2;
	}
	public int sum2(int num1, int num2) {
		return num1+ num2;
	}

}
class StaticTest{
	int a; //객체가 만들어질 때 선언됨. 선언이 안되어있는 상태이므로 사용불가
	static int sa; // 객체가 만들어지기 선언됨.
	
	
	public void printA() {
		a=10;
		sa=10;
	}
	private static void printSa() {
		// a=10; // 객체 변수는 정적 메소드에서 사용할 수 없음.
		StaticTest st = new StaticTest();
		st.a =10; // 객체 변수 사용을 위해 객체를 생성한 후 사용하면 가능.
		sa =10;
	}
	
	
	public void test() {
		printA();
		printSa();
	}
	public static void staticTest() {
		//printA(); // 객체 메소드는 정적 메소드에서 사용할 수 없음
		StaticTest st = new StaticTest();
		st.printA(); // 객체 메소드를 사용하기 위해 객체를 생성한 후 사용하면 가능
		printSa();
	}
}