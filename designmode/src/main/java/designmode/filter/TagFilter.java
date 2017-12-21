package designmode.filter;

//tag过滤器  只过滤标签
public class TagFilter implements Filter {
	@Override
	public String doFilter(String msg) {
		return msg.replace("<", "[").replace(">","]");
	}

}
