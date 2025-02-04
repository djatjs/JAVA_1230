package Ex02_NotMyCode;

import java.util.List;
import java.util.Scanner;

import homework.v2.ConsoleProgram;

public class AdminProgram implements ConsoleProgram{
	private Scanner scan = new Scanner(System.in);
	
	private WordManager wm;
	public AdminProgram(List<Word> words) {
		wm = new WordManager(words);
	}
	
	@Override
	public void run() {
		int menu=0;
		do {
			printMenu();
			menu=scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			wm.sort();
			wm.print();
		}while(menu !=4);
	}

	@Override
	public void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 단어 등록\n"
				+ "2. 단어 수정\n"
				+ "3. 단어 삭제\n"
				+ "4. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	private void insertWord() {
		System.out.println("추가할 단어 정보 입력");
		
		Word wordObj = input();
		
		if(wm.insert(wordObj)) {
			System.out.println("저장함");
		}else {
			System.out.println("저장못함");
		}
		
	}

	private void updateWord() {
		//수정할 단어 선택
		System.out.println("수정할 단어 입력");
		System.out.print("단어");
		String word = scan.nextLine();
		
		//수정할 단어 검색해서 출력
		//word와 일치하는 단어들의 리스트를 반환 및 출력
		List<Word> tmpList = wm.getWordList(word);
		wm.print(tmpList);
		if(tmpList.isEmpty()) {
			return;
		}
		
		//수정할 단어 선택
		System.out.print("수정할 단어 번호 : ");
		int index = scan.nextInt()-1;
		scan.nextLine();
		if(index<0 || index>=tmpList.size()) {
			System.out.println("유효하지 않은 번호");
			return;
		}
		//수정할 단어 품사 뜻 입력
		Word wordObj = input();
		
		//수정
		if(wm.update(tmpList.get(index), wordObj)) {
			System.out.println("수정함");
		}else {
			System.out.println("수정안함");
		}
		
	}

	private void deleteWord() {
		//삭제할 단어 선택
		System.out.println("삭제할 단어 입력");
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		//삭제할 단어 검색해서 출력
		//word와 일치하는 단어들의 리스트를 반환 및 출력
		List<Word> tmpList = wm.getWordList(word);
		wm.print(tmpList);
		
		//삭제할 단어 선택
		System.out.print("삭제할 단어 번호 : ");
		int index = scan.nextInt()-1;
		if(index<0 || index>=tmpList.size()) {
			System.out.println("유효하지 않은 번호");
			return;
		}
		//삭제
		if(wm.delete(tmpList.get(index))) {
			System.out.println("삭제함");
		}else {
			System.out.println("삭제안함");
		}
	}
	
	private Word input() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("품사 [명, 대, 동, 형, 부, 전, 접, 관] : ");
		String partOfSpeech = scan.next();
		scan.nextLine();
		
		System.out.print("뜻 : ");
		String meaning = scan.nextLine();
		return new Word(word, partOfSpeech, meaning);
	}


}
