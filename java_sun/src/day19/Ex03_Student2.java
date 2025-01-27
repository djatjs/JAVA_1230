package day19;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student2 {
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private static List<AttendanceList> list = new ArrayList<AttendanceList>();
	private static List<String> students = new ArrayList<String>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 학생들의 출석을 관리하는 프로그램
		 * 1. 학생등록
		 *  - 이름만 등록
		 * 2. 출석체크
		 *  - 날짜를 입력하면 등록된 학생들의 출석 여부를 체크
		 *  - 2025-01-27
		 *  - 지각, 조퇴는 없다고 가정
		 *  - 출석이면 O, 결석이면 X로 관리
		 * 3. 출석 확인
		 * 4. 종료
		 * */
		
		int menu=0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		} while (menu !=4);
	}
	private static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석 확인");
		System.out.println("4. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStd();
			break;
		case 2:
			check();
			break;
		case 3:
			print();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아님");
		}
		
	}
	private static void insertStd() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		students.add(name);
		System.out.println("학생 등록 완료");
		
	}
	private static void check() {
		System.out.print("날짜 입력 : ");
		String date = scan.nextLine();
		if(students.isEmpty()) {
			System.out.println("등록된 학생이 없습니다");
			return;
		}
		//학생 이름 출력 후 출석 여부를 입력 받음
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생들의 출석 여부를 체크해주세요 (O/X)");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		List<Attnedence> attnedences = new ArrayList<Attnedence>();
		
		for(int i=0; i<students.size();i++) {
			System.out.println(i+1 +". "+students.get(i));
			char check = scan.next().charAt(0);
			//출석 객체 생성
			Attnedence attnedence = new Attnedence(students.get(i), check);
			//출석리스트에 추가
			attnedences.add(attnedence);
		}
		//출석부에 출석 리스트 추가
		list.add(new AttendanceList(date,attnedences));
	}
	private static void print() {
		
		printDates();
		
		System.out.print("날짜 입력(정수) : ");
		int index = scan.nextInt() -1;
		
		if(index <0 || index >= list.size()) {
			System.out.println("잘못 입력함");
			return;
		}
		//출석부에서 날짜와 일치하는 출석리스트를 가져옴
		AttendanceList attendanceList = list.get(index);
		attendanceList.print();
		
	}
	private static void printDates() {
		if(list.isEmpty()) {
			System.out.println("등록된 출석부가 없습니다");
			return;
		}
		
		for(int i=0; i<list.size();i++) {
			System.out.println(i+1 +". "+list.get(i).getDate());
		}
		
	}
	
}
@Data
@AllArgsConstructor
class AttendanceList{
	private String date;
	private List<Attnedence> list;
	public void print() {
		System.out.println("출석일 : "+ date);
		for(Attnedence attnedence : list) {
			System.out.println(attnedence);
		}
	}
}
@Data
@AllArgsConstructor
class Attnedence{
	private String name;
	private char attendace;
	@Override
	public String toString() {
		return name + " : " +attendace;
	}
	
	
}
