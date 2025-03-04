package day09;

import java.util.regex.Pattern;

public class Ex04_Regex2 {

	public static void main(String[] args) {
		/* 아이디가 주어진 조건에 맞는지 확인하는 코드
		 * 아이디는 숫자, 또는 영문 또는 특수만주(!@#$)로 이루어짐
		 * 아이디는 최소 8자에서 최대 13자
		 */
		String id = "!abc1234@";
		//String regex = "^[0-9a-zA-Z!@#$]{8,13}$";
		String regex = "^(\\w|[!@#$]){8,13}$";
		
		if(Pattern.matches(regex, id)) {
			System.out.println(id+"는 사용 가능한 아이디");
		}
		else {
			System.out.println(id+"는 사용 불가능한 아이디");
		}
		
	}

}
