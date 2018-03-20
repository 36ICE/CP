package cn.jxufe.service.assess;

import cn.jxufe.domain.TSelAss;

public interface TSelAssService {

	/**
	 * @return
	 * @throws Exception
	 */
	public boolean updateTSelAss(String userNum,String name, String value)throws Exception;
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public TSelAss selectTSelAss(String userNum)throws Exception;
	
	
	/**
	 * @param selAssId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTSelAss(int selAssId)throws Exception;
}
