package day05;

public class Ex04_Static {

	public static void main(String[] args) {
		KiaCar k1 = new KiaCar("레이");
		KiaCar k2 = new KiaCar("니로");
		KiaCar k3 = new KiaCar("k5");
		
		// k1.setCompany("KIA");
		// static 변수는 클래스 변수로 선언해야됨
		KiaCar.setCompany("KIA");
		
		k1.print(); //얘만 바뀜
		k2.print();
		k3.print();
	}

}
class KiaCar{
	
	private static String company;
	private String carName;
	
	// getter & setter
	public String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
	    KiaCar.company = company; // 클래스 변수에 값 설정
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public void print() {
		System.out.println(company + " : " + carName);
	}
	
	// 생성자
	public KiaCar(String carName) {
		company = "기아";
		this.carName = carName;
	}	
	
	
	
}