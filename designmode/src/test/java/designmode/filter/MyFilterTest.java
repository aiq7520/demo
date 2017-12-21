package designmode.filter;

import org.junit.Test;

import designmode.filter.gege.MsgProcessor;
import designmode.filter.gege.MyFilterChain;
import designmode.filter.gege.MyFilterImpl1;
import designmode.filter.gege.MyFilterImpl2;
import designmode.filter.gege.MyFilterImpl3;;

public class MyFilterTest {
	@Test//①
	public void test() {
		String msg ="msg";
		MyFilterChain chain = new MyFilterChain();
		MyFilterChain chain2 = new MyFilterChain();
		chain2.add(new MyFilterImpl1());
		chain.add(new MyFilterImpl1());
		chain.add(new MyFilterImpl2());
		chain.add(new MyFilterImpl3());
		chain.add(chain2);//chain.add(此处如果 chain实现MyFilter 我们就可以将链条加入链条);
		
		String result = chain.doFilter(msg);
		System.out.println(result);
	}
	@Test//②
	public void test2() {
		String msg ="msg";
		MyFilterChain chain = new MyFilterChain();
		MyFilterChain chain2 = new MyFilterChain();
		chain2.add(new MyFilterImpl1());
		chain.add(new MyFilterImpl1());
		chain.add(new MyFilterImpl2());
		chain.add(new MyFilterImpl3());
		chain.add(chain2);//chain.add(此处如果 chain实现MyFilter 我们就可以将链条加入链条);
		MsgProcessor msgprocessor = new MsgProcessor(msg);
		msgprocessor.setChain(chain);
		String result = msgprocessor.process();
		System.out.println(result);
	}

}
