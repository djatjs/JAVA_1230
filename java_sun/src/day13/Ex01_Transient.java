package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Ex01_Transient {

	public static void main(String[] args) {
		/* transient
		 * - 직렬화, 역직렬화가 되는 과정에서 직렬화/역직렬화를 하고 싶지 않은 객체에 사용
		 * */
		Point point = new Point(1, 2, 3);
		String fileName = "src/day13/point.txt";
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			point = (Point) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없음");
			e.printStackTrace();
		}
		//처음 객체를 만들고 읽어오려할때는 파일이 없으니까 (1,2,3)으로 출력됨.
		//transient int z;으로 되어있어서 파일에 저장은 (1,2,0)으로 될거고, 다음에 다시 run하면 파일 읽어져서 (1,2,0)으로 나옴
		System.out.println(point);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(point);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.printStackTrace();
		}

	}

}
@Data
@AllArgsConstructor
class Point implements Serializable{

	private static final long serialVersionUID = -5564626764405437214L;


	private int x,y;
	
	
	private transient int z;
	
	
}