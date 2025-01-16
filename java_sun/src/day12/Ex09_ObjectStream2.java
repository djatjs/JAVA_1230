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

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {
	
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
		final int EXIT = 3;
		String fileName = "src/day12/car.txt";
		
		load(fileName, carList);
		do {
			printMenu();
			menu=scan.nextInt();
			
			runMenu(menu);
		}while(menu != EXIT);
		
		save(fileName, carList);
		
		
	}
	private static void load(String fileName, ArrayList<Car> carList) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			ArrayList<Car> tmp = (ArrayList<Car>) ois.readObject();
			carList.addAll(tmp);
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
		
	}
	private static void save(String fileName, ArrayList<Car> carList2) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(carList);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
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
			printCar();
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
		//객체 생성 및 추가
		//Car car = new Car(name, brand);
		//carList.add(car);
		carList.add(new Car(name, brand));
		
		
	}
	private static void printCar() {
		//정렬
		carList.sort((o1,o2)->{
			//브랜드를 비교하여 다르면 사전순으로 정렬
			if(!o1.getBrand().equals(o2.getBrand())) {
				return o1.getBrand().compareTo(o2.getBrand());
			}
			//이름을 사전순으로 정렬
			return o1.getName().compareTo(o2.getName());
		});
		
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
	
	private static final long serialVersionUID = 1455289863100321662L; //직렬화시키기 위해서 시리얼라이즈를 함
	private String name;
	private String brand;
	
	@Override
	public String toString() {
		return brand+ " : " + name;
	}
	
}