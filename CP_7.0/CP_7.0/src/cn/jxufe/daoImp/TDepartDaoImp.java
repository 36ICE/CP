package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import cn.jxufe.dao.TDepartDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TDepart;
public class TDepartDaoImp implements TDepartDao {
	private String sql;
	private TDepart tDepart;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	public Boolean checkDepartNumber(String departNum) throws Exception {
		return null;
	}

	public Boolean checkDepartId(int departId)throws Exception {
		return null;
	}

	public boolean addTDepart(TDepart tDepart)throws Exception {
		// TODO Auto-generated method stub
		sql = "INSERT INTO tdepart(schoolId,departName,schoolNumber) VALUES('" + 
				tDepart.tSchool.schoolId + "','" + tDepart.departName + "','" + tDepart.departNum + "');";
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

	public boolean addManyTDepart(Collection<TDepart> tDepart)throws Exception {
		return false;
	}
	
	public boolean deleteTDepart(String departNumber)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tdepart WHERE departNumber='"+departNumber+"';";
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

	public boolean deleteManyTDepart(Collection<String>departNumbers)throws Exception {
		return false;
	}
	
	public boolean alterDepartName(long departId,String departName)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE depart set departName='"+departName+"' WHERE departId='"+departId+"';";
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

	public boolean alterDepartNumber(long departId,String departNumber)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE depart set departNumber='"+departNumber+"' WHERE departId='"+departId+"';";
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

	public TDepart findAllByDepartId(String DepartId) throws Exception {
		return null;
	}

	public TDepart findAllByDepartNumber(String departNumber)throws Exception {
		return null;
	}
	@Override
	public int findDepartIdByDepartName(String departName)throws Exception{
		String sql="select departId from tdepart where departName='"+departName+"';";
		java.sql.PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){	
				return (int)rs.getLong("departId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		}
		return 0;
	}

	public int getCount() throws Exception{
		return 0;
		
	}

	public Collection<TDepart> findAll()throws Exception{
		return null;
		
	}
	public String findDepartNameByDepartNumber()throws Exception{
		return null;
		
	}

}