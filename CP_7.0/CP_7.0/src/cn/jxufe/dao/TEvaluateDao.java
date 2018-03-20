package cn.jxufe.dao;

import cn.jxufe.domain.TEvaluate;

public interface TEvaluateDao {
	/**
	 * @author hkl
	 *	long evaluateId;
	 * 专业学习 long gProLea;
	 * 非专业学习 long gNonProLea;
	 * 课外学习  long gExtraLearn;
	 * 身体健康 long gPhyHealth;
	 * 心理健康 long gMentalHealth;
	 * 理财 long gManageMoney;
	 * 人际沟通 long gInterpersonal;
 	 * 社团部门 long gClubEvent;
 	 * 社会 long gSocialEvent;
 	 * 评价人id long eveluaterId;
	 */
	

	/**
	 * 验证是否存在 evaluateId
	 * @param evaluateId
	 * @throws Exception
	 */
	public void checkbyID(long evaluateId)throws Exception;

	/**
	 * 增加互评分数
	 * @param tEvaluate
	 * @return 
	 * @throws Exception
	 */
	public boolean addTEvaluate(TEvaluate tEvaluate)throws Exception;

	/**
	 * 删除互评分数
	 * @param evaluateId
	 * @return 
	 * @throws Exception
	 */
	public boolean DeletebyEvaluateId(long evaluateId) throws Exception;
	
	/**
	 * 修改互评分数
	 * @param tEvaluate
	 * @return 
	 * @throws Exception
	 */
	public boolean alterByEvaluateId(int evaluateId,TEvaluate tEvaluateId)throws Exception;

	TEvaluate FindByEvalusteId(long tEvaluateId) throws Exception;
	
	
}