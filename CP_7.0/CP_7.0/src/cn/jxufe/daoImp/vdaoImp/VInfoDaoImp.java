package cn.jxufe.daoImp.vdaoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import cn.jxufe.dao.vdao.VInfoDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VInfo;

public class VInfoDaoImp implements VInfoDao {

	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@Override
	public boolean checkUserNum(String userNum){
		String sql="select * from vinfo where userNum='"+userNum+"';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){	
				//存在用户
				return true;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(pst!=null)
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	@SuppressWarnings("null")
	@Override
	public VInfo findByUserNum(String userNum) throws Exception {
		VInfo vInfo=new VInfo();
		String sql="select * from vinfo where userNum='"+userNum+"';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){	
				
				vInfo.setUserNum(rs.getString("userNum"));
				vInfo.setUserName(rs.getString("userName"));
				vInfo.setUnitName(rs.getString("unitName"));
				vInfo.setDepartName(rs.getString("departName"));
				vInfo.setQq(rs.getString("qq"));
				vInfo.setTelphone(rs.getString("telphone"));
				vInfo.setEmail(rs.getString("email"));
				vInfo.setUnitId(rs.getInt("unitId"));
				vInfo.setRoleName(rs.getString("roleName"));
				//System.out.println(sql+vInfo.toString());
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			pst.close();
			conn.close();
		}
		return vInfo;
	}
	@Override
	public VInfo findByUserId(int userId)throws Exception{
		VInfo vInfo=new VInfo();
		String sql="select * from vinfo where userId='"+userId+"'and roleName='student';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){	
				
				vInfo.setUserNum(rs.getString("userNum"));
				vInfo.setUserName(rs.getString("userName"));
				vInfo.setUnitName(rs.getString("unitName"));
				vInfo.setDepartName(rs.getString("departName"));
				vInfo.setQq(rs.getString("qq"));
				vInfo.setTelphone(rs.getString("telphone"));
				vInfo.setEmail(rs.getString("email"));
				vInfo.setUnitId(rs.getInt("unitId"));
				vInfo.setRoleName(rs.getString("roleName"));
				//System.out.println(sql+vInfo.toString());
				
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			pst.close();
			conn.close();
		}
		return vInfo;
	}
	/* (non-Javadoc)
	 * @see cn.jxufe.dao.vdao.VInfoDao#findVInfosbyUnitId(int)
	 * 查找一个班的学生
	 */
	@Override
	public Collection<VInfo> findVInfosbyUnitId(int unitId )throws Exception{
		
		Collection<VInfo> vInfos=new ArrayList<VInfo>();
		String sql="select * from vinfo where unitId='"+unitId+"'and roleName='student';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){	
				VInfo vInfo=new VInfo();
				vInfo.setUserId(rs.getInt("userId"));
				vInfo.setUserNum(rs.getString("userNum"));
				vInfo.setUserName(rs.getString("userName"));
				vInfo.setUnitName(rs.getString("unitName"));
				vInfo.setDepartName(rs.getString("departName"));
				vInfo.setQq(rs.getString("qq"));
				vInfo.setTelphone(rs.getString("telphone"));
				vInfo.setEmail(rs.getString("email"));
				vInfo.setUnitId(rs.getInt("unitId"));
				vInfo.setRoleName(rs.getString("roleName"));
			
				vInfos.add(vInfo);
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			pst.close();
			conn.close();
		}
		return vInfos;
	}
}
