package day08;

public class Ex09_Interface {
	public static void main(String[] args) {
		// 인터페이스는 객체 생성 불가능. static 붙은 것도 같은 이유.
		System.out.println(ConsoleProgram.num);

		/* 구현 클래스와 인터페이스의 형변환 */
		ConsoleProgram cp = new StudentScoreProgram();
		cp.run();
		ConsoleProgram.test();
	}
}

// 인터페이스 정의
interface ConsoleProgram {
	/* public static final */int num = 10;

	void print();

	void runMenu(int menu);

	void run();

	// default 메소드는 나중에 추가 되어도 기존 구현 클래스들에게 문제를 일으키지 않음.
	default void func1() {
		// 구현부 있는데 오버라이딩 해도 되고 안해도됨.
	};

	static void test() {
		// 구현부 있는데 오버라이딩 해야 됨.
		System.out.println("정적 메소드");
	}
}

// 인터페이스를 이용하여 구현클래스를 정의 => 메소드 오버라이딩을 통해 인터페이스의 추상 메소드를 구현
class StudentScoreProgram implements ConsoleProgram {

	@Override
	public void print() {
		System.out.println("메뉴 출력");

	}

	@Override
	public void runMenu(int menu) {
		System.out.println("메뉴에 따른 기능 실행");

	}

	@Override
	public void run() {
		System.out.println("프로그램 구동");

	}

}
interface Program{
	void run();
}
/* Program의 run과 ConsoleProgram의 run은 둘다 추상메소드이기 때문에 오버라이딩이 필요함 */
interface GeneralProgram extends Program, ConsoleProgram{
	
}
