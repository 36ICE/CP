package cn.jxufe.service.assess;

import cn.jxufe.domain.TJobAss;

public interface TJobAssService {
	
	/**
	 * 更新
	 * @return
	 * @throws Exception
	 */
	public boolean updateTJobAss(String userNum,String name ,String Value )throws Exception;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public  TJobAss selectTJobAss(String userNum)throws Exception;
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public  boolean deleteTJobAss(String userNum)throws Exception;

	boolean isSubmit(String userNum, String termNum);
	
	
}
