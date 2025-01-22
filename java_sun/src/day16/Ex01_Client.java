package day16;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
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
		

		try  {
			Socket socket = new Socket(ip, port);
			System.out.println("[서버에 연결 성공]");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			
		} catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다");
			return;
		}

		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				scan.nextLine();
				oos.flush();
				runMenu(menu);

			} catch (Exception e) {
				System.out.println("올바른 메뉴를 입력하시오.");
				scan.nextLine();
			}
		} while (menu != 5);

	}


	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}

	}


	private static void insert() {
		try {
			Post post = inputBase();

			// 메뉴번호와 객체를 서버로 전송
			oos.writeInt(1);
			oos.writeObject(post);
			

			// 추가여부에 따른 결과 알림은 필요하지 않긴 함. 게시글은 중복 작성 가능하니까 무조건 성공 ㅇㅇ
			boolean res = ois.readBoolean();
			if(!res) {
				System.out.println("게시글 등록 실패");
			}
			System.out.println("게시글 등록 완료");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			scan.nextLine();
		}

	}

	private static void update() {
		try {
			System.out.print("게시글 번호 입력 : ");
			int num = scan.nextInt();
			scan.nextLine();
			
			//메뉴와 수정하려는 게시글 번호를 서버로 보냄
			oos.writeInt(2);
			oos.writeInt(num);
			oos.flush();
			
			//수정할 내용 입력 : 난 객체 안만들거임
			System.out.print("제목 : ");
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String content = scan.nextLine();
			
			oos.writeUTF(title);
			oos.writeUTF(content);
			oos.flush();
			
			boolean res = ois.readBoolean();
			if(!res) {
				System.out.println("게시글 수정 실패");
				return;
			}
			System.out.println("게시글 수정 완료");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void delete() {
		try {
			System.out.print("게시글 번호 입력 : ");
			int num = scan.nextInt();
			scan.nextLine();
			//메뉴와 수정하려는 게시글 번호를 서버로 보냄
			oos.writeInt(3);
			oos.writeInt(num);
			oos.flush();
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("게시글 삭제 완료");
				return;
			}
			System.out.println("게시글 삭제 실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void view() {
		try {
			//서버에게 전체 게시글을 요청 후 출력
//			List<Post> list = (List<Post>) ois.readObject();
//			if(!printList(list)){
//				return;
//			}
			
			System.out.print("게시글 번호 입력 : ");
			int num = scan.nextInt();
			scan.nextLine();
			//메뉴와 수정하려는 게시글 번호를 서버로 보냄
			oos.writeInt(4);
			oos.writeInt(num);
			oos.flush();
			
			Post post = (Post) ois.readObject();
			if(post !=null) {
				post.print();
			}else {
				System.out.println("해당 번호의 글이 존재하지 않습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean printList(List<Post> list) {
		if(list ==null || list.size()==0) {
			System.out.println("등록된 게시글이 없음");
			return false;
		}
		for(Post post : list) {
			System.out.println(post);
		}
		return true;
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

	private static Post input() {
		// 제목, 내용, 작성자를 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();

		// 입력받은 내용으로 객체를 생성
		return new Post(title, content, "");
	}
	private static Post inputBase() {
		Post post = input();
		
		System.out.print("작성자 : ");
		String writer = scan.next();
		scan.nextLine();		
		post.setWriter(writer);

		return post;
	}
}
