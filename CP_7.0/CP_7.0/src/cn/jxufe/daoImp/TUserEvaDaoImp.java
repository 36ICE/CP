package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.jxufe.dao.TUserEvaDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TUserEva;
public class TUserEvaDaoImp implements TUserEvaDao {
	private String sql;
	private TUserEva tUserEva;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean checkbyID(long userEvaId) throws Exception {
		return false;
	}

	@Override
	public boolean InsertTUserEva(TUserEva tUserEva) throws Exception {
		// TODO Auto-generated method stub
		sql = "INSERT INTO tusereva(userId,termNum,evaluateId) VALUES('" + 
				tUserEva.userEvaId + "','" + tUserEva + tUserEva.tEvaluate.evaluateId + "');";
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
					return false;
				}
		}		
	
	}

	@Override
	public boolean DeletebyID(long userEvaId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tusereva WHERE userEvaId='"+userEvaId+"';";
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
	public boolean UpdatebyID(TUserEva tUserEva) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tevaluate set userEvaId='"+tUserEva.userEvaId+"',termNum='"+tUserEva.termNum+"',"+ 
		"' WHERE evaluaterId='"+tUserEva.tEvaluate.evaluateId+"';";
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
	
}