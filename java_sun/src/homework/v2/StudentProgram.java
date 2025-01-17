package homework.v2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements ConsoleProgram {
	
	private Scanner scan= new Scanner(System.in);

	private StudentManager studentManager = new StudentManager();
	private SubjectManager subjectManager = new SubjectManager();
	
	public void run() {
		
		int menu = 0; //예외처리 때문에 초기화를 해야 함.
		final int EXIT = 13;
		
		//불러오기
		String studentFileName = "src/homework/v2/student.txt";
		String subjectFileName = "src/homework/v2/subject.txt";
		
		load(studentFileName, new ArrayList<Object>(studentManager.getList()));
		load(subjectFileName, new ArrayList<Object>(subjectManager.getList()));
		
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				removeBuffer();
				//메뉴 실행
				runMenu(menu);
			}
			//잘못된 타입의 메뉴를 입력한 경우(int가 아닐 때)
			catch(InputMismatchException e) {
				System.out.println("올바른 입력이 아닙니다!");
				removeBuffer();//잘못 입력한 값을 입력 버퍼에서 지우기 위함
			}
		}while(menu != EXIT);
		//저장하기
	}
	
	@Override
	public void printMenu() {
		
	}


	private void removeBuffer() {
		scan.nextLine();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			System.out.println("과목 등록 기능 구현 예정");
			insertSubject();
			break;
		case 5:
			System.out.println("과목 수정 기능 구현 예정");
			updateSubject();
			break;
		case 6:
			System.out.println("과목 삭제 기능 구현 예정");
			deleteSubject();
			break;
		case 7:
			System.out.println("성적 등록 기능 구현 예정");
			insertScore();
			break;
		case 8:
			System.out.println("성적 수정 기능 구현 예정");
			updateScore();
			break;
		case 9:
			System.out.println("성적 삭제 기능 구현 예정");
			deleteScore();
			break;
		case 10:
			System.out.println("학생 조회 기능 구현 예정");
			searchStudent();
			break;
		case 11:
			System.out.println("과목 조회 기능 구현 예정");
			searchSubject();
			break;
		case 12:
			System.out.println("성적 조회 기능 구현 예정");
			searchScore();
			break;
		case 13:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
	}
	//1.학생 추가
	private static void insertStudent() {
		//학년, 반, 번호, 이름 입력
			
		//주의 : 학생 객체 생성시 성적 리스트를 생성 #null 주의
		//입력 받은 학년, 반, 번호, 이름을 이용하여 객체 생성 => 리스트에 있는 기능을 활용하기 위해 #contains, indexOf

		//학생 매니저에게 학생 개체를 주면서 추가하라고 시키고 추가 여부를 확인해서 알림
	
	}
	//2.학생 수정
	private static void updateStudent() {
		//학년, 반, 번호 입력
			
		//입력한 학생 정보를 객체 생성
			
		//학생 매니저에게 학생 객체를 주면서 있는지 확인 요청하여 있으면 알림 후 종료
			
		//아니면 수정할 학년, 반, 번호, 이름을 입력
			
		//입력받은 정보로 객체를 생성
			
		//학생 매니저에게 기본 학생 개체와 새 학생 객체를 주면서 수정하고 수정 여부를 알려달라 요청 후 결과에 따라 알림
			
	}
	//3.학생 삭제
	private static void deleteStudent() {
		//학년, 반, 번호를 입력
		
		//입력받은 정보로 객체 생성
		
		//학생 매니저에게 학생 객체를 주면서 삭제하고 삭제여부를 알려달라고 요청
		
		//삭제에 성공하면 성공알림문구
		
		//실패하면 실패 알림문구 출력
		
	}
	//4.과목 추가
	private static void insertSubject() {
		//학년, 학기, 과목명을 입력
		
		//과목 객체 생성
		
		//과목 매니저에게 과목을 주면서 등록하라고 요청 후 결과에 따라 알림
		
	}
	//5.과목 수정
	private static void updateSubject() {
		//학년, 학기, 과목명을 입력
		
		//입력한 정보로 객체 생성
		
		//새 과목 정보를 입력(학년, 학기, 과목)
		
		//과목 매니저에게 기존 과목 객체와 새 과목 객체를 주면서 수정하라고 요청 후 결과에 따라 알림
		
	}
	//6.과목 삭제
	private static void deleteSubject() {
		//학년, 학기, 과목명 입력
		
		//입력한 정보로 객체 생성
		
		//과목 매니저에게 과목 객체를 주면서 삭제하라고 요청 후 결과에 따라 알림
		
	}
	//7.성적 추가
	private static void insertScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
		
		//학생 매니저에게 학생이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		
		//학년, 학기, 과목을 입력
		
		//입력한 정보로 객체를 생성(Subject)
		
		//과목 매니저에게 과목이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		
		//학생 매니저에게 학생 객체와 성적 객체를 주면서 성적을 등록하고 요청 후 결과에 따라 알림
		
	}
	//8.성적 수정
	private static void updateScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
				
		//학생 매니저에게 확인 후 없으면 알림 후 종료
				
		//학년, 학기, 과목을 입력
				
		//입력한 정보로 객체를 생성(Subject)
				
		//과목 매니저에게 과목을 확인 후 없으면 알림 후 종료
		
		//새 과목 정보를 입력(학년, 학기, 과목)
		
		//과목 매니저에게 새 과목을 확인 후 없으면 알림 후 종료
		
		//성적 입력
		
		//새 과목 정보와 성적을 이용하여 새 성적 개체를 생성
		
		//학생 매니저에게 기존 과목과 새 성적을 주면서 성적을 수정하라고 요청 후 결과에 따라 알림
		
		//실패하면 알림
		
	}
	//9.성적 삭제
	private static void deleteScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
						
		//학생 매니저에게 학생이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
						
		//학년, 학기, 과목을 입력
						
		//입력한 정보로 객체를 생성(Subject)
		
		//과목 매니저에게 과목이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		
		//학생 매니저에게 과목을 주고 삭제 요청 후 결과에 따라 알림
		
	}
	//10.학생 조회
	private static void searchStudent() {
		//학년, 반, 번호를 입력
		
		//입력한 정보를 이용하여 객체 생성
		
		//학생 매니저에게 학생 정보를 주면서 출력하라고 요청
		
	}
	//11.과목 조회
	private static void searchSubject() {
		//과목 매니저에게 등록된 과목을 출력하라고 요청
		
	}
	//12.성적 조회
	private static void searchScore() {
		//학년, 학기, 과목명 입력
		
		//입력한 정보로 객체 생성
		
		//학생매니저에게 학생이 있는지 확인 후 없으면 알림
		
		//학년, 학기, 과목명을 입력
		
		//과목정보로 객체를 생성
		
		//학생 매니저에게 학생 정보와 과목 정보를 주면서 성적을 출력하라고 요청
		
	}
	

	@Override
	public void load(String fileName, List<Object> list) {

	}

	@Override
	public void save(String fileName, List<Object> list) {

	}
}
