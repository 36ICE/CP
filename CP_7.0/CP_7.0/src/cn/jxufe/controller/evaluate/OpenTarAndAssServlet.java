package cn.jxufe.controller.evaluate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.evaluation.OpenTarAndAssService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.evaluation.OpenTarAndAssServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;

public class OpenTarAndAssServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);
		
		String userNum=(String)session.getAttribute("userNum");
		
		try {
			
			PrintWriter out = resp.getWriter();
			OpenTarAndAssService openTarAndAssService=new OpenTarAndAssServiceImp();
			if(openTarAndAssService.tarAndAssStrategy(userNum)){	
				
				out.print("true");
				req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
			}else{
				
				out.print("false");
				req.setAttribute("content",ConstantValue.PAGE_ERROE);
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
