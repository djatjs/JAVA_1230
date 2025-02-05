package day23;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex15_Chaining {

	public static void main(String[] args) {
		Point4 p = new Point4(10, 0);
		//print1은 리턴이 void이기 때문에 체이닝 못 씀
		p.print1();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		//print2는 리턴이 Point4 객체라서 Point4에서 제공하는 메소드를 이어서 체이닝 가능
		p.print2().print1();;
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		//print2는 리턴이 Point4 객체라서 Point4에서 제공하는 메소드를 이어서 체이닝 가능하고
		//toString은 리턴이 String이니까 String에서 제공하는 subString을 체이닝으로 사용 가능
		String str = p.print2().toString().substring(3);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		/* System 클래스의 클래스로 PrintStream 클래스 객체 out이 있고, PrintStream에서 제공하는 println을 사용 가능*/
		System.out.println(str);

	}

}
@Data
@AllArgsConstructor
class Point4{
	private int x,y;
	public void print1() {
		System.out.println(x+", "+y);
	}
	public Point4 print2() {
		System.out.println(x+", "+y);
		return this;
	}
}