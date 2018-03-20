package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jxufe.dao.TRoleDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TGroup;
import cn.jxufe.domain.TRole;
public class TRoleDaoImp implements TRoleDao {

	/**
	 * @author A
	 *	角色查找：roleId
	 *	角色的增加：roleId,roleName,roleCom
	 *	角色的删除：roleId
	 *	角色修改：roleId,roleName,roleCom
	 */
	@Override
	public void checkbyID(long roleId) throws Exception {
		// TODO Auto-generated method stub
		TRole trole = new TRole();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from trole where roleId='"+roleId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		try {
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				trole.setRoleId(rs.getLong(1));
				trole.setRoleName(rs.getString(2));
				trole.setRoleCom(rs.getString(3));
//				System.out.println(rs.getLong(1));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println(trole.getRoleId()+"   "+trole.getRoleName()+"   "+trole.getRoleCom());
			conn.close();
		}
		return ;
	}

	@Override
	public void InsertTRole(long roleId, String roleName, String roleCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO trole(roleId,roleName,roleCom) "
				+ "VALUES('"+roleId+"','"+roleName+"','"+roleCom+"');";
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
	public void DeletebyID(long roleId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM trole WHERE roleId='"+roleId+"';";
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
	public void UpdatebyID(long roleId, String roleName, String roleCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE trole set roleName='"+roleName+"',roleCom='"+roleCom+"' WHERE roleId='"+roleId+"';";
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

//		public static void main(String arg[]) throws Exception{
//		TRoleDao trole =new TRoleDaoImp();
////		trole.InsertTRole(11, "ads"," bf");
////		trole.checkbyID(11);
////		trole.UpdatebyID(11, "aaa", "bbb");
//		trole.DeletebyID(11);

//	
//}
}