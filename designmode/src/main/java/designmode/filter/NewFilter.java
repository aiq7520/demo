package designmode.filter;

public class NewFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		return msg.replace("²Ý", "*");
	}

}
