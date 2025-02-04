package Ex02_MyCode2;

import java.util.Scanner;

import homework.v2.ConsoleProgram;

public class WordProgram implements ConsoleProgram{
	
	private Scanner scan = new Scanner(System.in);
	private String id;
	@Override
	public void run() {
		
		System.out.print("아이디 입력 : ");
		id = scan.next();
		
		if("admin".equals(id)) {
			AdminProgram adminProgram = new AdminProgram();
			adminProgram.run();
		}
		else {
			UserProgram userProgram = new UserProgram();
			userProgram.run();
			
		}
		
	}
	
}
