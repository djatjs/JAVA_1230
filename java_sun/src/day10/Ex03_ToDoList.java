package day10;

import java.util.ArrayList;
import java.util.Scanner;


public class Ex03_ToDoList {
	
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args){
		//List 사용 예제
		/* 다음 기능을 갖는 프로그램을 작성하시오.
		 * 1. 일정 등록
		 * 2. 일정 삭제
		 * 3. 일정 조회
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * 등원
		 * 1. 일정 등록
		 * 2. 일정 삭제
		 * 3. 일정 조회
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * 수업
		 * 1. 일정 등록
		 * 2. 일정 삭제
		 * 3. 일정 조회
		 * 4. 종료
		 * 메뉴 선택 : 2
		 * 1. 등원
		 * 2. 수업
		 * 삭제할 일정을 선택 : 1
		 * 삭제 되었습니다.
		 * 1. 일정 등록
		 * 2. 일정 삭제
		 * 3. 일정 조회
		 * 4. 종료
		 * 메뉴 선택 : 3
		 * 1. 수업
		 * 입력 : 
		 * */
		
		
		ArrayList<String> list = new ArrayList<String>();
		int menu = 0;
		
		do {
			try {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu, list);
			}catch (Exception e) {
				System.out.println("잘못된 입력");
				scan.nextLine();
			}
				
		}while(menu != 4);

		
	}
	//메뉴 출력
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 일정 등록");
		System.out.println("2. 일정 삭제");
		System.out.println("3. 일정 조회");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}
	//입력에 따른 메뉴 실행
	public static void runMenu(int menu, ArrayList<String> list) {
		switch(menu) {
		case 1:
			addToDo(list);
			break;
		case 2:
			removeToDo(list);
			break;
		case 3:
			listToDo(list);
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		}	
	}
	//일정 등록
	private static void addToDo(ArrayList<String> list) {
		System.out.print("등록할 일정 : ");
		String todo = scan.nextLine();
		list.add(todo);
		System.out.println("일정 등록 완료");
	}
	//일정 제거
	private static void removeToDo(ArrayList<String> list) {
		if(!listToDo(list)) {
			return;
		};
		
		System.out.print("삭제할 일정을 선택(번호 입력) : ");
		int index = scan.nextInt() -1;
		if(index >=list.size() || index <0) {
			System.out.println("잘못된 번호 입력");
			return;
			
		}
		list.remove(index);
		System.out.println("삭제 되었습니다.");

	}
	//일정 조회
	private static boolean listToDo(ArrayList<String> list) {
		if(list.size() == 0) {
			System.out.println("등록된 일정이 없습니다");
			return false;
		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		return true;
	}
}
