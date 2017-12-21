package ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/CordovaDemo",produces="text/html;charset=UTF-8")
public class CordovaWeb {
	private String prieStr="cordova\\";
	//流程部署
	@RequestMapping("hello")
	@ResponseBody
	public String createWorkFlow(String name ,String pwd){
		System.out.println(name+" "+pwd);
		return "{'str':'Hello'}";
	}
	
	//流程部署
		@RequestMapping("hello1")
		public String hello1(String name ,String pwd,Model model){
			model.addAttribute("name", name);
			model.addAttribute("pwd", pwd);
			model.addAttribute("path", "http://192.168.1.152:8081/ssm/resources/cordova");
			return prieStr+"index";
		}
}
