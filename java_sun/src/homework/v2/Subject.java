package homework.v2;

import java.util.Objects;

public class Subject {

	public int grade;
	public int semester;
	public String name;

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && name == other.name && semester == other.semester;
	}

	public Subject(int grade, int semester, String name){
		this.grade = grade;
		this.semester = semester;
		this.name = name;
	}
	
	
}