package kr.spring.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
@Component
public class LogonCheckInterceptor extends HandlerInterceptorAdapter{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response,
			                 Object handler)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("=======LogonCheckInterceptor 진입=====");
		}
		
		//session 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")==null){
			response.sendRedirect(
					request.getContextPath()+"/member/login.do");
			return false;
		}
		return true;
	}
	
}





