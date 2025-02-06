package day23;

import lombok.Data;

public class Ex06_Class {

	public static void main(String[] args) {
		//잘못된 부분 찾아 수정
		MyStudent std = new MyStudent();
		print(std);
	}
	private static void print(MyStudent std) {
		System.out.println(std.getGrade()+"학년");
		System.out.println(std.getClassNum()+"반");
		System.out.println(std.getNum()+"번호");
		System.out.println(std.getName());
	}

}
@Data
 class MyStudent{
	int grade, classNum, num;
	String name;
	
	public static double PI = 3.14;

	public static double getPI() {
		return PI;
	}	

}
