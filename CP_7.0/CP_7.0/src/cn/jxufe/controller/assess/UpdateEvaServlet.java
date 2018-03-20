package cn.jxufe.controller.assess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.domain.TEvaluate;
import cn.jxufe.service.evaluation.TEvaluateService;
import cn.jxufe.service.evaluation.TEvaluaterService;
import cn.jxufe.serviceImp.evaluation.TEvaluateServiceImp;
import cn.jxufe.serviceImp.evaluation.TEvaluaterServiceImp;

public class UpdateEvaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		HttpSession session;
		session = req.getSession(true);

		String paruserNum=req.getParameter("paruserNum");
		
	    TEvaluate tEvaluate=new TEvaluate();
	    int eveluaterId=Integer.parseInt(req.getParameter("eveluaterId"));
	    //找到评价人的id
	    tEvaluate.setEveluaterId(Long.parseLong(req.getParameter("eveluaterId")));
	    //插入评价及usereva表
	 
	    tEvaluate.setgClubEvent(Long.parseLong(req.getParameter("gClubEvent")));
	    tEvaluate.setgExtraLearn(Long.parseLong(req.getParameter("gExtraLearn")));
	    tEvaluate.setgInterpersonal(Long.parseLong(req.getParameter("gInterpersonal")));
	    tEvaluate.setgManageMoney(Long.parseLong(req.getParameter("gManageMoney")));
	    tEvaluate.setgMentalHealth(Long.parseLong(req.getParameter("gMentalHealth")));
	    tEvaluate.setgNonProLea(Long.parseLong(req.getParameter("gNonProLea")));
	    tEvaluate.setgPhyHealth(Long.parseLong(req.getParameter("gPhyHealth")));
	    tEvaluate.setgProLea(Long.parseLong(req.getParameter("gProLea")));
	    
	    TEvaluateService tEvaluateService =new TEvaluateServiceImp();
	    try {
	    	//插入
	    	
			tEvaluateService.update((int)tEvaluate.getEveluaterId(),tEvaluate);
			//改标志符
			TEvaluaterService tEvaluaterService=new TEvaluaterServiceImp();
			
			if(tEvaluaterService.changeSubmitState(eveluaterId)){

				req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
				req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
			}else{
				req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_FAIL_JSP);
				req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_FAIL_JSP).forward(req, resp);
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
