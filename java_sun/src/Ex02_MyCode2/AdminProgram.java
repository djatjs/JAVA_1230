package Ex02_MyCode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ex02_NotMyCode.Word;


public class AdminProgram implements ConsoleProgram{
	private Scanner scan = new Scanner(System.in);
	private List<Word> words = new ArrayList<Word>();

	@Override
	public void run() {
		int EXIT = 4;
		int menu =0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
		}while(menu != EXIT);
		
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
		Word word = inputWord();
		
		//Word객체들을 담는 리스트에 넣으면 됨. 근데 내용이 없거나 word가 null상태면 안됨
		if(word == null || word.getWord() == null || word.getPartsOfSpeech() == null || word.getMeaning() == null) {
			System.out.println("넣을 수 없음");
			return;
		}
		
		
	}

	private Word inputWord() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("품사 [명, 대, 동, 형, 부, 전, 접, 관] : ");
		String partOfSpeech = scan.next();
		scan.nextLine();
		
		System.out.print("뜻 : ");
		String meaning = scan.nextLine();
		return new Word(word, partOfSpeech, meaning);
	}

	private void updateWord() {
		// TODO Auto-generated method stub
		
	}

	private void deleteWord() {
		// TODO Auto-generated method stub
		
	}

	

}
