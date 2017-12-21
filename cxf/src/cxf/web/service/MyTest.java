package cxf.web.service;


import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Test;

public class MyTest{

	@Test
	public void test() throws Exception {
		try {
			JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();  
			factory.setServiceClass(WebServiceImpl.class);  
			factory.setAddress("http://localhost:8080/webServiceImpl");  
			  
			Server server = factory.create();  
			server.start();  
			System.out.println("aa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
