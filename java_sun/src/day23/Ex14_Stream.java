package day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex14_Stream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ㅁ","길동","머길동ㅁ","ㅁㅁㅁㅁ","야뭘봐");
		
		//문자열에 길동이 포함된 문자열 출력
		for(String tmp : list) {
			if(tmp.contains("길동")) {
				System.out.println(tmp);
			}
		}
		//스트림 활용
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		Stream<String> stream = list.stream();
		stream.filter(p->p.contains("길동")).forEach(p->System.out.println(p));
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");		
		stream= list.stream();
		stream.filter(p->p.contains("ㅁ")).forEach(p->System.out.println(p));
		//스트림 활용 : 3글자 문자열을 출력하는 코드 작성
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");	
		stream=list.stream();
		stream.filter(p->p.length()==3).forEach(p->System.out.println(p));
	}

}
