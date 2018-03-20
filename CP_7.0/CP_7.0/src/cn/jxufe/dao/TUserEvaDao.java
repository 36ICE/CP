package cn.jxufe.dao;

import cn.jxufe.domain.TEvaluate;
import cn.jxufe.domain.TUser;
import cn.jxufe.domain.TUserEva;

public interface TUserEvaDao {
	/**
	 * @author hkl
	 *	用户_评价分数表
	 * userEvaId;
	 * 学期号 termNum
	 * TUser tUser
	 * TEvaluate tEvaluate
	 */
	
	/**
	 * 是否存在userEvaId的用户_评价分数表
	 * @param userEvaId
	 * @return
	 * @throws Exception
	 */
	public boolean checkbyID(long userEvaId)throws Exception;
	/**
	 * 添加用户_评价分数表
	 * @param userEvaId, termNum,tUser,tEvaluate
	 * @return
	 * @throws Exception
	 */
	public boolean InsertTUserEva(TUserEva tUserEva)throws Exception;
	/**
	 * 删除userEvaId的评价分数
	 * @param userEvaId
	 * @return
	 * @throws Exception
	 */
	public boolean DeletebyID(long userEvaId) throws Exception;
	/**
	 * 修改评价分数
	 * @param userEvaId, termNum,tUser,tEvaluate
	 * @return
	 * @throws Exception
	 */
	public boolean UpdatebyID(TUserEva tUserEva)throws Exception;
	
	
}