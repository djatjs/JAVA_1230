package day12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student> students = new ArrayList<Student>();
	static Stream<Student>stream = students.stream();
	
	public static void main(String[] args) {
		/* 다음 기능을 갖는 프로그램을 작성하세요.
		 * 1. 학생 추가
		 * - 학년, 반, 번호, 이름 입력
		 * 2. 학생 조회
		 * 3. 종료
		 * 4. 학생 삭제
		 * - 이름을 입력받아 학생들을 출력하고, 그중 선택된 학생을 삭제
		 * 
		 * 2-1. 학년 조회 : 학년
		 * 2-2. 반 조회 : 학년, 반
		 * 2-3. 번호 조회 : 학년, 반, 번호
		 * 2-4. 전체 조회 : 입력 X
		 * 
		 * - 학생 클래스 추가
		 * - List를 이용해서 학생들을 관리
		 * - Stream과 람다식을 이용해서 출력을 구현
		 * */
		
		//sample data
		students.add(new Student(1, 1, 1, "sun"));
		students.add(new Student(1, 1, 2, "sun2"));
		students.add(new Student(2, 1, 1, "um"));
		students.add(new Student(2, 1, 2, "zz"));
		students.add(new Student(3, 1, 1, "df"));
		students.add(new Student(3, 2, 1, "qwer"));
		
		
		int menu=0;
		do {
			printMenu();
			menu=scan.nextInt();
			runMenu(menu);
		}while(menu!=3);
	}
	//기본 메뉴 출력
	public static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("4. 학생 삭제");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	//메뉴에 따른 기능
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//학생추가
			inserStudent();
			break;
		case 2:
			//학생 조회
			searchStudent();
			break;
		case 3:
			System.out.println("종료");
			break;
		case 4:
			//학생 삭제
			deleteStudent();
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	//학생 추가
	private static void inserStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		//입력받은 정보로 학생 객체를 생성
		Student stdObj = new Student(grade, classNum, num, name);
		//리스트에 추가
		students.add(stdObj);
		
	}
	//학생 조회
	private static void searchStudent() {
		//메뉴2
		int menu2=0;
		do {
			printSearchMenu();
			menu2 =scan.nextInt();
			runSearchMenu(menu2);
		}while(menu2!=5);

		
	}
	//조회 메뉴 출력
	public static void printSearchMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("2-1. 학년 조회");
		System.out.println("2-2. 반 조회");
		System.out.println("2-3. 번호 조회");
		System.out.println("2-4. 전체 조회");
		System.out.println("2-5. 뒤로 가기");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}
	//조회 메뉴 상세 기능
	private static void runSearchMenu(int menu2) {
		switch(menu2) {
		case 1:
			//학년 조회 : 학년
			searchGrade();
			break;
		case 2:
			//반 조회 : 학년, 반
			searchClassNum();
			break;
		case 3:
			//번호 조회 : 학년, 반, 번호
			searchNum();
			break;
		case 4:
			//전체 조회
			searchAll();
			break;
		case 5:
			System.out.println("뒤로 가기");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	//2-1. 학년 조회 : 학년
	private static void searchGrade() {
		//stream = students.stream();
		
		System.out.print("학년을 입력하세요 : ");
		int grade = scan.nextInt();
		
		print(students,s->s.getGrade()==grade);
		//stream.filter(std->std.getGrade()==grade)
		//.forEach((std)->{System.out.println(std);});
		
	}
	//2-2. 반 조회 : 학년, 반
	private static void searchClassNum() {
		//stream = students.stream();
		
		System.out.print("학년을 입력하세요 : ");
		int grade = scan.nextInt();
		System.out.print("반을 입력하세요 : ");
		int classNum = scan.nextInt();
		print(students,s->s.getGrade()==grade&&s.getClassNum()==classNum);
		
		//stream.filter(std->std.getGrade()==grade && std.getClassNum()==classNum)
		//.forEach((std)->{System.out.println(std);});
		
	}
	//2-3. 번호 조회 : 학년, 반, 번호
	private static void searchNum() {
		//stream = students.stream();
		
		System.out.print("학년을 입력하세요 : ");
		int grade = scan.nextInt();
		System.out.print("반을 입력하세요 : ");
		int classNum = scan.nextInt();
		System.out.print("번호를 입력하세요 : ");
		int num = scan.nextInt();
		
		print(students,s->s.getGrade()==grade&&s.getClassNum()==classNum&&s.getNum()==num);

		//stream.filter(std->std.getGrade()==grade && std.getClassNum()==classNum && std.getNum()==num)
		//.forEach((std)->{System.out.println(std);});
		
	}
	//2-4. 전체 조회
	private static void searchAll() {
		//stream = students.stream();
		//stream.forEach((std)->{System.out.println(std);});
		print(students,s->true);
	}
	
	//학생 삭제
	private static void deleteStudent() {
		//stream = students.stream();
		//정보 입력
		scan.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine();

		//이름을 포함하는 학생들을 번호와 함께 출력
		List<Student> tmpList =
				students.stream().filter(s->s.getName().contains(name)).collect(Collectors.toList());
		print(tmpList, s->true, true);
		
		//삭제할 번호 입력
		System.out.print("삭제 될 학생 번호 입력하세요 : ");
		
		//입력받은 번호에 맞는 개체를 가져옴
		int indexNum = scan.nextInt()-1;
		Student tmp = tmpList.get(indexNum);
		
		//리스트에서 삭제할 객체를 이용하여 제거
		students.remove(tmp);
				
		 // 이렇게 하면 다른게 삭제될 수 있음.
		//객체를 가져와야하니까 스트림으로 가져오는건 어떰?

		System.out.println("삭제 되었습니다.");
	}
	//stream 편하게 쓰기위한 메소드
	private static void print(List<Student> students, Predicate<Student> p) {
		//Stream<Student> stream = students.stream();
		//stream.filter(p).forEach(s->System.out.println(s));
		print(students,p,false);
	}
	//삭제용 오버로딩
	private static void print(List<Student> students,Predicate<Student> p, boolean isCount) {
		Stream<Student> stream = students.stream();
		AtomicInteger index = new AtomicInteger(1);
		
		stream.filter(p).forEach(s->{
			int num = index.getAndIncrement();
			System.out.println((isCount? num+". ":"")+s);
		});
	}

}
@Data
@AllArgsConstructor
class Student{
	private int grade;
	private int classNum;
	private int num;
	private String name;
	
	@Override
	public String toString() {
		return grade+"학년 "+classNum+"반 "+num+"번 "+name;
	}
	
	
}