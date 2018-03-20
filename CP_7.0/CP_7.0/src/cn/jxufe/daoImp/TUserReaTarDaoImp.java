package cn.jxufe.daoImp;
 import java.sql.Connection;
import java.sql.ResultSet;

import cn.jxufe.dao.TUserReaTarDao;
import cn.jxufe.db.DbcpConnection;

public class TUserReaTarDaoImp implements TUserReaTarDao {

	private String sql;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean cheackUserId(int userId,int termNum) throws Exception {	
		sql="select * from tuserreatar where userId='"+userId+"'and termNum='"+termNum+"';";
		
	
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
	public int findReaTarIdByUserIdAndTermNum(int userId, int termNum)
			throws Exception {
		String sql="select reaTarId from tuserreatar where userId='"+userId+"' and termNum='"+termNum+"';";
		
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				
				return (int)rs.getLong("reaTarId");
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