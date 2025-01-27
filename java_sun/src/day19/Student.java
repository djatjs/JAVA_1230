package day19;

import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Student {
	private String std;
	private String date;
	private boolean attention = false;
	
	public Student(String std) {
		this.std = std;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(std, other.std);
	}

	@Override
	public int hashCode() {
		return Objects.hash(std);
	}


}
