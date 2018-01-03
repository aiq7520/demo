package ssm.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssm.entity.Emp;
import ssm.service.Service;


@WebService(endpointInterface = "ssm.webservice.CordovaWebService")
@Component
public class CordovaWebServiceImpl implements CordovaWebService{
	@Autowired
	private Service service;
	
	@Override
	public String cordovaAndiroLogin(String name, String pwd) throws Exception {
		Emp user = service.login(name,pwd);
		if(user==null){
			return "false";
		}
		return "success";
	}
	
	
	public CordovaWebServiceImpl(){
		Endpoint.publish("http://192.168.1.152:9081/Service/CordovaWebService?wsdl", this);
		System.out.println("success");
	}
}
