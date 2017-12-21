package designmode.filter.gege;

import java.util.List;
import java.util.ArrayList;

public class MyFilterChain implements MyFilter{
	List<MyFilter> list = new ArrayList<MyFilter>();
	
	public MyFilterChain add(MyFilter f){
		list.add(f);
		return this;
	}
	
	public String doFilter(String msg){
		for(MyFilter f: list)
			msg = f.doFilter(msg);
		return msg;
	}
}
