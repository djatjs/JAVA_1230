package day04;

public class Ex08_Class2 {

	public static void main(String[] args) {
		// (10,10)위치에 점을 생성
		Point1 p1= new Point1(1,2);
		
	}

	// 화면에 점을 나타내기 위한 클래스 작성하기
	
}
class Point1 {
	// 필드
	private int x ; // x좌표
	private int y ; // y좌표

	// 메소드
	// 좌표출력
	
	// 좌표 이동
	public void moveXY(int x1, int y1) {
		x= x1;
		y= y1;
		return;
	}
	
	// 생성자
	public Point1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	
}