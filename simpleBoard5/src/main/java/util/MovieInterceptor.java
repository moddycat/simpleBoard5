package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MovieInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("userid");
		if (name == null) {
			response.sendRedirect(request.getContextPath() + "/memberlogin");
			return false;
		} else {
			return true;
		}
	}

}
