package day23;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class test {

	public static void main(String[] args) {
//		Person[] pArr = new Person[3];
//		
//		for(int i=0; i<pArr.length; i++) {
//			System.out.println(pArr[i]);
//		}
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "빨강"));
		list.add(new Fruit("포도", "빨강"));
		//list.add("맛있는 과일");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName()+" : "+list.get(i).getColor());
		}
	}

}
@Data
class Person {
	private String name;
}

@Data
@AllArgsConstructor
class Fruit{
	private String name;
	private String color;
}