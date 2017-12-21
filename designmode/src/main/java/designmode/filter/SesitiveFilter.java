package designmode.filter;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		return msg.replace("√Ù∏–", "***");
	}

}
