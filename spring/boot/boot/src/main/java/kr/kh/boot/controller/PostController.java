package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post/list/{bo_num}")
    public String postList(@PathVariable int bo_num, Model model) {
        System.out.println(bo_num);
        List<PostVO> list= postService.getPostList(bo_num);
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("url", "/post/list");
        return "post/list";
    }

    @GetMapping("/post/detail/{po_num}")
    public String getMethodName(@PathVariable int po_num, Model model) {
        System.out.println(po_num);
        PostVO post = postService.getPost(po_num);
        System.out.println(post);
        model.addAttribute("post", post);
        return "post/detail";
    }
    
    
}
