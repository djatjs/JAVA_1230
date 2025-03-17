package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.dto.PersonDTO;

/**
 * Handles requests for the application home page.
 */
/* @Controller
 * => HandlerMapping에 url을 등록하기 위한 어노테이션
 * */
@Controller
public class HomeController {
	
	/* @RequestMapping
	 * => 처리할 url정보를 지정하는 어노테이션으로 해당 정보와 일치하는 경우 메소드를 호출하여 실행
	 * => value : 처리할 url 지정
	 * => method : 리퀘스트 메소드 처리 방식을 지정. GET, POST, PUT, DELETE 등
	 * 
	 * @GetMapping
	 * => @RequestMapping(value = "/", method = RequestMethod.GET)인 경우 대체할 수 있는 어노테이션
	 * 
	 * @PostMapping
	 *  => @RequestMapping(value = "/", method = RequestMethod.POST)인 경우 대체할 수 있는 어노테이션
	 * */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String home(Model model, String name, Integer age) { // int는 null 허용 X
		System.out.println("화면에서 보낸 이름 : "+ name);
		System.out.println("화면에서 보낸 이름 : "+ age);
		/* 화면에 데이터를 전송하는 방법
		 * - Model 객체를 이용하여 전송
		 * - addAttribute("화면에서 쓸 이름","데이터")
		 * */
		model.addAttribute("name","홍길동");
		
		/* 컨트롤러가 Dispatcher Servlet(이하 디스패처)에게 home이라는 문자열을 반환 
		 * => 디스패처가 View Resolver(이하 뷰 리졸버)에게 home이라는 문자열을 전달
		 * => 뷰 리졸버는 설정된 방법에 따라 home을 가공함
		 * 	=> 뷰 리졸버 설정은 servlet-context.xml에 있음
		 *  => 기본 뷰 리졸버에 의해 /WEB-INF/views/home.jsp가 완성되어
		 *  	최종적으로 해당 jsp의 결과 화면을 클라이언트에 전송*/
		return "home";
	}
	/* 메소드의 매개변수에 객체를 넣어주면, 매핑이 되든 안되든 기본 생성자를 이용해서 객체를 만듦.
	 * => 화면에서 보낸 변수의 이름과 같은 필드가 있으면 자동으로 매핑이 되어 값이 변경됨. 이 때 setter를 호출
	 * */
	// Get, Post 둘다 내용같아서 Request로 둠
	// @GetMapping, @PostMapping에서 처리하는 내용이 같은 경우 @RequestMapping으로 묶을 수 있음
	@RequestMapping(value = "/send") 
	public String send(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : "+ person);
		/* 서버에서 화면으로 객체 전송 */
		model.addAttribute("person", person);
		return "sample/send";
	}
	
	
}
