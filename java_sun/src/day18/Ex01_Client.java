package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ex01_Client {
	static List<Account> list = new ArrayList<Account>();
	static Scanner scan = new Scanner(System.in);
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		/* 은행 계좌 관리 프로그램
		 * - 1. 접속
		 *   - 은행. 이름. 계좌번호. 비밀번호
		 * - 2. 계좌 개설
		 *   - 은행. 이름. 계좌번호. 비밀번호. 비밀번호 확인
		 * - 3. 종료
		 * 
		 *   - 예금 조회
		 *   - 입금
		 *   - 출금
		 *   - 이전
		 *   
		 * 주의사항
		 *  - 한 계좌에 여러명이 동시에 접근하는 경우 먼저 접근한 사람이 사용하도록 처리(동기화로 방지)
		 * 
		 * */
		
		//서버의 ip와 port에 찾아가기 위해
		String ip = "127.0.0.1";
		int port = 5001;
		
	
		
		try {
			//서버와 통신 시도 : 실패 시 프로그램 종료
			Socket socket = new Socket(ip, port);
			System.out.println("[은행 프로그램 연결 완료]");
			
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			ClientProgram program = new ClientProgram(socket);
			program.run();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[은행 프로그램 종료]");
		}
		
		
	}
	//기본 메뉴
	private static void printBasicMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 접속");
		System.out.println("2. 계좌 개설");
		System.out.println("3. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
		
	}
	//기본 메뉴 동작
	private static void runBasicMenu(int menu) {
		switch(menu) {
		case 1:
			//접속
			startService();
			break;
		case 2:
			//계좌 생성
			newAcount();
			break;
		case 3:
			System.out.println("[은행 프로그램 종료]");
			break;
		default:
			System.out.println("[잘못된 입력]");
		}
		
	}
	//1. 접속
	private static void startService() {
		// 계좌 정보 입력
		Account account = inputAccount();
		try {
			// 서버로 보내고 일치하는지 확인받음. 여부는 res로 받기
			oos.writeObject(account);
			boolean res = ois.readBoolean();
			
			//res가 참이면 접속 메뉴 들어가고, 아니라면 return;
			if(res){
				int menu = 0;
				do {
					printServiceMenu();
					menu = scan.nextInt();
					scan.nextLine();
					
					//여기서 서버에 menu 보내주는 코드도 추가하면 좋긴 할듯
					oos.writeInt(menu);
					runServiceMenu(menu);
					
				}while(menu !=5);
			}
			else {
				System.out.println("[로그인 실패 : 잘못된 계좌 정보]");
				System.out.println("[이전 메뉴로 돌아갑니다]");
				return;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
	}
	//1-0. 접속 후 메뉴 동작
	private static void runServiceMenu(int menu) {
		switch(menu) {
		case 1:
			//예금 조회
			checkAcount();
			break;
		case 2:
			//입금
			deposit();
			break;
		case 3:
			//출금
			withdraw();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다");
			break;
		default:
			System.out.println("[잘못된 입력]");
		}
		
	}
	//1-0. 메뉴
	private static void printServiceMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 예금 조회");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 이전으로");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	//1-1. 예금 조회
	private static void checkAcount() {
		//서버에 oos.wirteInt(1)이 이미 처리되어있으면 생략
		
		
	}
	//1-2. 입금
	private static void deposit() {
		//서버에 oos.wirteInt(2)이 이미 처리되어있으면 생략
		
	}
	//1-3. 출금
	private static void withdraw() {
		//서버에 oos.wirteInt(3)이 이미 처리되어있으면 생략
		
	}
	
	//2. 계좌 등록
	private static void newAcount() {
		// 계좌 정보 입력
		Account account = inputAccount();
		
		// 계좌 정보 체크
		System.out.print("비밀 번호 확인 : ");
		String checkPassword = scan.nextLine();
		if(checkPassword.equals(account.getPassword())) {
			try {
				// 서버로 계좌 객체 보냄 
				oos.writeObject(account);
				//등록되었는지 여부 확인 (이미 등록된 계좌면 false로 받아옴)
				boolean res = ois.readBoolean();
				if(res) {
					System.out.println("계좌가 정상 등록 되었습니다");
				}
				else {
					System.out.println("계좌 등록에 실패했습니다");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			//비밀 번호 확인만 반복시키는건 나중에 구현하기
			System.out.println("잘못된 비밀 번호 입력");
			System.out.println("이전으로 돌아갑니다");
		}
		
	}
	private static Account inputAccount() {
		System.out.print("은행 : ");
		String bank = scan.nextLine();
		Bank bank2 = Bank.valueOf(bank);
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("계좌번호 : ");
		String accountNum = scan.nextLine();
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();
		
		return new Account(bank2, name, accountNum, password);
	}
	

}
