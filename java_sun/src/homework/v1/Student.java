package homework.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

//getter, setter, toString, equals등을 제공
@Data
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 2267297665460352943L;
	private int grade, classNum, num;
	private String name="";
	
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list;
	
	
	//equals를 오버라이딩, 학년, 반, 번호를 이용
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && Objects.equals(num, other.num);
	}
	

	
	
	
	//학생 추가용 생성자
	public Student (int grade, int classNum, int num, String name) {
		this.grade =grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		list = new ArrayList<SubjectScore>();
	}
	//학생 수정용 생성자
		public Student (int grade, int classNum, int num) {
			this.grade =grade;
			this.classNum = classNum;
			this.num = num;
			list = new ArrayList<SubjectScore>();
		}
		
	
	public void print() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		if(list.size()==0) {
			System.out.println("등록된 성적이 없습니다.");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			return;
		}for(SubjectScore score : list) {
			System.out.println(score);
		}
	}

	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name + "의 성적 : "
				+ list;
	}

	public boolean addScore(SubjectScore subjectScore) {
		if(!list.contains(subjectScore)) {
			list.add(subjectScore);
			return true;
		}
		return false;
		
	}

	public boolean updateScore(SubjectScore newSubjectScore) {
		if(list.contains(newSubjectScore)) {
			list.remove(newSubjectScore);
			list.add(newSubjectScore);
			return true;
		}
		return false;
	}

	public boolean deleteScore(SubjectScore newSubjectScore) {
		if(list.contains(newSubjectScore)) {
			list.remove(newSubjectScore);
			return true;
		}
		return false;
	}

	public void printScore(Subject tmpSubject) {
		int index = list.indexOf(new SubjectScore(tmpSubject));
		if(index <0) {
			System.out.println("오류뜸");
			return;
		}
		System.out.println(list.get(index));	
	}
	
}