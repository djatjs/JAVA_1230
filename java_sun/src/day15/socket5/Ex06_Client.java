package day15.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex06_Client {
	static Scanner scan=new Scanner(System.in);
	
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		int port=5001;
		
		int menu;
		//프로그램 시작전 서버 연결체크 : 실패하면 종료, 성공하면 프로그램 실행.
		try  {
			Socket socket = new Socket(ip, port);
			System.out.println("[프로그램 시작]");
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois= new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) { //ip나 port가 정상적이지 않은 경우
			System.out.println("[서버와 연결에 실패함]");
			System.out.println("[프로그램 종료]");
			return;
		}
		System.out.println("[서버와 연결에 성공함]");
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu!=5);
		
		
	}

	private static void printMenu() {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
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
			search();
			break;
		case 5: 
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}
	//등록 요청
	private static void insert() {
		System.out.println("추가할 학생의 정보를 입력하세요");
		Student std = input();
		
		try {
			oos.writeInt(1);//메뉴 전송
			oos.writeObject(std);//학생 전송
			oos.flush();
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("학생 등록 완료");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("학생 등록 실패");
	}

	private static Student input() {
		Student std = inputBase();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		std.setName(name);
		return std;
	}
	//학년 반 번호 입력
	private static Student inputBase() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		return new Student(grade, classNum, num, "");
	}

	//수정 요청
	private static void update() {
		try {
			//학생 기본 정보를 입력
			System.out.println("학생 정보 입력");
			Student std = inputBase();
			
			//수정할 학생 정보를 입력
			System.out.println("새 학생 정보 입력");
			Student newStd = input();
			
			//메뉴 전송
			oos.writeInt(2);
			
			//서버에 학생 기본 정보와 수정할 학생 정보를 전송
			oos.writeObject(std);
			oos.writeObject(newStd);
			oos.flush();
			
			//서버에서 결과를 받아서 true면 수정 성공, false면 수정 실패를 알림
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("학생 수정 완료");
				return;
			}
			System.out.println("학생 수정 실패");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//삭제 요청
	private static void delete() {
		try {
			//삭제할 학생의 정보 입력
			Student std = inputBase();
			
			//서버에 메뉴와 학생 정보 전송
			oos.writeInt(3);
			oos.writeObject(std);
			oos.flush();
			
			//결과룰 서버로부터 받아 알림문구 출력
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("학생 삭제 완료");
				return;
			}
			System.out.println("학생 삭제 실패");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//조회 요청
	private static void search() {
		try {
			//서버에게 요청하여 전체 게시글을 가져옴 
			//메뉴 전송
			oos.writeInt(4);
			oos.flush();
			
			//학생 정보를 입력
			Student std = inputBase();
			
			//서버에게 학생 정보를 전송 후 학생 정보를 받아 옴
			oos.writeObject(std);
			Student receiveStd = (Student) ois.readObject();
			
			//학생 정보가 있으면 출력, 없으면 안내문구
			if(receiveStd != null) {
				System.out.println(receiveStd);
				return;
			}
			System.out.println("일치하는 학생이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
