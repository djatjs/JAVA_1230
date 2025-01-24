package day18;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Server {
	
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	private Socket socket;
	private List<Account> list;
	
	public Server(Socket socket, List<Account> list) {
		this.socket = socket;
		this.list = list;
		
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
		if (socket == null || ois ==null || oos ==null || list ==null) {
			System.out.println("[클라이언트와의 연결에 실패했습니다]");
			return;
		}

		// 은행 프로그램 시작
		int menu=0;
		while(true) {
			// 기본 메뉴번호(접속, 계좌 등록, 종료) 클라이언트로부터 받음
			try {
				menu = ois.readInt();
				runBasicMenu(menu);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[선택 : "+menu+"]");
		}
	}
	private void runBasicMenu(int menu) {
		switch(menu) {
		case 0:
			//접속
			open();
			break;
		case 1:
			//접속
			deposit();
			break;
		case 2:
			//계좌 생성
			withdraw();
			break;
		case 3:
			check();
			break;
		default:
			System.out.println("[은행 프로그램 종료]");
			System.out.println("[잘못된 입력]");
		}
		
	}

	private void open() {
		// TODO Auto-generated method stub
		
	}

	private void deposit() {
		// TODO Auto-generated method stub
		
	}

	private void withdraw() {
		// TODO Auto-generated method stub
		
	}

	private void check() {
		// TODO Auto-generated method stub
		
	}
}
