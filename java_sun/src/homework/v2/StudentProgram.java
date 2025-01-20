package homework.v2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements ConsoleProgram {

	private Scanner scan = new Scanner(System.in);

	private StudentManager studentManager;
	private SubjectManager subjectManager;

	public void run() {

		int menu = 0; // 예외처리 때문에 초기화를 해야 함.
		final int EXIT = 13;

		// 불러오기
		String studentFileName = "src/homework/v2/student.txt";
		String subjectFileName = "src/homework/v2/subject.txt";

		List<Student> students = (List<Student>) load(studentFileName);
		List<Subject> subjects = (List<Subject>) load(subjectFileName);

		studentManager = new StudentManager(students);
		subjectManager = new SubjectManager(subjects);

		do {
			// 메뉴 출력
			printMenu();
			try {
				// 메뉴 선택
				menu = scan.nextInt();
				removeBuffer();
				// 메뉴 실행
				runMenu(menu);
			}
			// 잘못된 타입의 메뉴를 입력한 경우(int가 아닐 때)
			catch (InputMismatchException e) {
				System.out.println("올바른 입력이 아닙니다!");
				removeBuffer();// 잘못 입력한 값을 입력 버퍼에서 지우기 위함
			}
		} while (menu != EXIT);
		// 저장하기
		save(studentFileName, studentManager.getList());
		save(subjectFileName, subjectManager.getList());
	}

	// 메뉴출력
	@Override
	public void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 과목 등록");
		System.out.println("5. 과목 수정");
		System.out.println("6. 과목 삭제");
		System.out.println("7. 성적 등록");
		System.out.println("8. 성적 수정");
		System.out.println("9. 성적 삭제");
		System.out.println("10.학생 조회");
		System.out.println("11.과목 조회");
		System.out.println("12.성적 조회");
		System.out.println("13.종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 선택 : ");
	}

	// 버퍼 내용 지우기
	private void removeBuffer() {
		scan.nextLine();
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
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
			insertSubject();
			break;
		case 5:
			updateSubject();
			break;
		case 6:
			deleteSubject();
			break;
		case 7:
			insertScore();
			break;
		case 8:
			updateScore();
			break;
		case 9:
			deleteScore();
			break;
		case 10:
			searchStudent();
			break;
		case 11:
			searchSubject();
			break;
		case 12:
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

	// 1.학생 추가
	private void insertStudent() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputStudent();
		if (!studentManager.insertStudent(std)) { // 매니저가 할 거임
			System.out.println("이미 등록되어있음");
			return;
		}
		System.out.println("학생 추가 완료");

	}

	// 2.학생 수정
	private void updateStudent() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		Student selStd = studentManager.getStudent(std);

		if (selStd == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("수정 할 정보를 입력하세요");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student newStd = inputStudent();

		if (studentManager.updateStudent(selStd, newStd)) {
			System.out.println("수정 완료");
			return;
		}
		System.out.println("수정 실패 : 이미 등록된 학생");

	}

	// 3.학생 삭제
	private void deleteStudent() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		if (studentManager.deleteStudent(std)) {
			System.out.println("삭제 완료");
			return;
		}
		System.out.println("삭제 실패");

	}

	// 4.과목 추가
	private void insertSubject() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		if (!subjectManager.insertSubject(subject)) {
			System.out.println("이미 등록되어있음");
			return;
		}
		System.out.println("과목 추가 완료");
	}

	// 5.과목 수정
	private void updateSubject() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();
		if (!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("수정할 과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject newSubject = insertSubInfo();
		if (subjectManager.updateSubject(subject, newSubject)) {
			System.out.println("과목 수정완료.");
			return;
		}
		System.out.println("이미 등록된 과목");
	}

	// 6.과목 삭제
	private void deleteSubject() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("조회할 과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		if (subjectManager.deleteSubject(subject)) {
			System.out.println("삭제됨");
		}

		// 과목 매니저에게 과목 객체를 주면서 삭제하라고 요청 후 결과에 따라 알림

	}

	// 7.성적 추가
	private void insertScore() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		
		if (studentManager.getStudent(std)==null) {
			System.out.println("등록된 학생이 아님");
			return;
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		
		if (subjectManager.contains(subject)) {
			System.out.println("등록된 과목이 아님");
			return;
		}

		System.out.print("성적 : ");
		int score = scan.nextInt();
		SubjectScore subjectScore = new SubjectScore(subject, score);
		
		if (studentManager.insertScore(std, subjectScore)) {
			System.out.println("성적 추가됨");
			return;
		}		
		System.out.println("성적 추가 안됨");


	}

	// 8.성적 수정
	private void updateScore() {

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		
		if (studentManager.getStudent(std)==null) {
			System.out.println("등록된 학생이 아님");
			return;
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		
		if (subjectManager.contains(subject)) {
			System.out.println("등록된 과목이 아님");
			return;
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("새 과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject newSubject = insertSubInfo();

		
		if (subjectManager.contains(newSubject)) {
			System.out.println("등록된 과목이 아님");
			return;
		}

		// 성적 입력
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("성적 : ");
		int score = scan.nextInt();

		// 새 과목 정보와 성적을 이용하여 성적개체를 생성
		SubjectScore newSubjectScore = new SubjectScore(newSubject, score);
		// 학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		if (studentManager.updateScore(std, subject, newSubjectScore)) {
			System.out.println("성적 수정됨");
			return;
		}
		// 실패하면 알림
		System.out.println("성적 수정 실패 : 이미 등록된 성적");

	}

	// 9.성적 삭제
	private void deleteScore() {
		// 학년, 반, 번호를 입력하고 입력한 정보로 객체를 생성(Student)
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		// 리스트에 있는지 확인해서 없으면 알림 후 종료
		if (studentManager.getStudent(std)==null) {
			System.out.println("등록된 학생이 아님");
			return;
		}

		// 학년, 학기, 과목을 입력하고 입력한 정보로 객체를 생성(Subject)
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		// 과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if (subjectManager.contains(subject)) {
			System.out.println("등록된 과목이 아님");
			return;
		}
		
		// 학생에게 과목 정보를 주면서 성적을 삭제하라고 요청 후 성공 여부까지 알림
		SubjectScore subjectScore = new SubjectScore(subject);
		
		if (studentManager.deleteScore(std, subject, subjectScore)) {
			System.out.println("성적 삭제됨");
		} else {// 실패하면 알림
			System.out.println("성적 삭제 안됨");
		}

	}

	// 10.학생 조회
	private void searchStudent() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("학생 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Student std = inputBaseStudent();

		// 리스트에 있는지 확인해서 없으면 알림 후 종료
		if (studentManager.getStudent(std)==null) {
			System.out.println("등록된 학생이 아님");
			return;
		}

		// 학년, 학기, 과목을 입력하고 입력한 정보로 객체를 생성(Subject)
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("과목 정보 입력");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Subject subject = insertSubInfo();

		// 과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if (subjectManager.contains(subject)) {
			System.out.println("등록된 과목이 아님");
			return;
		}

		// 학생 매니저에게 학생 정보를 주면서 출력하라고 요청
		

	}

	// 11.과목 조회
	private static void searchSubject() {
		// 과목 매니저에게 등록된 과목을 출력하라고 요청

	}

	// 12.성적 조회
	private static void searchScore() {
		// 학년, 학기, 과목명 입력

		// 입력한 정보로 객체 생성

		// 학생매니저에게 학생이 있는지 확인 후 없으면 알림

		// 학년, 학기, 과목명을 입력

		// 과목정보로 객체를 생성

		// 학생 매니저에게 학생 정보와 과목 정보를 주면서 성적을 출력하라고 요청

	}

	// 정보입력
	/** 학년 반 번호를 입력하면 객체를 반환하는 메소드 */
	private Student inputBaseStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();

		return new Student(grade, classNum, num);
	}

	/** 학년 반 번호 이름을 입력하면 객체를 반환하는 메소드 */
	private Student inputStudent() {
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
		Student tmp = inputBaseStudent();

		removeBuffer();

		System.out.print("이름 : ");
		String name = scan.nextLine();

		tmp.setName(name);
		return tmp;
//			return new Student(grade, classNum, num, name);
	}

	private Subject insertSubInfo() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		removeBuffer();
		System.out.print("과목 : ");
		String subject = scan.nextLine();

		return new Subject(grade, semester, subject);

	}

}
