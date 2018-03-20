package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import cn.jxufe.dao.TEvaluaterDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TEvaluater;
import cn.jxufe.domain.TUser;
public class TEvaluaterDaoImp implements TEvaluaterDao {
	private String sql;
	private TEvaluater tEvaluater;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean checkbyID(long evaluaterId) throws Exception {
		// TODO Auto-generated method stub
		TEvaluater tEvaluater = new TEvaluater();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tevaluater where evaluaterId='"+evaluaterId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		try {
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println(tEvaluater.getEvaluaterId()+"   "+tEvaluater.getTermNum()+
					"   "+tEvaluater.getTUser());
			conn.close();
		}
		return false;
		
	}


	@Override
	public boolean InsertTEvaluater(int userId,int termNum,int evauserId)throws Exception{
		sql = "INSERT INTO tevaluater(userId,termNum,evauserId) VALUES('" + 
				userId+ "','" + termNum + "','"+evauserId+"');";
		System.out.println(sql);
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate(sql);	
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			if(null != conn){
				conn.close();
			}
		}
		
		return false;
	}
	@Override
	public boolean DeletebyID(long evaluaterId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tevaluater WHERE evaluaterId='"+evaluaterId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		dbc=new DbcpConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
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
	public boolean UpdatebyID(long evaluaterId,long termNum,TUser tUser) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tevaluate set userId='"+tUser.userId+"',termNum='"+termNum+"',"+ 
		"' WHERE evaluaterId='"+evaluaterId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		dbc=new DbcpConnection();
	 
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
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

	/* (non-Javadoc)
	 * @see cn.jxufe.dao.TEvaluaterDao#findByEvaUserId(int, int)
	 * 
	 * 学期号
	 */
	@Override
	public Collection<TEvaluater> findByEvaUserId(int evauserId,int termNum)
			throws Exception {
		
		Collection<TEvaluater> tEvaluaters=new ArrayList<TEvaluater>();
		
		
		String sql="select * from tevaluater where evauserId='"+evauserId+"'and termNum='"+termNum+"';";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("excluter sql："+sql);
			while(rs.next()){
				TEvaluater tEvaluater=new TEvaluater();
				tEvaluater.setEvauserId(rs.getLong("evauserId"));
				tEvaluater.setUserId(rs.getInt("userId"));
				tEvaluater.setEvaluaterId(rs.getLong("evaluaterId"));
				tEvaluater.setTermNum(rs.getLong("termNum"));
				tEvaluater.setSubmit(rs.getString("submit"));
				tEvaluaters.add(tEvaluater);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tEvaluaters;
	}
	@Override
	public boolean UpdatebyID(int evaluaterId,String submit){
		
		String sql="UPDATE tevaluater set submit='"+submit+"' WHERE evaluaterId='"+evaluaterId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		
	 
		try{
			Connection conn = DbcpConnection.getConnection();
			
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			
			
			return true;
			
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if(null != conn){
				try {
					
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}		
		}
		
	}
	@Override
	public String selectSubmitState(int evaluaterId){
		
		String sql = "select * from tevaluater where evaluaterId='"+evaluaterId+"';";
		Statement stmt = null ;
		try {
			Connection conn = DbcpConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getString("submit");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
			
		}
		return "";
	}
	@Override
	public boolean changeSubmitState(int evaluaterId){
		try {
			if(checkbyID(evaluaterId)){
				String state=selectSubmitState(evaluaterId);
				if(state.equals("fail")){
					UpdatebyID(evaluaterId,"success");
				}else{
					UpdatebyID(evaluaterId,"fail");
				}
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}