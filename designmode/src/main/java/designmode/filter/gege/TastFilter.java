package designmode.filter.gege;

import org.junit.Test;

public class TastFilter {

	@Test
	public void test(){
		MsgProcessor mp =new MsgProcessor("gege ");
		MyFilterChain chain = new MyFilterChain();
		chain.add(new MyFilterImpl1());
		chain.add(new MyFilterImpl2());
		mp.setChain(chain);
		System.out.println(mp.process());
	}
}
