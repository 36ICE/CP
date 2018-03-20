package cn.jxufe.controller.analyse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.domain.ventity.VAvgEva;
import cn.jxufe.domain.ventity.VEvaDatas;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.assess.VAvgEvaService;
import cn.jxufe.service.evaluation.VTarService;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.service.user.VInfoService;
import cn.jxufe.serviceImp.assess.VAvgEvaServiceImp;
import cn.jxufe.serviceImp.evaluation.VTarServiceImp;
import cn.jxufe.serviceImp.permission.RoleServiceImp;
import cn.jxufe.serviceImp.user.VInfoServiceImp;

/**
 * 横向比较      各项目标的平均值
 * @author Administrator
 *
 */
public class BroadwiseServlet extends HttpServlet {

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
		HttpSession session;
		session = req.getSession(true);

		String userNum=(String)session.getAttribute("userNum");
		String paruserNum=req.getParameter("paruserNum");
	
	    try {
	    	VInfoService vInfoService =new VInfoServiceImp();
	    	VInfo vInfo;
			vInfo=vInfoService.findVInfoByUserNum(userNum);
	    	int unitId=vInfo.getUnitId();
	    	ArrayList<VAvgEva> vAvgEvas =new ArrayList<VAvgEva>();
	    	ArrayList<VEvaDatas> vEvaDatass=new ArrayList<>();
	    	
	    	

			RoleService roleService=new RoleServiceImp();
			if(roleService.isRole(userNum, ConstantValue.ROLE_TEACHER) ){
				
				VAvgEvaService VAvgEvaDao=new VAvgEvaServiceImp();
		    	vAvgEvas=(ArrayList<VAvgEva>) VAvgEvaDao.findVAvgEvaByuserNumAndUnitId(paruserNum, unitId);
		    	
				for( int i=0;i<vAvgEvas.size();i++){
					VEvaDatas vEvaDatas=new VEvaDatas(vAvgEvas.get(i));
					vEvaDatass.add(vEvaDatas);
				}
				
				req.setAttribute("paruserNum", paruserNum);
				req.setAttribute("vEvaDatass", vEvaDatass);
				req.setAttribute("content",ConstantValue.RoleTeacher.PAGE_TEACHER_LINE_JSP);
				req.getRequestDispatcher(ConstantValue.RoleTeacher.PAGE_TEMPLETE_INDEX_JSP).forward(req, resp);
			}else if((roleService.isRole(userNum, ConstantValue.ROLE_STUDENT) )){
				
				VAvgEvaService VAvgEvaDao=new VAvgEvaServiceImp();
		    	vAvgEvas=(ArrayList<VAvgEva>) VAvgEvaDao.findVAvgEvaByuserNumAndUnitId(userNum, unitId);
		    	
				for( int i=0;i<vAvgEvas.size();i++){
					VEvaDatas vEvaDatas=new VEvaDatas(vAvgEvas.get(i));
					vEvaDatass.add(vEvaDatas);
				}
				
				req.setAttribute("paruserNum", userNum);
				req.setAttribute("vEvaDatass", vEvaDatass);
				req.setAttribute("content",ConstantValue.RoleStudent.PAGE_STUDENT_LINE_JSP);
				req.getRequestDispatcher(ConstantValue.RoleStudent.PAGE_TEMPLETE_INDEX_JSP).forward(req, resp);
			}else if((roleService.isRole(userNum, ConstantValue.ROLE_ADMIN) )){
				
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
