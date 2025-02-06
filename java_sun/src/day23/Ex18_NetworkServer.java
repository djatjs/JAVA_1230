package day23;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex18_NetworkServer {

	public static void main(String[] args) {
		//port 설정
		int port= 3001;
		ServerSocket serverSocket;
		try {
			//서버소켓 생성
			serverSocket = new ServerSocket(port);
			while(true) {
				//연결될 때까지 대기. 연결되면 소켓 생성
				Socket socket = serverSocket.accept();
				System.out.println("연결 완료");				
				//통신을 통해 데이터 주고 받음
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				String str = ois.readUTF();
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("EXIT");

	}

}
