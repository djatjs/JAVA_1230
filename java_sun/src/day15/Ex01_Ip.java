package day15;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01_Ip {

	public static void main(String[] args) {
		/*InetAdress 클래스 예제 */
		
		//localhost : 내부 아이피 주소에 지정된 이름. 127.0.0.1
		try {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			address = InetAddress.getByName("www.naver.com"); //도메인 : IpAdress를 직접치는거 대신 이름으로 찾을 수 있게 한듯. 그냥 Ip주소의 이름이랄까
			System.out.println(address); //도메인에 대한 주소
			
			InetAddress [] list = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(list));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
