package cn.jxufe.controller.evaluate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.dao.vdao.VInfoDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.daoImp.vdaoImp.VInfoDaoImp;
import cn.jxufe.domain.TUser;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.service.evaluation.OpenEvaService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.serviceImp.evaluation.TOpenEvaServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;

public class OpenEvaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/* parme
		 *  starttime
		 *  endtime
		 *  unitId
		 *  
		 *  根据互评算法
		 *  写入评价人表
		 *  将开启互评功能关闭，禁止用户二次开启
		 *  
		 *  
		 */
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		
		HttpSession session;
		session = req.getSession(true);
		int num=Integer.parseInt(req.getParameter("num"));
		
		String isSelf=(String)req.getAttribute("inlineRadioOptions");
		
		String userNum= (String)session.getAttribute("userNum");
		//获取unitId 班级
		VInfo vInfo=new VInfo();
		VInfoDao vInfoDao=new VInfoDaoImp();
		
		try {
			VInfo vinfo=vInfoDao.findByUserNum(userNum);
			OpenEvaService openEvaService=new TOpenEvaServiceImp();
			
			PrintWriter out = resp.getWriter();
			
			TUserDao tUserDao=new TUserDaoImp();
			TUser tUser =tUserDao.findAllByUserNum(userNum);
			int year=tUser.getYear();
			TUserService tUserService=new TUserServiceImp();		
			int termNum=tUserService.getTermNumByYear(year);
			
			//开启互评
			if(openEvaService.evaStrategy(vinfo.getUnitId(), termNum, num,isSelf)){	
				out.print("true");
				req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
			}else{
				out.print("false");
				req.setAttribute("content", ConstantValue.PAGE_ERROE);
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
