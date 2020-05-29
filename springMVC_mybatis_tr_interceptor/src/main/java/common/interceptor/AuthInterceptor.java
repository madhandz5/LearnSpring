package common.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//Interceptor
// DispatcherServlet이 컨트롤러를 호출하기전에 요청을 가로채서 원하는 작업을 진행할 수 있다.
// servletContainer -> filter(서블릿 호출하기전에 요청을 가로 챌 수 있다.)
// -> servlet -> interceptor(서블릿이 컨트롤러를 호출하기전에 요청을 가로 챌 수 있다.) -> controller
// 이벤트 발생시 Listener가 호출

public class AuthInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	// Controller가 수행되기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// return 타입 boolean
		// true 반환 시 : 컨트롤러를 정상적으로 호출
		// false 반환 시 : 컨트롤러를 호출하지 않음

		logger.info("[interceptor] : preHandle");
		HttpSession session = request.getSession();
		if (request.getRequestURI().contains("book/") && session.getAttribute("logInInfo") == null) {
			request.setAttribute("alertMsg", "로그인 이후 사용 가능한 기능입니다.");
			request.setAttribute("back", "back");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			rd.forward(request, response);
		}
		return true;
	}

	// Controller가 수행되고 View를 호출하기 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// View까지 호출이 완료 된 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
