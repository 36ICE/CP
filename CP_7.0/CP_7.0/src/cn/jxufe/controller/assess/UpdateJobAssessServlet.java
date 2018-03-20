package cn.jxufe.controller.assess;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.controller.permission.ConstantValue.RoleStudent;
import cn.jxufe.dao.TJobAssDao;
import cn.jxufe.daoImp.TJobAssDaoImp;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.service.assess.TJobAssService;
import cn.jxufe.serviceImp.assess.TJobAssServiceImp;

public class UpdateJobAssessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
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
			TJobAss tJobAss=null;
			TJobAssService tJobAssService=new TJobAssServiceImp();

			
			if(tJobAssService.updateTJobAss( userNum,colName, colValue)){
				
			
				tJobAss=tJobAssService.selectTJobAss(userNum);
				if(null==tJobAss.getSubmit()){	
					req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_NOTOPEN_JSP).forward(req, resp);
				}else if(tJobAss.getSubmit().equals(ConstantValue.FAIL)){
				req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_updateJOBASS_JSP);
				req.setAttribute("tJobAss", tJobAss);
				//操作成功，刷新数据更新页面
				req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP+
						"?content="+ConstantValue.RoleStudent.PAGE_STUDENT_updateJOBASS_JSP+"&userNum="+userNum).forward(req, resp);
				}else{
					req.setAttribute("content", ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP);
					req.getRequestDispatcher(RoleStudent.PAGE_TEMPLETE_INDEX_JSP+"?content="+
							ConstantValue.RoleStudent.PAGE_STUDENT_SUBMIT_JSP).forward(req, resp);
				}
				
			}else{
				req.setAttribute("content", ConstantValue.PAGE_ERROE);
				//操作失败跳转失败页面
				req.getRequestDispatcher(ConstantValue.PAGE_ERROE).forward(req, resp);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req,resp);
	}
	

}
