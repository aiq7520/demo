package designmode.filter;

//tag������  ֻ���˱�ǩ
public class TagFilter implements Filter {
	@Override
	public String doFilter(String msg) {
		return msg.replace("<", "[").replace(">","]");
	}

}
