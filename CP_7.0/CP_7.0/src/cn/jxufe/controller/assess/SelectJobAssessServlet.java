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
import cn.jxufe.dao.TJobAssDao;
import cn.jxufe.daoImp.TJobAssDaoImp;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.service.assess.TJobAssService;
import cn.jxufe.serviceImp.assess.TJobAssServiceImp;

/**
 * @author Administrator
 *	学生访问，初始修改的显示
 */
public class SelectJobAssessServlet extends HttpServlet {

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
		/*
		*1.判断是否有数据
		*	1.1 如果有则显示
		*	1.2没有则调转到
		*/
		//获取session userNum
		HttpSession session=req.getSession(true);
		String userNum=(String)session.getAttribute("userNum");
		System.out.println("String userNum=(String)session.getAttribute"+userNum);
		try {
			
			//查询
			TJobAss tJobAss=null;
			
			TJobAssService tJobAssService=new TJobAssServiceImp();
			
			tJobAss=tJobAssService.selectTJobAss(userNum);
			req.setAttribute("tJobAss", tJobAss);
		
			
			
			if(session.getAttribute("roleName").equals(ConstantValue.ROLE_STUDENT)){
				if(null==tJobAss.getSubmit()){
					req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP);
					
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP).forward(req, resp);
				}else if(tJobAss.getSubmit().equals(ConstantValue.FAIL)){
					req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_updateJOBASS_JSP);
					
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
								ConstantValue.RoleStudent.PAGE_STUDENT_updateJOBASS_JSP+"&userNum="+userNum).forward(req, resp);
				}else if(tJobAss.getSubmit().equals(ConstantValue.SUCCESS)){
					req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
					
					req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
				}else {
					req.setAttribute("content", ConstantValue.PAGE_ERROE);
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
