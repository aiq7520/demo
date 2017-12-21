package designmode.filter.gege;

public class MyFilterImpl2 implements MyFilter {

	@Override
	public String doFilter(String msg) {
		return msg+" MyFilterImpl2 has do ";
	}

}
