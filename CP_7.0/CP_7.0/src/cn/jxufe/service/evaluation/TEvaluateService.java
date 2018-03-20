package cn.jxufe.service.evaluation;

import java.util.Collection;

import cn.jxufe.domain.TEvaluate;

public interface TEvaluateService {

	/**
	 * @return
	 * @throws Exception
	 */
	public TEvaluate select()throws Exception;
	

	
	
	
	/**
	 * @param evaluateId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int evaluateId)throws Exception;




	public Collection<TEvaluate> findByUserNumAndTermNum(String userNum);



	boolean update(int evaluateId, TEvaluate tEvaluate) throws Exception;
}
