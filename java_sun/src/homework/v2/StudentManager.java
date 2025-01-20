package homework.v2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentManager {
	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		if(list==null) {
			this.list = new ArrayList<Student>();
		}
		else {
			this.list = list;
		}
	}
	
	public StudentManager() {
		list=new ArrayList<Student>();
	}
	
	//학생 추가
	public boolean insertStudent(Student std) {
		if(std == null || list==null) {
			return false;
		}
		if(list.contains(std)) {
			return false;
		}
		return list.add(std);
	}
	
	
	public Student getStudent(Student std) {
		int index = list.indexOf(std);
		return index<0? null : list.get(index);
	}

	//학생 수정
	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd == null || newStd==null|| list==null) {
			return false;
		}
		if(!list.contains(selStd)) {
			return false;
		}
		Student tmp = getStudent(newStd);
		//수정될 정보가 없거나 이전 학생 정보이면 수정
		if(tmp==null || tmp== getStudent(selStd)) {
			getStudent(selStd).update(newStd);
			return true;
		}
		return false;
	}
	
	
	//학생 삭제
	public boolean deleteStudent(Student std) {
		if(std == null || list==null) {
			return false;
		}
		return list.remove(std);
	}
	//학생 조회
	public void printStudent(Student std) {
		if(std == null) {
			System.out.println("학생 정보가 없음");
			return;
		}if(list == null) {
			System.out.println("학생 리스트가 없음");
			return;
		}
		Student tmp = getStudent(std);
		if(tmp ==null) {
			System.out.println("일치하는 학생이 없음");
			return;
		}
		tmp.print();
		
	}
	//성적 추가
	public boolean insertScore(Student std, SubjectScore subjectScore) {
		if(std == null || list ==null || subjectScore==null) {
			return false;
		}
		std = getStudent(std);
		if(std==null) {
			return false;
		}
//		return std.insertScore(subjectScore);
		return true;//꺼지쇼
	}
	//성적 수정
	public boolean updateScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(std == null || list ==null ||subject==null|| subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return std.updateScore(subject, subjectScore);
	}
	//성적 삭제
	public boolean deleteScore(Student std, Subject subject, SubjectScore subjectScore) {
		if(std == null || list ==null ||subject==null|| subjectScore == null) {
			return false;
		}
		std = getStudent(std);
		if(std == null) {
			return false;
		}
		return true;//껴지쇼
	}





}
