package Ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class User {
	private String id;
	private List<String> searchHistory = new ArrayList<String>();

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(id, other.id);
//	}

	public User(String id) {
		this.id = id;
	}

	public void addSeachWord(String name) {
		if(searchHistory.contains(name)) {
			//최신 검색 기록을 맨 뒤로 빼며 중복된 항목 삭제.
			//searchHistory.remove(name);
		}
		searchHistory.add(name);
	}

	@Override
	public String toString() {
		return id + ", 검색내역" + searchHistory;
	}
	
	
	
	
	
}
