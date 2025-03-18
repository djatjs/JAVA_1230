package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.PostVO;

@Service
public class PostSeriveImp  implements PostSerive{

	@Autowired
	private PostDAO postDAO; //DAO는 어노테이션 안달아도 되는 이유 -> root-context에서 인식하도록 설정함

	@Override
	public List<PostVO> getPostList() {
		return postDAO.selectPostList();
	}

}
	
