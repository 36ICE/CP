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
import cn.jxufe.domain.ventity.VEva;
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.evaluation.VEvaService;
import cn.jxufe.service.evaluation.VTarService;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.serviceImp.evaluation.VEvaServiceImp;
import cn.jxufe.serviceImp.evaluation.VTarServiceImp;
import cn.jxufe.serviceImp.permission.RoleServiceImp;

public class SelectEvaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);

		String paruserNum=req.getParameter("paruserNum");
		int eveluaterId =Integer.parseInt(req.getParameter("eveluaterId"));
	    int termNum=Integer.parseInt(req.getParameter("termNum"));
	    
	    VEva vEva=new VEva();
	    VEvaService vEvaService=new VEvaServiceImp();

		try {
			vEva=vEvaService.findByUserNum(paruserNum, termNum);
			session.setAttribute("eveluaterId", eveluaterId);
				session.setAttribute("vEva", vEva);
				req.setAttribute("paruserNum", paruserNum);
				req.setAttribute("content",RoleStudent.PAGE_STUDENT_updateEVALUATE_JSP);
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
				RoleStudent.PAGE_STUDENT_updateEVALUATE_JSP).forward(req, resp);
		
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
