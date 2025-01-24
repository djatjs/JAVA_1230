package day18;

import java.util.Date;

import lombok.Data;

@Data
public class Item {
	private Date date;//입출금 날짜
	private Type content;//입금 or 출금
	private int money;//금액
}
