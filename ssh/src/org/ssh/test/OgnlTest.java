package org.ssh.test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class OgnlTest {

	@Test
	public void test() {
		Locale locale = new Locale("zh","CN");
		Date date = new Date();    
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);    
		System.out.println(df.format(date)); 
	}
	@Test
	public void test2() {
	    //����Ϣ��ʽ����    
	    String pattern1 = "{0}����ã����� {1} �ڹ������д��� {2} Ԫ��";  
	    String pattern2 = "At {1,time,short} On {1,date,long},{0} paid {2,number, currency}.";  
	      
	    //�����ڶ�̬�滻ռλ���Ĳ���    
	    Object[] params = {"John",new Date(), 1.0E3};  
	      
	    //��ʹ��Ĭ�ϱ��ػ������ʽ����Ϣ    
	    String msg1 = MessageFormat.format(pattern1, params);  
	      
	    //��ʹ��ָ���ı��ػ������ʽ����Ϣ    
	    MessageFormat mf = new MessageFormat(pattern2, Locale.US);  
	    String msg2 = mf.format(params);  
	    System.out.println(msg1);  
	    System.out.println(msg2);  
	}
	@Test
	public void test3() {
		Locale locale = new Locale("zh","CN");
	    ResourceBundle rb = ResourceBundle.getBundle("org/ssh/test/resource", locale); 
	    System.out.println(rb.getString("greeting.common"));
	    ResourceBundle rb1 = ResourceBundle.getBundle("org/ssh/test/resource", Locale.US);  
	    ResourceBundle rb2 = ResourceBundle.getBundle("org/ssh/test/resource", Locale.CHINA);  
	    System.out.println("us:"+rb1.getString("greeting.common"));  
	    System.out.println("cn:"+rb2.getString("greeting.common"));  
	}
	@Test
	public void test4() {
		Locale locale = new Locale("zh","CN");
		ResourceBundle rb = ResourceBundle.getBundle("org/ssh/test/resource",locale);
		System.out.println(MessageFormat.format(rb.getString("greeting.common"), "John",new Date()));
		Locale locale1 = new Locale("en","US");
		ResourceBundle rb1 = ResourceBundle.getBundle("org/ssh/test/resource",locale1);
		MessageFormat mf = new MessageFormat(rb1.getString("greeting.common"), Locale.US);
	    Object[] params = {"John",new Date(), 1.0E3};  
		System.out.println(mf.format(params));
	}

}
