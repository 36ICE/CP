package cn.jxufe.service.evaluation;

import cn.jxufe.domain.TReaTar;

public interface TReaTarSevice {

	/**
	 * @return
	 * @throws Exception
	 */
	public TReaTar  select(int tReaTarId)throws Exception;
	

	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean update(TReaTar tReaTar)throws Exception;
	
	/**
	 * @param evaluateId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int tReaTarId)throws Exception;
}
