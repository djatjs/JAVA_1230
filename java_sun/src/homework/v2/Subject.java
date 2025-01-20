package homework.v2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable{

	private static final long serialVersionUID = -7622521791400060367L;
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
		return grade == other.grade && Objects.equals(name, other.name) && semester == other.semester;
	}
	
	@Override
	public String toString() {
		return grade + "학년 " + semester + "학기 " + name;
	}

}