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
			//�α���â���� ������
			response.sendRedirect(request.getContextPath()+"/memberlogin");
			
			//���� false��, Controller�� �������� ��������. ��� ��
			return false;
		}else {
			
			
			
			
			
		return true;
		}
	}
	
	
}
