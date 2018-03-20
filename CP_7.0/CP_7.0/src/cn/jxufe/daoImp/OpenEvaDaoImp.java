package cn.jxufe.daoImp;

import java.sql.Connection;
import java.sql.SQLException;

import cn.jxufe.dao.OpenEvaDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TEvaluater;

public class OpenEvaDaoImp implements OpenEvaDao {

	private String sql;
	private TEvaluater tEvaluater;
	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean addOpenEva(int unitId,int termNum){
		//还未写开始结束时间，需手动开启和关闭
		String sql="insert into topeneva(unitId,termNum,falg)values('"+unitId+"','"+termNum+"','success');";
		System.out.println(sql);
		try {
			
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate(sql)>0){
				return true;
			}

			conn.close();
		} catch (Exception e) {
			
			if(null != conn){
				try {
					conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
		return false;
		
	}
}
