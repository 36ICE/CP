package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jxufe.dao.TPermissionDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TPermission;
import cn.jxufe.domain.TPermission;

/**
 * @author A
 *权限查找：permiId
 *权限增加：permiId，permiName，permiCom
 *权限删除：permiId
 *权限修改：permiId，permiName，permiCom
 */
public class TPermissionDaoImp implements TPermissionDao {

	@Override
	public void checkbyID(long permiId) throws Exception {
		// TODO Auto-generated method stub
		TPermission tpermission = new TPermission();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tpermission where permiId='"+permiId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		try {
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				tpermission.setPermiId(rs.getLong(1));
				tpermission.setPermiName(rs.getString(2));
				tpermission.setPermiCom(rs.getString(3));
//				System.out.println(rs.getLong(1));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println(tpermission.getPermiId()+"   "+tpermission.getPermiName()+"   "+
			tpermission.getPermiCom());
			conn.close();
		}
		return ;
	}

	@Override
	public void InsertTPermi(long permiId, String permiName, String permiCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tpermission(permiId,permiName,permiCom) "
				+ "VALUES('"+permiId+"','"+permiName+"','"+permiCom+"');";
		Statement stmt=null;
		DbcpConnection dbc=null;
		System.out.println(sql);
		dbc=new DbcpConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
			stmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			stmt.close();
			conn.close();
			
		}
	}

	@Override
	public void DeletebyID(long permiId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tpermission WHERE permiId='"+permiId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		dbc=new DbcpConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
			stmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			stmt.close();
			conn.close();
			
		}
	}

	@Override
	public void UpdatebyID(long permiId, String permiName, String permiCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tpermission set permiName='"+permiName+"',permiCom='"+permiCom+"' WHERE permiId='"+permiId+"';";
		Statement stmt=null;
		DbcpConnection dbc=null;
		dbc=new DbcpConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
			stmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			stmt.close();
			conn.close();
			
		}
	}
	
//	public static void main(String arg[]) throws Exception{
//	TPermissionDao TPermissionDao =new TPermissionDaoImp();
//	TPermissionDao.InsertTPermi(11, "ads"," bf");
//	TPermissionDao.checkbyID(11);
//	TPermissionDao.UpdatebyID(11, "aaa", "bbb");
//	TPermissionDao.DeletebyID(11);
//		
//}

}