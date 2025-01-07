package day06;

import java.util.Scanner;

public class Ex09_ProScore {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/* 학생의 국어 성적을 관리하는 프로그램
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름 : sun
		 * 성적 : 100
		 * 입력이 완료되었습니다
		 * 이름 : um
		 * 성적 : 90
		 * 입력이 완료되었습니다
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * sun : 100
		 * um : 90
		 * 평균 : 95
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * 프로그램 종료
		 * */
		
		// 배열
		Student[] std = new Student[2];
		char menu;
		int count=0; //저장된 학생 수

		do {
			// 메뉴 출력
			printMenu();
			menu = scan.next().charAt(0);
			count = runMenu(menu, std, count);
			//학생 배열이 꽉 차면 늘려주는 기능
			std =expend(std, count);
			System.out.println("현재 저장된 학생 수 : " + count);
		} while (menu != '3');

	}
	
	// 배열 확장
	public static Student[] expend(Student[] std, int count) {
		//보험용
		if(std == null) {
			return new Student[5];
		}
		// 공간 여유 있으면 그냥 반환
		if(count < std.length) {
			return std;
		}
		Student tmp[] = new Student[std.length +5];
		System.arraycopy(std, 0, tmp, 0, std.length);
		System.out.println("공간 확장 업데이트됨");
		System.out.println("전체 공간 : "+tmp.length);
		return tmp;
	}

	// 메뉴 문구 출력
	public static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡ 메뉴 ㅡㅡㅡㅡㅡ");
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 전체 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	// 메뉴 실행
	public static int runMenu(char menu, Student [] std, int count) {
		switch (menu) { 
		case '1': 
			count = addStudent(std, count);
			break;
		case '2': 
			listStudent(std ,count);
			break;
		case '3': 
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		return count;
	}
	

	// 성적 추가 메소드
	public static int addStudent(Student[] std, int count) {
		System.out.print("이름 : ");
		String name1 = scan.next();
		System.out.print("성적 : ");
		int score1 = scan.nextInt();
		// 객체 만들고 std에 넣기
		/*
		 * Student student = new Student(name1, score1); std[count]=student; return
		 * count;
		 */
		//내가 한 부분 (비어 있는 곳에 넣기)
		for (int i = 0; i < std.length; i++) { if (std[i] == null) { std[i] = new
		Student(name1, score1); count++; break; } }return count;
			
		}

	// 학생들의 이름 및 성적 확인
	public static void listStudent(Student[] arr, int count) {
		// 한 명도 등록 X -> sysout 등록안되어있음
		if(count==0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		int sum=0;
		// 정보 출력
		for (int i = 0; i < count; i++) {
			System.out.println(arr[i].getName() + " : " + arr[i].getScore());
		}
		// 평균 점수 출력
		for (int i = 0; i < count; i++) {
			sum += arr[i].getScore();
		}
		System.out.println("평균 점수 : "+sum/(double)count);
	}

	
}
class Student {
	private String name;
	private int score;
	
	
	// setter 같은 경우는 수정 기능 안쓸거여서 안넣음.
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
