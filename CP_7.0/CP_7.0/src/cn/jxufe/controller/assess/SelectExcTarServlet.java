package cn.jxufe.controller.assess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TUser;
import cn.jxufe.service.assess.TarService;
import cn.jxufe.service.evaluation.TExcTarService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.assess.TarServiceImp;
import cn.jxufe.serviceImp.evaluation.TExcTarServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;

public class SelectExcTarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		
		//获取session userNum
		HttpSession session=req.getSession(true);
		String userNum=(String)session.getAttribute("userNum");
		
		
	   // int termNum=Integer.parseInt(req.getParameter("termNum"));
		
		try {
		
			//获得学期号
			TUserDao tUserDao=new TUserDaoImp();
			TUser tUser =tUserDao.findAllByUserNum(userNum);
			int year=tUser.getYear();
			TUserService tUserService=new TUserServiceImp();		
			int termNum=tUserService.getTermNumByYear(year);
			
			
			TarService tarService=new TarServiceImp();
			TExcTar tExcTar=tarService.selectExcTar(userNum, termNum);
			if(session.getAttribute("roleName").equals(ConstantValue.ROLE_STUDENT)){
				if(null==tExcTar.getSubmit()){	
					
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP).forward(req, resp);
				}else if(tExcTar.getSubmit().equals(ConstantValue.FAIL)){
					req.setAttribute("tExcTar", tExcTar);
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_updateEXCTAR_JSP);
					
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+
					"?content="+ConstantValue.RoleStudent.PAGE_STUDENT_updateEXCTAR_JSP+"&userNum="+userNum).forward(req, resp);
				}else if(tExcTar.getSubmit().equals(ConstantValue.SUCCESS)){
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
				}else{
					req.setAttribute("content",ConstantValue.PAGE_ERROE);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.PAGE_ERROE).forward(req, resp);
				}	
			}else{
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
