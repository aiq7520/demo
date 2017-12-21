package cxf.web.service;

import javax.jws.WebService;

public class WebServiceImpl implements WebServiceTest{
	@Override
	public void print() throws Exception {
		System.out.println("test");
	}

}
