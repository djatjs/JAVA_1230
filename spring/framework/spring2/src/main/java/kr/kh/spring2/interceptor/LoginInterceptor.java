package kr.kh.spring2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		 //구현   
		System.out.println("인터셉터 : 컨트롤러에서 나온 후");
		//컨트롤러가 보내준 회원 정보를 가져옴
		MemberVO user = (MemberVO) modelAndView.getModel().get("user");
		//가져온 회원 정보가 있으면 세션에 회원 정보를 저장
		if(user == null) {return;}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
		//구현
		System.out.println("인터셉터 : 컨트롤러에 들어가기 전");
		return true;
	}
}
