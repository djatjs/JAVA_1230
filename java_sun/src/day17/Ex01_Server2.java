package day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import day16.ver2.Post;

public class Ex01_Server2 {

	static List<Game> list;

	static ObjectOutputStream oos;
	static ObjectInputStream ois;

	public static void main(String[] args) {
		/*
		 * 숫자 야구 게임 단, 기록은 통신을 이용해 서버에 저장 
		 * 기록은 영문 3자와 횟수를 기록 
		 * ex) SUN 3 기록이 같은 경우 먼저 등록된
		 * 순으로 순위를 출력(그럼 숫자 기준으로 해야할 듯) 
		 * 기록은 상위 5명만 출력
		 */
		// 서버는 클라이언트가 찾아올거니까 ip설정 필요 X
		int port = 5001;
		
		// 게임 순위 정보 불러오기
		String fileName = "src/day17/game.txt";
		System.out.println("[게임 정보를 불러옵니다]");
		list = (List<Game>) load(fileName);
		
		 // 리스트 초기화 (null 체크 후)
        if (list == null) {
            list = new ArrayList<Game>(); // 리스트 초기화
        }
        
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("[서버 : 게임 유저 입장]");
					// 소켓을 활용한 입출력 기능
					oos = new ObjectOutputStream(socket.getOutputStream());
					ois = new ObjectInputStream(socket.getInputStream());

					// 게임 시작
					while (true) {
						// 메뉴를 입력 받음
						int menu = ois.readInt();
						System.out.println("[유저 선택 : "+menu+"]"); // 여기부터가 잘못됨
						// 입력받은 메뉴에 맞는 기능을 실행
						runMenu(menu);
					}
				} catch (Exception e) {
					System.out.println("[서버 : 게임 유저 퇴장]");
					System.out.println("[게임 기록을 저장합니다]");
					//save();
					save(fileName, list);
				}
			}

		} catch (Exception e) {
			// 저장
		} finally {
			// 저장(예상치 못한 상황으로 인해 저장되었을 때 보험용)
		}

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
			System.out.println("[클라이언트 : 메뉴 잘못 입력함]");
		}

	}

	private static void startGame() {
		try {
			// 클라이언트가 게임 플레이 후 점수를 보내면 5위 안에 드는지 판별
			// 점수를 받음
			System.out.println("[서버 : 스코어 전달받는중 ...]");
			int score = ois.readInt();
			System.out.println("[받은 스코어: " + score + "]");
			
			// 5위 안에 들면 이니셜 보내라는 신호로 res=true 전송, 아니면 false전송
			boolean res = checkRanking(score);
			
			if (res) {
				oos.writeBoolean(res);
				oos.flush();
				// 클라이언트가 이니셜 보내면 게임 객체를 만들어 list.add(게임 객체)해줌
				// 이 과정에서 list.remove(5등), list.add(게임 객체), list.sort()하면 될거같음
				String name = ois.readUTF();
				
				list.add(new Game(score, name));
				
				//정렬
				Collections.sort(list,(o1,o2)->{
					Game g1 = (Game)o1;
					Game g2 = (Game)o2;
					if(g1.getScore()!=g2.getScore()) {
						return g1.getScore() - g2.getScore();
					}
					return g1.getDate().compareTo(g2.getDate());
				});
				
				//뒤쳐진 기록 삭제
				if(list.size()>5) {
					list.remove(5);
				}
				
				// 처리 후 클라이언트가 처리 유무 알 수 있게 res2 반환.
				boolean res2 = true;
				oos.writeBoolean(res2);
				System.out.println(res2);
				oos.flush();
			} else {
				oos.writeBoolean(res);
				oos.flush();
				return;
			}

			System.out.println(list);
		} catch (Exception e) {
			// e.printStackTrace();
		}

		// 클라이언트가 이니셜 보내면 게임 객체를 만들어 list.add(게임 객체)해줌
		// 이 과정에서 list.remove(5등), list.add(게임 객체), list.sort()하면 될거같음

		// 처리 후 클라이언트가 처리 유무 알 수 있게 res2 반환.

	}

	private static boolean checkRanking(int score) {
		//조건에 안맞으면 false로 두기
		Date date = new Date(); //시간도 비교해야됨.. //왜 이런 짓을 하냐.. 상위권에 도달한 유저에게는 특별한 메시지를 주고싶어서.
		
		//리스트 크기가 5이하라면 바로 순위권
		if(list.size()<5) {
			return true;
		}else {
			// 리스트를 순회하며 점수나 날짜가 기준에 맞는지 확인
			for(Game tmp : list) {
				//횟수가 낮다는건 순위안에 든다는것. 처음엔 false로 될 수 있음. 근데 리스트 돌면서 끝까지 갈 땐 true로 될 수도 있다는거.  
				// 점수가 더 낮거나, 날짜가 더 이전이면 순위권 가능
				if (tmp.getScore() > score || 
					    (tmp.getScore() == score && date.before(tmp.getDate()))) { 
					return true;
				}//끝까지 false라면 그냥 버리도록하자.

			}
		}
		return false;
	}

	private static void ranking() {
		// list 보내줌
		try {
		    oos.writeObject(list);
		    oos.flush();
		    oos.reset();
		} catch (IOException e) {
		    e.printStackTrace();
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
