package designmode.filter.gege;

public class MyFilterImpl3 implements MyFilter {

	@Override
	public String doFilter(String msg) {
		return msg +" MyFilterImpl3 has do ";
	}

}
