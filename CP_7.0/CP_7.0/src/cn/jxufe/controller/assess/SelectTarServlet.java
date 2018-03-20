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
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.evaluation.VTarService;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.serviceImp.evaluation.VTarServiceImp;
import cn.jxufe.serviceImp.permission.RoleServiceImp;

public class SelectTarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);

		
		String userNum=(String)session.getAttribute("userNum");
	    int termNum=Integer.parseInt(req.getParameter("termNum"));
		VTar vTar=new VTar();
		VTarService vTarService=new VTarServiceImp();
		RoleService roleService=new RoleServiceImp();
		try {

			if(roleService.isRole(userNum, ConstantValue.ROLE_STUDENT)){
				
				vTar=vTarService.findVTar(userNum, termNum);
				req.setAttribute("termNum", termNum);
				req.setAttribute("vTar", vTar);
				req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_showTAR);

				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_showTAR).forward(req, resp);
				
			}else if(roleService.isRole(userNum, ConstantValue.ROLE_TEACHER)){
				String paruserNum=req.getParameter("paruserNum");
				vTar=vTarService.findVTar(paruserNum, termNum);
				req.setAttribute("vTar", vTar);
				//session.setAttribute("roleName",ConstantValue.ROLE_TEACHER);
				req.setAttribute("paruserNum", paruserNum);
				req.setAttribute("termNum", termNum);
				req.setAttribute("content", ConstantValue.RoleTeacher.PAGE_TEACHER_showTAR);
				req.getRequestDispatcher(RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						RoleTeacher.PAGE_TEACHER_showTAR).forward(req, resp);
			}
			else if(roleService.isRole(userNum, ConstantValue.ROLE_ADMIN)){
				//session.setAttribute("roleName",ConstantValue.ROLE_ADMIN);
			
				req.getRequestDispatcher(RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+"?content="+ConstantValue.RoleAdmin.PAGE_ADMIN_Tar_JSP).forward(req, resp);
			}else{
				
				req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

			
			
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	
	}

}
