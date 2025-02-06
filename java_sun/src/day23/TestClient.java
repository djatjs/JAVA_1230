package day23;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String[] args) {
		int port =3000;
		String serverIP;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP,port);
			System.out.println("연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
