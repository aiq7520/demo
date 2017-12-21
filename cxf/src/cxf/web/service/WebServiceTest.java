package cxf.web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceTest {
	@WebMethod
	public void print() throws Exception ;
}
