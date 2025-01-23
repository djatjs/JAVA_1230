package day17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	
	static List<Game> list;
	
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// 찾아갈 서버의 ip, port 지정
		String ip = "127.0.0.1";
		int port = 5001;
		
		 // 리스트 초기화 (null 체크 후)
        if (list == null) {
            list = new ArrayList<Game>(); // 리스트 초기화
        }
        
		
		try {
			// 서버와 연결
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 성공]");

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			 // 게임 접속

		} catch (Exception e) {
			System.out.println("[서버와 연결이 되지 않아 프로그램을 종료합니다.]");
			return;
			// 저장
		}
		while(true) {
			try {
				printMenu();
				int menu = scan.nextInt();
				scan.nextLine();
				// 서버에 메뉴 보내기
				oos.writeInt(menu);
				oos.flush();
				runMenu(menu);
				if (menu == 3) break; // 종료 메뉴 처리
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

	private static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 게임 시작");
		System.out.println("2. 랭킹 조회");
		System.out.println("3. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");

	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			startGame();
			break;
		case 2:
			ranking();
			break;
		case 3:
			break;
		default:
			System.out.println("잘못된 입력");
		}

	}

	private static void startGame() {
		try {
			
			// 게임 플레이 후 점수 반환
			int score = playGame();
			System.out.println(score); //여기까지는 수행하는거같은데
			oos.writeInt(score);
			oos.flush();
			// 점수 서버에 보냄 -> 5위 안에 들면 서버에게 res=true 전송받음
			boolean res = ois.readBoolean();
			System.out.println("서버 응답: " + res);
			oos.flush(); 
			if(!res) {
				//순위에 못들었다고 안내 후 메뉴로 복귀
				System.out.println("게임이 종료되었습니다.");
				return;
			}
			else {
				//이니셜 보내도록 안내
				System.out.println("축하합니다! 게임 순위에 등록합니다.");
				String name = "";
				scan.nextLine();
				while(name.length()!=3) {
					System.out.print("3글자 이니셜 입력 : ");
					name = scan.nextLine();
				}
				oos.writeUTF(name);
				oos.flush(); 
				//랭킹 등록 처리 유무
				boolean res2 = ois.readBoolean();
				if(res2) {
					System.out.println("랭킹 등록 완료");
				}else {System.out.println("랭킹 등록 실패");}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int playGame() {
		// 게임 플레이
		int min = 1, max = 9;
		ArrayList<Integer> com = creatRandom(min, max);

		int strike = 0, ball = 0;
		int num = 0; // 사용자가 입력 할 숫자
		ArrayList<Integer> user = new ArrayList<Integer>();

		int score = 0; // 점수

		// 맞출 때 까지 반복
		while (strike != 3) {
			// clear()로 리스트에 있는 값 초기화
			user.clear();
			// 입력
			while (user.size() < 3) {
				System.out.print("사용자 숫자 입력 : ");
				num = scan.nextInt();
				if (!user.contains(num)) {
					user.add(num);
				} else {
					System.out.println("다시 입력하시오");
				}
			}
			score++; // 0 0 0 이렇게 입력 하고 나면 점수(트라이 횟수)+1
			strike = getstrike(com, user);
			ball = getBall(com, user);

			// 결과 출력
			gameResult(strike, ball);
		}
		return score;
	}

	private static void gameResult(int strike, int ball) {
		System.out.print("게임 결과 : ");
		if (strike != 0) {
			System.out.print(strike + "S");
		}
		if (ball != 0) {
			System.out.print(ball + "B");
		}
		if (strike == 0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}

	private static int getstrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (com.get(i) == user.get(i)) {
				strike++;
			}
		}
		return strike;
	}

	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		int count = 0;
		// contains 쓰면 되지 않을까
		for (int i = 0; i < 3; i++) {
			if (com.contains(user.get(i))) {
				count++;
				continue;
			}
		}
		int ball = count - getstrike(com, user);
		return ball;
	}

	private static ArrayList<Integer> creatRandom(int min, int max) {
		// 세트로 숫자 랜덤으로 받기
		HashSet<Integer> set = new HashSet<Integer>();
		while (set.size() < 3) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			set.add(r);
		}
		// 리스트로 옮기고 셔플
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		return list;

	}

	private static void ranking() {
		try {
			// 서버에게 리스트 반환받음
			List<Game> list = (List<Game>) ois.readObject();
			// 출력
			if(list.isEmpty()) {
				System.out.println("현재 기록 없음");
				return;
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + 1 + ". " + list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
