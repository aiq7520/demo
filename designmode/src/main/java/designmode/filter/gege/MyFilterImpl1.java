package designmode.filter.gege;

public class MyFilterImpl1 implements MyFilter {

	@Override
	public String doFilter(String msg) {
		return msg+" MyFilterImpl1 has do ";
	}

}
