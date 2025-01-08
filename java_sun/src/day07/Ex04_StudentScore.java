package day07;

import java.util.Scanner;

public class Ex04_StudentScore {
	public static void main(String[] args) {
		/* 학생의 성적을 관리하는 프로그램을 만들기 위해 필요한 Student 클래스 작성
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 이름 : sun
		 * 과목 : 국어
		 * 성적 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 1학년 1반 1번 sun 국어 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 수정할 학생 정보를 입력하세요
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 국어
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 95
		 * 성적이 수정되었습니다.
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료 
		 * 메뉴 선택 : 3
		 * 수정할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 영어
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 95
		 * 과목이 없거나 학생 정보가 없습니다.
		 * 프로그램을 종료합니다
		 * */
		//메뉴를 4를 입력하기 전까지 반복해서 출력하는 코드
		
		int menu, count=0;
		Scanner scan = new Scanner(System.in);
		//학생 성적을 관리하기 위한 10개짜리 배열을 선언하고 생성하세요
		Student [] list = new Student [10];
		//0번지에 1학년 1반 1번 sun 국어 100을 가지는 객체를 저장하세요.
		list[count] = new Student(1, 1, 1, "sun", "국어", 100);
		count++;
		
		do {
			//printMenu();
			System.out.print("메뉴\r\n"
					+ "1. 학생 성적 추가\r\n"
					+ "2. 학생 성적 조회\r\n"
					+ "3. 학생 성적 수정\r\n"
					+ "4. 프로그램 종료 \r\n"
					+ "메뉴 선택 :");
			//메뉴 입력
			menu= scan.nextInt();
	
			switch (menu) {
			case 1:
				//학생 성적 추가 : 스캐너를 이용하여 학년 반 번호 이름 과목 점수 입력 받기
				System.out.print("학년 : ");
				int grade= scan.nextInt();
				System.out.print("반 : ");
				int classNum= scan.nextInt();
				System.out.print("번호 : ");
				int stdNum= scan.nextInt();
				System.out.print("이름 : ");
				String name= scan.next();
				System.out.print("과목 : ");
				String subject= scan.next();
				System.out.print("점수 : ");
				int score= scan.nextInt();
				//입력받은 정보를 이용해서 객체를 생성하는 코드
				Student tmp = new Student(grade, classNum, stdNum, name , subject, score);
				list[count]= tmp;
				list[count].printStdInfo();
				count++;
				break;
			case 2:
				//학생 성적 조회
				// 0번지부터 count-1번지까지 1씩 증가하면서 list에 있는 학생 정보 출력
				for (int i=0; i<count; i++) {
					list[i].printStdInfo();
				}
				break;
			case 3:
				//학생 성적 수정
				System.out.println("수정할 학생의 정보를 입력하세요.");
				System.out.print("학년 : ");
				grade= scan.nextInt();
				System.out.print("반 : ");
				classNum= scan.nextInt();
				System.out.print("번호 : ");
				stdNum= scan.nextInt();
				System.out.print("과목 : ");
				subject= scan.next();
				
				System.out.println("수정할 점수를 입력하세요 : ");
				System.out.print("점수 : ");
				score= scan.nextInt();
				int index=-1;
				/* 0번지부터 count-1번지까지 list에서 하나씩 꺼내서
				 * list 정보와 위에서 입력받은 학년 반 번호 과목 정보가 같으면
				 * index에 해당 번지를 저장하고 break로 빠져 나옴
				 * */
				for(int i=0; i<count; i++) {
					if(list[i].equal(grade, classNum, stdNum, subject)) {
						index = i;
						break;
					}
				}
				if(index>=0) {
					// index 번지에 있는 학생의 성적을 입력받은 새 성적으로 수정
					list[index].setScore(score);
					System.out.println("학생 정보를 수정했습니다.");
				}else {
					System.out.println("과목이 없거나 학생 정보가 없습니다.");
				}
				
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("올바른 메뉴가 아님");
			}
			System.out.println();
		}while(menu !=4);
		
		
//		Student std = new Student(1, 1, 1, "sun", "국어", 100);
//		std.printStdInfo();
//		std.modifyStdScore();
//		std.printStdInfo();
	}

	public static void printMenu() {
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 조회");
		System.out.println("3. 학생 성적 수정");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}

class Student{
	int grade;
	int classNum;
	int stdNum;
	String name;
	String subject;
	int score;
	
	public void printStdInfo() {
		System.out.println(grade+"학년 "+classNum+"반 "+stdNum+"번 "+ name +" "+ subject+" : " + score);
	}
	
	public void modifyStdScore() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 학생 정보를 입력하세요.");
		
		//입력 받기
		System.out.print("학년 : ");
		int mGrade= scan.nextInt();
		System.out.print("반 : ");
		int mClassNum= scan.nextInt();
		System.out.print("번호 : ");
		int mStdNum= scan.nextInt();
		System.out.print("과목 : ");
		String mSubject= scan.next();
		
		// 일단 과목만 맞는지 확인
		if(subject.equals(mSubject)) {
			System.out.print("수정할 점수를 입력하세요 : ");
			int mScore= scan.nextInt();
			score = mScore;
			System.out.println("성적이 수정되었습니다");
		}
		else {
			System.out.println("과목이 없거나 학생 정보가 없습니다.");
		}
		
		
	}
	
	//다른방식 : 정보 일치하는지 확인하는 bool형 메소드
	public boolean equal(int grade, int classNum, int stdNum, String subject) {
		if(this.grade != grade) {
			return false;
		}
		if(this.classNum != classNum) {
			return false;
		}
		if(this.stdNum != stdNum) {
			return false;
		}
		if(!this.subject.equals(subject)) {
			return false;
		}
		return true;
	}
	// ""
	public void setScore(int score) {
		this.score=score;
	}
	
	
	public Student(int grade, int classNum, int stdNum, String name, String subject, int score) {
		this.grade = grade;
		this.classNum = classNum;
		this.stdNum = stdNum;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}
	
	
	
	
}