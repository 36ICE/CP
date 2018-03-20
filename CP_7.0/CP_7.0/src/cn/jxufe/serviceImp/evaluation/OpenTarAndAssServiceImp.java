package cn.jxufe.serviceImp.evaluation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

//import com.mysql.jdbc.Connection;



import cn.jxufe.dao.TExcTarDao;
import cn.jxufe.dao.TJobAssDao;
import cn.jxufe.dao.TOpenTarDao;
import cn.jxufe.dao.TReaTarDao;
import cn.jxufe.dao.TSelAssDao;
import cn.jxufe.dao.TUserDao;
import cn.jxufe.dao.TUserExcTarDao;
import cn.jxufe.dao.TUserReaTarDao;
import cn.jxufe.daoImp.TExcTarDaoImp;
import cn.jxufe.daoImp.TOpenTarDaoImp;
import cn.jxufe.daoImp.TReaTarDaoImp;
import cn.jxufe.daoImp.TUserDaoImp;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TUser;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.service.evaluation.OpenTarAndAssService;
import cn.jxufe.service.user.TUserService;
import cn.jxufe.service.user.VInfoService;
import cn.jxufe.serviceImp.user.TUserServiceImp;
import cn.jxufe.serviceImp.user.VInfoServiceImp;

public class OpenTarAndAssServiceImp implements OpenTarAndAssService {

	
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	
	@Override
	public boolean tarAndAssStrategy(String userNum){
		
		//unitId找到班级名单userIds
		//获得学期
		//事务开启
		//改变jobass状态
		//改变selfass状态
		//改变userexctar状态
		//改变userreatar状态
		//事务处理提交
		VInfoService vInfoService=new VInfoServiceImp();
		//TJobAssDao tJobAssDao=new TJobAssDaoImp();	
		String sql_jobass;
		//TSelAssDao tSelAssDao=new TSelAssDaoImp();
		String sql_selass;
	//	TUserExcTarDao tUserExcTarDao=new TUserExcTarDaoImp();
		String sql_userExcTar;
		//TUserReaTarDao tUserReaTarDao=new TUserReaTarDaoImp();
		String sql_userReaTar;
		TExcTarDao tExcTarDao=new TExcTarDaoImp();
		
		TReaTarDao tReaTarDao=new TReaTarDaoImp();

		try {
			//1.获得班级号
			VInfo vInfo1=vInfoService.findVInfoByUserNum(userNum);
			int unitId=vInfo1.getUnitId();
			

			//2.获得学期号
			TUserDao tUserDao=new TUserDaoImp();
			TUser tUser =tUserDao.findAllByUserNum(userNum);
			int year=tUser.getYear();
			TUserService tUserService=new TUserServiceImp();		
			int termNum=tUserService.getTermNumByYear(year);
			
			Collection<VInfo> vInfos=null ;
			try {
				conn = DbcpConnection.getConnection();
				//4获得班级名单
				vInfos =vInfoService.findVInfosbyUnitId(unitId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null != vInfos){
				Iterator<VInfo> it=vInfos.iterator();
				
				while(it.hasNext()){
					VInfo vInfo=(VInfo)it.next();
					int userId=vInfo.getUserId();
					
					//5.获得外键
					int exctar_key=tExcTarDao.getTExctarKey();
					int reatar_key=tReaTarDao.getTReatarKey();
					//sql语句
					sql_jobass="INSERT INTO tjobass(userId) VALUES('" + userId+ "');";
					sql_selass="INSERT INTO tselass(userId) VALUES('" + userId+ "');";
					sql_userExcTar="INSERT INTO tuserexctar(userId,termNum,excTarId) VALUES('"+ userId+ "','"+termNum+"','"+exctar_key+"');";
					sql_userReaTar="INSERT INTO tuserreatar(userId,termNum,reaTarId) VALUES('"+ userId+ "','"+termNum+"','"+reatar_key+"');";
					//6.开启事务
					conn.setAutoCommit(false);// 更改JDBC事务的默认提交方式 
					
					//7.插入jobass
					pst = conn.prepareStatement(sql_jobass);
					pst.executeUpdate();
					
					//8.插入selass
					pst = conn.prepareStatement(sql_selass);
					pst.executeUpdate();
					
					//9.插入userExcTar
					pst = conn.prepareStatement(sql_userExcTar);
					pst.executeUpdate();
					
					//10.插入userexc
					pst = conn.prepareStatement(sql_userReaTar);
					pst.executeUpdate();
					
					
				}
				//11.写入开启规划表
				TOpenTarDao tOpenTarDao=new TOpenTarDaoImp();
				
				tOpenTarDao.addOpenTar(unitId, termNum);
						
				
				//12.提交事务
				conn.commit();//提交JDBC事务 
				conn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
				conn.close();
				return true;
			}
			
		} catch (Exception e) {
			try {
				if(null!=conn){
					conn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
					conn.close();
					//回滚JDBC事务 
					conn.rollback();
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		return false;
		
	}
	/*
	public boolean InsertTJobAss(int userId,int termNum,int evauserId)throws Exception{
		String sql = "INSERT INTO tjobass(userId,termNum,evauserId) VALUES('" + 
				userId+ "','" + termNum + "','"+evauserId+"');";
		System.out.println(sql);
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}*/
}
