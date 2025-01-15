package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07_CharStream {

	public static void main(String[] args) {
		
		//char_stream.txt파일에는 "가나다123"이 있음
		
		String fileName ="src/day12/char_stream.txt";
		try(FileReader fr = new FileReader(fileName)){
			while(fr.ready()) {
				char ch = (char)fr.read();
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
		System.out.println();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		try(FileWriter fw = new FileWriter(fileName)){
			String str = "가나다123";
			fw.write(str);
			fw.flush();
			System.out.println(str+" :  파일에 기록됨");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		}
	}

}
