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
	
	//������Ϣ
	/*
	 public String process(){
		msg = msg.replace("<", "[").replace(">", "]")//����һ
				.replace("��", "*")//���˶�
				.replace("����", "***");//������
		 
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
