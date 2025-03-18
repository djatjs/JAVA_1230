package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring.service.BoardSerive;

@Controller
public class BoardController {
	
	@Autowired //@Service가 있어야 됨. -> 서비스 객체 만들어줌
	private BoardSerive boardSerive;
	
	@GetMapping("/board/list")
	public String boardList() {
		
		return "/board/list";
	}
}
