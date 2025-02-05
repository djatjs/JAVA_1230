package day23;

public class Ex17_Thread {

	public static void main(String[] args) {
		//쓰레드 써서 +를 100번 출력하는 쓰레드 생성해서 실행하고
		// -를 100 번 출력하는 쓰레드 생성해서 실행
		Thread plus = new Plus();
		Thread minus = new Minus();
		plus.start();
		minus.start();
		Thread t =  new Thread(()->{
			for(int i=0; i<100;i++) {
				System.out.print("=");
			}
		});
		t.start();
	}


}
class Plus extends Thread{
	@Override
	public void run(){
		for(int i=0; i<100;i++) {
			System.out.print("+");			
		}
	}
}
class Minus extends Thread{
	@Override
	public void run(){
		for(int i=0; i<100;i++) {
			System.out.print("-");			
		}
	}
}
