package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

@Service
public class PostSeriveImp  implements PostSerive{

	@Autowired
	PostDAO postDAO; //DAO는 어노테이션 안달아도 되는 이유 -> root-context에서 인식하도록 설정함
	
	@Autowired
	MessageService messageService;
	
	@Override
	public List<PostVO> getPostList() {
		return postDAO.selectPostList();
	}

	@Override
	public List<BoardVO> getBoardList() {
		return postDAO.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		if(bo_name==null || bo_name.trim().length()==0) {
			return false;
		}
		try {
			//bo_name이 중복된 경우 예외 발생 => 추가 실패 => return false;
			//bo_name이 unique로 설정되어있어서 그럼
			return postDAO.insertBoard(bo_name);
		}catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDAO.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board==null || board.getBo_name()==null || board.getBo_name().trim().length()==0) {
			return false;
		}
		return postDAO.updateBoard(board);
	}



}
	
