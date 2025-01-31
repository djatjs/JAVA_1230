package day20;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String id;
	private String password;
	private String type = "회원"; //회원 : 1, 관리자 : 0
	
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "("+type+")"+ id + "/" + password;
	}

	
	
	
}
