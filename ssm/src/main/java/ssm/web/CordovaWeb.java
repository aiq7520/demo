package ssm.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Car;
import ssm.entity.Emp;
import ssm.service.Service;

@Controller
@RequestMapping(value="/CordovaDemo",produces="text/html;charset=UTF-8")
public class CordovaWeb {
	@Autowired
	private Service service;
	
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
		public String hello1(String name ,String pwd,Model model,HttpServletResponse response) throws IOException{
			Emp user = service.login(name,pwd);
			if(user==null){
				response.getOutputStream().print("error");
				return null;
			}
			model.addAttribute("name", name);
			model.addAttribute("pwd", pwd);
			//model.addAttribute("path", "http://192.168.1.152:8081/ssm/resources/cordova");
			List<?> list = service.listObj(Car.class);
			model.addAttribute("list", list);
			return prieStr+"index";
		}
}
