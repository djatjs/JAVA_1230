package day10;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex10_Dictionary {
	
	/* 다음 기능을 갖는 사전 프로그램 작성하기
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * 단어 : apple
	 * 의미 : 사과, 회사명
	 * 단어가 등록되었습니다.
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * 단어 : apple
	 * 의미 : apple
	 * 이미 등록된 단어입니다.
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 2
	 * 단어 : apple
	 * 의미 : 사과, 회사명(애플)
	 * 단어가 수정되었습니다.
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 4
	 * 단어 : a
	 * apple : 사과, 회사명(애플)
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 3
	 * 단어 : apple
	 * 삭제되었습니다.
	 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 4. 단어 검색
	 * 5. 종료
	 * 메뉴 선택 : 5
	 * 프로그램 종료
	 * */
	static ArrayList<Word> list = new ArrayList<Word>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu=0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu, list);
		}while(menu !=5);
	}
	
	
	private static void runMenu(int menu, ArrayList<Word> list) {
		switch(menu) {
		case 1:
			//1. 단어 등록
			insertWord();
			break;
		case 2:
			//2. 단어 수정
			updateWord();
			break;
		case 3:
			//3. 단어 삭제
			deleteWord();
			break;
		case 4:
			//4. 단어 검색
			searchWord();
			break;
		case 5:
			System.out.println("종료");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
			
		}
		
	}


	//1. 단어 입력
	private static void insertWord() {
		//입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		System.out.print("의미 : ");
		String meaning = scan.nextLine();
		
		
		Word wordObj = new Word(word, meaning);
		//단어가 등록되어 있으면 알림문구 후 종료
		if(list.contains(wordObj)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		}else {
			//단어 추가
			list.add(wordObj);
			System.out.println("단어를 등록했습니다.");
			System.out.println(list);
		}
		
		
		
		
	}
	//2. 단어 수정
	private static void updateWord() {
		// 단어와 새 뜻을 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		System.out.print("의미 : ");
		String mean = scan.nextLine();
		
		// 단어 없으면 알림문구 후 종료
		// 단어가 몇번인지 확인 후 -1번지이면 알림문구 후 종료
		Word wordObj = new Word(word, mean);
		int index = list.indexOf(wordObj);
		if(index<0) {
			System.out.println("일치하는 단어 없음");
			return;
		}
		
		//수정
		//번지에 있는 단어를 가져와서 단어를 수정
		list.set(index, wordObj);
		System.out.println("수정 되었습니다.");
		
	}
	//3. 단어 삭제
	private static void deleteWord() {
		// 단어 하나라도 있는지 없는지 확인
		System.out.print("단어 : ");
		String word = scan.nextLine();
		// 해당 단어 있는지 없는지 확인
		
		if(list.remove(new Word(word, ""))) {
			//단어가 있다면 삭제 후 알림 문구 출력
			System.out.println("삭제 되었습니다.");
		}else { //없으면 알림문구 출력
			System.out.println("없는 단어입니다.");
		}
		
		
		
	}
	//4. 단어 검색
	private static void searchWord() {
		// 단어 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		// 해당 단어 있으면 검색 단어를 포함하고 있으면 출력
		int count=0;
		for(Word tmp : list) {
			if(tmp.getWord().contains(word)) {
				//단어 위치 찾고 해당 위치 내용 출력
				System.out.println(tmp);
				count++;
			}
		}
		if(count==0) {
			System.out.println("해당 단어 없음");
		}		
	}

	private static void printMenu() {
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 단어 검색");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");		
	}

}
@Data
@AllArgsConstructor
class Word{
	private String word, meaning;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}
	
	@Override
	public String toString() {
		return word + " : "+ meaning;
	}
	
}