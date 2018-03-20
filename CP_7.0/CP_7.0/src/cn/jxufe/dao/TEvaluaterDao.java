package cn.jxufe.dao;

import java.util.Collection;

import cn.jxufe.domain.TEvaluater;
import cn.jxufe.domain.TUser;

public interface TEvaluaterDao {
	/** 
	 * 评价人表
	 * evaluaterId
	 * 学期号 termNum
	 * TUser tUser//userId
	 */
	
	/**
	 * 是否存在evaluaterId的评价人表
	 * @param evaluaterId
	 * @return
	 * @throws Exception
	 */
	public boolean checkbyID(long evaluaterId)throws Exception;

	/**
	 * 删除evaluateId的评价分数
	 * @param evaluaterId
	 * @return
	 * @throws Exception
	 */
	public boolean DeletebyID(long evaluaterId) throws Exception;
	/**
	 * 修改评价人表
	 * @param evaluaterId,termNum，tUser
	 * @return
	 * @throws Exception
	 */
	public boolean UpdatebyID(long evaluaterId,long termNum,TUser tUser)throws Exception;

	boolean InsertTEvaluater(int userId, int termNum, int evauserId)
			throws Exception;

	Collection<TEvaluater> findByEvaUserId(int evauserId, int termNum)
			throws Exception;

	boolean changeSubmitState(int eveluaterId);

	String selectSubmitState(int eveluaterId);

	boolean UpdatebyID(int evaluaterId, String submit);
	
	
	
}