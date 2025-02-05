package day23;

import java.io.Serializable;

public class Ex07_Class {

	public static void main(String[] args) {
		//카페 메뉴를 관리하기 위한 음료 클래스 만들기
		//클래스 선언. 클래스는 캡슐화에 맞춰 구현하고 게터,세터 작성, 매개변수 있는 생성자 두고, 직렬화/역직렬화 가능하도록 설정
		Drink drink = new Drink("아이스 아메리카노", 1500);
		System.out.println(drink.getMenu() +" : "+drink.getPrice());
	}
	
}
class Drink implements Serializable{

	private static final long serialVersionUID = -6505926526873853026L;
	//멤버 필드
	private String menu;
	private int price;
	
	//어노테이션 써서 이런 코드 굳이 안만들어도 되긴함
	//Getter
	public String getMenu() {
		return menu;
	}
	public int getPrice() {
		return price;
	}
	//Setter
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자
	public Drink(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}
	
	
}

