package cn.jxufe.dao;

import java.sql.SQLException;
import java.util.Collection;

import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TSelAss;
import cn.jxufe.domain.TUser;

public interface TJobAssDao {
public boolean addJobAss(TJobAss tJobAss) throws Exception;
	
	/**
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean checkByUserId(int userId) throws SQLException;
	/**
	 * 批量添加自我评价表
	 * @param tSelAsss
	 * @return
	 * @throws Exception
	 */
//	public boolean addManySelAss(Collection<TSelAss> tSelAsss) throws Exception;
	
	/**
	 * 删除tUser的自我评价表
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteJobAss(TUser tUser) throws Exception;
	
	/**
	 * 删除用户号为tUser的自我评价表
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean deleteJobAss(String userNum) throws Exception;
	
	/**
	 * 批量删除自我评价表
	 * @param tUsers
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManyJobAss(Collection<TUser> tUsers) throws Exception;
	
	/**
	 * 将tUser的自我评价表改为tSelAss
	 * @param tUser
	 * @param tSelAss
	 * @return
	 * @throws Exception
	 */
	//public boolean alterJobAss(TUser tUser,TJobAss tJobAss) throws Exception;
	

	/**
	 * 查找自我评价表
	 * @param tUser
	 * @return
	 * @throws Exception
	 */
	public TJobAss findByUser(TUser tUser) throws Exception;
	
	/**
	 * 查找自我评价表
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public TJobAss findByUserNum(String userNum) throws Exception;
	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TJobAss findByUserId(int userId) throws Exception;
	
	/**
	 * 得到表中数据行数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;
	
	/**
	 * @param tjobAss
	 * @return
	 * @throws Exception
	 */
	public boolean updateJobAss(TJobAss tjobAss) throws Exception;
	/**
	 * @param userNum
	 * @param name
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean updateByUserIdAndValue(int userId,String name,String value)throws Exception;

	/**
	 * @param userId
	 * @param name
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean addJobAssByNameAndValue(int userId,String name,String value)throws Exception;
}