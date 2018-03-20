package cn.jxufe.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jxufe.dao.TOpenTarDao;
import cn.jxufe.db.DbcpConnection;

public class TOpenTarDaoImp implements TOpenTarDao {

	private String sql;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean addOpenTar(int unitId,int termNum){
		//还未写开始结束时间，需手动开启和关闭
		String sql="insert into topentar(unitId,termNum,flag)values('"+unitId+"','"+termNum+"','success');";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			
			if(pst.executeUpdate(sql)>0){
				return true;
			}
			
		} catch (Exception e) {
			if(null!=conn){
				try {
					conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		
		return false;
		
	}
}
