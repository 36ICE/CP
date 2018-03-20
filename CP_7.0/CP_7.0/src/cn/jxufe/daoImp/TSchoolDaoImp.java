package cn.jxufe.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import cn.jxufe.dao.TSchoolDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TEvaluater;
import cn.jxufe.domain.TSchool;

public class TSchoolDaoImp implements TSchoolDao {
	private String sql;
	private TSchool tSchool;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean checkSchoolNumber(String schoolNumber) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSchoolId(int schoolId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTSchool(TSchool tSchool) throws Exception {
		// TODO Auto-generated method stub
		sql = "INSERT INTO tschool(schoolId,schoolName,schoolNumber) VALUES('" + 
				tSchool.schoolId + "','" + tSchool.schoolName + "','" + tSchool.schoolNumber + "');";
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
	public boolean addManyTSchool(Collection<TSchool> tSchools)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTSchool(String schoolNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tschool WHERE schoolNumber='"+schoolNumber+"';";
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
	public boolean deleteManyTSchool(Collection<String> schoolNumbers)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterSchoolName(long schoolId,String schoolName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tschool set schoolName='"+schoolName+"' WHERE schoolId='"+schoolId+"';";
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
	public boolean alterSchoolNumber(long schoolId,String schoolNumber) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tschool set schoolNumber='"+schoolNumber+"' WHERE schoolId='"+schoolId+"';";
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
	public TSchool findAllBySchoolId(String schoolId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TSchool findAllBySchoolNumber(String schoolNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<TSchool> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findSchoolNameBySchoolNumber() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int findSchoolIdBySchoolName(String schoolName)throws Exception{
		String sql="select schoolId from tschool  whereschoolName='"+schoolName+"';";
		
		  Connection con=null;
		   try {
			   conn = DbcpConnection.getConnection();
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				if(rs.next()){	
					return rs.getInt("schoolId");
				}
		    
		    //更新创建者
		   
		   } catch (Exception e) {
		    e.printStackTrace(); 
		   }finally{
			   if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		   }
		   return 0;
	}

}
