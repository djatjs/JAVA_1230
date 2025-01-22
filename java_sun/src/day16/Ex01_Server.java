package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;




public class Ex01_Server {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		
		int port = 5001;
		
		//불러오기용
		String fileName = "src/day16/post.txt";
		List<Post> list = (List<Post>) load(fileName);

		if (list != null && !list.isEmpty()) {
		    int lastIndex = list.size() - 1;
		    Post lastPost = list.get(lastIndex);
		    int lastNum = lastPost.getNum();
		    Post.setCount(lastNum);
		} else {
		    Post.setCount(0);
		}
		
		
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while(true) {
				save(fileName, list);
				//서버가 대기하다 연결 요청이 오면 소켓 객체를 생성
				//1. 서버 대기 2. 연결 요청 수락 3. 소켓 객체 생성
				Socket socket = serverSocket.accept();
				System.out.println("[연결 완료]");
				
				//소켓을 활용한 클라이언트와의 실제 작업은 서버 클래스에 구현 예정이므로 소켓 객체를 넘겨줌
				Server server = new Server(socket,list);
				server.run();				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
