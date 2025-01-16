package day13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex03_IOStream {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		String fileName = "src/day13/String.txt";
		//불러오기
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)){
			String line;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e1) {
			System.out.println("파일을 찾을 수 없음");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("IO 예외 발생");
			e1.printStackTrace();
		}
		
		
		list.add("안녕");
		list.add("이름");
		
		//저장하기
		//FileWriter에서 이어쓰기를 하려면 생성자에 파일명과 true를 순서대로 넣어주면 됨.
		try(FileWriter fw = new FileWriter(fileName, true)){ //,true 붙이면 이어쓰기 됨. 없으면 새로쓰기
			fw.write("안녕하세요 \n");
			fw.write("저는 sun입니다. \n");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		}
		
	}

}

