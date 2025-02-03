package day21;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat implements Serializable{

	private static final long serialVersionUID = 1L;
	String id;
	String chat;
	Date date;
	
	public Chat(String id, String chat) {
		this.id = id;
		this.chat = chat;
		date = new Date();
	}
	
	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(date);
	}

	@Override
	public String toString() {
		return id +" : "+ chat + "("+ getDateStr()+")";
	}
	
	
	
	
}
