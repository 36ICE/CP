package cn.jxufe.controller.assess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TSelAss;
import cn.jxufe.service.assess.TJobAssService;
import cn.jxufe.service.assess.TSelAssService;
import cn.jxufe.serviceImp.assess.TJobAssServiceImp;
import cn.jxufe.serviceImp.assess.TSelAssServiceImp;

public class UpdateSelAssessServlet extends HttpServlet {

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
		
		HttpSession session=req.getSession(true);
		String userNum=(String)session.getAttribute("userNum");
		
		try {
			String colName=req.getParameter("colName");
			String colValue=req.getParameter("colValue");
			//编码转换
			//String colName = URLEncoder.encode(new String(req.getParameter("colName").toString().getBytes("Gbk")), "UTF-8");  
			//获取name 对应的修改值
			//String colValue=URLEncoder.encode(new String(req.getParameter("colValue").toString().getBytes("UTF-8")), "UTF-8");
			TSelAss tSelAss=null;
			TSelAssService tSelAssService=new TSelAssServiceImp();

			if(tSelAssService.updateTSelAss(userNum, colName, colValue)){
				
				tSelAss=tSelAssService.selectTSelAss(userNum);
				if(null==tSelAss.getSubmit()){	
					
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP).forward(req, resp);
				}else if(tSelAss.getSubmit().equals(ConstantValue.FAIL)){
					
					req.setAttribute("tSelAss", tSelAss);
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_updateSELASS_JSP);
					//操作成功，刷新数据更新页面
					req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+
					   "?content="+ConstantValue.RoleStudent.PAGE_STUDENT_updateSELASS_JSP+
					   	   "&userNum="+userNum).forward(req, resp);
				}else{
					req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
				}
				
			}else{
				req.setAttribute("content",ConstantValue.PAGE_ERROE);
				//操作失败跳转错误页面
				req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP).forward(req, resp);
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
