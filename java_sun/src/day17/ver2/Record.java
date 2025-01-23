package day17.ver2;

import lombok.Data;

@Data
public class Record {
	private int count;
	private String nickName;
	
	public Record(int count, String nickName) {
		this.count = count;
		//닉네임은 최대 3자. 3자 미만이면 남은자리를 '?'으로 채움
		if(nickName ==null) {
			this.nickName = "";
		}
		//닉네임 3자 이상이면 3자만 추출
		else if(nickName.length()>3) {
			this.nickName = nickName.substring(0,3);
			return;
		}
		//닉네임 3자 미만이면 남은자리를 ?으로 채움
		int repeatCount = 3 -nickName.length();
		this.nickName = nickName + "?".repeat(repeatCount);
		
	}
}
