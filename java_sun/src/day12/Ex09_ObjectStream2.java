package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import day01.Ex08_Casting;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {
	
	static String fileName = "src/day12/car_stream.txt";
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Car> carList = new ArrayList<Car>();
	
	public static void main(String[] args) {
		/* 다음 기능을 갖는 프로그램을 작성하쇼
		 * 단, 저장기능과 불러오기 기능을 추가
		 * - 저장은 프로그램 종료할 때
		 * - 불러오기는 프로그램 시작 전
		 * 
		 * 1. 자동차 추가
		 * 2. 자동차 조회(전체)
		 * 3. 종료
		 * 
		 * ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 인터페이스임
		 * */
		
		int menu=0;
		
		//여기서 열어야될거같은데. 일단 열고봐
		try(FileOutputStream fos = new FileOutputStream(fileName);
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(fileName);
        		ObjectInputStream ois = new ObjectInputStream(fis)){
			
			do {
				printMenu();
				menu = scan.nextInt();
				runMenu(menu);
			}while(menu!=3);
			oos.writeObject(carList);
			//여기서 닫아야될거같은데
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
			
			
			
		
		
	}
	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			//추가
			insertCar();
			break;
		case 2:
			//조회
			searchCar();
			break;
		case 3:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	private static void insertCar() {
		// 일단 콘솔로 입력 받으셈
		scan.nextLine();
		System.out.print("이름 : ");
		String name= scan.nextLine();
		System.out.print("회사 : ");
		String brand= scan.nextLine();
		
		Car car = new Car(name, brand);
		carList.add(car);
		
		
	}
	private static void searchCar() {
		for(Car tmp : carList) {
			System.out.println(tmp);
		}
		
	}
	public static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 자동차 추가");
		System.out.println("2. 자동차 조회");
		System.out.println("3. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}

}
@Data
@AllArgsConstructor
class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1455289863100321662L;
	private String name;
	private String brand;
	
	@Override
	public String toString() {
		return name + " of " + brand;
	}
	
}