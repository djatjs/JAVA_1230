package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.service.MessageService;
import kr.kh.spring.service.PostSerive;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	PostSerive postSerive;
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/board") //리퀘스트매핑으로 해놔서 "/admin/board"와 같음
	public String board(Model model) {
		//모든 게시판을 가져와서 화면에 전송
		List<BoardVO> list = postSerive.getBoardList();
		//if(list != null) {
			model.addAttribute("list", list);
		//}
		return "/admin/board";
	}
	
	@PostMapping("/board/insert")
	public String boardInsert(String bo_name, HttpServletResponse response, HttpServletRequest request){
		if(postSerive.insertBoard(bo_name)) {
			messageService.sendMessage(response, request, "게시판을 등록했습니다.", "/admin/board");
		}else {
			messageService.sendMessage(response, request, "게시판을 등록하지 못했습니다.", "/admin/board");
		}
		return "/admin/board";
	}
	
	@PostMapping("/board/delete")
	public String boardDelete(int bo_num, HttpServletResponse response, HttpServletRequest request){
		if(postSerive.deleteBoard(bo_num)) {
			messageService.sendMessage(response, request, "게시판을 삭제했습니다.", "/admin/board");
		}else {
			messageService.sendMessage(response, request, "게시판을 삭제하지 못했습니다.", "/admin/board");
		}
		return "/admin/board";
	}
	
	@PostMapping("/board/update")
	public String boardUpdate(BoardVO board,  HttpServletResponse response, HttpServletRequest request){
		if(postSerive.updateBoard(board)) {
			messageService.sendMessage(response, request, "게시판을 수정했습니다.", "/admin/board");
		}else {
			messageService.sendMessage(response, request, "게시판을 수정하지 못했습니다.", "/admin/board");
		}
		return "/admin/board";
	}
	
	
}
