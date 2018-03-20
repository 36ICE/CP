package cn.jxufe.dao;

import java.util.Collection;

import cn.jxufe.domain.TJobAss;
import cn.jxufe.domain.TSelAss;
import cn.jxufe.domain.TUser;

/*自我评价表*/
public interface TSelAssDao {
	
	/**
	 * 是否存在userId的自我评价表
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserId(int userId) throws Exception;
	
	/**
	 * 添加自我评价表
	 * @param tSelAss
	 * @return
	 * @throws Exception
	 */
	public boolean addSelAss(TSelAss tSelAss) throws Exception;
	
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
	public boolean deleteSelAss(TUser tUser) throws Exception;
	
	/**
	 * 删除用户号为tUser的自我评价表
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSelAss(String userNum) throws Exception;
	
	/**
	 * 批量删除自我评价表
	 * @param tUsers
	 * @return
	 * @throws Exception
	 */
	public boolean deleteManySelAss(Collection<TUser> tUsers) throws Exception;
	
	/**
	 * 将tUser的自我评价表改为tSelAss
	 * @param tUser
	 * @param tSelAss
	 * @return
	 * @throws Exception
	 */
	public void alterSelAss(TUser tUser,TSelAss tSelAss) throws Exception;
	

	/**
	 * 查找自我评价表
	 * @param tUser
	 * @return
	 * @throws Exception
	 */
	public TSelAss findByUser(TUser tUser) throws Exception;
	
	/**
	 * 查找自我评价表
	 * @param userNum
	 * @return
	 * @throws Exception
	 */
	public TSelAss findByUserNum(String userNum) throws Exception;
	
	/**
	 * 得到表中数据行数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;

	public boolean updateSelAss(TSelAss tSelAss)throws Exception;
	
	public boolean updateByUserIdAndValue(int userId,String  name,String value)throws Exception;

	boolean addJobAssByNameAndValue(int userId, String name, String value)
			throws Exception;

	TSelAss findByUserId(int userId) throws Exception;
}
	
	