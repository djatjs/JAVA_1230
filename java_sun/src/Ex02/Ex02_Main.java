package Ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_Main {

	/* 단어장 프로그램
	 * - 관리자
	 * 	 - 단어 등록
	 *   - 단어 수정
	 *   - 단어 삭제
	 * - 사용자
	 *   - 단어 검색
	 *   - 내 검색 단어 보기(검색 내역)
	 * 
	 * - 주의사항
	 *   - 중복된 단어 허용
	 *   - 단어는 단어, 품사, 뜻으로 구성
	 *   - 사용자는 아이디로만 구분(중복된 아이디 허용X)
	 *   - 사용자는 회원가입을 따로 하지 않음
	 *   - 관리자는 admin으로 고정
	 *   - 저장과 불러오기 필수
	 *   
	 * 시작 전
	 * 아이디 : admin
	 * 관리자 메뉴 출력
	 * 메뉴 선택 :
	 * 
	 * 아이디 : aaa
	 * 사용자 메뉴 출력
	 * 메뉴 선택 :
	 * */
	static Scanner scan = new Scanner(System.in);
	//단어목록
	static List<Word> list = new ArrayList<Word>();
	//검색목록
	static List<User> users = new ArrayList<User>();
	public static void main(String[] args) {
		
		//파일 불러오기
		
		while(true) {
			System.out.print("아이디 : ");
			String id = scan.next();
			if(id.equals("admin")) {
				adminMenu();
			}else {
				userMenu(id);
			}
		}

	}
	//관리자 메뉴
	private static void adminMenu() {
		int menu=0;
		do {
			printAdminMenu();
			menu=scan.nextInt();
			scan.nextLine();
			runAdminMenu(menu);
		}while(menu!=4);
	}
	private static void printAdminMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 단어 등록\n"
				+ "2. 단어 수정\n"
				+ "3. 단어 삭제\n"
				+ "4. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	private static void runAdminMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			editWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			System.out.println("로그아웃하여 이전으로 돌아감");
			break;
		default:
			System.out.println("잘못된 입력");
		}
	}
	private static void insertWord() {
		Word word = inputWord();
		list.add(word);
		System.out.println("단어 등록완료");
		System.out.println(word);
	}
	private static void editWord() {
		//전체 단어 출력
		printAllWord();
		//수정할 단어 고르기
		int index = 0;
		do {
			System.out.print("수정할 단어 번호 입력 : ");
			index = scan.nextInt()-1;
			if(index<0 || index>list.size()) {
				System.out.println("제시된 번호만 입력하시오");
				scan.nextLine();
			}			
		}while(index<0 || index>list.size());
		//단어 수정
		Word edit = inputWord();
		list.remove(index);
		list.add(index, edit);
		System.out.println("단어 수정 완료");
		
	}
	private static void deleteWord() {
		//전체 단어 출력
		printAllWord();
		//삭제할 단어 고르기
		int index = 0;
		do {
			System.out.print("삭제할 단어 번호 입력 : ");
			index = scan.nextInt()-1;
			if(index<0 || index>list.size()) {
				System.out.println("제시된 번호만 입력하시오");
				scan.nextLine();
			}			
		}while(index<0 || index>list.size());
		//단어 삭제
		list.remove(index);
		System.out.println("단어 삭제 완료");
		
	}
	
	private static void printAllWord() {
		//단어 등록이 안되어있는 경우
		if(list.isEmpty()||list.size()==0) {
			System.out.println("등록된 단어 없음");
			return;
		}
		//전체 단어 출력
		for(int i=0; i<list.size();i++) {
			System.out.println(i+1 +". "+ list.get(i));
		}
	}
	private static Word inputWord() {
		System.out.print("단어 : ");
		String name = scan.next();
		System.out.print("품사 : ");
		String type = scan.next();
		scan.nextLine();
		System.out.print("뜻 : ");
		String content = scan.nextLine();
		return new Word(name, type, content);
	}
	
	//사용자 메뉴
	private static void userMenu(String id) {
		int menu=0;
		do {
			printUserMenu();
			menu=scan.nextInt();
			scan.nextLine();
			runUserMenu(menu, id);
		}while(menu!=3);
	}
	private static void printUserMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 단어 검색\n"
				+ "2. 단어 검색 내역 확인\n"
				+ "3. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	private static void runUserMenu(int menu, String id) {
		switch(menu) {
		case 1:
			searchWord(id);
			break;
		case 2:
			searchWordHistory(id);
			break;
		case 3:
			System.out.println("로그아웃하여 이전으로 돌아감");
			break;
		default : 
			System.out.println("잘못된 입력");
		}
		
	}
	private static void searchWord(String id) {
		//단어 등록이 안되어있는 경우
		if(list.isEmpty()||list.size()==0) {
			System.out.println("등록된 단어 없음");
			return;
		}
		//검색어 입력
		System.out.print("단어 : ");
		String name = scan.next();
		
		
		//검색 및 출력
//		int index = list.indexOf(id);
//		if(!users.contains(index)) {
//			//users.add();
//		}
//		if(index == -1) {
//			System.out.println("검색 결과 없음");
//			user.addSeachWord(name);
//		}
//		boolean res = false;
//		for(int i=0; i<list.size();i++) {
//			if(list.get(i).getName().equals(name)) {
//				System.out.println(list.get(i));
//				//검색 내역 저장 : 사용자 중복 방지를 위해
//				//가입은 아니지만 리스트 안에 없는 사용자라면 넣고
//				
//				
//				user.addSeachWord(name);
//				System.out.println(user);
//				res = true;
//			}
//		}
		
	}
	private static void searchWordHistory(String id) {
		System.out.println(id+"의 검색 내역");
		int index =  users.indexOf(new User(id));
		//검색 내역이 없는 경우
		if(index == -1) {
			System.out.println("해당 사용자의 검색 내역이 없음");
			return;
		}
		System.out.println(users);
		//검색 내역 출력
		User searchhistory = users.get(index);
		
		System.out.println(searchhistory);
		
//		for(User user : users) {
//			if(user.getId().equals(id)) {
//				//printUserSearchHistory(user);
//				System.out.println(user.getSearchHistory());
//			}
//		}
		
	}
	private static void printUserSearchHistory(User user) {
		for(int i=0; i<user.getSearchHistory().size(); i++) {
			System.out.println(i+1 +". "+user.getSearchHistory().get(i));
		}
	}
}
