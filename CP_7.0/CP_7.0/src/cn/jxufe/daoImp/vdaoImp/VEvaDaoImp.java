package cn.jxufe.daoImp.vdaoImp;

import java.sql.Connection;
import java.sql.ResultSet;

import cn.jxufe.dao.vdao.VEvaDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VEva;
import cn.jxufe.domain.ventity.VTar;

public class VEvaDaoImp implements VEvaDao {

	private java.sql.PreparedStatement pst, avgpst= null;
	private Connection conn = null;
	@Override
	public VEva findByUserNum(String userNum, int termNum) throws Exception {
		
		String sql="select * from veva where userNum='"+userNum+"' and rtermNum='"+termNum+"';";
		/*String avgsql="select AVG(`evaluateId`)AS evaluateId,AVG(`gproLea`) AS gproLea,AVG( `gnonProLea`),AVG(`gextraLearn`),AVG(`gphyHealth`),"+
		"AVG( `gmentalHealth`),AVG( `gmanageMoney`),AVG(`ginterpersonal`),AVG( `gclubEvent`),AVG(`gsocialEvent`)"+
				"from vavgeva WHERE userId='"+userId+"'and termNum='"+termNum+"';";*/
		VEva vEva=new VEva();
		System.out.println(sql);
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			//avgpst=conn.prepareStatement(avgsql);
			//ResultSet avgrs=avgpst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				//vTar.setEveluaterId(rs.getLong("evaluateId"));
				
				
				vEva.seteClubEvent(rs.getString("eclubEvent"));
				vEva.seteExtraLearn(rs.getString("eextraLearn"));
				vEva.seteInterpersonal(rs.getString("einterpersonal"));
				vEva.seteManageMoney(rs.getString("emanageMoney"));
				vEva.seteMentalHealth(rs.getString("ementalHealth"));
				vEva.seteNonProLea(rs.getString("enonProLea"));
				vEva.setePhyHealth(rs.getString("ephyHealth"));
				vEva.seteProLea(rs.getString("eproLea"));
				vEva.seteSocialEvent(rs.getString("esocialEvent"));
				
				vEva.setrClubEvent(rs.getString("rclubEvent"));
				vEva.setrExtraLearn(rs.getString("rextraLearn"));
				vEva.setrInterpersonal(rs.getString("rinterpersonal"));
				vEva.setrManageMoney(rs.getString("rmanageMoney"));
				vEva.setrMentalHealth(rs.getString("rmentalHealth"));
				vEva.setrNonProLea(rs.getString("rnonProLea"));
				vEva.setrPhyHealth(rs.getString("rphyHealth"));
				vEva.setrProLea(rs.getString("rproLea"));
				vEva.setrSocialEvent(rs.getString("rsocialEvent"));
				
				vEva.setEtermNum((int)rs.getLong("etermNum"));
				vEva.setRtermNum((int)rs.getLong("rtermNum"));
				vEva.setUserNum(rs.getString("userNum"));
				vEva.setUserName(rs.getString("username"));
				//vEva.setDepartId(rs.getLong("departId"));
				//vEva.setDepartName(rs.getNString("departName"));
				//tDepart.setDepartNum(rs.getNString("DepartNum"));
				
				//vEva.setUnitId(rs.getLong("unitId"));
				//vEva.setUnitName(rs.getNString("unitName"));
				//vEva.setTermNum(rs.getLong("termNum"));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			
		} finally {
			pst.close();
			conn.close();
		}
		return vEva;
	}

}
