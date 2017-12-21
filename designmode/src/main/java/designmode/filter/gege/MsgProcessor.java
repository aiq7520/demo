package designmode.filter.gege;

public class MsgProcessor {
	private String msg;
	private MyFilterChain chain;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MsgProcessor(String msg) {
		super();
		this.msg = msg;
	}
	public String process(){
		return chain.doFilter(msg);
	}
	public MyFilterChain getChain() {
		return chain;
	}
	public void setChain(MyFilterChain chain) {
		this.chain = chain;
	}
	
}
