package cn.jxufe.controller.assess;

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
import cn.jxufe.domain.TSelAss;
import cn.jxufe.service.assess.TSelAssService;
import cn.jxufe.serviceImp.assess.TSelAssServiceImp;

public class SelectSelAssessServlet extends HttpServlet {

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
		HttpSession session=req.getSession(true);
		
		String userNum=(String)session.getAttribute("userNum");
		System.out.println("String userNum=(String)session.getAttribute;"+userNum);
		String content=(String)req.getParameter(("content"));
		System.out.println("String content=(String)req."+content);
		req.setAttribute("content", "ssubmit.jsp");
		try {
			TSelAss tSelAss=new TSelAss();
			TSelAssService tSelAssService=new TSelAssServiceImp();
			
			tSelAss=tSelAssService.selectTSelAss(userNum);
			//.toString() 将Object转为String 否则
			
			if(session.getAttribute("roleName").equals(ConstantValue.ROLE_STUDENT)){
				if(null==tSelAss.getSubmit()){
					
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP).forward(req, resp);
				}
				else if(tSelAss.getSubmit().toString().equals(ConstantValue.FAIL)){	
					req.setAttribute("tSelAss", tSelAss);
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_updateSELASS_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_updateSELASS_JSP+
							"&userNum="+userNum).forward(req, resp);
				}else if(tSelAss.getSubmit().toString().equals(ConstantValue.SUCCESS)){
					
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
				}else{
					req.setAttribute("content",ConstantValue.PAGE_ERROE);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.PAGE_ERROE).forward(req, resp);
				}
				
				
			}else{
				req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
			
			
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
