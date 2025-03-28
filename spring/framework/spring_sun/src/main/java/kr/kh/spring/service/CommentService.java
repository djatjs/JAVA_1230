package kr.kh.spring.service;

import java.util.List;

import kr.kh.spring.Pagination.Criteria;
import kr.kh.spring.Pagination.PageMaker;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> getCommentList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

}
