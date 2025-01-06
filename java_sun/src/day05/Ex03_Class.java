package day05;

import java.util.concurrent.CountDownLatch;

public class Ex03_Class {

	public static void main(String[] args) {
		String name = "um";
		int count =99;
		
		System.out.println("이름 : "+name + " - " + count + "회");
		// 값 전달 해봤자 다시 돌아옴
		recode1(name, count);
		System.out.println("이름 : "+name + " - " + count + "회");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		Record r1 = new Record(name, count);
		r1.print();	
		// getter & setter 사용 (참조 전달)
		recode2(r1);
		r1.print();

	}
	
	public static void recode1(String name, int count) {
		name = "sun";
		count = 100;
	}
	public static void recode2(Record r1) {
		r1.setName("sun");
		r1.setCount(100);
	}

}
class Record{
	// 멤버 변수(필드)
	private int count;
	private String name;
	
	// 메소드(기능)
	//getter & setter
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//print 기능
	public void print() {
		System.out.println("이름 : "+name + " - " + count + "회");
	}
	
	
	// 생성자
	public Record(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public Record() {
		this("djatjs", 1);
		//name = "djatjs"
		//count = 100;
	}

}