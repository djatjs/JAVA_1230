package day04;

public class Ex07_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1 = new Car("현대","아반떼",2025);
		Car car2 = new Car("기아","G5",2025);
		
		car1.info();
		car1.turnOn();
		car1.info();
		car1.chageGear('D');
		
		for (int i=1; i<=10;i++) {
			car1.speedUp();			
		}

		// car2.info();
		
		car1.color = "Grey"; //접근 제어자 : public -> 다른 클래스에서 직접 접근 할 수 있음
		System.out.println(car1.color);
		// car1.gear = 'N'; //접근 제어자 : private -> 다른 클래스에서 직접 접근 할 수 없음
		
		
	}

}
/* 자동차 클래스
 * - 정보(멤버 변수) : 연료 종류, 회사, 종류, 색상, 년식
 * - 기능(메소드) : 시동 켜기/끄기, 기어 변경, 엑셀 누름, 브레이크 누름, 핸들 변경
 * */
class Car{ //default
	//멤버변수
	public String company;
	public String name;
	public String type;
	public String color;
	public int year;
	public String oilType;
	private boolean power;//전원
	private char gear = 'P'; //기어
	private int speed; //속력
	private int handle; //핸들 방향 각도
	
	//기능
	//시동 켜기/끄기 메소드
	public void turnOn() {
		if(power == true) {
			System.out.println(name + " : 이미 켜져있습니다");
			return;
		}else {
			power = true;
			System.out.println(name + " : 시동이 켜졌습니다.");
			return;
		}
		
	}
	public void turnOff(){
		if(speed == 0) {
			power = false;
			System.out.println("시동이 꺼졌습니다.");
		}else {
			System.out.println("시동을 먼저 켜주세요.");
		}
			return;
	}	
	//속력 메소드
	public void speedUp() {
		if(power ==true && (gear =='D'||gear=='R')) {
			speed+=1;
		}
		else {
			System.out.println("시동을 먼저 켜주세요.");
		}
		return;
	}
	public void speedDown() {
		if(power ==true) {
		speed-=1;
		}
		else {
			System.out.println("시동을 먼저 켜주세요.");
		}
		return;
	}
	//기어 메소드
	public void chageGear(char gear1) {
		if(power ==true) {
			gear = gear1;
		}
		else {
			System.out.println("시동을 먼저 켜주세요.");
		}
		return;
	}
	//핸들 메소드
	public void changeHandle(int handle1) {
		handle = handle1;
		return;
	}
	
	//자동차 정보 확인 메소드
	public void info() {
		System.out.println("----------");
		System.out.println(name);
		System.out.println("전원 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("기어 : " + gear);
		System.out.println("----------");
	}

	// 기본 생성자 
	public Car(String company1){
		company = company1;
	}
	
	// 생성자 오버로딩
	public Car(String company1, String name1, int year1){
		company = company1;
		name= name1;
		year = year1;
	}
}