package designmode.filter;

import org.junit.Test;

import designmode.filter.web.Request;
import designmode.filter.web.Response;
import designmode.filter.web.WebFilterChain;
import designmode.filter.web.WebFilterImpl1;
import designmode.filter.web.WebFilterImpl2;
import designmode.filter.web.WebFilterImpl3;;

public class WebFilterTest {
	@Test//¢Ù
	public void test() {
		
	}
	@Test//¢Ú
	public void test2() {
		Request request = new Request();
		request.requestStr =" request: ";
		Response response = new Response();
		response.responseStr =" response: ";
		
		
		WebFilterChain chain = new WebFilterChain();
		chain.add(new WebFilterImpl1())//
		.add(new WebFilterImpl2())//
		.add(new WebFilterImpl3());//
		chain.doFilter(request, response,chain);
		System.out.println(request.requestStr);
		System.out.println(response.responseStr);
	}

}
