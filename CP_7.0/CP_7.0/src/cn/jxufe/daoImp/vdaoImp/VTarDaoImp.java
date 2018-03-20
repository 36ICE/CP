package cn.jxufe.daoImp.vdaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.jxufe.dao.vdao.VTarDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TDepart;
import cn.jxufe.domain.TEvaluate;
import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;
import cn.jxufe.domain.TUnit;
import cn.jxufe.domain.ventity.VTar;

public class VTarDaoImp implements VTarDao {

	private java.sql.PreparedStatement pst, avgpst= null;
	private Connection conn = null;
	@Override
	public VTar selectTVarByUserIdAndTermNum(int userId, int termNum)
			throws Exception {
		
		String sql="select * from vtar where userId='"+userId+"' and termNum='"+termNum+"';";
		/*String avgsql="select AVG(`evaluateId`)AS evaluateId,AVG(`gproLea`) AS gproLea,AVG( `gnonProLea`),AVG(`gextraLearn`),AVG(`gphyHealth`),"+
		"AVG( `gmentalHealth`),AVG( `gmanageMoney`),AVG(`ginterpersonal`),AVG( `gclubEvent`),AVG(`gsocialEvent`)"+
				"from vavgeva WHERE userId='"+userId+"'and termNum='"+termNum+"';";*/
		System.out.println(sql);
		VTar vTar=new VTar();
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			//avgpst=conn.prepareStatement(avgsql);
			//ResultSet avgrs=avgpst.executeQuery();
			//System.out.println("视图sql："+sql);
			if(rs.next()){	
				//vTar.setEveluaterId(rs.getLong("evaluateId"));
				vTar.setgClubEvent(rs.getLong("gclubEvent"));
				vTar.setgExtraLearn(rs.getLong("gextraLearn"));
				vTar.setgInterpersonal(rs.getLong("ginterpersonal"));
				vTar.setgManageMoney(rs.getLong("gmanageMoney"));
				vTar.setgMentalHealth(rs.getLong("gmentalHealth"));
				vTar.setgNonProLea(rs.getLong("gnonProLea"));
				vTar.setgPhyHealth(rs.getLong("gphyHealth"));
				vTar.setgProLea(rs.getLong("gproLea"));
				vTar.setgSocialEvent(rs.getLong("gsocialEvent"));
				
				vTar.seteClubEvent(rs.getString("eclubEvent"));
				vTar.seteExtraLearn(rs.getString("eextraLearn"));
				vTar.seteInterpersonal(rs.getString("einterpersonal"));
				vTar.seteManageMoney(rs.getString("emanageMoney"));
				vTar.seteMentalHealth(rs.getString("ementalHealth"));
				vTar.seteNonProLea(rs.getString("enonProLea"));
				vTar.setePhyHealth(rs.getString("ephyHealth"));
				vTar.seteProLea(rs.getString("eproLea"));
				vTar.seteSocialEvent(rs.getString("esocialEvent"));
				
				vTar.setrClubEvent(rs.getString("rclubEvent"));
				vTar.setrExtraLearn(rs.getString("rextraLearn"));
				vTar.setrInterpersonal(rs.getString("rinterpersonal"));
				vTar.setrManageMoney(rs.getString("rmanageMoney"));
				vTar.setrMentalHealth(rs.getString("rmentalHealth"));
				vTar.setrNonProLea(rs.getString("rnonProLea"));
				vTar.setrPhyHealth(rs.getString("rphyHealth"));
				vTar.setrProLea(rs.getString("rproLea"));
				vTar.setrSocialEvent(rs.getString("rsocialEvent"));
				
				vTar.setDepartId(rs.getLong("departId"));
				vTar.setDepartName(rs.getNString("departName"));
				
				
				vTar.setUnitId(rs.getLong("unitId"));
				vTar.setUnitName(rs.getNString("unitName"));
				vTar.setTermNum(rs.getLong("termNum"));
				vTar.setUserName(rs.getString("userName"));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			
		} finally {
			pst.close();
			conn.close();
		}
		return vTar;
	}
	@Override
	public Collection<VTar> selectTVarByUnitId(int unitId,int termNum) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from vtar where unitId='"+unitId+"'and termNum='"+termNum+"';";
		
		Collection<VTar> vTars=new ArrayList<VTar>();
		System.out.println("public Collection<VTar> selectTVarByUnitId(int unitId) throws Exception=>sql"+sql);
		try {
			
			//TDepart tDepart=vTar.getTDepart();
			//TUnit tUnit=vTar.getTUnit();
			//TExcTar tExctar=vTar.getTexcTar();
			//TReaTar tReaTar=vTar.gettReatar();
			//TEvaluate tEvaluate=vTar.gettEvaluate();
			conn = DbcpConnection.getConnection();
			
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			while(rs.next()){	
				VTar vTar=new VTar();
				//vTar.setEveluaterId(rs.getLong("evaluateId"));
				vTar.setgClubEvent(rs.getLong("gclubEvent"));
				vTar.setgExtraLearn(rs.getLong("gextraLearn"));
				vTar.setgInterpersonal(rs.getLong("ginterpersonal"));
				vTar.setgManageMoney(rs.getLong("gmanageMoney"));
				vTar.setgMentalHealth(rs.getLong("gmentalHealth"));
				vTar.setgNonProLea(rs.getLong("gnonProLea"));
				vTar.setgPhyHealth(rs.getLong("gphyHealth"));
				vTar.setgProLea(rs.getLong("gproLea"));
				vTar.setgSocialEvent(rs.getLong("gsocialEvent"));
				
				vTar.seteClubEvent(rs.getString("eclubEvent"));
				vTar.seteExtraLearn(rs.getString("eextraLearn"));
				vTar.seteInterpersonal(rs.getString("einterpersonal"));
				vTar.seteManageMoney(rs.getString("emanageMoney"));
				vTar.seteMentalHealth(rs.getString("ementalHealth"));
				vTar.seteNonProLea(rs.getString("enonProLea"));
				vTar.setePhyHealth(rs.getString("ephyHealth"));
				vTar.seteProLea(rs.getString("eproLea"));
				vTar.seteSocialEvent(rs.getString("esocialEvent"));
				
				vTar.setrClubEvent(rs.getString("rclubEvent"));
				vTar.setrExtraLearn(rs.getString("rextraLearn"));
				vTar.setrInterpersonal(rs.getString("rinterpersonal"));
				vTar.setrManageMoney(rs.getString("rmanageMoney"));
				vTar.setrMentalHealth(rs.getString("rmentalHealth"));
				vTar.setrNonProLea(rs.getString("rnonProLea"));
				vTar.setrPhyHealth(rs.getString("rphyHealth"));
				vTar.setrProLea(rs.getString("rproLea"));
				vTar.setrSocialEvent(rs.getString("rsocialEvent"));
				
				vTar.setDepartId(rs.getLong("departId"));
				vTar.setDepartName(rs.getNString("departName"));
				//tDepart.setDepartNum(rs.getNString("DepartNum"));
				
				vTar.setUnitId(rs.getLong("unitId"));
				vTar.setUnitName(rs.getNString("unitName"));
				
				vTar.setUserName(rs.getString("userName"));
				vTar.setUserNum(rs.getString("userNum"));
				vTar.setTermNum(rs.getLong("termNum"));
				vTars.add(vTar);
			}
			
			Iterator<VTar> it = vTars.iterator(); 
			while(it.hasNext()){
				System.out.println(it.next());
			}

			rs.close();
			return  vTars;
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			return null;
		} finally {
			
			pst.close();
			conn.close();
		}
		
	}
	@Override
	public Collection<VTar> selectTVarByDepartId(int departId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from vtar where departId='"+departId+"';";
		VTar vTar=new VTar();
		Collection<VTar> vTars=new ArrayList<VTar>();
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			while(rs.next()){	
				//vTar.setEveluaterId(rs.getLong("evaluaterId"));
				vTar.setgClubEvent(rs.getLong("gclubEvent"));
				vTar.setgExtraLearn(rs.getLong("gextraLearn"));
				vTar.setgInterpersonal(rs.getLong("interpersonal"));
				vTar.setgManageMoney(rs.getLong("gmanageMoney"));
				vTar.setgMentalHealth(rs.getLong("gmentalHealth"));
				vTar.setgNonProLea(rs.getLong("gnonProLea"));
				vTar.setgPhyHealth(rs.getLong("gphyHealth"));
				vTar.setgProLea(rs.getLong("gproLea"));
				vTar.setgSocialEvent(rs.getLong("gsocialEvent"));
				
				vTar.seteClubEvent(rs.getString("eclubEvent"));
				vTar.seteExtraLearn(rs.getString("eextraLearn"));
				vTar.seteInterpersonal(rs.getString("einterpersonal"));
				vTar.seteManageMoney(rs.getString("emanageMoney"));
				vTar.seteMentalHealth(rs.getString("ementalHealth"));
				vTar.seteNonProLea(rs.getString("enonProLea"));
				vTar.setePhyHealth(rs.getString("ephyHealth"));
				vTar.seteProLea(rs.getString("eproLea"));
				vTar.seteSocialEvent(rs.getString("esocaialEvent"));
				
				vTar.setrClubEvent(rs.getString("rclubEvent"));
				vTar.setrExtraLearn(rs.getString("rextraLearn"));
				vTar.setrInterpersonal(rs.getString("rinterpersonal"));
				vTar.setrManageMoney(rs.getString("rmanageMoney"));
				vTar.setrMentalHealth(rs.getString("rmentalHealth"));
				vTar.setrNonProLea(rs.getString("rnonProLea"));
				vTar.setrPhyHealth(rs.getString("rphyHealth"));
				vTar.setrProLea(rs.getString("rproLea"));
				vTar.setrSocialEvent(rs.getString("rsocialEvent"));
				
				vTar.setDepartId(rs.getLong("departId"));
				vTar.setDepartName(rs.getNString("departName"));
				
				
				vTar.setUnitId(rs.getLong("unitId"));
				vTar.setUnitName(rs.getNString("unitName"));
				
				vTar.setTermNum(rs.getLong("termNum"));
				vTars.add(vTar);
			}
			rs.close();
			return  vTars;
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			return null;
		} finally {
			
			pst.close();
			conn.close();
		}
		
	}
	@Override
	public VTar selectTVarEvaluateByUserNumAndTermNum(String userNum,int termNum) throws Exception {
		String sql="select *from vtest where userNum='"+userNum+"' and termNum='"+termNum+"';";
		System.out.println("public VTar selectTVarEvaluateByUserNumAndTermNum(String userNum,int termNum) throws Exception:sql:"+sql);
		VTar vTar=new VTar();
		//Collection<VTar> vTars=new ArrayList<VTar>();
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				//vTar.setEveluaterId(rs.getLong("evaluaterId"));
				vTar.setgClubEvent(rs.getLong("gclubEvent"));
				vTar.setgExtraLearn(rs.getLong("gextraLearn"));
				vTar.setgInterpersonal(rs.getLong("ginterpersonal"));
				vTar.setgManageMoney(rs.getLong("gmanageMoney"));
				vTar.setgMentalHealth(rs.getLong("gmentalHealth"));
				vTar.setgNonProLea(rs.getLong("gnonProLea"));
				vTar.setgPhyHealth(rs.getLong("gphyHealth"));
				vTar.setgProLea(rs.getLong("gproLea"));
				vTar.setgSocialEvent(rs.getLong("gsocialEvent"));

			
				
				vTar.setTermNum(rs.getLong("termNum"));
				vTar.setUserName(rs.getString("userName"));
				vTar.setUserNum(rs.getString("userNum"));
				//vTar.add(vTar);
				return  vTar;
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
		return null;
	}
	

}
