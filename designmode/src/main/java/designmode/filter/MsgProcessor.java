package designmode.filter;

public class MsgProcessor {
	private String msg;
	//Filter[] filtes ={new TagFilter(),new SesitiveFilter(),new NewFilter()};
	private FilterChain fc ;;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//处理信息
	/*
	 public String process(){
		msg = msg.replace("<", "[").replace(">", "]")//过滤一
				.replace("草", "*")//过滤二
				.replace("敏感", "***");//过滤三
		 
		return msg;
	}
	*/
	public String process(){
		return fc.doFilter(msg);
	}
	public FilterChain getFc() {
		return fc;
	}
	public void setFc(FilterChain fc) {
		this.fc = fc;
	}
}
