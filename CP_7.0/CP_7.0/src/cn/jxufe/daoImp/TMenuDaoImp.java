package cn.jxufe.daoImp;
 import cn.jxufe.dao.TMenuDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TMenu;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
public class TMenuDaoImp implements TMenuDao {
	/**
	 * @author A
	 *	菜单查找：checkbyID
	 *	菜单的增加：InsertTMenu
	 *	菜单的删除：DeletebyID
	 *	菜单修改：UpdatebyID
	 *	主函数：测试
	 */
	@Override
	public boolean checkbyID(long menuId) throws Exception {
		// TODO Auto-generated method stub
		TMenu tmenu = new TMenu();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tmenu where menuId='"+menuId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		ResultSet rs = stmt.executeQuery(sql);
		try {
			stmt = dbc.getConnection().createStatement();		
			if(rs.next()) {
				//tmenu.setMenuId(rs.getLong(1));
				//tmenu.setMenuName(rs.getString(2));
				//tmenu.setMenuUrl(rs.getString(3));
				//tmenu.setParentId(rs.getLong(4));
				//tmenu.setMenuComment(rs.getString(5));
//				System.out.println(rs.getLong(1));
				return true;
			}
			else return false;			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {			
			/*System.out.println(tmenu.getMenuId()+"   "+tmenu.getMenuName()+"   "+
			tmenu.getMenuUrl()+"   "+tmenu.getParentId()+"   "+tmenu.getMenuComment());
			conn.close();*/
			rs.close();
			stmt.close();
		}
		//return ;
		
	}

	@Override
	public void InsertTMenu(long menuId, String menuName, String menuUrl,
			long parentId, String menuComment) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tmenu(menuId,menuName,menuUrl,parentId,menuComment) "
				+ "VALUES('"+menuId+"','"+menuName+"','"+menuUrl+"','"+parentId+"','"+menuComment+"');";
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
	public void DeletebyID(long menuId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tmenu WHERE menuId='"+menuId+"';";
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
	public void UpdatebyID(long menuId, String menuName, String menuUrl,
			long parentId, String menuComment) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tmenu set menuName='"+menuName+"',menuUrl='"+menuUrl+"',parentId='"+parentId+"',menuComment='"+menuComment+"' WHERE menuId='"+menuId+"';";
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
//		TMenuDao Tmenu =new TMenuDaoImp();
//		Tmenu.InsertTMenu(11, "ads"," bf", 3, "cdfad");
////		Tmenu.checkbyID(11);
////		Tmenu.UpdatebyID(1, "aaa", "bbb", 6, "eee");
////		Tmenu.DeletebyID(11);
//		
//	}
	

}