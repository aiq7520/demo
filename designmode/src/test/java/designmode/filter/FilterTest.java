package designmode.filter;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest {

	@Test//��
	public void test() {
		String msg ="<html>�ݣ�����ĺð���Ŷ   ����� ?  ���д�</html>";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		String result = mp.process();
		System.out.println(result);
		String targe ="[html]*������ĺð���Ŷ   ����� ?  ***��[/html]";
		Assert.assertThat(result, new IsEqual<String>(targe));
	}
	@Test//��
	public void test2() {
		String msg ="<html>�ݣ�����ĺð���Ŷ   ����� ?  ���д�</html>";
		FilterChain fc = new FilterChain();
		fc.add(new SesitiveFilter());
		fc.add(new TagFilter());
		fc.add(new NewFilter());
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		mp.setFc(fc);
		String result = mp.process();
		String targe ="[html]*������ĺð���Ŷ   ����� ?  ***��[/html]";
		System.out.println(result);
		Assert.assertThat(result, new IsEqual<String>(targe));
	}

}
