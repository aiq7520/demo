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
import ssm.webservice.client.CordovaWebService;
import ssm.webservice.client.CordovaWebServiceImplService;
import ssm.webservice.client.Exception_Exception;

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
		public String hello1(String name ,String pwd,Model model,HttpServletResponse response) throws IOException, Exception_Exception{
			CordovaWebService cordovaWebServiceImplPort = new CordovaWebServiceImplService().getCordovaWebServiceImplPort();
			String falg = cordovaWebServiceImplPort.cordovaAndiroLogin(name,pwd);
			if(falg.equals("false")){
				response.getOutputStream().print("error");
				return null;
			}
			Emp user = service.login(name,pwd);
			model.addAttribute("user", user);
			model.addAttribute("falg", falg);
			//model.addAttribute("path", "http://192.168.1.152:8081/ssm/resources/cordova");
			List<?> list = service.listObj(Car.class);
			model.addAttribute("list", list);
			return prieStr+"index";
		}
}
