package kr.kh.spring2.controller;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.PageMaker;
import kr.kh.spring2.pagination.PostCriteria;
import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		//게시판 목록을 서비스에게 요청하여 가져온 후 화면에 전송
		List<BoardVO> boardList = postService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "/post/list";
	}
	
	@PostMapping("/list")
	public String listPost(@RequestBody PostCriteria cri, Model model) {
		cri.setPerPageNum(2);
		//num을 서비스에게 주면서 게시판 번호에 맞는 게시글 목록 중 2개를 가져오기
		List<PostVO> postList = postService.getPostList(cri);
		//서비스에게 현재 페이지 정보를 주고 PageMaker 객체를 달라고 요청
		PageMaker pm = postService.getPageMaker(cri);
		
		//가져온 게시글을 화면에 전송
		model.addAttribute("postList", postList);
		model.addAttribute("pm", pm);
		return "post/sub";
	}

}
