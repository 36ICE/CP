package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jxufe.dao.TOperateDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TOperate;
public class TOperateDaoImp implements TOperateDao {

	/**
	 * @author A
	 *	操作查找：operateId
	 *	操作的增加：operateId,operateName
	 *	操作的删除：operateId
	 *	操作修改：operateId,operateName
	 */
	@Override
	public boolean checkbyID(long operateId) throws Exception {
		// TODO Auto-generated method stub
		TOperate toperate = new TOperate();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from toperate where operateId='"+operateId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		ResultSet rs = stmt.executeQuery(sql);
		try {
				stmt = dbc.getConnection().createStatement();				
				if(rs.next()) {
					//toperate.setOperateId(rs.getLong(1));
					//toperate.setOperateName(rs.getString(2));
//					System.out.println(rs.getLong(1));
					return true;
				}
				else return false;
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
					System.out.println(toperate.getOperateId()+"   "+toperate.getOperateName());
					conn.close();
					rs.close();
					stmt.close();
			}		
	}

	@Override
	public boolean InsertTOperate(long operateId, String operateName)
			throws Exception {
		// TODO Auto-generated method stub
				Connection conn = DbcpConnection.getConnection();
				String sql="INSERT INTO toperate(operateId,operateName) "
						+ "VALUES('"+operateId+"','"+operateName+"');";
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
	public boolean DeletebyID(long operateId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM toperate WHERE operateId='"+operateId+"';";
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
	public boolean UpdatebyID(long operateId, String operateName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE toperate set operateName='"+operateName+"' WHERE operateId='"+operateId+"';";
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