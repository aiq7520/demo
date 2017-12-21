package org.ssh.web;

import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ChangelanAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String json;
	private String msg;
	@Override
	public String execute() throws Exception {
        //获得本地默认的语言环境
        Locale locale=Locale.getDefault();
        //存入到一个session变量中。"WW-TRANS-I18N-LOCALE"为固定写法
        ActionContext.getContext().getSession().put("WW-TRANS-I18N-LOCALE", locale);
        msg ="msg";
        return SUCCESS;
    }
	
	public String toJson(){
		json = "{'doubleValue': 10.10,'nestedBean': {'name': 'Mr Bean'},'list': ['A', 10, 20.20, {'firstName': 'El Zorro'}],'array': [10, 20] }";
		return SUCCESS;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}