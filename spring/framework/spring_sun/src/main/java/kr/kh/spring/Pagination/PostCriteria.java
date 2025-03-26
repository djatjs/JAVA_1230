package kr.kh.spring.Pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {
	private int po_bo_num;

	public PostCriteria(int page, int perPageNum, int po_bo_num) {
		super(page, perPageNum);
	}
	
}
