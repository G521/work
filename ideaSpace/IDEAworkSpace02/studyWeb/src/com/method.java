package com;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class method extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("�����doGet������");
//		System.out.println(req.getRequestURL());//���url��ַ
//		System.out.println(req.getRequestURI());
	System.out.println(req.getParameter("uname"));
	System.out.println(req.getParameter("pwd"));
}
}
