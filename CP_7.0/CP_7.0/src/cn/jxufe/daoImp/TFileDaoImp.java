package cn.jxufe.daoImp;
 import cn.jxufe.dao.TFileDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TFile;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

public class TFileDaoImp implements TFileDao {
	/**
	 * @author A
	 *	菜单查找：checkbyID
	 *	菜单的增加：InsertTFile
	 *	菜单的删除：DeletebyID
	 *	菜单修改：UpdatebyID
	 *	主函数：测试
	 */
	@Override
	public boolean checkbyID(long fileId) throws Exception {
		// TODO Auto-generated method stub
		TFile tfile = new TFile();
		Connection conn = DbcpConnection.getConnection();
		String sql = "select * from tfile where fileId='"+fileId+"';";
		Statement stmt = null ;
		DbcpConnection dbc = null;
		dbc = new DbcpConnection();
		ResultSet rs = stmt.executeQuery(sql);
		try {
			stmt = dbc.getConnection().createStatement();			
			if(rs.next()) {
				//tfile.setFileId(rs.getLong(1));
				//tfile.setFileName(rs.getString(2));
				//tfile.setFileUrl(rs.getString(3));
				//tfile.setFileComent(rs.getString(4));
//				System.out.println(rs.getLong(1));
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			
			//System.out.println(tfile.getFileId()+"   "+tfile.getFileName()+"   "+
			//tfile.getFileUrl()+"   "+tfile.getFileComent());
			conn.close();
			rs.close();
			stmt.close();
		}
		
	}

	@Override
	public boolean InsertTFile(long fileId, String fileName, String fileUrl, String fileComent) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="INSERT INTO tfile(fileId,fileName,fileUrl,fileComent) "
				+ "VALUES('"+fileId+"','"+fileName+"','"+fileUrl+"','"+fileComent+"');";
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
	public boolean DeletebyID(long fileId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="DELETE FROM tfile WHERE fileId='"+fileId+"';";
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
	public boolean UpdatebyID(long fileId, String fileName, String fileUrl, String fileComent) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DbcpConnection.getConnection();
		String sql="UPDATE tfile set fileName='"+fileName+"',fileUrl='"+fileUrl+"',fileComent='"+fileComent+"' WHERE fileId='"+fileId+"';";
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