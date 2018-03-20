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
import cn.jxufe.domain.TJobAss;
import cn.jxufe.service.assess.TJobAssService;
import cn.jxufe.serviceImp.assess.TJobAssServiceImp;

public class ShowJobAssServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		/*
		*1.判断是否有数据
		*	1.1 如果有则显示
		*	1.2没有则调转到
		*/
		//获取session userNum
		HttpSession session=req.getSession(true);
		String userNum=(String)session.getAttribute("userNum");
	
		try {
			//查询
			TJobAss tJobAss=null;
			
			TJobAssService tJobAssService=new TJobAssServiceImp();
			if(session.getAttribute("roleName").equals(ConstantValue.ROLE_STUDENT)){
				
				req.setAttribute("paruserNum", userNum);
				tJobAss=tJobAssService.selectTJobAss(userNum);
				session.setAttribute("tJobAss", tJobAss);
				req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_showJOBASS_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_showJOBASS_JSP+"&userNum="+userNum).forward(req, resp);
	
			}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_TEACHER)){
				
				String paruserNum=(String)req.getParameter("paruserNum");
				req.setAttribute("paruserNum", paruserNum);
				
				tJobAss=tJobAssService.selectTJobAss(paruserNum);
				req.setAttribute("tJobAss", tJobAss);
				req.setAttribute("content",ConstantValue.RoleTeacher.PAGE_TEACHER_showJOBASS_JSP);
				req.getRequestDispatcher(RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleTeacher.PAGE_TEACHER_showJOBASS_JSP+
							"&paruserNum="+paruserNum).forward(req, resp);
				
			}else if(session.getAttribute("roleName").equals(ConstantValue.ROLE_ADMIN)){
				
				//RoleAdmin role=(RoleAdmin)session.getAttribute( "ROLE");
				req.setAttribute("content",ConstantValue.RoleAdmin.PAGE_ADMIN_JOBASS_JSP);
				req.getRequestDispatcher(RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+
						"?content="+ConstantValue.RoleAdmin.PAGE_ADMIN_JOBASS_JSP).forward(req, resp);
			}else{
				
				req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
