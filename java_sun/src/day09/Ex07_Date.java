package day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Date {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		System.out.println(date); //Fri Jan 10 11:26:45 KST 2025
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = format.format(date);
		
		System.out.println(str); //2025-01-10 11:29:18
		
		str="2024-01-01 14:30:00";
		date = format.parse(str);
		System.out.println(date);//Mon Jan 01 14:30:00 KST 2024

	}

}
