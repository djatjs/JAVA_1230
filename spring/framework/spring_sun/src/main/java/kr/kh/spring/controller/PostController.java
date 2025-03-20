package kr.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.service.PostSerive;

@Controller
public class PostController {
	
	@Autowired //@Service가 있어야 됨. -> 서비스 객체 만들어줌
	private PostSerive postSerive;
	
	@GetMapping("/post/list")
	public String postList(Model model) {
		//게시글 목록 전체를 가져옴
		List<PostVO> list = postSerive.getPostList();
		System.out.println(list);
		//화면에 게시글 목록 전송
		model.addAttribute("list", list);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		//등록된 게시판 리스트를 가져와서 화면에 전송
		List<BoardVO> list = postSerive.getBoardList();
		model.addAttribute("list", list);
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(PostVO post) {
		MemberVO user = new MemberVO();
		user.setMe_id("ADMIN");
		System.out.println(post);
		if(postSerive.insertPost(post, user)) {
			
		}else {
			
		}
		return "redirect:/post/list";
	}
}
