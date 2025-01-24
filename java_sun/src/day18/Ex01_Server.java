package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	static List<Account> list = new ArrayList<Account>();
	
	public static void main(String[] args) {

		int port = 5001;

		// list가 null이면 새로 만들어줌
		// 근데 사실 이 부분은 서버가 해야할 일임
		if (list == null || list.isEmpty()) {
			list = new ArrayList<Account>();
		}

		try {
			// 클라이언트와의 연결
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			System.out.println("[서버 : 은행 사용자가 들어왔습니다.]");
			// IO 작업용
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			//서버 프로그램
			Server server = new Server(socket, list);
			server.run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
	
	
	
	
	private static void startService() {
		try {
			// 클라이언트로부터 계좌 정보 받음
			Account account = (Account) ois.readObject();
			
			// 서비스메뉴로 가기위한 변수. 정보가 맞으면 true, 아니면 false;
			boolean res;
			if(list.contains(account)) {
				res = true;
				oos.writeBoolean(res);
				//서비스 메뉴로 들어가기.
				int menu=0;
				do {
					menu = ois.readInt();
					System.out.println("[입력받은 서비스 메뉴 : "+menu+"]");
					runServiceMenu(menu, account);					
				}while(menu !=5);
			}
			else {
				//false라면 더이상 통신할 것 없음
				res = false;
				oos.writeBoolean(res);
				oos.flush();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//2. 계좌 등록
	private static void newAcount() {
		try {
			//클라이언트로부터 계좌 객체 받음
			Account account = (Account) ois.readObject();
			
			//등록된 계좌인지 확인 후 res로 결과 담기
			boolean res;
			if(list.contains(account)) {
				res = false;
			}
			else {
				//등록된 계좌가 아니라면 추가후 true.
				list.add(account);
				res = true;
			}
			oos.writeBoolean(res);
			
			//서버 자체 확인용
			System.out.println(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runServiceMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			//예금 조회
			//checkAcount(account);
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
			System.out.println("[클라이언트 : 이전 메뉴로 돌아갑니다]");
			break;
		default:
			System.out.println("[잘못된 입력]");
		}
		
	}

	private static void checkAcount() {
		// TODO Auto-generated method stub
		
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		
	}

}
