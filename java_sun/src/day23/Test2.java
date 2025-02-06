package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

public class Test2 {
	static List<Food> list;
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		String fileName = "D:/test.txt";
		list= (List<Food>) load(fileName);
		// 리스트 초기화 (null 체크 후)
        if (list == null) {
            list =  new ArrayList<Food>(); // 리스트 초기화
        }
        //샘플 데이터
		list.add(new Food("사과",20));
        System.out.println(list);
		
		save(fileName,list);
	}

	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("불러오기 실패");
			System.out.println("-----------------");
		}
		return null;
	}

	private static void save(String fileName, List<Food> list) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
		}catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
		}
	}
}
@Data
class Food implements Serializable{

	private static final long serialVersionUID = -2105986756574039479L;
	private String name;
	private int kcal;
	
	//생성자
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	
	public Food() {
		
	}

	@Override
	public String toString() {
		return name + " : " + kcal + "칼로리";
	}
	
}