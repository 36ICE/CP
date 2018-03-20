package cn.jxufe.service.assess;

import cn.jxufe.domain.TExcTar;
import cn.jxufe.domain.TReaTar;

public interface TarService {
	/**
	 * @param userNum
	 * @param name
	 * @param Value
	 * @return
	 * @throws Exception
	 */
	public boolean updateExcTar(String userNum,String name ,String value ,int termNum)throws Exception;
	
	/**
	 * @param userNum
	 * @param name
	 * @param Value
	 * @return
	 * @throws Exception
	 */
	public boolean updateReaTar(String userNum,String name ,String value,int termNum )throws Exception;
	
	
	
	/**
	 * @param userNum
	 * @param name
	 * @param Value
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public TReaTar selectReaTar(String userNum,int termNum )throws Exception;
	
	/**
	 * @param userNum
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public TExcTar selectExcTar(String userNum,int termNum )throws Exception;
	
	
	/**
	 * @param userNum
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public boolean deleteReaTar(String userNum,int termNum )throws Exception;
	
	/**
	 * @param userNum
	 * @param termNum
	 * @return
	 * @throws Exception
	 */
	public boolean deleteExcTar(String userNum,int termNum )throws Exception;
	
}
