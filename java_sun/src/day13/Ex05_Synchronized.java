package day13;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex05_Synchronized {

	public static void main(String[] args) {
		BankBook bankBook = new BankBook("sun", 0);
		Customer1 c1 = new Customer1("sun", bankBook);
		Customer2 c2 = new Customer2("sun's friend", bankBook);
		
		c1.start();
		c2.start();
	}

}
@AllArgsConstructor
class Customer1 extends Thread{
	private String name;
	private BankBook bankBook;
	
	@Override
	public void run() {
		System.out.println(name+"님이 "+10000+"원을 ATM으로 입금중입니다.");
		bankBook.deposit(name, 10000);
	}
}

@AllArgsConstructor
class Customer2 extends Thread{
	private String name;
	private BankBook bankBook;
	
	@Override
	public void run() {
		System.out.println(name+"님이 "+10000+"원을 모바일로 입금중입니다.");
		bankBook.deposit(name, 10000);
	}
}


@Data
@AllArgsConstructor
class BankBook{
	private String name;
	private int balance;
	
	//동기화
	public synchronized void deposit(String name, int money) {
		System.out.println(name+"님의 입금 전 잔액 : "+balance);
		balance += money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name+" : "+money+"원 입금. 잔액 : "+balance);
	}
}