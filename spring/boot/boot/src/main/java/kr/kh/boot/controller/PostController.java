package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.MemberVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post/list/{bo_num}")
    public String postList(@PathVariable int bo_num, Model model) {
        System.out.println(bo_num);
        List<BoardVO> boardList = postService.getBoardList();
        List<PostVO> list= postService.getPostList(bo_num);
        model.addAttribute("list", list);
        model.addAttribute("url", "/post/list");
        model.addAttribute("boardList", boardList);
        return "post/list";
    }

    @GetMapping("/post/detail/{po_num}")
    public String postDetail(@PathVariable int po_num, Model model) {
        PostVO post = postService.getPost(po_num);
        List<FileVO> list = postService.getFileList(po_num);
        System.out.println(list);
        model.addAttribute("post", post);
        model.addAttribute("list", list);
        return "post/detail";
    }

    @GetMapping("/post/insert")
    public String postInsert(Model model) {
        List<BoardVO> boardList = postService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "post/insert";
    }
    @PostMapping("/post/insert")
	public String postInsertPost(PostVO post, @AuthenticationPrincipal CustomUser customUser) {
		
		//로그인한 회원 정보를 가져옴
		if(customUser != null){
			MemberVO user = customUser.getMember();
			post.setPo_me_id(user.getMe_id());
		}
		if(postService.insertPost(post)){
			return "redirect:/post/list/" + post.getPo_bo_num();
		}
		return "redirect:/post/insert";
	}
    
    
}
