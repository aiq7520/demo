package designmode.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	List<Filter> filters =new ArrayList<Filter>();
	
	public FilterChain add(Filter f){
		filters.add(f);
		return this;
	}
	
	
	public String doFilter(String msg){
		for(Filter f:filters)
			msg = f.doFilter(msg);
		return msg;
	}
}
