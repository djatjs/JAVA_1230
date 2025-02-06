package day23;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt", false);
			fw.write(97);
			fw.write(65);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
