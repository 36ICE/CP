package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import cn.jxufe.dao.TUnitDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TUnit;
public class TUnitDaoImp implements TUnitDao {
	private String sql;
	private TUnit tUnit;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;

	public boolean checkUnitNumber(String UnitNum) throws Exception {
		return false;
	}	

	public boolean checkTUnitId(int UnitId)throws Exception {
		return false;
	}

	public boolean addTUnit(TUnit tUnit)throws Exception {
		// TODO Auto-generated method stub
		sql = "INSERT INTO tunit(unitId,unitName,unitNumber) VALUES('" + 
				tUnit.unitId + "','" + tUnit.unitNumber + "','" + tUnit.unitNumber + "');";
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

	public boolean addManyTUnit(Collection<TUnit> tUnit)throws Exception {
		return false;
	}

	public boolean deleteTUnit(String unitNumber)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tunit WHERE unitNumber='"+ unitNumber+"';";
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

	public boolean deleteManyTUnit(Collection<String>tUnitNumbers)throws Exception {
		return false;
	}
	
	public boolean alterUnitName(long unitId,String unitName)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tunit set unitId='"+unitId+"' WHERE unitName='"+unitName+"';";
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

	public boolean alterUnitNumber(long unitId,String tUnitNumber)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tunit set unitId='"+unitId+"' WHERE tUnitNumber='"+tUnitNumber+"';";
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

	public TUnit findAllByUnitId(int unitId) throws Exception {
		return null;
	}
	@Override
	public String findUnitNameByUnitId(int unitId)throws Exception{
	
		String sql="select unitName from tunit where unitId='"+unitId+"';";
		java.sql.PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){	
				return rs.getString("unitName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		}
		return null;
		
	}
	@Override
	public int findUnitIdByUnitName(String unitName)throws Exception{
		String sql="select unitId from tunit where unitName='"+unitName+"';";
		java.sql.PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){	
				return (int)rs.getLong("unitId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pst.close();
			conn.close();
		}
		return 0;
	}
	public String findUnitNameByUnitNumber()throws Exception {
		return null;
	}

	public TUnit findAllByUnitNumber(String UnitNumber)throws Exception {
		return null;
	}

	public int getCount() throws Exception {
		return 0;
	}

	public Collection<TUnit> findAll()throws Exception {
		return null;
	}


	
}