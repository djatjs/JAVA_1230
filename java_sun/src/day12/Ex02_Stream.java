package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02_Stream {

	public static void main(String[] args) {
		List<Person2> list = new ArrayList<Person2>();
		
		list.add(new Person2("홍길동", 20, "남"));
		list.add(new Person2("하나", 20, "여"));
		list.add(new Person2("산티", 80, "남"));
		list.add(new Person2("로또", 75, "여"));
		
		//남자들의 정보만 출력
		Stream<Person2> stream = list.stream();
		
		//스트림 한 번 사용함
		stream
			.filter(p->p.getGender().equals("남"))//남자들만 남도록(필터는 predicate를 써서 판별하고 그걸 선택함.)
			.forEach((p)->{System.out.println(p);});//정보를 출력
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		//나이가 30미만인 여자들의 정보만 출력
		//스트림은 재사용이 안되므로 다시 만들어줘야함.
		stream = list.stream(); 
		stream
		.filter(p->p.getGender().equals("여")&&p.getAge()<30)
		.forEach(p->System.out.println(p));//정보를 출력
		
		
		//여자들의 수 #count
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		stream = list.stream(); 
		long count = stream
		.filter(p->p.getGender().equals("여"))
		.count();
		System.out.println("여자들의 수 : "+count);
		
		//사람들의 평균 나이를 계산 #average()
		/*
		 * map()은 Person2를 R로 리턴
		 * mapToIn()는 Person2를 Integer로 리턴
		 * average()는 평균을 구하는데, 스트림에 아무것도 없어서 평균을 구할 수 없는 경우가 발생할 수 있음.
		 * -> OptionalDouble로 리턴
		 * OptionalDouble에는 isPresnet() 메소드를 통해 평균이 있는지 없는지 확인 할 수 있음.
		 */
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		stream = list.stream(); 
		OptionalDouble avg = stream.mapToDouble(Person2::getAge).average();
		//OptionalDouble avg = stream.mapToDouble(p->p.getAge()).average();
		if(avg.isPresent()) {
			System.out.println("평균 나이 : "+avg.getAsDouble());
		}else {
			System.out.println("일치하는 사람이 없습니다.");
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		//orElse는 OptionalDouble에서 제공하는 메소드로 평균이 있다면 평균을, 없으면 매개변수 값을 double로 반환.
		stream = list.stream(); 
		double avg2 = stream.mapToInt(Person2::getAge).average().orElse(0);
		System.out.println("평균 나이 : "+avg2);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		/* 스트림을 객체로 반환
		 * */
		stream = list.stream(); 
		List<Person2> list2 = stream
				.filter(p->p.getAge()>30)
				.collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		//숫자와 함께 출력
		stream = list.stream();
		AtomicInteger index = new AtomicInteger(0); //람다식 안에 들어가면 원래 상수되는건데 클래스 안에서 Increment로 숫자 증가 가능. int num=0; n++;이러면 에러뜸.
		
		stream.forEach(p->{
			int curIndex = index.getAndIncrement();//현재 번지를 가져오고 1증가
			System.out.println(curIndex+1+". " +p);
		});
		
	}

}
@Data
@AllArgsConstructor
class Person2{
	private String name;
	private int age;
	private String gender;
	
}