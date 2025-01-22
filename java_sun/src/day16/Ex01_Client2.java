package day16;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Client2 {
	static Scanner scan = new Scanner(System.in);
	// 클라이언트는 그냥 바로 서버에 넘겨줄게 있으면 됨(클라이언트 클래스를 따로 만든다거나 그런 일이 없으니까 ㅇㅇ)
	static ObjectInputStream ois;
	static ObjectOutputStream oos;

	public static void main(String[] args) {
		/*
		 * day14/Ex01_Post 예제를 활용하여 게시글 관리 프로그램을 작성하시오. 단, 네트워크 통신을 이용하여 서버와 클라이언트로 동작하는
		 * 프로그램을 작성하시오.
		 */

		String ip = "127.0.0.1";
		int port = 5001;
		Socket socket = null;

		try {
			socket = new Socket(ip, port);
			System.out.println("[서버에 연결 성공]");

		} catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다");
			return;
		}
		System.out.println("[서버와 연결에 성공함]");

		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				scan.nextLine();

				runMenu(menu, socket);

			} catch (Exception e) {
				System.out.println("올바른 메뉴를 입력하시오.");
				scan.nextLine();
			}
		} while (menu != 5);

	}

	private static void runMenu(int menu, Socket socket) {
		switch (menu) {
		case 1:
			insert(socket);
			break;
		case 2:
			update(socket);
			break;
		case 3:
			delete(socket);
			break;
		case 4:
			view(socket);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}

	}

	private static void insert(Socket socket) {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			//Post post = input();

			// 메뉴번호와 객체를 서버로 전송
			oos.writeInt(1);
			//oos.writeObject(post);
			oos.flush();

			// 추가여부에 따른 결과 알림은 필요하지 않긴 함. 게시글은 중복 작성 가능하니까 무조건 성공 ㅇㅇ
			System.out.println("게시글 등록 완료");
		} catch (Exception e) {
			e.printStackTrace();
			scan.nextLine();
		}

	}

	private static void update(Socket socket) {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			oos.writeInt(2);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void delete(Socket socket) {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			oos.writeInt(3);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void view(Socket socket) {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			oos.writeInt(4);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}

	private static Post input(boolean isWriter) {
		// 제목, 내용, 작성자를 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		String writer ="";
		
		if(isWriter) {
			System.out.println("작성자 : ");
			writer = scan.next();
			scan.nextLine();
		}
		// 입력받은 내용으로 객체를 생성
		return new Post(title, content, writer);
	}
	
}
