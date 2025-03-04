package db.ex1.model.vo;

import lombok.Data;

@Data
public class ScoreVO {
	
	/* mybatis에서 자동으로 매핑을 할 때 다음과 같은 규칙을 따름
	 * 1. 정확히 일치하면 가능 					=> sc_score
	 * 2. prefix를 생략하면 가능 - 느슨한 매핑 	=> score
	 * 3. 유사한 필드명도 매핑 					=> score1
	 * - autoMappingBehavior 속성 값에 따라 매칭 강도를 조절 할 수 있음
	 *  	- FULL : 기본값. 1, 2, 3 다 가능
	 *  	- PARTIAL : 정확히 일치할 때만 매핑 	=> 1
	 *  	- NONE : 자동 매핑 비활성화 		=> resultMapping 써야함?
	 * */
	
	private SubjectVO subject;
	private int sc_num;
	private int sc_score;
	private int sc_st_key;
	private int sc_sj_num;
	
	
	@Override
	public String toString() {
		return subject + " : " + sc_score + "점";
	}
	
	
	
}