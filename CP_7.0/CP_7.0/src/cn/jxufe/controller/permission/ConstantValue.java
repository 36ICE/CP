package cn.jxufe.controller.permission;

public final class ConstantValue {
 
	//角色常量
	public static final String ROLE_TEACHER = "teacher";
	public static final String ROLE_STUDENT = "student";
	public static final String ROLE_ADMIN   = "admin";
	
	
	//标识字符
	public static final String SUCCESS   = "success";
	public static final String FAIL   = "fail";
	
	public static final String PAGE_ERROE="error.jsp";
	public static final String PAGE_LOGIN_ERROE="loginerror.jsp";
	//private static final RoleStudent RoleStudent = new RoleStudent();
	
	public static Object getRole(String roleName){
		if(roleName.equals(ROLE_STUDENT)){
			return new RoleStudent();
		}else if(roleName.equals(ROLE_TEACHER)){
			return new RoleTeacher();
		}else if(roleName.equals(ROLE_ADMIN)){
			return new RoleAdmin();
		}else{
			return null;
		}
		
		
	}
	public   final static  class RoleStudent{
	
		//student file
		public static final String FILE_STUDENT	=	"student/";
		
		//templete
		public static final String PAGE_TEMPLETE_INDEX_JSP="sindex.jsp";
		public static final String PAGE_TEMPLETE_NAV_JSP="nav.jsp";
		public static final String PAGE_TEMPLETE_SIDER="ssidebar.jsp";
		
		//student page ，数据操作页面
		public static final String PAGE_STUDENT_SHOUYE_JSP="sshouye.jsp";
		
		//修改页面，填写
		public static final String PAGE_STUDENT_NOTOPEN_JSP="notopen.jsp";
		
		public static final String PAGE_STUDENT_updateJOBASS_JSP="supdatejobass.jsp";
		public static final String PAGE_STUDENT_updateSELASS_JSP="supdateselass.jsp";
		public static final String PAGE_STUDENT_updateEXCTAR_JSP="supdateexctar.jsp";
		public static final String PAGE_STUDENT_updateREATAR_JSP="supdatereatar.jsp";
		public static final String PAGE_STUDENT_updateEVALUATE_JSP="supdateevaluate.jsp";
		
		//显示页面
		public static final String PAGE_STUDENT_showJOBASS_JSP="sshowjobass.jsp";
		public static final String PAGE_STUDENT_showSELASS_JSP="sshowselass.jsp";
		public static final String PAGE_STUDENT_showTAR="sshowtar.jsp";
		
		
		public static final String PAGE_TEACHER_showEVALUATERLIST="sevaluaterlist.jsp";
		//提交任务完成页面
		public static final String PAGE_STUDENT_SUBMIT_JSP="ssubmit.jsp";
		public static final String PAGE_STUDENT_FAIL_JSP="sfail.jsp";
		
		public static final String PAGE_STUDENT_showEXCTAR_JSP="sshowexctar.jsp";
		public static final String PAGE_STUDENT_showREATAR_JSP="sshowreatar.jsp";
		
		public static final String PAGE_STUDENT_LINE_JSP="Line1.jsp";
		//error
		public static final String PAGE_ERROE="error.jsp";
	}
	
	

	public  final static class RoleTeacher{
			
		//teacher file
		public static final String FILE_TEACHER	=	"teacher/";
		
		//templete
		public static final String PAGE_TEMPLETE_INDEX_JSP="tindex.jsp";
		public static final String PAGE_TEMPLETE_NAV_JSP="nav.jsp";
		public static final String PAGE_TEMPLETE_SIDER="tsidebar.jsp";
		
		//teacher page ，数据操作页面
		public static final String PAGE_TEACHER_SHOUYE_JSP="tshouye.jsp";
		
		public static final String PAGE_TEACHER_showJOBASS_JSP="tshowjobass.jsp";
		public static final String PAGE_TEACHER_showSELASS_JSP="tshowselass.jsp";
		public static final String PAGE_TEACHER_showTAR="tshowtar.jsp";
		
		public static final String PAGE_TEACHER_showJOBASSLIST_JSP="tshowjobasslist.jsp";
		public static final String PAGE_TEACHER_showSELASSLIST_JSP="tshowselasslist.jsp";
		public static final String PAGE_TEACHER_showANALYSELIST_JSP="tanalyselist.jsp";
		public static final String PAGE_TEACHER_showTARLIST="tshowtarlist.jsp";
		
		
		public static final String PAGE_TEACHER_updateSTUDENTLIST="tstudentlist.jsp";
		
		//数据分析页面
		
		
		public static final String PAGE_TEACHER_BAR_JSP="tbroadwise.jsp";
		public static final String PAGE_TEACHER_LINE_JSP="Line1.jsp";
		//error
		public static final String PAGE_ERROE="error.jsp";
	}
	
	public  final static class RoleAdmin{
		
		
		//admin file
		public static final String FILE_ADMIN	=	"admin/";
		
		//templete
		public static final String PAGE_TEMPLETE_INDEX_JSP="aindex.jsp";
		public static final String PAGE_TEMPLETE_NAV_JSP="nav.jsp";
		public static final String PAGE_TEMPLETE_SIDER="sidebar.jsp";
		
		//admin page
		public static final String PAGE_ADMIN_SHOUYE_JSP="ashouye.jsp";
		public static final String PAGE_ADMIN_JOBASS_JSP="jobAss.jsp";
		public static final String PAGE_ADMIN_SELASS_JSP="selAss.jsp";
		public static final String PAGE_ADMIN_Tar_JSP="Tar.jsp";
		public static final String PAGE_ADMIN_SHOWTARLIST_JSP="TarList.jsp";
		
				//error
		public static final String PAGE_ERROE="error.jsp";
	}


	
	
	
	
}
