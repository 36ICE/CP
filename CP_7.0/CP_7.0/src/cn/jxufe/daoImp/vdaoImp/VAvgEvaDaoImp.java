package cn.jxufe.daoImp.vdaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import cn.jxufe.dao.vdao.VAvgEvaDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VAvgEva;

public class VAvgEvaDaoImp implements VAvgEvaDao {
	private java.sql.PreparedStatement pst, avgpst= null;
	private Connection conn = null;
	@Override
	public Collection<VAvgEva> selectByUserIdAndUnitId(int userId, int unitId)
			throws Exception {
		//select avg(gproLea) ,userId from vavgeva where unitId='13' and userNum ='0144206'vGROUP BY termNum
		
		/*
		 *
		 * select avg(gproLea) As gproLea ,
			avg(gclubEvent)AS gclubEvent,
			avg(gextraLearn) AS gextraLearn,
			avg(ginterpersonal) AS ginterpersonal,
			avg(gmanageMoney) AS gmanageMoney ,
			avg(gmentalHealth) AS gmentalHealth,
			avg(gnonProLea) AS gnonProLea,
			avg(gphyHealth) AS gphyHealth,
			avg(gphyHealth) AS gphyHealth,
			avg(gsocialEvent)AS gsocialEvent
			 from vavgeva 
			where unitId='13' and userNum ='0144206'
			GROUP BY termNum
			
		 */
		String sql="select avg(gproLea) As gproLea ,avg(gclubEvent)AS gclubEvent,avg(gextraLearn) AS gextraLearn,"+
			"avg(ginterpersonal) AS ginterpersonal,avg(gmanageMoney) AS gmanageMoney ,"+
				"avg(gmentalHealth) AS gmentalHealth,avg(gnonProLea) AS gnonProLea,"+
					"avg(gphyHealth) AS gphyHealth,avg(gphyHealth) AS gphyHealth,avg(gsocialEvent)AS gsocialEvent"+
			          " from vavgeva where unitId='"+unitId+"' and userId ='"+userId+"' GROUP BY termNum";
		Collection <VAvgEva> vAvgEvas=new ArrayList<VAvgEva>();
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				VAvgEva vAvgEva=new VAvgEva();
				vAvgEva.setgClubEvent(rs.getLong("gclubEvent"));
				vAvgEva.setgExtraLearn(rs.getLong("gextraLearn"));
				vAvgEva.setgInterpersonal(rs.getLong("ginterpersonal"));
				vAvgEva.setgManageMoney(rs.getLong("gmanageMoney"));
				vAvgEva.setgMentalHealth(rs.getLong("gmentalHealth"));
				vAvgEva.setgNonProLea(rs.getLong("gnonProLea"));
				vAvgEva.setgPhyHealth(rs.getLong("gphyHealth"));
				vAvgEva.setgProLea(rs.getLong("gproLea"));
				vAvgEva.setgSocialEvent(rs.getLong("gsocialEvent"));
		
				vAvgEva.setEvauserId(rs.getInt("evauserId"));
				vAvgEva.setTermNum(rs.getInt("termNum"));
				vAvgEva.setUnitId(rs.getInt("unitId"));
				vAvgEva.setUserId(rs.getInt("userId"));
				vAvgEva.setUserName(rs.getString("userName"));
				vAvgEva.setUserNum(rs.getString("userNum"));
				
				vAvgEvas.add(vAvgEva);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			return null;
		} finally {
			pst.close();
			conn.close();
		}
		return vAvgEvas;
		
	}

	@Override
	public Collection<VAvgEva> selectByUserNumAndUnitId(String userNum,
			int unitId) throws Exception {
		
		String sql="select termNum,avg(gproLea) As gproLea ,avg(gclubEvent)AS gclubEvent,avg(gextraLearn) AS gextraLearn,"+
				"avg(ginterpersonal) AS ginterpersonal,avg(gmanageMoney) AS gmanageMoney ,"+
					"avg(gmentalHealth) AS gmentalHealth,avg(gnonProLea) AS gnonProLea,"+
						"avg(gphyHealth) AS gphyHealth,avg(gphyHealth) AS gphyHealth,avg(gsocialEvent)AS gsocialEvent"+
				          " from vavgeva where unitId='"+unitId+"' and userNum ='"+userNum+"' GROUP BY termNum";
		//and submit ='success'
		Collection <VAvgEva> vAvgEvas=new ArrayList<VAvgEva>();
		System.out.println(sql);
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			while(rs.next()){	
				VAvgEva vAvgEva=new VAvgEva();
				vAvgEva.setgClubEvent(rs.getLong("gclubEvent"));
				vAvgEva.setgExtraLearn(rs.getLong("gextraLearn"));
				vAvgEva.setgInterpersonal(rs.getLong("ginterpersonal"));
				vAvgEva.setgManageMoney(rs.getLong("gmanageMoney"));
				vAvgEva.setgMentalHealth(rs.getLong("gmentalHealth"));
				vAvgEva.setgNonProLea(rs.getLong("gnonProLea"));
				vAvgEva.setgPhyHealth(rs.getLong("gphyHealth"));
				vAvgEva.setgProLea(rs.getLong("gproLea"));
				vAvgEva.setgSocialEvent(rs.getLong("gsocialEvent"));
		
				//vAvgEva.setEvauserId(rs.getInt("evauserId"));
				vAvgEva.setTermNum(rs.getInt("termNum"));
				//vAvgEva.setUnitId(rs.getInt("unitId"));
				//vAvgEva.setUserId(rs.getInt("userId"));
				//vAvgEva.setUserName(rs.getString("userName"));
				//vAvgEva.setUserNum(rs.getString("userNum"));
				
				vAvgEvas.add(vAvgEva);
			}
			rs.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
			e.printStackTrace();
			
			return null;
		} finally {
			if(null != conn){
				conn.close();
			}
			
		}
		return vAvgEvas;
	}

	@Override
	public VAvgEva selectByUserNumAndUnitIdAndTermNum(String userNum,
			int unitId,int termNum) throws Exception {
		
		String sql="select termNum,avg(gproLea) As gproLea ,avg(gclubEvent)AS gclubEvent,avg(gextraLearn) AS gextraLearn,"+
				"avg(ginterpersonal) AS ginterpersonal,avg(gmanageMoney) AS gmanageMoney ,"+
					"avg(gmentalHealth) AS gmentalHealth,avg(gnonProLea) AS gnonProLea,"+
						"avg(gphyHealth) AS gphyHealth,avg(gphyHealth) AS gphyHealth,avg(gsocialEvent)AS gsocialEvent"+
				          " from vavgeva where unitId='"+unitId+"' and userNum ='"+userNum+"'and submit ='success' and termNum='"+termNum+"' GROUP BY termNum";
		//VAvgEva vAvgEvas=new VAvgEva();
		VAvgEva vAvgEva=new VAvgEva();
		System.out.println(sql);
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				
				vAvgEva.setgClubEvent(rs.getLong("gclubEvent"));
				vAvgEva.setgExtraLearn(rs.getLong("gextraLearn"));
				vAvgEva.setgInterpersonal(rs.getLong("ginterpersonal"));
				vAvgEva.setgManageMoney(rs.getLong("gmanageMoney"));
				vAvgEva.setgMentalHealth(rs.getLong("gmentalHealth"));
				vAvgEva.setgNonProLea(rs.getLong("gnonProLea"));
				vAvgEva.setgPhyHealth(rs.getLong("gphyHealth"));
				vAvgEva.setgProLea(rs.getLong("gproLea"));
				vAvgEva.setgSocialEvent(rs.getLong("gsocialEvent"));
		
				//vAvgEva.setEvauserId(rs.getInt("evauserId"));
				vAvgEva.setTermNum(rs.getInt("termNum"));
				//vAvgEva.setUnitId(rs.getInt("unitId"));
				//vAvgEva.setUserId(rs.getInt("userId"));
				//vAvgEva.setUserName(rs.getString("userName"));
				//vAvgEva.setUserNum(rs.getString("userNum"));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		} finally {
			if(null != conn){
				conn.close();
			}
			
		}
		return vAvgEva;
	}

}
