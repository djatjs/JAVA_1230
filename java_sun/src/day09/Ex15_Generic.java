package day09;

public class Ex15_Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<String> list1 = new Array<String>(10);
		list1.set(0, "abc");
		list1.set(1, "123");
		System.out.println(list1.get(0));
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		list1.print();
		
		Array<Integer> list2 = new Array<Integer>(10);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		list2.set(0, 11);
		list2.set(1, 200);
		list2.set(3, 400);
		list2.print();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		print(1);
		print("123");
	}
	
	// generic 타입의 메소드를 만들어 다양한 타입이 들어감을 알 수 있음.
	public static <T> void print(T t) {
		if(t == null) {
			return;
		}
		System.out.println(t);
	}

}
class Array<T>{
	private T[] list;
	
	public void setList(T [] list) {
		this.list = list;
	}
	public T [] getList() {
		return list;
	}
	
	public Array(int size) {
		list = (T[]) new Object[size];
	}
	//특정 번지에 있는 값 바꾸는데 성공하면 기존에 있던 데이터를 반환하고 실패하면 null 반환
	public T set(int index, T data) {
		list[index]=data;
		if(index<0 || index>=list.length) {
			return null;
		}
		T tmp = list[index];
		list[index] = data;
		return tmp;
	}
	
	public T get(int index) {
		if(index<0 || index>=list.length) {
			return null;
		}
		return list[index];
	}
	
	public void print() {
		for(T tmp : list) {
			if(tmp != null) {
				System.out.println(tmp);
			}
		}
	}
}
