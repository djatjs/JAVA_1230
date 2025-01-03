package day04.access.modifier1;

import day04.access.modifier2.B;

public class Ex08_AccessModifier {

	public static void main(String[] args) {
		//A클래스는 이 예제와 같은 패키지에 있음.
		//B클래스는 이 예제와 다른 패키지에 있어서 인식이 안됨. 그래서 import해야됨.
		A a1 = new A();
		B b1 = new B();
		
		// public 필드들은 다른 패키지에 있는 클래스에서도 사용 가능.
		a1.name = "sun";
		b1.name = "nus";
		
		// default 필드들은 같은 패키지에 있는 클래스에서 사용 가능. (앞에 아무것도 안붙이면 default로 설정됨)
		a1.address = "서울";
		// b1.address = "tjdnf"; //다른 패키지에 있는거여서 사용할 수 없음.
		
		// private 필드들은 해당 클래스가 아니면 사용할 수 없음.
		// a1.num = "000000-0000000";
		// b1.num = "000000-0000000";
		b1.setNum("000000-0000000"); //Setter로 설정함
		System.out.println(b1.getNum());
	}

}
