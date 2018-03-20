package cn.jxufe.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import cn.jxufe.dao.TUserDao;
import cn.jxufe.db.DbcpConnection;
import cn.jxufe.domain.TUser;
import cn.jxufe.exception.ErrNameException;
import cn.jxufe.exception.ErrPwdException;

public class TUserDaoImp implements TUserDao {

	private String sql;
	private PreparedStatement pst = null;
	private Connection conn = null;

	@Override
	public boolean checkUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TUser findAllByUserNum(String userNum) throws Exception {

		TUser tUser = new TUser();
		sql = "SELECT * FROM TUser WHERE userNum='" + userNum + "';";
		// System.out.println("测试sql输出："+sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				tUser.setUserId(rs.getInt("userId"));
				tUser.setUserNum(rs.getString("userNum"));
				tUser.setCode(rs.getString("code"));
				tUser.setYear(rs.getInt("year"));
				tUser.setUserName(rs.getString("userName"));
				tUser.setCreaterole(rs.getString("createRole"));
				tUser.setCreateDate(rs.getDate("createDate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
		return tUser;
	}

	@Override
	public boolean checkUserNumAndCode(String userNum, String code, TUser user)
			throws Exception {
		// TUser user = new TUser();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// DbUtil dbUtil = null;
		String sql = "select * from tuser where userNum=?";
		System.out.println(sql+"ceshi");
		try {
			conn = DbcpConnection.getConnection();
			pstmt = DbcpConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, userNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (!code.equals(rs.getString("code"))) {
					System.out.println("密码不正确！！");
					//throw new ErrPwdException("密码不正确！！");
					return false;
				} else {
					// 登录成功
					user.setUserName(rs.getString("userName"));
					user.setUserNum(rs.getString("userNum"));
					System.out.println("密码正确！！");
					return true;
				}
			} else {
				//throw new ErrNameException("用户名不存在！！");
				System.out.println("用户名不存在！！！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	@Override
	public boolean addTUser(TUser tUser) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addManyTUser(Collection<TUser> tUser) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addManyTuser(Collection<TUser> tUser, int count)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTUserByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteManyTUserByUserNums(Collection<String> userNums)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterCodeByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterUnitIdByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteManyTUserByUserNums(Collection<String> userNums,
			int count) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterUserNameByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findUnitIdByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserNameByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findCreateRoleByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date findCreateDateByUserNum(String userNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterInfoByUserNum(String sex, Date birthday,
			String telphone, String qq, String email, String userNum)
			throws Exception {
		TUser tUser = new TUser();
		sql = "update tuser set sex='" + sex + "',birthday='" + birthday
				+ "',telphone='" + telphone + "',qq='" + qq + "',email='"
				+ email + "' WHERE userNum='" + userNum + "';";
		// System.out.println("测试sql输出："+sql);
		try {
			conn = DbcpConnection.getConnection();
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				tUser.setUserId(rs.getInt("userId"));
				tUser.setUserNum(rs.getString("userNum"));
				tUser.setCode(rs.getString("code"));
				tUser.setUserName(rs.getString("userName"));
				tUser.setCreaterole(rs.getString("createRole"));
				tUser.setCreateDate(rs.getDate("createDate"));
			}
			rs.close();
		} catch (Exception e) {
			throw new Exception("error!");
		} finally {
			pst.close();
			conn.close();
		}
		return false;
	}

}
