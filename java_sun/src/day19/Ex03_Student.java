package day19;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ex03_Student {
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	static List<Student> list = new ArrayList<Student>();
	static Scanner scan = new Scanner(System.in);
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
			checkStd();
			break;
		case 3:
			checkAttention();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
		}
		
	}
	private static void insertStd() {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		list.add(new Student(name));		
	}
	private static void checkStd() {
		for(Student tmp : list) {
			System.out.print(tmp.getStd() + " : 출석했나요?(O/X) : ");
			String attention =  scan.nextLine();
			if(attention.equals("O")) {
				tmp.setAttention(true);
				Date date = new Date();
				String datestr = format.format(date);
				tmp.setDate(datestr);
			}else if (attention.equals("X")){
				tmp.setAttention(false);
				Date date = new Date();
				String datestr = format.format(date);
				tmp.setDate(datestr);
			}
			else {
				System.out.println("잘못된 입력. 결석처리합니다");
				Date date = new Date();
				String datestr = format.format(date);
				tmp.setDate(datestr);
			}
			
			
		}
		
	}
	private static void checkAttention() {
		for(Student tmp : list) {
			System.out.println(tmp.getDate());
		}
		
	}
	
	

}
