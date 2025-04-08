package kr.kh.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //기본 생성자
public class PersonDTO {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
	public String total() {
		return name + " : " + age;
	}
	
	
}
