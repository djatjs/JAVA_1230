package day23;

import java.io.FileReader;
import java.io.FileWriter;

public class Ex16_IOStream {

	public static void main(String[] args) {
		//
		String fileName = "src/day23/ex16.txt";
		//FileWriter(파일명) : 기존 파일 지우고 새로 만듬
		//FileWriter(파일명, boolean) : 참이면 이어쓰기, 거짓이면 새로 만듬
		try(FileWriter fw = new FileWriter(fileName, true)){
			fw.write(97);
			fw.write(65);
			//fw.flush();
		}catch (Exception e) {
		}
		
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch =(char) fr.read();
				System.out.print(ch);
			}			
		}catch (Exception e) {
		}

	}

}
