package day01;

public class Ex04_Overflow {

	public static void main(String[] args) {
		byte num1 = 127;
		num1++; // 1증가
		System.out.println(num1);
		// -128이 나옴 (오버플로우)
		// 가장 큰 숫자에 1을 더했을 때 한 바퀴 돌아서 가장 작은 숫자로 가는거라고 함. 
		
		byte num2 = -128;
		num2--;
		System.out.println(num2);
		// 127 나옴 (언더플로우)
		// 가장 작은 숫자에 1을 뺐을 때 한 바퀴 돌아서 가장 큰 숫자로 가는거라고 함.
	}

}
