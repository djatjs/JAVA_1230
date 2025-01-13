package day10;

import java.util.HashMap;

public class Ex11_Map {

	public static void main(String[] args) {
		/* Map 인터페이스
		 * - Key, Value 값을 관리
		 * - Key : 중복 X
		 * - Value : 중복 O
		 * */ 
		HashMap<String, String>map = new HashMap<String, String>();
		
		/* put(k,v) : k와 v의 값을 각각 key와 value에 추가하여 저장
		 * key가 중복되는 경우 v로 덮어쓰기 함
		 * */
		map.put("abc123", "pwabc1234");
		map.put("qwe123", "pwabc1234");
		map.put("abc123", "qweqwe1234");
		
		System.out.println(map); //abc123=pwabc1234에서 abc123=qweqwe1234로 덮어쓰기됨
		
		
		/* get(k)
		 * - key값 중에서 k와 일치하는 value 반환
		 * - 없으면 null 반환
		 * */
		System.out.println(map.get("abc123"));//key로 get하면 value가 나옴. 
		System.out.println(map.get("abc1234"));
		
		/* isEmpty()
		 * - map이 비었는지를 반환
		 * containsKey(k)
		 * - key값 중에서 k와 일치하는 값이 있는지를 반환
		 * containsValue(v)
		 * - value값 중에서 v와 일치하는 값이 있는지를 반환
		 * */
		System.out.println(map.isEmpty()); //false
		System.out.println(map.containsKey("abc123")); //true
		System.out.println(map.containsKey("abc")); //false
		System.out.println(map.containsValue("pwabc1234")); //true
		System.out.println(map.containsValue("abc")); //false
		
		/* remove(k)
		 * - key값 중에 k와 일치하는 값이 있으면 삭제 후 value 반환
		 * remove(k,v)
		 * - key값 중에 k와 일치하고, value값 중에 v와 일치하는 값이 있으면 삭제 후 삭재 여부를 반환
		 * */
		System.out.println("삭제 전");
		System.out.println(map);
		System.out.println(map.remove("abc123"));
		System.out.println("삭제 후"); //qweqwe1234
		System.out.println(map);
		System.out.println(map.remove("qwe123", "pwabc1234"));
		System.out.println("삭제 후"); //true
		System.out.println(map);
		
	}

}
