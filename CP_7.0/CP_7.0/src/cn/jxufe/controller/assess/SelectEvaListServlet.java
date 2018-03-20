package cn.jxufe.controller.assess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleAdmin;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.domain.TEvaluater;
import cn.jxufe.domain.TUser;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.service.evaluation.TEvaluaterService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.service.user.VInfoService;
import cn.jxufe.serviceImp.evaluation.TEvaluateServiceImp;
import cn.jxufe.serviceImp.evaluation.TEvaluaterServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;
import cn.jxufe.serviceImp.user.VInfoServiceImp;

public class SelectEvaListServlet extends HttpServlet {

	/**
	 * 互评
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);

		
		String userNum=(String)session.getAttribute("userNum");
	   // int termNum=Integer.parseInt(req.getParameter("termNum"));
	    String paruserNum=(String)req.getParameter("paruserNum");
	    TEvaluaterService tEvaluaterService=new TEvaluaterServiceImp();
	    
	    try {
			

			//获得学期
			TUserDao tUserDao=new TUserDaoImp();
			TUser tUser =tUserDao.findAllByUserNum(userNum);
			//int evauserId=(int)tUser.getUserId();
			int year=tUser.getYear();
			TUserService tUserService=new TUserServiceImp();		
			int termNum=tUserService.getTermNumByYear(year);			
			
			
			Collection<TEvaluater> tEvaluaters= tEvaluaterService.findByEvaUserNum(userNum);
			
			req.setAttribute("termNum",termNum);
			session.setAttribute("tEvaluaters", tEvaluaters);
			VInfoService vInfoService=new VInfoServiceImp();
			Collection<VInfo> vInfos_fail=new ArrayList<VInfo>();
			
			Collection<VInfo> vInfos_success=new ArrayList<VInfo>();
			
			Iterator<TEvaluater> it=tEvaluaters.iterator();
			while(it.hasNext()){
				TEvaluater temp1=(TEvaluater)it.next();
				if(temp1.getSubmit().equals("fail")){
					VInfo temp2=vInfoService.findVInfoByUserId((int)((temp1.getUserId())));
					temp2.setEveluaterId((int) temp1.getEvaluaterId());
					vInfos_fail.add(temp2);		
					
				}else{
					VInfo temp2=vInfoService.findVInfoByUserId((int)((temp1.getUserId())));
					temp2.setEveluaterId((int) temp1.getEvaluaterId());
					vInfos_success.add(temp2);					
				}
				
			}
		//	System.out.println("vInfos_fail.size()"+vInfos_fail.size());
		//	System.out.println("vInfos_success.size()"+vInfos_success.size());
			
			req.setAttribute("vInfos_fail", vInfos_fail);
			req.setAttribute("paruserNum", paruserNum);
			req.setAttribute("vInfos_success", vInfos_success);		
			req.setAttribute("content",ConstantValue.RoleStudent.PAGE_TEACHER_showEVALUATERLIST);
			req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
					ConstantValue.RoleStudent.PAGE_TEACHER_showEVALUATERLIST).forward(req, resp);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
