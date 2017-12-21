package ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ssm.entity.Emp;

public class LoginInterceptor extends HandlerInterceptorAdapter{
    public static final String LAST_PAGE = "com.alibaba.lastPage"; 
    /**  
     * ��ҵ��������������֮ǰ������  
     * �������false  
     *     �ӵ�ǰ������������ִ��������������afterCompletion(),���˳��������� 
     * �������true  
     *    ִ����һ��������,ֱ�����е���������ִ�����  
     *    ��ִ�б����ص�Controller  
     *    Ȼ�������������,  
     *    �����һ������������ִ�����е�postHandle()  
     *    �����ٴ����һ������������ִ�����е�afterCompletion()  
     */    
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
        Emp emp =  (Emp)request.getSession().getAttribute("user");   
        if(emp==null){  
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            request.setAttribute("msg", "���ȵ�¼");
            return false;  
        }else  
            return true;     
    }   
}
