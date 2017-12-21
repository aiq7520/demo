package designmode.filter.web;

import java.util.ArrayList;
import java.util.List;

public class WebFilterChain implements WebFilter{
	List<WebFilter> list = new ArrayList<WebFilter>();
	int i=0;
	public WebFilterChain add(WebFilter f){
		list.add(f);
		return this;
	}
	
	@Override
	public void doFilter(Request request,Response response,WebFilterChain chain){
		if(i==list.size())
			return;
		WebFilter f = list.get(i++);
		f.doFilter(request, response,chain);
	}
}
