package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientProgram {
	static Scanner scan;
	static ObjectInputStream ois;
	static ObjectOutputStream oos;

	private Socket socket;

	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);
		if (socket == null) {
			return;
		}
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		if (socket == null || ois ==null || oos ==null) {
			System.out.println("[서버 연결에 실패했습니다]");
			return;
		}
		
		int menu = 0;
		do {
			printBasicMenu();
			menu = scan.nextInt();
			scan.nextLine();
			// 기본 메뉴 서버로 전송
			try {
				oos.writeInt(menu);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runBasicMenu(menu);
		} while (menu != 3);
	}

	private static void printBasicMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 접속");
		System.out.println("2. 계좌 개설");
		System.out.println("3. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");

	}

	private static void runBasicMenu(int menu) {
		switch (menu) {
		case 1:
			// 접속
			login();
			break;
		case 2:
			// 계좌 생성
			//newAcount();
			break;
		case 3:
			System.out.println("[은행 프로그램 종료]");
			break;
		default:
			System.out.println("[잘못된 입력]");
		}
	}

	private static void login() {
		// 계좌 정보 입력
		Account account = inputAccount();
		System.out.println("[접속 중]");
		System.out.println("[같은 계정으로 다른 사용자가 먼저 사용중이면 대기할 수 있습니다.]");
		// 서버로 보내 account가 일치하는지 확인받음 => 서버에게 account와 일치하는 계좌 정보를 달라고 요청? 이건 왜하지?
		
		//일치하지 않으면 안내 후 종료
		
		System.out.println("[계좌에 접속했습니다]");
		int menu;
		do {
			printLoginMenu();
			
			menu = scan.nextInt();
			
			runLoginMenu(menu,account);
		}while(menu!=4);
		
	}

	private static Account inputAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void printLoginMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void runLoginMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			check(account);
			break;
		case 2:
			deposit(account);
			break;
		case 3:
			withdraw(account);
			break;
		case 4:
			break;
		default:
			
		}
		
	}

	private static void check(Account account) {
		// TODO Auto-generated method stub
		
	}

	private static void deposit(Account account) {
		// TODO Auto-generated method stub
		
	}

	private static void withdraw(Account account) {
		// TODO Auto-generated method stub
		
	}

}
