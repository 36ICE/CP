package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jxufe.dao.TPageDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TPage;
import cn.jxufe.domain.TPage;

/**
 * @author A
 *	页面查找：pageId
 *  页面增加：pageId，pageName，pageUrl，pageComment
 *  页面删除：pageId
 *  页面修改：pageId，pageName，pageUrl，pageComment
 */
public class TPageDaoImp implements TPageDao {

	@Override
	public void checkbyID(long pageId) throws Exception {
		// TODO Auto-generated method stub
		TPage tpage = new TPage();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tpage where pageId='"+pageId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		try {
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				tpage.setPageId(rs.getLong(1));
				tpage.setPafeName(rs.getString(2));
				tpage.setPageUrl(rs.getString(3));
				tpage.setPageComment(rs.getString(4));
//				System.out.println(rs.getLong(1));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println(tpage.getPageId()+"   "+tpage.getPafeName()+"   "+
			tpage.getPageUrl()+"   "+tpage.getPageComment());
			conn.close();
		}
		return ;
		
	}

	@Override
	public void InsertTPage(long pageId, String pafeName, String pageUrl,
			String pageComment) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tpage(pageId,pafeName,pageUrl,pageComment) "
				+ "VALUES('"+pageId+"','"+pafeName+"','"+pageUrl+"','"+pageComment+"');";
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
	public void DeletebyID(long pageId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tpage WHERE pageId='"+pageId+"';";
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
	public void UpdatebyID(long pageId, String pafeName, String pageUrl,

			String pageComment) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tpage set pafeName='"+pafeName+"',pageUrl='"+pageUrl+"',pageComment='"+pageComment+"' WHERE pageId='"+pageId+"';";
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
//	TPageDao Tmenu =new TPageDaoImp();
//	Tmenu.InsertTPage(11, "ads"," bf", "cdfad");
//	Tmenu.checkbyID(11);
//	Tmenu.UpdatebyID(11, "aaa", "bbb", "eee");
//	Tmenu.DeletebyID(11);
//		
//}

}