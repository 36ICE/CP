package cn.jxufe.controller.assess;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import cn.jxufe.controller.permission.ConstantValue;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.evaluation.VTarService;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.service.user.VInfoService;
import cn.jxufe.serviceImp.evaluation.VTarServiceImp;
import cn.jxufe.serviceImp.permission.RoleServiceImp;
import cn.jxufe.serviceImp.user.VInfoServiceImp;

public class ShowTarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session;
		session = req.getSession(true);

	
		String userNum=(String)session.getAttribute("userNum");
	    int termNum=Integer.parseInt(req.getParameter("termNum"));
		//VTar vTar=new VTar();
		VTarService vTarService=new VTarServiceImp();
		RoleService roleService=new RoleServiceImp();
		VInfoService vInfoService =new VInfoServiceImp();
		
		try {
			if(roleService.isRole(userNum, ConstantValue.ROLE_TEACHER) ){
				System.out.println(userNum);
				VInfo vInfo;
				vInfo=vInfoService.findVInfoByUserNum(userNum);
			
				String unitName=vInfo.getUnitName();
				String userName=vInfo.getUserName();
				System.out.println(unitName);
				
				VTar vTar=new VTar();
				String paruserNum=(String)req.getParameter("paruserNum");
				vTar=vTarService.findVTar(paruserNum, termNum);
				 req.setAttribute("vTar", vTar);
				 req.setAttribute("paruserNum", paruserNum);
				 req.setAttribute("termNum", termNum);
				 
				 req.setAttribute("content",ConstantValue.RoleTeacher.PAGE_TEACHER_showTAR);
				req.getRequestDispatcher(ConstantValue.RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleTeacher.PAGE_TEACHER_showTAR).forward(req, resp);
				
			}else if((roleService.isRole(userNum, ConstantValue.ROLE_ADMIN) )){
				String departName=vInfoService.findVInfoByUserNum(userNum).getDepartName();
				Collection<VTar> vTars=vTarService.findVTarsByDepartName(departName);
				JSONArray jsArr=JSONArray.fromObject(vTars);
				req.setAttribute("jsArr", jsArr);
				
				 req.setAttribute("content",ConstantValue.RoleAdmin.PAGE_ADMIN_SHOWTARLIST_JSP);
				req.getRequestDispatcher(ConstantValue.RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleAdmin.PAGE_ADMIN_SHOWTARLIST_JSP).forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
