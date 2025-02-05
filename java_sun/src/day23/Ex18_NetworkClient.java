package day23;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex18_NetworkClient {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//ip, port 설정
		//ip 설정시 내부 아이피에서 한 pc에서 테스트할 땐 동작되지만 여러 pc에서 테스트할 땐 안됨
		String ip = "192.168.40.73";
		int port = 3001;
		
		try {
			//소켓 생성
			Socket socket = new Socket(ip, port);
			System.out.println("연결됨");
			//데이터 주고 받음
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			String str = scan.nextLine();
			oos.writeUTF(str);
			oos.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("EXIT");

	}

}
