package ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ssm.entity.Emp;

public class Utils {
	private final static String  GOALUSER ="user";
	//获取当前登录用户
	public static Emp getUser(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		//WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		//ServletContext servletContext = webApplicationContext.getServletContext();
		//return (Emp)servletContext.getAttribute(GOALUSER);
		HttpSession session = request.getSession();
		return (Emp)session.getAttribute(GOALUSER);
	}

	public static void setUser(Emp user) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(GOALUSER, user);
	}
}
