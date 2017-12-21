package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fileUpServlet", urlPatterns = { "/fileUpServlet" })
public class FileUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式为utf-8
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8"); 
		 System.out.println(request.getContentLength());
		 System.out.println(request.getCharacterEncoding());
		 InputStream inputStream = request.getInputStream();
		 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		 String r ="";
		 while(r!=null){
			 r = br.readLine();
			 System.out.println(r);
		 }
	}

}
