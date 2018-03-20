package cn.jxufe.daoImp.vdaoImp;

import java.sql.Connection;
import java.sql.ResultSet;

import cn.jxufe.dao.vdao.VRoleDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.domain.ventity.VRole;

public class VRoleDaoImp implements VRoleDao {

	private java.sql.PreparedStatement pst = null;
	private Connection conn = null;
	@SuppressWarnings("null")
	@Override
	public VRole findByUserNum(String userNum) throws Exception {
		VRole vRole=new VRole();
		String sql="select * from vrole where userNum='"+userNum+"';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				vRole.setUserNum(rs.getString("userNum"));
				vRole.setUserName(rs.getString("userName"));
				vRole.setRoleName(rs.getString("roleName"));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			
		} finally {
			pst.close();
			conn.close();
		}
	
		return vRole;
	}
	@Override
	public String findRoleNameByUserNum(String userNum) throws Exception {
		VRole vRole=new VRole();
		String sql="select * from vrole where userNum='"+userNum+"';";
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				//vRole.setUserNum(rs.getString("userNum"));
				//vRole.setUserName(rs.getString("userName"));
				vRole.setRoleName(rs.getString("roleName"));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
		
		} finally {
			pst.close();
			conn.close();
		}
	
		return vRole.getRoleName();
	}
	//若不用视图
	@Override
	public String findRoleNameByUserNum2(String userNum) throws Exception {
		VRole vRole=new VRole();
		String sql="select roleName from trole where roleId=(select roleId from tuserrole where roleId=(select userId from tuser where userNum='"+userNum+"'))";
		System.out.println(sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("视图sql："+sql);
			if(rs.next()){	
				//vRole.setUserNum(rs.getString("userNum"));
				//vRole.setUserName(rs.getString("userName"));
				//vRole.setRoleName(rs.getString("roleName"));
				vRole.setRoleName(rs.getString("roleName"));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			
			
		} finally {
			pst.close();
			conn.close();
		}
	
		return vRole.getRoleName();
	}

}
