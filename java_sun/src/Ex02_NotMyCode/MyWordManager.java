package Ex02_NotMyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyWordManager {
	private Map<String, List<String>> myWords;

	public MyWordManager(Map<String, List<String>> myWords) {
		this.myWords = myWords;
	}
	public void add(String id, String word) {
		List<String> list = myWords.get(id);
		if(list == null) {
			list = new ArrayList<String>();
			list.add(word);
			myWords.put(id, list);
			return;
		}
		//기존에 검색했던 거라면 삭제후 다시 등록
		list.remove(word);
		list.add(word);
	}
	public void print(String id) {
		List<String> list = myWords.get(id);
		//없으면
		if(list == null) {
			System.out.println("[검색 기록이 없습니다.]");
			return;
		}
		list.stream().forEach(w->System.out.println(w));
	}

}
