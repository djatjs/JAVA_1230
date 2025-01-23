package day17;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game implements Serializable {

	private static final long serialVersionUID = 7237652302595304148L;
	private int score;
	private String name;
	private Date date;
	
	public Game(int score, String name) {
		this.score = score;
		this.name = name;
		date = new Date();
	}
	
	@Override
	public String toString() {
		return  name + " : " + score;
	}
	
	
	//자체 기능 : sort()
	
	
	
}
