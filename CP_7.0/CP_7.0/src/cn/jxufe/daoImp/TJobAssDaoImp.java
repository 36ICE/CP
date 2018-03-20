package cn.jxufe.daoImp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import cn.jxufe.dao.TJobAssDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TUser;
public class TJobAssDaoImp implements TJobAssDao {
	private String sql;
	private TJobAss tJobAss;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	
	public boolean checkByUserId(int userId) throws SQLException{
		sql="select * from tjobass where userId='"+userId+"';";
		
		System.out.println("public boolean checkByUserId(int userId):sql:"+sql);
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return false;
	}
	@Override
	public boolean addJobAss(TJobAss tJobAss) throws Exception {
		sql = "INSERT INTO tjobass(userId,employSituation,credentials,income,knowledge,prospects,qualifications,skills,suggest) VALUES('" + 
				tJobAss.tUser.userId + "','" + tJobAss.employSituation + "','" + tJobAss.credentials + "','" +tJobAss.income + "','" +tJobAss.knowledge + "','" +
				tJobAss.prospects + "','" + tJobAss.qualifications + "','" + tJobAss.skills + "','" +tJobAss.suggest +"');";
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
	public boolean addJobAssByNameAndValue(int userId,String name,String value)throws Exception{
		
		sql="insert into tjobass(userId,"+name+")values('"+userId+"','"+value+"');";
		
		System.out.println();
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate(sql)>0);
				return true;			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			try {
				if(pst!=null) pst.close();
				if(conn!=null &&!conn.isClosed()) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public boolean deleteJobAss(TUser tUser) throws Exception {
		sql = "DELETE FROM tjobass WHERE tjobass.userId = '" +  tUser.getUserId() +"';";
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
	public boolean deleteJobAss(String userNum) throws Exception {
		sql = "DELETE FROM tjobass WHERE tjobass.userId IN" + "(SELECT userId FROM tuser WHERE tuser.userNum = '" + userNum +"');";
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
	public boolean deleteManyJobAss(Collection<TUser> tUsers) throws Exception {
		for(int i = 0; i<tUsers.size(); i++)
		{
			TUser user = tUsers.iterator().next();
			deleteJobAss(user);
		}
		return false;
	}

	/*@Override
	public boolean alterJobAss(TUser tUser, TJobAss tJobAss) throws Exception {
		deleteJobAss(tUser);
		addJobAss(tJobAss);
		
	}*/

	@Override
	public TJobAss findByUser(TUser tUser) throws Exception {
		tJobAss = new TJobAss();
		sql = "SELECT * FROM tjobass WHERE tjobass.userId = '" +  tUser.getUserId() +"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tJobAss.credentials = rs.getString("credentials");
				tJobAss.employSituation = rs.getString("employSituation");
				tJobAss.income = rs.getString("income");
				tJobAss.knowledge = rs.getString("knowledge");
				tJobAss.prospects = rs.getString("prospects");
				tJobAss.qualifications = rs.getString("qualifications");
				tJobAss.skills = rs.getString("skills");
				tJobAss.suggest = rs.getString("suggest");
				tJobAss.tUser = tUser;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return tJobAss;	
	}

	@Override
	public TJobAss findByUserNum(String userNum) throws Exception {
		TUser tuser = new TUser();
		String sql2 = "SELECT * FROM tuser WHERE tuser.userNum = '" + userNum +"';";
//		sql = "SELECT * FROM tselass WHERE tselass.userId IN" + "(SELECT userId FROM tuser WHERE tuser.userNum = '" + userNum +"');";
		System.out.println(sql2);
//		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql2);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tuser.userId = rs.getInt("userId");
				tuser.code = rs.getString("code");
				tuser.userName = rs.getString("userName");
				tuser.userNum = rs.getString("userNum");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		
		return findByUser(tuser);
	}
	/* (non-Javadoc)
	 * @see cn.jxufe.dao.TJobAssDao#findByUserId(int)
	 */
	@Override
	public TJobAss findByUserId(int userId) throws Exception {
		TJobAss tJobAss=new TJobAss();
		String sql = "SELECT * FROM tjobass WHERE userId = '" + userId +"';";

		System.out.println(sql);

		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				tJobAss.setCredentials(rs.getString("credentials"));
				tJobAss.setEmploySituation(rs.getString("employSituation"));
				tJobAss.setIncome(rs.getString("income"));
				tJobAss.setJobAssId(rs.getLong("jobAssId"));
				tJobAss.setKnowledge(rs.getString("knowledge"));
				tJobAss.setProspects(rs.getString("prospects"));
				tJobAss.setQualifications(rs.getString("qualifications"));
				tJobAss.setSkills(rs.getString("skills"));
				tJobAss.setSuggest(rs.getString("suggest"));
				tJobAss.setSubmit(rs.getString("submit"));
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		
		return tJobAss;
	}

	@Override
	public int getCount() throws Exception {
		sql = "SELECT COUNT(*) FROM tjobass";
		int count = 0;
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return count;
	}
	
	public boolean updateJobAss(TJobAss tjobAss) throws Exception { 
		
		//userId,employSituation,credentials,income,knowledge,prospects,qualifications,skills,suggest
		
		 sql="update tjobAss set employSituation='"+tjobAss.getEmploySituation()+"',credentials='"+tjobAss.getCredentials()+"',income='"+
				 tjobAss.getIncome()+"',knowledge='"+tjobAss.getKnowledge()+"',prospects='"+tjobAss.getProspects()+"',qualifications='"+
				 tjobAss.getQualifications()+"',skills='"+tjobAss.getSkills()+"',suggest='"+
				 tjobAss.getSuggest()+"'where userId='"+tjobAss.getTUser().getUserId()+"';";
		
		pst = null ;  
		conn = null ;
       try{  
			conn=DbcpConnection.getConnection();
			pst = DbcpConnection.getConnection().prepareStatement(sql);
			System.out.println("jasja"+sql);
			pst.executeUpdate(sql);
			if(pst.executeUpdate(sql)>0) 
				return true;
			else 
				return false;
	        } catch (Exception e){  
	            throw new Exception("操作出现异常"+e.toString()) ;  
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        } 
	 }
	
	
	public boolean updateByUserIdAndValue(int userId,String name,String value)throws Exception{
		
		sql="update tjobAss set "+name+"='"+value+"' where userid='"+userId+"';";
		pst = null ;  
		conn = null ;
       try{  
			conn=DbcpConnection.getConnection();
			pst = DbcpConnection.getConnection().prepareStatement(sql);
		
			pst.executeUpdate(sql);
			if(pst.executeUpdate(sql)>0) {
				return true;
			}
			else{
				return false;
			}
				
	        } catch (Exception e){  
	            throw new Exception("操作出现异常"+e.toString()) ;  
	        }  
	        finally{  
	        	//pst.close();
	            // 关闭数据库连接  
	            conn.close() ;  
	        }
	}
	
	
	
	
	
	
	

}