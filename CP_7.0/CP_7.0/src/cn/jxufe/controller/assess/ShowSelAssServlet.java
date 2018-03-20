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

public class ShowSelAssServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session=req.getSession(true);
		String userNum=(String)session.getAttribute("userNum");
		

		try {
			TSelAss tSelAss=new TSelAss();
			TSelAssService tSelAssService=new TSelAssServiceImp();

			if(session.getAttribute("roleName").equals(ConstantValue.ROLE_STUDENT)){
				//if(tSelAss.getSubmit().equals("success")){
					tSelAss=tSelAssService.selectTSelAss(userNum);
				//	System.out.println(tSelAss.chater);
					req.setAttribute("tSelAss", tSelAss);
					req.setAttribute("paruserNum", userNum);
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_showSELASS_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_showSELASS_JSP+"&userNum="+userNum).forward(req, resp);
			
				
				
			}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_TEACHER)){
		
				String paruserNum=(String)req.getParameter("paruserNum");
				req.setAttribute("paruserNum", paruserNum);
				tSelAss=tSelAssService.selectTSelAss(paruserNum);
				req.setAttribute("tSelAss", tSelAss);
				
				req.setAttribute("content",ConstantValue.RoleTeacher.PAGE_TEACHER_showSELASS_JSP);
				req.getRequestDispatcher(RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleTeacher.PAGE_TEACHER_showSELASS_JSP+"&paruserNum="+paruserNum).forward(req, resp);
			}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_ADMIN)){
				req.setAttribute("content",ConstantValue.RoleAdmin.PAGE_ADMIN_SELASS_JSP);
				req.getRequestDispatcher(RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleAdmin.PAGE_ADMIN_SELASS_JSP).forward(req, resp);
			}else{
				req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
