package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Lambda {

	public static void main(String[] args) {
		List<Point3> list = new ArrayList<Point3>();
		list.add(new Point3(0, 0));
		list.add(new Point3(1, 1));
		list.add(new Point3(-1, -1));
		
		//x좌표가 0이상인 좌표들만 출력
		printOverZeroX(list);
		//y좌표가 0이상인 좌표들만 출력
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		printOverZeroY(list);
		
		//람다식 => 메소드를 간결하게 표현해서 객체를 생성할 때 사용. ()->{}
		//람다식은 함수형 인터페이스의 객체를 만들 때 사용
		
		//람다식으로 전체 좌표 출력
		//printList(list, t->true);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		printList(list, new Predicate<Point3>() {
			
			@Override
			public boolean test(Point3 t) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		//람다식을 이용하여 x좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어 테스트하기
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		printList(list, t->t.getX()>=0);
		
		//람다식을 이용하여 y좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어 테스트하기
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		printList(list, t->t.getY()>=0);
		
	}
	public static void printList(List<Point3> list, Predicate<Point3>p) {
		for(Point3 point3 : list) {
			if(p.test(point3)) {
				System.out.println(point3);
			}
		}
	}
	
	public static void printOverZeroX(List<Point3> list) {
		for(Point3 point3 : list) {
			if(point3.getX()>=0) {
				System.out.println(point3);
			}
		}
	}
	private static void printOverZeroY(List<Point3> list) {
		for(Point3 point3 : list) {
			if(point3.getY()>=0) {
				System.out.println(point3);
			}
		}
	}

}
@Data
@AllArgsConstructor
class Point3{
	private int x,y;
}