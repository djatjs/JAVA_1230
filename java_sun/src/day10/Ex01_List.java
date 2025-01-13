package day10;

import java.util.ArrayList;

public class Ex01_List {

	public static void main(String[] args) {
		/* Collection 프레임워크를 왜 사용할까?
		 * - 여러 데이터를 편하게 사용하기 위해서
		 * - 배열은 꽉 차면 직접 늘려줘야 함.
		 * - 배열은 중간에 삭제하면 앞으로 당겨줘야 함.
		 * Collection 인터페이스의 자식 인터페이스
		 * List는 인터페이스
		 * - 중복 허용
		 * - 순서 보장 => 특정 번지에 접근 가능
		 * ArrayList
		 * - List 인터페이스의 구현 클래스
		 * - 제네릭 클래스
		 *   - 멤버변수/메서드의 타입이 정해지지 않은 클래스
		 *   - 타입은 객체를 생성할 때 정함
		 *   - 타입은 클래스만 가능( ex Integer )
		 * */
		ArrayList<Integer> list = new ArrayList<Integer>();
		//ArrayList list2 = new ArrayList(); //이렇게 하면 오브젝트 형식으로 생성됨. 나중에 형변환 필요.
		
		list.add(10); //Collection 인터페이스에서 제공하는 메소드를 오버라이딩하여 사용.
		list.add(20);
		list.add(30);
		list.add(10);
		System.out.println(list);
		
		//번지와 관련된 메소드는 List 인터페이스에서 제공하는 메소드로 보면 됨.
		
		
		// 특정번지에 접근해서 작업함.
		list.add(1,15); //List 인터페이스에서 제공하는 메소드 -> Set에는 없음
		System.out.println(list);
		
		// 첫번째 10 삭제
		list.remove((Integer) 10); //Collection 인터페이스에서 제공하는 메소드
		System.out.println(list);
		
		list.remove(0); //List 인터페이스에서 제공하는 메소드
		System.out.println(list);
		
		System.out.println(list.get(0));//List 인터페이스에서 제공하는 메소드
		
		System.out.println(list.contains(30));//Collection 인터페이스에서 제공하는 메소드
		
		System.out.println(list.indexOf(30));//List 인터페이스에서 제공하는 메소드
	}

}
