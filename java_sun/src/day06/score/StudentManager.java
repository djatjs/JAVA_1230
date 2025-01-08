package day06.score;



public class StudentManager {
	//학생 정보를 관리하는 클래스로 학생 정보를 추가, 조회하는 기능을 가짐
	
	
	private Student []std = new Student[5];
	private int count = 0;
	
	//학생 정보 저장 공간
	private void expend() {
		if(std == null) {
			std = new Student[5];
		}
		if(count < std.length) {
			return;
		}
		//확장
		Student tmp[] = new Student[std.length + 5];
		//복사  
		System.arraycopy(std, 0, tmp, 0, std.length);
		//새 것으로 바꿔치기
		std= tmp;
	}
	
	// 학생 정보 추가
	public void insertStudent(String name, int score) {
		std[count++] = new Student(name, score);
		expend();
	}
	
	//학생 정보 조회
	public void listStudent() {
		// 한 명도 등록 X
		if(count==0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		int sum=0;
		// 정보 출력
		for (int i = 0; i < count; i++) {
			std[i].print();
		}
		// 평균 점수 출력
		for (int i = 0; i < count; i++) {
			sum += std[i].getScore();	
		}
		System.out.println("평균 점수 : "+sum/(double)count);
	}
	
	
	
}
