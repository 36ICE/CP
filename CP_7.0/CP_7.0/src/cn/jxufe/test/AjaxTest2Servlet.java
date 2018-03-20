package cn.jxufe.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxTest2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //处理中文问题
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		   System.out.println("start............");
		   String username=req.getParameter("username");
		   String content=req.getParameter("content");
		   //username=new String(username.getBytes("gb2312"),"utf-8");
		   PrintWriter out = resp.getWriter();
		   out.write(username);
		   System.out.println("username>>=="+username);
		   out.write(content);
		   out.flush();
		   out.close();
		   System.out.println("end");
	}

}
