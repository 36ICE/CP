package cn.jxufe.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleAdmin;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.controller.permission.ConstantValue.RoleTeacher;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.permission.RoleServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;

public class LoginServlet extends HttpServlet {

	/**
	 * 处理登录服务
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doGet(req, resp);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	//	resp.setContentType("text/xml;charset=utf-8");


		String userNum = req.getParameter("userNum");
		String code=req.getParameter("code");
		System.out.println("String userNum = req.getParameter"+userNum);
		TUserService userService=new TUserServiceImp();
		TUser tuser=new TUser();
		try {
			if(userService.Login(userNum, code,tuser)){

				HttpSession session;
				session = req.getSession(true);
				session.setAttribute("userNum", userNum);
				session.setAttribute("userName" , tuser.getUserName());
				RoleService roleService=new RoleServiceImp();
				
				if(roleService.isRole(userNum, ConstantValue.ROLE_STUDENT)){
					
					session.setAttribute("roleName",ConstantValue.ROLE_STUDENT);			
					req.setAttribute("content",RoleStudent.PAGE_STUDENT_SHOUYE_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
					RoleStudent.PAGE_STUDENT_SHOUYE_JSP).forward(req, resp);
					
				}else if(roleService.isRole(userNum, ConstantValue.ROLE_TEACHER)){
					
					session.setAttribute("roleName",ConstantValue.ROLE_TEACHER);			
					req.setAttribute("content",RoleTeacher.PAGE_TEACHER_SHOUYE_JSP);
					req.getRequestDispatcher(RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
					RoleTeacher.PAGE_TEACHER_SHOUYE_JSP).forward(req, resp);
					
				}else if(roleService.isRole(userNum, ConstantValue.ROLE_ADMIN)){
					
					session.setAttribute("roleName",ConstantValue.ROLE_ADMIN);		
					req.setAttribute("content",RoleAdmin.PAGE_ADMIN_SHOUYE_JSP);
					req.getRequestDispatcher(RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+"?content="+
					RoleAdmin.PAGE_ADMIN_SHOUYE_JSP).forward(req, resp);
					
				}else{
					
					req.getRequestDispatcher(ConstantValue.PAGE_LOGIN_ERROE).forward(req, resp);
				}
			}else{
				
				req.getRequestDispatcher(ConstantValue.PAGE_LOGIN_ERROE).forward(req, resp);
				
			}
			
		} catch (Exception e) {
		
			//e.printStackTrace();
			throw new RuntimeException("Login error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	//	super.doPost(req, resp);
		doGet(req,resp);
	}
	
	
	

}
