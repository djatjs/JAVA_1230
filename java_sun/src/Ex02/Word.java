package Ex02;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
	private String name;
	private String type;
	private String content;
	
	@Override
	public String toString() {
		return name + "(" + type + ") : " + content;
	}
	
	
}
