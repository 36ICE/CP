package cn.jxufe.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleAdmin;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.controller.permission.ConstantValue.RoleTeacher;

public class SkipServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);
		//String content=req.getParameter("content");
		
		String roleName=(String) session.getAttribute("roleName");
		if( null!=roleName & roleName.equals(ConstantValue.ROLE_STUDENT)){
			req.setAttribute("content","sshouye.jsp");
			//RoleStudent role=(RoleStudent)session.getAttribute( "ROLE");
			req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP
			).forward(req, resp);
		}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_TEACHER)){
			req.setAttribute("content","tshouye.jsp");
			req.getRequestDispatcher(RoleTeacher.PAGE_TEMPLETE_INDEX_JSP).forward(req, resp);
		}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_ADMIN)){
			req.setAttribute("content","ashouye.jsp");
			req.getRequestDispatcher(RoleAdmin.PAGE_TEMPLETE_INDEX_JSP).forward(req, resp);
		}else{
			req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	
	}

}
