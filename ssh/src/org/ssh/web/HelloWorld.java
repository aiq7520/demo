package org.ssh.web;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;
public class HelloWorld extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "Struts is up and running ...";
	
	@Override
    public String execute() throws Exception {
        setMessage(MESSAGE);
        return SUCCESS;
    }

    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    @Action("foo")
    public String foo() {
    	System.out.println("foo");
        return "bar";
    }

    @Action("foo-bar")
    public String bar() {
    	System.out.println("foo-bar");
        return SUCCESS;
    }
}