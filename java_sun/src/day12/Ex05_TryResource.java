package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex05_TryResource {

	public static void main(String[] args) {
		
		/* try resource문은 리소스를 열어서 사용한 후 닫아줘야하는데 자동으로 닫히게 하고 싶을 때 사용.
		 * */
		try(FileInputStream fis = new FileInputStream("src/day12/byte_stream.txt")){
			int data;
			do {
				data = fis.read();
				if (data !=-1) {
					System.out.println((char)data);
				}
			}while(data!=-1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("읽기에 실패함");
		}
	}

}
