package Ex02_MyCode2;

public interface ConsoleProgram {
	void run();
	
	default void printMenu() {};
	default void runMenu(int menu) {};
}
