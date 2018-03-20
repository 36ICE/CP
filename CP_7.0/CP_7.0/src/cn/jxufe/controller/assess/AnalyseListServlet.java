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
import cn.jxufe.dao.TUserDao;
import cn.jxufe.dao.vdao.VTarDao;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.daoImp.vdaoImp.VTarDaoImp;
import cn.jxufe.domain.TUser;
import cn.jxufe.domain.ventity.VAvgEva;
import cn.jxufe.domain.ventity.VEvaDatas;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.domain.ventity.VTar;
import cn.jxufe.service.assess.VAvgEvaService;
import cn.jxufe.service.evaluation.VTarService;
import cn.jxufe.service.permission.RoleService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.service.user.VInfoService;
import cn.jxufe.serviceImp.assess.VAvgEvaServiceImp;
import cn.jxufe.serviceImp.evaluation.VTarServiceImp;
import cn.jxufe.serviceImp.permission.RoleServiceImp;
import cn.jxufe.serviceImp.user.TUserServiceImp;
import cn.jxufe.serviceImp.user.VInfoServiceImp;

/**
 * @author Administrator
 * 教师访问 ，列表
 */
public class AnalyseListServlet extends HttpServlet {

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
	    //int termNum=Integer.parseInt(req.getParameter("termNum"));
		RoleService roleService=new RoleServiceImp();
		VInfoService vInfoService =new VInfoServiceImp();
		try {
			if(roleService.isRole(userNum, ConstantValue.ROLE_TEACHER) ){
				System.out.println(userNum);
				VInfo vInfo;
				vInfo=vInfoService.findVInfoByUserNum(userNum);
				
				//获得学期号
				TUserDao tUserDao=new TUserDaoImp();
				TUser tUser =tUserDao.findAllByUserNum(userNum);
				int year=tUser.getYear();
				TUserService tUserService=new TUserServiceImp();		
				int termNum=tUserService.getTermNumByYear(year);
				//
				String unitName=vInfo.getUnitName();
				int unitId=vInfo.getUnitId();
				System.out.println(unitName);
				Collection<VInfo> vInfos=vInfoService.findVInfosbyUnitId(unitId);
				Collection<InfoList> infoLists=calculate(vInfos,termNum);
				
				JSONArray jsArr = new JSONArray();
	
				jsArr=JSONArray.fromObject(infoLists);
				
				System.out.println("jsArr java:"+jsArr);
				req.setAttribute("unitName", unitName);
				req.setAttribute("jsArr", jsArr);		
				req.setAttribute("content",ConstantValue.RoleTeacher.PAGE_TEACHER_showANALYSELIST_JSP);
				req.getRequestDispatcher(ConstantValue.RoleTeacher.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleTeacher.PAGE_TEACHER_showANALYSELIST_JSP).forward(req, resp);
				
			}else if((roleService.isRole(userNum, ConstantValue.ROLE_ADMIN) )){
				VTarService vTarService=new VTarServiceImp();
				String departName=vInfoService.findVInfoByUserNum(userNum).getDepartName();
				Collection<VTar> vTars=vTarService.findVTarsByDepartName(departName);
				JSONArray jsArr=JSONArray.fromObject(vTars);
				req.setAttribute("jsArr", jsArr);
				req.setAttribute("content",ConstantValue.RoleAdmin.PAGE_ADMIN_SHOWTARLIST_JSP);
				req.getRequestDispatcher(ConstantValue.RoleAdmin.PAGE_TEMPLETE_INDEX_JSP+"?content="+
						ConstantValue.RoleAdmin.PAGE_ADMIN_SHOWTARLIST_JSP).forward(req, resp);
				
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
	
	public Collection<InfoList> calculate(Collection<VInfo> vInfos,int termNum){

		
    	VAvgEva vAvgEva =new VAvgEva();
    	Collection<InfoList> infoList=new ArrayList<>();
    	VAvgEvaService VAvgEvaDao=new VAvgEvaServiceImp();
    //	ArrayList<VEvaDatas> vEvaDatass=new ArrayList<>();
    	int i=0;
    	try {
			
			 Iterator<VInfo>	it=vInfos.iterator();
		        while(it.hasNext()){
		        	VInfo vInfo=it.next();
		        	String userNum=vInfo.getUserNum();
		        	int    unitId=vInfo.getUnitId();
		        	vAvgEva=VAvgEvaDao.selectByUserNumAndUnitIdAndTermNum(userNum, unitId, termNum);		
					int grade=(int) (vAvgEva.getgClubEvent()+vAvgEva.getgExtraLearn()+vAvgEva.getgInterpersonal()+vAvgEva.getgManageMoney()+vAvgEva.gMentalHealth+vAvgEva.getgNonProLea()+vAvgEva.getgPhyHealth()+vAvgEva.getgProLea()+vAvgEva.getgSocialEvent());				
					infoList.add(new InfoList(vInfo.getUserNum(),vInfo.getUserName(),grade));
					i++;
		        }
		} catch (Exception e1) {
			e1.printStackTrace();
		}
       
    	return infoList;
    	
	}
	public class InfoList{
		public InfoList(String userNum,String userName,int grade) {
			this.userName=userName;
			this.userNum=userNum;
			this.grade=grade;
		}
		public InfoList() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
		 */
		private String userNum;
		/**
		 * 
		 */
		private String userName;

		/**
		 * 
		 */
		private String unitName;
		
		
		/**
		 * 
		 */
		private int    grade;


		public String getUserNum() {
			return userNum;
		}


		public void setUserNum(String userNum) {
			this.userNum = userNum;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getUnitName() {
			return unitName;
		}


		public void setUnitName(String unitName) {
			this.unitName = unitName;
		}


		public int getGrade() {
			return grade;
		}


		public void setGrade(int grade) {
			this.grade = grade;
		}
		
	}



	
}
