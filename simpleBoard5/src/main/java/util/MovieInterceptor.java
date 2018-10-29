package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MovieInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("userid");
		if(name==null) {
			//로그인창으로 보내기
			response.sendRedirect(request.getContextPath()+"/memberlogin");
			
			//리턴 false는, Controller의 리턴으로 가지말라. 라는 뜻
			return false;
		}else {
			
			
			
			
			
		return true;
		}
	}
	
	
}
