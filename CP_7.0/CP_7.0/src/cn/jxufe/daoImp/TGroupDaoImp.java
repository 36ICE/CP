package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jxufe.dao.TGroupDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TGroup;
import cn.jxufe.domain.TMenu;
public class TGroupDaoImp implements TGroupDao {

	/**
	 * @author A
	 *	组查找：groupId
	 *	组的增加：groupId,groupName,groupCom
	 *	组的删除：groupId
	 *	组修改：groupId,groupName,groupCom
	 */
	
	@Override
	public boolean checkbyID(long groupId) throws Exception {
		// TODO Auto-generated method stub
		TGroup tgroup = new TGroup();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tgroup where groupId='"+groupId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		ResultSet rs = stmt.executeQuery(sql);
		try {
			stmt = dbc.getConnection().createStatement();
			
			if(rs.next()) {
				//tgroup.setGroupId(rs.getLong(1));
				//tgroup.setGroupName(rs.getString(2));
				//tgroup.setGroupCom(rs.getString(3));
//				System.out.println(rs.getLong(1));
				return true;
			}	
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {			
			//System.out.println(tgroup.getGroupId()+"   "+tgroupid.getGroupName()+"   "+tgroupid.getGroupCom());
			conn.close();
			rs.close();
			stmt.close();
		}
		//return ;
	}

	@Override
	public boolean InsertTGroup(long groupId, String groupName, String groupCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tgroup(groupId,groupName,groupCom) "
				+ "VALUES('"+groupId+"','"+groupName+"','"+groupCom+"');";
		Statement stmt=null;
		DbcpConnection dbc=null;
		System.out.println(sql);
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
	public boolean InsertTGroup(TGroup tgroup)throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tgroup(groupId,groupName,groupCom) "
				+ "VALUES('"+tgroup.getGroupId()+"','"+tgroup.getGroupName()+"','"+tgroup.getGroupCom()+"');";
		Statement stmt=null;
		DbcpConnection dbc=null;
		System.out.println(sql);
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
	public boolean DeletebyID(long groupId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tgroup WHERE groupId='"+groupId+"';";
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
	public boolean UpdatebyID(long groupId, String groupName, String groupCom)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tgroup set groupName='"+groupName+"',groupCom='"+groupCom+"' WHERE groupId='"+groupId+"';";
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
	public boolean UpdatebyID(TGroup tgroup)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tgroup set groupName='"+tgroup.getGroupName()+"',groupCom='"+tgroup.getGroupCom()+"' WHERE groupId='"+tgroup.getGroupId()+"';";
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