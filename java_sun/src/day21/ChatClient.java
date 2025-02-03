package day21;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChatClient {

	private String id;
	private Socket socket;
	private List<Chat>list = new ArrayList<Chat>();
	
	private final static String EXIT = "EXIT";
	
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	
	public void receive(){
		Thread t = new Thread(()->{
			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
				while(true) {
					//문자열 대신 Chat 객체를 받음
					Chat chat = (Chat) ois.readObject();
					//채팅 내용이 EXIT와 같으면 종료
					if(chat.getChat().equals(EXIT)) {
						break;
					}
					//받은 내용 출력
					System.out.println(chat);
					//채팅 기록에 추가
					list.add(chat);
				}
			} catch (Exception e) {
				return;
			}finally {
				System.out.println("[상대방이 나갔습니다. 종료하려면"+EXIT+ "를 입력하세요.]");
			}
		});
		t.start();

	}
	
	public void send(){
		Scanner scan = new Scanner(System.in);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())){
			System.out.println("[채팅을 시작합니다.]");
			System.out.println("[종료하려면 " +EXIT+ "를 입력하세요.]");
			while(true) {
				if(socket ==null || socket.isClosed()) {
					throw new SocketException();
				}
				System.out.print(id+" : ");
				String str = scan.nextLine();
				Chat chat = new Chat(id, str);
				//문자열이 아닌 Chat 객체를 전송
				oos.writeObject(chat);
				oos.flush();			
				if(chat.equals(EXIT)) {
					break;
				}
				//채팅 기록에 추가
				list.add(chat);
			}
		}catch (Exception e) {
		}finally {
			System.out.println("[전송 기능을 종료합니다.]");				
		}	
	}
	
	public void run() {
		//send, receive를 이용하여 호출
		//이 때 둘 중 하나는 쓰레드를 제거. 밑에 있는 메소드의 쓰레드를 제거하면 됨.
		//제거하는 이유 : 제거를 안하면 두 메소드가 쓰레드로 실행되기 때문에 run메소드가 종료되고,
		//그러면 메인 메뉴로 채팅이 끊나지 않은 상태에서 종료될 수 있기 때문에.
		receive();
		send();
	}
	
}
