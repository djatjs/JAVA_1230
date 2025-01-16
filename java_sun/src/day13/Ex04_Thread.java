package day13;

public class Ex04_Thread {

	public static void main(String[] args) {
		// 서로 왔다갔다하면서 실행됨. 일시정지할 때 다른 스레드가 일 처리하고 그럼. 그 때는 실행 대기 상태로 감.
		
		MyTread th1 = new MyTread();
		th1.start();
		
		//Runable 인터페이스를 구현한 구현 클래스를 이용
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		
		//Runable 인터페이스를 구현한 익명 클래스를 이용(람다식)
		Thread th3 = new Thread(()->{
			for(int i =0; i<10000;i++) {
				System.out.print("*");
			}
		});
		th3.start();
		
		for(int i=0; i<10000; i++) {
			System.out.print("|");
		} 
	}

}
class MyTread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10000;i++) {
			System.out.print("-");
		}
	}
}
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10000;i++) {
			System.out.print("+");
		}
	}
}