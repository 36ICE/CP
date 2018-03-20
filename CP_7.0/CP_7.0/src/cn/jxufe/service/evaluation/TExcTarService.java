package cn.jxufe.service.evaluation;

import java.util.Collection;

import cn.jxufe.domain.TExcTar;



public interface TExcTarService {

	

	/**
	 * @return
	 * @throws Exception
	 */
	public TExcTar select(int excTarId)throws Exception;
	

	
	/**
	 * @return
	 * @throws Exception
	 */
	public boolean update(TExcTar tExcTar)throws Exception;
	
	/**
	 * @param evaluateId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int tExcTarId)throws Exception;
	
	

	
	
	
	
	
	
	
	
	
	
}
