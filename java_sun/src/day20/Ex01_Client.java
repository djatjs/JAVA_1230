package day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	/* 쇼핑몰 구현하기
	 * - 제품 관리
	 *   - 관리자가 관리
	 *   - 관리자는 admin/admin으로 고정
	 *   - 제품 추가, 수정, 삭제, 제품 입고
	 *   - 제품 추가
	 *      - 제품 코드(6자리, ABC001), 분류, 제품명, 옵션, 가격을 등록
	 *      - ABC001, 문구, 볼펜, 빨강, 1000
	 *      - DEF001, 의류, 셔츠, XL, 30000
	 *      - XYZ001, 식품, 우유 1L, 딸기, 2000
	 *      - XYZ002, 식품, 초코 우유 , 1L, 2500
	 *      - XYZ003, 식품, 초코 우유 , 2L, 3500
	 *      - 분류는 문구, 의류, 식품, 가전, 기타로 고정
	 *      - 각 분류마다 분류 코드가 지정됨(문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC)
	 *      - 제품 코드는 분류 코드에 등록된 순서 3자리를 만들어서 총 6자리로 고정
	 *    - 제품 수정
	 *      - 제품 코드를 입력하여 제품명, 옵션, 가격을 수정
	 *    - 제품 삭제
	 *      - 제품 코드를 입력하여 삭제
	 *    - 제품 입고
	 *      - 제품 코드, 수량을 입력해서 제품을 입고
	 *    - 제품 구매
	 *      - 등록된 제품을 선택 후 수량을 선택해서 구매
	 *      - 로그인한 사용자가 제품을 구매할 수 있음
	 *      - 로그인 하지 않으면 제품 조회 및 구매 할 수 없음
	 *      - 수량이 있는 제품만 구매 가능
	 *      - 제품 코드와 수량을 선택해서 구매
	 *      - 결제 과정은 없음(생략)
	 *    - 제품 조회
	 *      - 분류를 이용하여 조회
	 *      - 문구, 의류, 식품, 가전, 기타, 전체
	 *      - 제품 코드, 제품명, 옵션, 수량, 가격
	 * - 제품을 구매
	 *    - 등록된 제품을 선택 후 수량 선택해서 구매
	 * - 회원가입
	 *    - 아이디, 비밀번호, 비밀번호 확인
	 * - 로그인
	 *    - 아이디, 비밀번호 입력하여 회원이면 제품 조회로, 아니면 메인으로 돌아감
	 *    - 관리자면 관리자 메뉴로 이동
	 * */
	
	/* 메인 메뉴
	 * 1. 로그인
	 * 2. 회원가입
	 * 3. 종료
	 * 
	 * 관리자 메뉴(로그인 시 관리자인 경우)
	 * 1. 제품 등록
	 * 2. 제품 수정
	 * 3. 제품 삭제
	 * 4. 제품 입고
	 * 5. 로그아웃
	 * 
	 * 사용자 메뉴(로그인 시 사용자인 경우)
	 * 1. 문구 조회
	 * 2. 의류 조회
	 * 3. 식품 조회
	 * 4. 가전 조회
	 * 5. 기타 조회
	 * 6. 전체 조회
	 * 7. 로그아웃
	 * 
	 * 제품 상세
	 * 제품 정보를 출력
	 * 1. 제품 구매
	 * 2. 이전으로
	 * */
	private static List<Product> list = new ArrayList<Product>();
	static List<Member> members = new ArrayList<Member>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//sample data
		members.add(new Member("add", "1111", "관리자"));
		members.add(new Member("aaa", "1111"));
		System.out.println(members);
		
		int menu=0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu !=3);
	}
	
	private static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			join();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	
	private static void login() {
		Member tmp = inputInfo();
		int index = members.indexOf(tmp);
		if(index != -1) {
			Member human = members.get(index);
			switch(human.getType()) {
			case "회원":
				System.out.println("회원 로그인 성공");
				menuForMember(human);
				break;
			case "관리자":
				System.out.println("관리자 로그인 성공");
				menuForAdmin();
				break;
			}
		}else {
			System.out.println("로그인 실패 : 아이디 or 비밀번호 틀림");
		}
		
	}
	
	private static void menuForMember(Member member) {
		int menu =0;
		do {
			printMemberMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMemberMenu(menu, member);
		}while(menu !=7);
		
	}
	
	private static void printMemberMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 문구 조회");
		System.out.println("2. 의류 조회");
		System.out.println("3. 식품 조회");
		System.out.println("4. 가전 조회");
		System.out.println("5. 기타 조회");
		System.out.println("6. 전체 조회");
		System.out.println("7. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");
	}
	private static void runMemberMenu(int menu, Member member) {
		switch(menu) {
		case 1,2,3,4,5:
			System.out.println("분류");
			check(menu, member);
			break;
		case 6:
			check(member);
			break;
		case 7:
			System.out.println("로그 아웃");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	//전체 상품 조회
	private static void check(Member member) {
		//제품 목록 조회
		for(Product product : list) {
			System.out.println(product);
		}
		//제품 선택
		System.out.print("제품 선택 : ");
		String code = scan.next();
		scan.nextLine();
		
		int index=-1;
		for(Product tmp : list) {
			if(tmp.getProductCode().equals(code)) {
				index = list.indexOf(tmp);
			}
		}
		if(index == -1) {
			System.out.println("해당 코드와 일치하는 항목이 없습니다.");
			return;
		}
		Product product = list.get(index);
		System.out.println(product);
		
		//선택된 제품 출력(예외 처리)
		int menu=0;
		do {
			printCheckDetailMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runCheckDetailMenu(menu, product);
		}while(menu !=2);
	}
	
	//제품 조회
	private static void check(int menu, Member member) {
		//제품 목록 조회
		System.out.println(menu+"카테고리 제품 조회");
		//제품 선택
		System.out.print("제품 선택 : ");
		String code = scan.next();
		scan.nextLine();
		
		int index = list.indexOf(code); //이거 고치셈
		Product product = list.get(index);
		System.out.println(product);
		
		int menu1=0;
		do {
			printCheckDetailMenu();
			menu1 = scan.nextInt();
			scan.nextLine();
			runCheckDetailMenu(menu1, product);
		}while(menu1 !=2);
	}
	
	private static void printCheckDetailMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 제품 구매");
		System.out.println("2. 이전으로");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");
	}
	private static void runCheckDetailMenu(int menu, Product product) {
		switch(menu) {
		case 1:
			buyProduct(product);
			System.out.println("구매");
			break;
		case 2:
			System.out.println("이전으로 돌아갑니다");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	
	private static void buyProduct(Product product) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("구매할 수량 : ");
		int amount = scan.nextInt();
		if(amount>product.getAmount()) {
			System.out.println("입고된 수량보다 더 많이 구매할 수 없습니다.");
			return;
		}
		product.setAmount(product.getAmount()-amount);
		System.out.println(product.getName() +" "+amount+"개 구매 완료");
		System.out.println(product.getName() +"남은 수량 : "+product.getAmount());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	//관리자 메뉴
	private static void menuForAdmin() {
		int menu =0;
		do {
			printAdminMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runAdminMenu(menu);
		}while(menu !=5);
		
	}
	
	private static void printAdminMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 제품 등록\r\n"
				+ "2. 제품 수정\r\n"
				+ "3. 제품 삭제\r\n"
				+ "4. 제품 입고\r\n"
				+ "5. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");
	}
	
	private static void runAdminMenu(int menu) {
		switch(menu) {
		case 1:
			registItem();
			break;
		case 2:
			modifyItem();
			break;
		case 3:
			deleteItem();
			break;
		case 4:
			storeItem();
			break;
		case 5:
			System.out.println("로그 아웃");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	private static void registItem() {
		//제품 정보 입력
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("분류 : ");
		String category = scan.next();
		scan.nextLine();
		
		System.out.print("제품명 : ");
		String name = scan.nextLine();
		System.out.print("옵션 : ");
		String option = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		//문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
		String codePrefix = Product.getCodePrefix(category);
		int count = getLastNum(list, codePrefix);
		//Product item = new Product(category,name,option,price);
		Product item = new Product(count, category,name,option,price);
		
		//중복된 상품인지 확인
		if(!list.contains(item)){
			item.setAmount(item.getAmount()+1);
			list.add(item);
			
			System.out.println("상품이 등록되었습니다.");
			System.out.println(list);
			return;
		}
		System.out.println("등록 실패 : 이미 등록된 상품");
		
	}
	
	private static void modifyItem() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("제품 코드 입력 : ");
		String code = scan.next();
		scan.nextLine();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		
		for(Product tmp : list) {
			if(tmp.getProductCode().equals(code)) {
				System.out.println("제품을 수정합니다");
				System.out.print("제품명 : ");
				tmp.setName(scan.nextLine());
				System.out.print("옵션 : ");
				tmp.setOption(scan.nextLine());
				System.out.print("가격 : ");
				tmp.setPrice(scan.nextInt());
				System.out.println(tmp);
				return;
			}
		}
		System.out.println("해당 코드와 일치하는 항목이 없습니다.");

	}

	private static void deleteItem() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("제품 코드 입력 : ");
		String code = scan.next();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(Product tmp : list) {
			if(tmp.getProductCode().equals(code)) {
				list.remove(tmp);
				System.out.println("삭제 완료");
				return;
			}
		}
		System.out.println("해당 코드와 일치하는 항목이 없습니다.");
		
	}
	
	private static void storeItem() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("제품 코드 입력 : ");
		String code = scan.next();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		for(Product tmp : list) {
			if(tmp.getProductCode().equals(code)) {
				int amount=0;
				do {
					System.out.print("입고할 수량 :");
					amount = scan.nextInt();
					scan.nextLine();
					if(amount<0) {
						System.out.println("다시 입력하세요");
					}
				}while(amount<0);
				tmp.setAmount(tmp.getAmount()+amount);
				System.out.println(tmp);
				return;
			}
		}
		System.out.println("해당 코드와 일치하는 항목이 없습니다.");
	}

	private static int getLastNum(List<Product> list, String codePrefix) {
		if (list == null) {
			return -1;
		}
		int max = 0;
		for(Product product : list) {
			//ABC001에서 ABC는 prefix, 001은 suffix
			String productCodePrefix = product.getProductCode().substring(0,3);
			String productCodeSuffix = product.getProductCode().substring(3);
			if(productCodePrefix.equals(codePrefix)) {
				//"001" => 1로 변환
				int num = Integer.parseInt(productCodeSuffix);
				if(max < num) {
					max = num;
				}
			}
		}
		return max;
	}

	//회원가입
	private static void join() {
		Member tmp = inputInforJoin();
		if(tmp == null) {
			System.out.println("가입 실패");
			return;
		}
		for(Member mem : members) {
			if(mem.getId().equals(tmp.getId())) {
				System.out.println("이미 등록된 아이디입니다.");
				return;
			}
		}
		members.add(tmp);
		System.out.println("회원가입 완료!");
	}
	
	//로그인
	private static Member inputInfo() {
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		return new Member(id, password);
	}
	//회원가입용 입력
	private static Member inputInforJoin() {
		Member tmp = inputInfo();
		String checkPassword= "";
		while(!checkPassword.equals(tmp.getPassword())) {
			System.out.print("비밀번호 확인 : ");
			checkPassword = scan.next();
			if(!checkPassword.equals(tmp.getPassword())) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			if(checkPassword.equals("EXIT")) {
				return null;
			}
		}
		return tmp;
	}

}
