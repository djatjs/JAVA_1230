package Ex02_NotMyCode;

import java.util.List;
import java.util.Map;
import java.util.Scanner;



import homework.v2.ConsoleProgram;

public class UserProgram implements ConsoleProgram{
	private Scanner scan = new Scanner(System.in);
	private WordManager wm;
	private MyWordManager mm;
	private String id;
	
	public UserProgram(List<Word> words, Map<String, List<String>> myWords, String id) {
		this.wm = new WordManager(words);
		this.mm = new MyWordManager(myWords);
		this.id = id;
	}

	@Override
	public void run() {
		int menu=0;
		do {
			printMenu();
			menu=scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu !=3);
		
	}

	@Override
	public void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 단어 검색\n"
				+ "2. 단어 검색 내역 확인\n"
				+ "3. 로그아웃");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("메뉴 입력 : ");
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			search();
			break;
		case 2:
			printMyWrods();
			break;
		case 3:
			System.out.println("로그아웃됨");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	private void search() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		wm.print(word);
		
		mm.add(id, word);
		
	}

	private void printMyWrods() {
		mm.print(id);
		
	}

}
