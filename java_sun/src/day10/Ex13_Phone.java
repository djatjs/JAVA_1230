package day10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Phone {

	/* 전화번호 관리하는 프로그램
	 * 1. 전화번호 추가
	 * - 이름과 전화번호를 입력받아 추가
	 * - 동명이인이 있을 수 있기 때문에 중복되도 추가 (이름, 전화번호 둘 다 중복 허용)
	 * 2. 전화번호 수정
	 * - 이름을 입력
	 * - 이름과 일치하는 목록을 출력
	 * - 수정하려는 전화번호를 선택 (1.ㅇㅇ : 010-0000-9999   2.ㅇㅇ : 010-0000-9999 둘 다 똑같을 수 있는데 1번, 2번 이걸로 선택하는거임)
	 * - 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 * - 이름을 입력
	 * - 이름과 일치하는 목록을 출력
	 * - 삭제하려는 전화번호를 선택
	 * - 선택한 전화번호 삭제
	 * 4. 전화번호 조회
	 * - 이름을 입력
	 * - 이름이 포함된 전화번호를 출력(홍 ->홍길동)
	 * */
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Phone> phoneList = new ArrayList<Phone>();
	public static void main(String[] args) {
		int menu = 0;
		do {
			printMenu();
			menu= scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu!=5);

	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertPhone();
			break;
		case 2:
			updatePhone();
			break;
		case 3:
			//deletePhone();
			break;
		case 4:
			searchPhone();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
		
	}
	private static void updatePhone() {
		//이름 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//이름과 일치하는 목록을 출력
		int count=0;
		for(Phone tmp : phoneList) {
			if(tmp.getName().contains(name)) {
				//출력
				System.out.println(tmp);
				count++;
			}
		}
		//없는경우
		if(count ==0) {
			System.out.println("해당 이름이 들어가는 정보가 없습니다.");
			return;
		}
		//수정할 전화번호 입력 - 근데 만약에 
		System.out.print("수정할 전화번호 : ");
		String pNum = scan.nextLine();
		System.out.print("새로운 전화번호 : ");
		String newNum = scan.nextLine();
		for(Phone tmp2 : phoneList) {
			if(tmp2.getPhoneNum().contains(pNum)) {
				tmp2.setPhoneNum(newNum);
			}
		}
	}
	//조회
	private static void searchPhone() {
		//검색어 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		int count=0;
		for(Phone tmp : phoneList) {
			if(tmp.getName().contains(name)) {
				//출력
				System.out.println(tmp);
				count++;
			}
		}
		//없는경우
		if(count ==0) {
			System.out.println("해당 이름이 들어가는 정보가 없습니다.");
		}
	}
	//추가
	private static void insertPhone() {
		//입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("전화번호 : ");
		String phoneNum = scan.nextLine();
		
		//정규표현식 체크 : 000-0000-0000
		String regex = "^\\d{2,3}(-\\d{4}){2}$";
		if(!Pattern.matches(regex, phoneNum)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		//저장
		Phone phoneObj = new Phone(name, phoneNum);
		phoneList.add(phoneObj);
		System.out.println(phoneList);
		
	}
	//메뉴출력
	private static void printMenu() {
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 입력 : ");
	}
	

}
@Data
@AllArgsConstructor
class Phone{
	private String name;
	private String phoneNum;
	
	@Override
	public String toString() {
		return name + " : " + phoneNum;
	}

	public void update(String newName, String phoneNumber) {
		this.name = newName;
		this.phoneNum = phoneNumber;
		
	}
}

