package day18.myCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
		String fileName = "src/day18/myCode/account.txt";

		list = (List<Account>) load(fileName);
		
		// list가 null이면 새로 만들어줌
		// 근데 사실 이 부분은 서버가 해야할 일임
		if (list == null || list.isEmpty()) {
			list = new ArrayList<Account>();
		}
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				try {
					// 클라이언트와의 연결
					Socket socket = serverSocket.accept();
					System.out.println("[서버 : 은행 사용자가 들어왔습니다.]");
					// IO 작업용
					oos = new ObjectOutputStream(socket.getOutputStream());
					ois = new ObjectInputStream(socket.getInputStream());
					
					// 은행 프로그램 시작
					int menu=0;
					while(true) {
						// 기본 메뉴번호(접속, 계좌 등록, 종료) 클라이언트로부터 받음
						menu = ois.readInt();
						System.out.println("[선택 : "+menu+"]");
						runBasicMenu(menu);
					}
				} catch (Exception e) {
					System.out.println("[서버 : 은행 사용자가 나갔습니다]");
					//저장하기
					save(fileName, list);
					System.out.println("[서버에 데이터를 저장합니다]");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private synchronized static void runBasicMenu(int menu) {
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
				oos.flush();
				//서비스 메뉴로 들어가기.
				int menu=0;
				do {
					menu = ois.readInt();
					System.out.println("[입력받은 서비스 메뉴 : "+menu+"]");
					runServiceMenu(menu, account);					
				}while(menu !=4);
			}
			else {
				//false라면 더이상 통신할 것 없음
				res = false;
				oos.writeBoolean(res);
				oos.flush();
				return;
			}
		} catch (Exception e) {
			
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
			oos.flush();
			
			//서버 자체 확인용
			System.out.println(list);
		}catch (Exception e) {
			
		}
		
	}

	private static void runServiceMenu(int menu, Account account) {
		switch(menu) {
		case 1:
			//예금 조회
			checkAcount(account);
			break;
		case 2:
			//입금
			deposit(account);
			break;
		case 3:
			//출금
			withdraw(account);
			break;
		case 4:
			System.out.println("[클라이언트 : 이전 메뉴로 돌아갑니다]");
			break;
		default:
			System.out.println("[잘못된 입력]");
		}
		
	}

	private static void checkAcount(Account account) {
		//입력했던 정보의 계좌 정보가져옴 : 돈까지 가져와야함
		int index = list.indexOf(account);
		Account tmpAccount = list.get(index);
		
		//클라이언트에게 계좌 정보 보내줌
		try {
			oos.writeObject(tmpAccount);
			oos.flush();
			oos.reset();
		}catch (Exception e) {
			
		}
		
	}

	private static void deposit(Account account) {
		//입력했던 정보의 계좌 정보가져옴 : 돈까지 가져와야함
		int index = list.indexOf(account);
		Account tmpAccount = list.get(index);
		
		try {
			//클라이언트로부터 입금할 금액을 받아옴
			int money = ois.readInt();
			
			//입금 처리
			boolean res;
			if(money <=0) {
				res=false;
			}else {
				tmpAccount.setMoney(tmpAccount.getMoney()+money);
				res = true;
			}
			//처리 성공 유무 반환
			oos.writeBoolean(res);
			oos.flush();
		} catch (Exception e) {
			
		}
		
	}

	private static void withdraw(Account account) {
		//입력했던 정보의 계좌 정보가져옴 : 돈까지 가져와야함
		int index = list.indexOf(account);
		Account tmpAccount = list.get(index);
		
		try {
			//클라이언트로부터 출금할 금액을 받아옴
			int money = ois.readInt();
			
			//출금 처리 : money가 0또는 음수면 안됨 && money가 tmpAccount.getMoney보다 크면 안됨
			boolean res;
			if(money <=0 || money>tmpAccount.getMoney()) {
				res = false;
			}else {
				tmpAccount.setMoney(tmpAccount.getMoney()-money);
				res = true;
			}
			//처리 성공 유무 반환
			oos.writeBoolean(res);
			oos.flush();
			
		} catch (Exception e) {
			
		}
		
	}
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
		}
		
	}
	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("불러오기 실패");
			System.out.println("-----------------");
		}
		return null;
	}

}
