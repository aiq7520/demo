package ssm.webservice.client;

import org.junit.Test;

public class WebServiceTest {
	@Test
	public void testWebTest() throws Exception_Exception{
		CordovaWebService cordovaWebServiceImplPort = new CordovaWebServiceImplService().getCordovaWebServiceImplPort();
		System.out.println(cordovaWebServiceImplPort.cordovaAndiroLogin("ÕÅÈý·á","test"));
	}
	
}
