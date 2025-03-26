package kr.kh.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class PostSeriveImp  implements PostSerive{

	@Autowired
	PostDAO postDAO; //DAO는 어노테이션 안달아도 되는 이유 -> root-context에서 인식하도록 설정함
	
	@Resource
	private String uploadPath;
	
	@Autowired
	MessageService messageService;
	
	@Override
	public List<PostVO> getPostList(int po_bo_num) {
		return postDAO.selectPostList(po_bo_num);
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

	@Override
	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		if(post==null || 
				post.getPo_title().trim().length()==0 ||
				post.getPo_content().trim().length()==0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDAO.insertPost(post);
		
		if(!res) {
			return false;
		}
		//첨부파일 없으면 더이상의 작업이 필요하지 않음
		if(fileList == null || fileList.length ==0) {
			return true;
		}
		
		for(MultipartFile file : fileList) {
			String fi_ori_name = file.getOriginalFilename();
			//파일명이 없으면
			if(fi_ori_name == null || fi_ori_name.length() ==0) {
				continue;
			}
			try {
				String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, file.getBytes());
				FileVO filevo = new FileVO(fi_ori_name, fi_name, post.getPo_num());
				postDAO.insertFile(filevo);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public PostVO getPost(int po_num) {
		return postDAO.selectPost(po_num);
	}

	@Override
	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		// 게시글 정보를 가져옴
		PostVO post = postDAO.selectPost(po_num);
		// 게시글의 작성자와 회원이 같은지 확인
		if(post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 삭제
		boolean res = postDAO.deletePost(po_num);
		
		
		return res;
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		if(post==null || 
				post.getPo_title().trim().length()==0 ||
				post.getPo_content().trim().length()==0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//작성자인지 확인
		//게시글 정보 가져옴
		PostVO dbPost = postDAO.selectPost(post.getPo_num());
		//게시글의 작성자와 회원이 다르면 false 리턴
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		boolean res = postDAO.updatePost(post);
		return res;
	}

	@Override
	public void updateView(int po_num) {
		postDAO.updateView(po_num);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		return postDAO.selectFileList(po_num);
	}



}
	
