package day23;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) {
		int port = 3000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket client = server.accept();	
				System.out.println("연결됨");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
