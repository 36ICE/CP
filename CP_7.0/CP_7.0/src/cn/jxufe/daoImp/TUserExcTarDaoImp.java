package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;

import cn.jxufe.dao.TUserExcTarDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TUserExcTar;
public class TUserExcTarDaoImp implements TUserExcTarDao {

	private String sql;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean cheackUserId(int userId,int termNum) throws Exception {	
		sql="select * from tuserexctar where userId='"+userId+"'and termNum='"+termNum+"';";
		
	
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return false;
	}
	
	
	@Override
	public int findExcTarIdByUserIdAndTermNum(int userId, int termNum)
			throws Exception {
	
		String sql="select excTarId from tuserexctar where userId='"+userId+"' and termNum='"+termNum+"';";
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				
				return (int)rs.getLong("excTarId");
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pst.close();
			conn.close();
		}
		return 0;
	}


}