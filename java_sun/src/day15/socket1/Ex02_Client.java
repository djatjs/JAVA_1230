package day15.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_Client {
	//서버와 연결 후 서버에 문자열을 보내고, 서버에서 받은 문자열을 출력하는 예제
	public static void main(String[] args) {
		//서버 IP와 서버 포트를 지정
		String ip = "127.0.0.1";//localhost : 내 컴퓨터
		int port = 5001; //서버와 포트번호 맞춤
		Scanner scan = new Scanner(System.in);
		
		
		//소켓을 생성하고 서버에 연결 요청
		try (Socket socket = new Socket(ip,port)) {
			System.out.println("[연결 완료]");
			//IO 스트림을 열어서 작업
			//보내기
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
				
			System.out.print("보낼 문자열 입력 : ");
			String sStr = scan.nextLine();
			oos.writeUTF(sStr);
			oos.flush();
			//받기
			InputStream iS = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(iS);
				
			String receiveStr = ois.readUTF();
			System.out.println("받은 문자열 : " + receiveStr);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
