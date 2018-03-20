package cn.jxufe.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jxufe.dao.VStudentDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VStudent;

public class VStudentDaoImp implements VStudentDao {

	@Override
	public boolean add(VStudent student){
		
		
		   String sql="insert into tuser(unitId,userNum,userName,createRole) values(?,?,?,?)";
		   
		   Connection con=null;
		   try {
			con=DbcpConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
		   // pst.setString(1, student.getSchoolName());
		   // pst.setString(2, student.getDepartName());
		    pst.setInt(1, student.getUnitId());
		    
		    pst.setString(2, student.getUserNum());
		    pst.setString(3, student.getUserName());
		    pst.setString(4, student.getCreateRole());
		    System.out.println(sql);
		    pst.executeUpdate();
		    
		    
		    //更新创建者
		    return true;
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
		   return false;
	}
}
