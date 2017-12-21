package designmode.filter;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest {

	@Test//①
	public void test() {
		String msg ="<html>草，我真的好爱你哦   你好吗 ?  敏感词</html>";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		String result = mp.process();
		System.out.println(result);
		String targe ="[html]*，我真的好爱你哦   你好吗 ?  ***词[/html]";
		Assert.assertThat(result, new IsEqual<String>(targe));
	}
	@Test//②
	public void test2() {
		String msg ="<html>草，我真的好爱你哦   你好吗 ?  敏感词</html>";
		FilterChain fc = new FilterChain();
		fc.add(new SesitiveFilter());
		fc.add(new TagFilter());
		fc.add(new NewFilter());
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		mp.setFc(fc);
		String result = mp.process();
		String targe ="[html]*，我真的好爱你哦   你好吗 ?  ***词[/html]";
		System.out.println(result);
		Assert.assertThat(result, new IsEqual<String>(targe));
	}

}
