package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import cn.jxufe.dao.TEvaluateDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TEvaluate;
public class TEvaluateDaoImp implements TEvaluateDao {
	private String sql;
	private TEvaluate tEvaluate;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public void checkbyID(long evaluateId) throws Exception {
		// TODO Auto-generated method stub
		return ;		
	}
	@Override
	public boolean addTEvaluate(TEvaluate tEvaluate) throws Exception {
	
		sql = "INSERT INTO tevaluate(gproLea,gnonProLea,gextraLearn,gphyHealth,gmentalHealth,gmanageMoney,ginterpersonal,gclubEvent,gsocialEvent,eveluaterId) VALUES('" + 
				tEvaluate.gProLea + "','" + tEvaluate.gNonProLea + "','" + tEvaluate.gExtraLearn + "','" +tEvaluate.gPhyHealth + "','" +tEvaluate.gMentalHealth + "','" +
				tEvaluate.gManageMoney + "','" + tEvaluate.gInterpersonal + "','" + tEvaluate.gClubEvent + "','" +tEvaluate.gSocialEvent +"','" +tEvaluate.eveluaterId +"');";
		System.out.println(sql);

		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
	}

	@Override
	public boolean DeletebyEvaluateId(long evaluateId) throws Exception {
	
		Connection conn = DbcpConnection.getConnection();
	
		String sql="DELETE FROM tEvaluate WHERE evaluateId='"+evaluateId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		dbc=new DbcpConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			//conn.commit();
			stmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			stmt.close();
			conn.close();
			
		}
		
	}
	@Override
	public TEvaluate FindByEvalusteId(long tEvaluateId) throws Exception{
		tEvaluate = new TEvaluate();
		sql = "SELECT * FROM tevaluate WHERE evaluateId = '" +  tEvaluateId +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){	
				tEvaluate.evaluateId = rs.getLong("evaluateId");			
				tEvaluate.gProLea = rs.getLong("gProLea");
				tEvaluate.gNonProLea = rs.getLong("gNonProLea");
				tEvaluate.gExtraLearn = rs.getLong("gExtraLearn");
				tEvaluate.gPhyHealth = rs.getLong("gPhyHealth");
				tEvaluate.gMentalHealth = rs.getLong("gMentalHealth");
				tEvaluate.gManageMoney = rs.getLong("gManageMoney");
				tEvaluate.gInterpersonal = rs.getLong("gInterpersonal");
				tEvaluate.gClubEvent = rs.getLong("gClubEvent");
				tEvaluate.gSocialEvent = rs.getLong("gSocialEvent");
				tEvaluate.eveluaterId = rs.getLong("eveluaterId");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
		return tEvaluate;	
	}

	
	public boolean alterByEvaluateId(int evaluaterId,TEvaluate tEvaluate) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		//tEvaluate=FindByEvalusteId(tEvaluate.getEvaluateId());
		String sql="UPDATE tevaluate set gproLea='"+tEvaluate.getgProLea()+"',gnonProLea='"+tEvaluate.getgNonProLea()+
		"',gextraLearn='"+tEvaluate.getgExtraLearn()+"',gphyHealth='"+tEvaluate.getgPhyHealth()+
		"',gmentalHealth='"+tEvaluate.getgMentalHealth()+"',gmanageMoney='"+tEvaluate.getgManageMoney()+
		"',ginterpersonal='"+tEvaluate.getgInterpersonal()+"',gclubEvent='"+tEvaluate.getgClubEvent()+
		"',gsocialEvent='"+tEvaluate.getgSocialEvent()+
				"' WHERE eveluaterId='"+evaluaterId+"';";
		System.out.println(sql);
		
		Statement stmt=null;	 
		try{
			stmt=DbcpConnection.getConnection().createStatement();
			stmt.executeUpdate(sql);

			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			
			conn.close();			
		}		
	}	
}