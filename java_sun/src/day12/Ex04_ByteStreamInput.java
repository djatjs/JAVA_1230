package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04_ByteStreamInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		
		
		//InputStream은 해당 폴더에 파일이 없으면 FileNotFoundException 에러가 뜸
		
		
		
		try {
			fis = new FileInputStream("src/day12/byte_stream.txt");
			int data;
			do {
				data = fis.read();
				if(data!= -1) {
					System.out.print((char)data);
				}
			}while(data !=-1);

		}catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException e){
			System.out.println("읽기에 실패했습니다.");
		}finally { //파일 닫아줘야함
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
