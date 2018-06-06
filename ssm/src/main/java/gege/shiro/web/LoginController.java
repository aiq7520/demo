package gege.shiro.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	public LoginController(){
		System.out.println("LoginController");
	}
	@RequestMapping("login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		System.out.println("login");
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������(UnknownAccountException)";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������(IncorrectCredentialsException)";
        } else if(exceptionClassName != null) {
            error = "(exceptionClassName)��������" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
	}
}
