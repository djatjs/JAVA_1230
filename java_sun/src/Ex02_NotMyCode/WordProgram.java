package Ex02_NotMyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class WordProgram implements ConsoleProgram{
	
	private Scanner scan = new Scanner(System.in);
	private String id;
	private List<Word> words;
	private Map<String, List<String>> myWords;
	
	@Override
	public void run() {
		
		String wordsFileName = "src/Ex02_NotMyCode/words.txt";
		String myWordsFileName = "src/Ex02_NotMyCode/myWords.txt";
		
		//불러옴
		words = (List<Word>) load(wordsFileName);
		myWords = (Map<String, List<String>>)load(myWordsFileName);
		
		//불러오기 실패 관리
		if(words == null) {
			words = new ArrayList<Word>();
			words.add(new Word("apple","명사","사과"));
			words.add(new Word("banana","명사","바나나"));
		}
		if(myWords == null) {
			myWords = new HashMap<String, List<String>>();
			List<String> list = new ArrayList<String>();
			list.add("test");
			myWords.put("abc", list);
		}

		
		//아이디 입력
		System.out.print("아이디 : ");
		String id = scan.next();
		
		if("admin".equals(id)) {
			AdminProgram adminProgram = new AdminProgram(words);
			adminProgram.run();
		}
		else {
			UserProgram userProgram = new UserProgram(words, myWords, id);
			userProgram.run();
		}
		
		//저장함
		save(wordsFileName, words);
		save(myWordsFileName, myWords);
		
	}

}
